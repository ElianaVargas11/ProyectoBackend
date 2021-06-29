package bo.edu.ucb.ingsoft.ProyectoBackend.dto;

public class RespondeMensaje {

    private String mensaje;

    public RespondeMensaje() {

    }

    public RespondeMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
