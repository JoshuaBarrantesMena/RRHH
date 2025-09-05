package modelo.utils;
import java.time.LocalDate; 
import modelo.inter.*;

public class Comisionista extends Empleado implements Bonificable {

    private final double base; 
    private final double porcentaje;
    private final double ventasQuincena;
    private Incentivo politicaDeIncentivo;

    public Comisionista(String cedula, String nombre, double base, double porcentaje, double ventasQuincena, LocalDate fechaIngreso){ // <-- 2. AÑADIR LocalDate fechaIngreso aquí
        super(cedula, nombre, fechaIngreso); 
        this.base = base;
        this.porcentaje = porcentaje;
        this.ventasQuincena = ventasQuincena;
        // La política de incentivo está bien
        this.politicaDeIncentivo = new IncentivoPorDesempeno(base); 
    }

    @Override
    public double bono() {
        return politicaDeIncentivo.calcularIncentivo(this);
    }
    
    @Override
    public double salarioQuincena() {
        double comision = this.ventasQuincena * this.porcentaje;
        return base + comision;
    }
}