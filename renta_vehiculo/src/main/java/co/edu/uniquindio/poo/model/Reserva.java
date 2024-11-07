package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private static int ultimoCodigo = 0;
    public Cliente cliente;
    public Vehiculo vehiculo;
    public LocalDate fechaInicio;
    public LocalDate fechaFinal;
    public String codigo;
    public double valorReserva;


    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.codigo = generadoCodigo();
        this.valorReserva = vehiculo.calcularReserva((int) ChronoUnit.DAYS.between(fechaInicio, fechaFinal));
    }

    private static String generadoCodigo(){
        ultimoCodigo++;
        return ultimoCodigo+"";
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }


    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public LocalDate getFechaFinal() {
        return fechaFinal;
    }


    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public double getValorReserva() {
        return valorReserva;
    }


    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }


    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaInicio=" + fechaInicio
                + ", fechaFinal=" + fechaFinal + ", codigo=" + codigo + ", valorReserva=" + valorReserva + "]";
    }

    
}
