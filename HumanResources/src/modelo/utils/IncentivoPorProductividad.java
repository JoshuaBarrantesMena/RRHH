package modelo.utils;
import modelo.inter.Incentivo;

public class IncentivoPorProductividad implements Incentivo {
    private final int umbralHoras;
    private final double montoBono;

    public IncentivoPorProductividad(int umbralHoras, double montoBono) {
        this.umbralHoras = umbralHoras;
        this.montoBono = montoBono;
    }
    @Override
    public double calcularIncentivo(Empleado empleado) {
        if (empleado instanceof PorHoras trabajadorPorHoras) {
          if (trabajadorPorHoras.getHorasQuincena() > this.umbralHoras) {
                return this.montoBono;
            }
        }
    
        return 0.0;
    }
}
    
    

