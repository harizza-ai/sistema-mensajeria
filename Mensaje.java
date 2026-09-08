import java.util.Date;

public class Mensaje {
    private String idMensaje;
    private Usuario remitente;
    private Date fecha;
    private EstadoLectura estado;
    private ContenidoMensaje contenido;

    public Mensaje(String idMensaje, Usuario remitente, ContenidoMensaje contenido) {
        this.idMensaje = idMensaje;
        this.remitente = remitente;
        this.fecha = new Date();
        this.estado = new Enviado();
        this.contenido = contenido;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Date getFecha() {
        return fecha;
    }

    public EstadoLectura getEstado() {
        return estado;
    }

    public void setEstado(EstadoLectura estado) {
        this.estado = estado;
    }

    public ContenidoMensaje getContenido() {
        return contenido;
    }

    public void setContenido(ContenidoMensaje contenido) {
        this.contenido = contenido;
    }

    public void avanzarEstado() {
        this.estado = this.estado.siguienteEstado();
    }

    public void mostrarContenido() {
        contenido.MostrarMensaje();
    }
}