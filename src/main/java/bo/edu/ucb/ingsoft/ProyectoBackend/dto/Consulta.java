package bo.edu.ucb.ingsoft.ProyectoBackend.dto;

public class Consulta {
    private int consulta_id;
    private int ciudad_id;
    private int veterinario_id;
    private String tema_consulta;
    private String descripcion;
    private String fecha;
    private String hora;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getConsulta_id() {
        return consulta_id;
    }

    public void setConsulta_id(int consulta_id) {
        this.consulta_id = consulta_id;
    }

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public int getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    public String getTema_consulta() {
        return tema_consulta;
    }

    public void setTema_consulta(String tema_consulta) {
        this.tema_consulta = tema_consulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }





}