package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    static double TARIFA = 15000;
    public int puertas;

    public Auto(int numMatricula, String marca, String modelo, int anioFabricacion, int puertas) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public double calcularReserva(int numDias) {
        return numDias*TARIFA;
    }

    @Override
    public String toString() {
        return "Auto [numMatricula=" + numMatricula + ", puertas=" + puertas + ", marca=" + marca + ", modelo=" + modelo
                + ", anioFabricacion=" + anioFabricacion + "]";
    }
    
}
