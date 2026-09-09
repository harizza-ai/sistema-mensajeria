public class Recibido implements EstadoLectura {

    @Override
    public EstadoLectura siguienteEstado() {
        return new Leido();
    }

    @Override
    public String toString() {
        return "Recibido";
    }
}