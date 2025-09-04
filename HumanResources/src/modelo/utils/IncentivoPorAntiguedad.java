package modelo.utils;
import modelo.inter.Incentivo;
import java.time.LocalDate;
import java.time.Period;
public class IncentivoPorAntiguedad implements Incentivo {
    public IncentivoPorAntiguedad(){}
@Override
    public double calcularIncentivo(Empleado empleado) {
        if(empleado==null|| empleado.getFechaIngreso()==null){
            return 0.0;
    }
        LocalDate fechaIngreso = empleado.getFechaIngreso();
        LocalDate fechaActual = LocalDate.now();
        int aniosDeServicio = Period.between(fechaIngreso, fechaActual).getYears();
        double salarioQuincenal = empleado.salarioQuincena();
        
        if (aniosDeServicio >= 5) {
            return salarioQuincenal * 0.05;
        } else if (aniosDeServicio >= 2) {
            return salarioQuincenal * 0.02;
        } else {
            return 0.0;
        }
    }
}
