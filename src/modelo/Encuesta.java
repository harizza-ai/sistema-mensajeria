package src.modelo;

import src.modelo.interfaces.ContenidoMensaje;

import java.util.ArrayList;
import java.util.List;

public class Encuesta implements ContenidoMensaje {
    private String pregunta;
    private List<String> opciones;
    private  List<Integer> votos;

    public String getPregunta() {
        return pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public List<Integer> getVotos() {
        return votos;
    }

    public Encuesta(String pregunta, List<String> opciones) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.votos = new ArrayList<>();
        for (int i = 0; i < this.opciones.size(); i++) {
            this.votos.add(0);
        }
    }

    public void registrarVoto(int opcion){
        if (opcion >= 0 && opcion < this.votos.size()){
            int votoActual = votos.get(opcion);
            votos.set(opcion, votoActual+1);
        }else {
            System.out.println("El opcion no existe");
        }

    }

    @Override
    public String  mostrarMensaje() {
        return "";
    }
}
