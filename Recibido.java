public class Recibido implements EstadoLectura {

    @Override
    public EstadoLectura siguienteEstado() {
        return new Leido();
    }
}