public class Leido implements EstadoLectura{

    @Override 
    public EstadoLectura siguienteEstado(){
        return this;
        
    }

    @Override
    public String toString() {
        return "Leido";
    }
}