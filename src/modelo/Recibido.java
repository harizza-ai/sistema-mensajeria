package src.modelo;

import src.modelo.interfaces.EstadoLectura;

public class Recibido implements EstadoLectura {

    @Override
    public EstadoLectura siguienteEstado() {
        return new Leido();
    }

    @Override
    public String toString() {
        return "src.modelo.Recibido";
    }
}