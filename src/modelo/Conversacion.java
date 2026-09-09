package src.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Conversacion {
    private String id;
    private Set<Usuario> usuarios;
    private List<Mensaje> mensajes;

    public Conversacion(String id, List<Usuario> participantesIniciales) {
        this.id = validarId(id);
        this.usuarios = new LinkedHashSet<>();
        this.mensajes = new ArrayList<>();
        if (participantesIniciales == null || participantesIniciales.size() < 2) {
            throw new IllegalArgumentException("Una conversación requiere al menos dos participantes.");
        }
        for (Usuario u : participantesIniciales) {
            agregarUsuario(u);
        }
    }

    private String validarId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id de la conversación no puede estar vacío.");
        }
        return id;
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("No se puede agregar un participante nulo.");
        }
        if (!usuarios.add(usuario)) {
            throw new IllegalArgumentException(
                    "El usuario " + usuario.getNombre() + " ya participa en esta conversación.");
        }
    }

    public void enviarMensaje(Mensaje mensaje) {
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo.");
        }
        if (!usuarios.contains(mensaje.getRemitente())) {
            throw new IllegalArgumentException(
                    "El remitente " + mensaje.getRemitente().getNombre()
                            + " no pertenece a esta conversación.");
        }
        mensajes.add(mensaje);
    }

    public List<Mensaje> obtenerHistorial() {
        return Collections.unmodifiableList(mensajes);
    }

    public String getId() {
        return id;
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
