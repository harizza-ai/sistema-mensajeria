public class Multimedia implements ContenidoMensaje{

    private String url;
    private String formato;

    public Multimedia(String url, String formato) {
        this.url = url;
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    /*@Override
    public void MostrarMensaje() {
        System.out.printf("URL: %s\n", url + "Formato: " + formato);
    }*/

    @Override
    public String mostrarMensaje() {
        return "url: " + url + ", formato: " + formato;
    }
}
