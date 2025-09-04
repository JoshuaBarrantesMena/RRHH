package modelo.utils; 

import modelo.inter.Incentivo;

public class IncentivoPorApoyo implements Incentivo {

    private final double tarifaBonoPorDia;
    public IncentivoPorApoyo(double tarifaBonoPorDia) {
        this.tarifaBonoPorDia = tarifaBonoPorDia;
    }

    @Override
    public double calcularIncentivo(Empleado empleado) {
        
        if (empleado instanceof Temporal empleadoTemporal) {

            int diasActivos = empleadoTemporal.getDiasActivos();
            return diasActivos * this.tarifaBonoPorDia;
        }
        return 0.0;
    }
}