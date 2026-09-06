public class Enviado implements EstadoLectura {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    @Override
    public EstadoLectura siguienteEstado() {
        return this; // este esta asi temporal mientras el fabi pone su parte
    }
=======
=======
>>>>>>> Stashed changes

    @Override
    public EstadoLectura siguienteEstado(){
        return new Recibido();
    }
    
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}