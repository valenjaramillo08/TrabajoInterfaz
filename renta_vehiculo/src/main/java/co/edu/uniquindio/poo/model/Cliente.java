package co.edu.uniquindio.poo.model;

public class Cliente {

    public String nombre;
    public String cedula;
    public String correo;

    public Cliente(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + "]";
    }
}
