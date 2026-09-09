package src.modelo;

import src.modelo.interfaces.EstadoLectura;

public class Leido implements EstadoLectura {

    @Override 
    public EstadoLectura siguienteEstado(){
        return this;
        
    }

    @Override
    public String toString() {
        return "src.modelo.Leido";
    }
}