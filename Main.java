import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.setEstado("Activo");

        Usuario user1 = new Usuario("1", "Ana");
        Usuario user2 = new Usuario("2", "Luis");
        sistema.registrarUsuario(user1);
        sistema.registrarUsuario(user2);

        Conversacion conversacion = new Conversacion("c1", List.of(user1, user2));
        sistema.crearConversacion(conversacion);

        Mensaje m1 = new Mensaje("m1", user1, new Date(), new Texto("Hola, ¿cómo estás?"));
        Mensaje m2 = new Mensaje("m2", user2, new Date(), new Multimedia("foto.jpg", "IMAGEN"));
        Mensaje m3 = new Mensaje("m3", user1, new Date(),
                new Encuesta("¿Nos vemos el viernes?", List.of("Sí", "No", "Tal vez")));

        conversacion.enviarMensaje(m1);
        conversacion.enviarMensaje(m2);
        conversacion.enviarMensaje(m3);

        m1.avanzarEstado();
        m1.avanzarEstado();

        Encuesta encuesta = (Encuesta) m3.getContenido();
        encuesta.registrarVoto(0);
        encuesta.registrarVoto(0);
        encuesta.registrarVoto(1);

        System.out.println("--- Historial ---");
        for (Mensaje m : conversacion.obtenerHistorial()) {
            System.out.println(m.mostrarContenido() + " [" + m.getEstado() + "]");
        }

        System.out.println("\n--- Validaciones ---");
        try {
            new Usuario("3", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
        try {
            new Encuesta("¿Vamos?", List.of("Solo una opción"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
        try {
            encuesta.registrarVoto(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
        try {
            Mensaje ajeno = new Mensaje("m4", new Usuario("9", "Intruso"), new Date(), new Texto("hola"));
            conversacion.enviarMensaje(ajeno);
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        System.out.println("\nUsuarios registrados: " + sistema.getUsuariosRegistrados().size());
        System.out.println("Conversaciones creadas: " + sistema.getConversaciones().size());
    }
}
