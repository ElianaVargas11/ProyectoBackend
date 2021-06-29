package bo.edu.ucb.ingsoft.ProyectoBackend.dto;

public class Usuario1 {
    private Integer id;
    private String nombre;

    public Usuario1() {

    }

    public Usuario1(String nombre) {
        this.nombre = nombre;
    }

    public Usuario1(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
