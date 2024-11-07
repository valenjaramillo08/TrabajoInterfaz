package co.edu.uniquindio.poo.model;
import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    public String nombre;
    public Collection<Reserva> reservas;
    public Collection<Cliente> clientes;
    public Collection<Vehiculo> vehiculos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.reservas = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.vehiculos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", reservas=" + reservas + ", clientes=" + clientes + ", vehiculos="
                + vehiculos + "]";
    }

        /*
     * Metodo que permite crear un cliente
     * @param Cliente
     */
    public boolean crearCliente(Cliente cliente){
        boolean bandera = false;
        if(!verificarClientes(cliente.getNombre(), cliente.getCedula())){
            clientes.add(cliente);
            bandera = true;
        }
        else{
            System.out.println("El cliente ya existe");
        }
        return bandera;
    }

    /**
     * Metodo que verifica si el cliente ya existe
     * @param nombre
     * @param cedula
     * @return bandera
     */
    public boolean verificarClientes(String nombre, String cedula){
        boolean bandera = false;
        for (Cliente cliente : clientes) {
            if(cliente.getNombre().equals(nombre) && cliente.getCedula().equals(cedula)){
                bandera = true;
            }
        }
        return bandera;
    }
    /*
     * Metodo que permite eliminar un cliente
     */
    public boolean eliminarCliente(Cliente cliente) {
        boolean bandera = false;
        if(verificarClientes(cliente.getNombre(), cliente.getCedula())){
            clientes.remove(cliente);
            bandera = true;
        }
        return bandera;
    }

        /*
     * Metodo que permite crear un vehiculo
     * @param Vehiculo
     */
    public void crearVehiculo(Vehiculo vehiculo){
        if(!verificarVehiculos(vehiculo.getMarca(), vehiculo.getNumMatricula())){
            vehiculos.add(vehiculo);
        }
        else{
            System.out.println("El vehiculo ya existe");
        }
    }

    /**
     * Metodo que verifica si el vehiculo ya existe
     * @param marca
     * @param numMatricula
     * @return bandera
     */
    public boolean verificarVehiculos(String marca, int numMatricula){
        boolean bandera = false;
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getMarca().equals(marca) && vehiculo.getNumMatricula() == (numMatricula)){
                bandera = true;
            }
        }
        return bandera;
    }

    /*
     * Metodo que permite eliminar un vehiculo
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        boolean bandera = false;
        if(verificarVehiculos(vehiculo.getMarca(), vehiculo.getNumMatricula())){
            vehiculos.remove(vehiculo);
            bandera = true;
        }
        return bandera;
    }
        /*
     * Metodo que permite crear un reserva
     * @param 
     */
    public boolean crearReserva(Reserva reserva){
        boolean bandera = false;
        if(!verificarReservas(reserva.getCodigo())){
            reservas.add(reserva);
            bandera = true;
        }
        else{
            System.out.println("La reserva ya existe");
        }
        return bandera;
    }

    /**
     * Metodo que verifica si el reserva ya existe
     * @param codigo
     * @return bandera
     */
    public boolean verificarReservas(String codigo){
        boolean bandera = false;
        for (Reserva reserva : reservas) {
            if(reserva.getCodigo().equals(codigo) ){
                bandera = true;
            }
        }
        return bandera;
    }
    /*
     * Metodo que permite eliminar un reserva
     */
    public boolean eliminarReserva(Reserva reserva) {
        boolean bandera = false;
        if(verificarReservas(reserva.getCodigo())){
            reservas.remove(reserva);
            bandera = true;
        }
        return bandera;
    }

}
