public interface EstadoLectura {
    EstadoLectura siguienteEstado();
}

public class Enviado implements EstadoLectura {
    @Override
    public EstadoLectura siguienteEstado() {
        return new Recibido();
    }
}

public class Recibido implements EstadoLectura {
    @Override
    public EstadoLectura siguienteEstado() {
        return new Leido();
    }
}

public class Leido implements EstadoLectura {
    @Override
    public EstadoLectura siguienteEstado() {
        return this; // Estado final
    }
}