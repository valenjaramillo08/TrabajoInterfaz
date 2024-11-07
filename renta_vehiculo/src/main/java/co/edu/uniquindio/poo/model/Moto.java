package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {

    static double TARIFA = 10000;
    public TipoCaja tipoCaja;

    public Moto(int numMatricula, String marca, String modelo, int anioFabricacion, TipoCaja tipoCaja) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.tipoCaja = tipoCaja;
    }

    
    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }


    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }
    
    @Override
    public double calcularReserva(int numDias) {
        double valor = TARIFA*numDias;
        if(tipoCaja == TipoCaja.AUTOMATICA){
            valor = valor + (valor*0.5);
        }
        return valor;
    }


    @Override
    public String toString() {
        return "Moto [numMatricula=" + numMatricula + ", tipoCaja=" + tipoCaja + ", marca=" + marca + ", modelo="
                + modelo + ", anioFabricacion=" + anioFabricacion + "]";
    }

}
