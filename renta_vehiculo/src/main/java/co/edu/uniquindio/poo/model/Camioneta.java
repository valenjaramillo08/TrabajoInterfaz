package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {
    
    static double TARIFA = 30000;
    public double toneladas;

    public Camioneta(int numMatricula, String marca, String modelo, int anioFabricacion, double toneladas) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.toneladas = toneladas;
    }

    public double getToneladas() {
        return toneladas;
    }

    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public double calcularReserva(int numDias) {
        double valor = (numDias*TARIFA) + (TARIFA*(toneladas*0.2));
        return valor;
    }

    @Override
    public String toString() {
        return "Camioneta [numMatricula=" + numMatricula + ", toneladas=" + toneladas + ", marca=" + marca + ", modelo="
                + modelo + ", anioFabricacion=" + anioFabricacion + "]";
    }

    
}
