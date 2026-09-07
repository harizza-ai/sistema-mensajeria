public class Enviado implements EstadoLectura {

    @Override
    public EstadoLectura siguienteEstado() {
        return new Recibido();
    }
}