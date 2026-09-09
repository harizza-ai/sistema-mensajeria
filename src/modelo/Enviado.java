package src.modelo;

import src.modelo.interfaces.EstadoLectura;

public class Enviado implements EstadoLectura {

    @Override
    public EstadoLectura siguienteEstado() {
        return new Recibido();
    }

    @Override
    public String toString() {
        return "src.modelo.Enviado";
    }
}