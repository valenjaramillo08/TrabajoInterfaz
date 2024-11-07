package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    
    public int numMatricula;
    public String marca;
    public String modelo;
    public int anioFabricacion;


    public Vehiculo(int numMatricula, String marca, String modelo, int anioFabricacion) {
        this.numMatricula = numMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public int getNumMatricula() {
        return numMatricula;
    }
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public abstract double calcularReserva(int numDias);
    
    @Override
    public String toString() {
        return "Vehiculo [numMatricula=" + numMatricula + ", marca=" + marca + ", modelo=" + modelo
                + ", anioFabricacion=" + anioFabricacion + "]";
    }

    
}
