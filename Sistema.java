import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {

    private String estado;
    private final List<Usuario> usuariosRegistrados;
    private final List<Conversacion> conversaciones;

    public Sistema() {
        this.usuariosRegistrados = new ArrayList<>();
        this.conversaciones = new ArrayList<>();
    }

    public void setEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado del sistema no puede estar vacío.");
        }
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("No se puede registrar un usuario nulo.");
        }
        if (usuariosRegistrados.contains(usuario)) {
            throw new IllegalArgumentException(
                    "El usuario " + usuario.getNombre() + " ya está registrado en el sistema.");
        }
        usuariosRegistrados.add(usuario);
    }

    public void crearConversacion(Conversacion conversacion) {
        if (conversacion == null) {
            throw new IllegalArgumentException("La conversación no puede ser nula.");
        }
        for (Usuario u : conversacion.getUsuarios()) {
            if (!usuariosRegistrados.contains(u)) {
                throw new IllegalArgumentException(
                        "El usuario " + u.getNombre() + " no está registrado en el sistema.");
            }
        }
        conversaciones.add(conversacion);
    }

    public List<Usuario> getUsuariosRegistrados() {
        return Collections.unmodifiableList(usuariosRegistrados);
    }

    public List<Conversacion> getConversaciones() {
        return Collections.unmodifiableList(conversaciones);
    }
}
