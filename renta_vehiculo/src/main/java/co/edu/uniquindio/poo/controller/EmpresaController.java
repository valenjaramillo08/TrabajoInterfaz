package co.edu.uniquindio.poo.controller;

import java.util.Collection;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class EmpresaController {
    Empresa empresa;
    
    public EmpresaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Collection<Reserva> getReservas() {
        return empresa.getReservas();
    }

    public Collection<Cliente> getClientes() {
        return empresa.getClientes();
    }

    public Collection<Vehiculo> getVehiculos() {
        return empresa.getVehiculos();
    }

    public boolean crearCliente(Cliente cliente) {
        return empresa.crearCliente(cliente);
    }

    public boolean eliminarCliente(Cliente cliente) {
        return empresa.eliminarCliente(cliente);
    }

    public void crearVehiculo(Vehiculo vehiculo) {
        empresa.crearVehiculo(vehiculo);
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return empresa.eliminarVehiculo(vehiculo);
    }

    public boolean crearReserva(Reserva reserva) {
        return empresa.crearReserva(reserva);
    }

    public boolean eliminarReserva(Reserva reserva) {
        return empresa.eliminarReserva(reserva);
    }


}
