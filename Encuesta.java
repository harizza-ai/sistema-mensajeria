import java.util.List;

public class Encuesta implements ContenidoMensaje{
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

    public Encuesta(String pregunta, List<String> opciones, List<Integer> votos) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.votos = votos;
    }

    public void RegistrarVoto(int opcion){
        if (opcion >= 0 && opcion < this.votos.size()){
            int votoActual = votos.get(opcion);
            votos.set(opcion, votoActual+1);
        }else {
            System.out.println("El opcion no existe");
        }

    }

    @Override
    public void MostrarMensaje() {
        System.out.println("Encuesta: " + pregunta);
        int i = 0;
        for (String opcion : opciones) {
            System.out.printf(" " + (i + 1) + ". " + opcion + ("Votos: " + votos.get(i) + "\n")) ;
            i++;
        }

    }
}
