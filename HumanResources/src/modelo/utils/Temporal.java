package modelo.utils;

import java.time.LocalDate;
import modelo.inter.Bonificable; 
import modelo.inter.Incentivo;

public final class Temporal extends Empleado implements Bonificable { 

    private final double tarifaDiaria;
    private final int diasActivos;
    private Incentivo politicaDeIncentivo; 

    public Temporal(String cedula, String nombre, double tarifaDiaria, int diasActivos) {
        super(cedula, nombre);
        this.tarifaDiaria = tarifaDiaria;
        this.diasActivos = diasActivos;
        this.politicaDeIncentivo = new IncentivoPorApoyo(2500.0);
    }

    @Override
    public double salarioQuincena() {
        // Su salario base es simplemente la tarifa por los días trabajados
        return this.tarifaDiaria * this.diasActivos;
    }
    public int getDiasActivos() {
        return this.diasActivos;
    }

    @Override
    public double bono() {
        return this.politicaDeIncentivo.calcularIncentivo(this);
    }

    public void setPoliticaDeIncentivo(Incentivo nuevaPolitica) {
        this.politicaDeIncentivo = nuevaPolitica;
    }
}