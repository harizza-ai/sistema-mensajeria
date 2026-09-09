package src.modelo;

import src.modelo.interfaces.ContenidoMensaje;

public class Texto implements ContenidoMensaje {

    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    /*@Override
    public void MostrarMensaje() {
        System.out.println("src.modelo.Texto: " + this.texto);
    }*/

    @Override
    public String mostrarMensaje() {
        return "src.modelo.Texto: " + texto;
    }
}
