public class Enviado implements EstadoLectura {
    @Override
    public EstadoLectura siguienteEstado() {
        return this; // este esta asi temporal mientras el fabi pone su parte
    }
}