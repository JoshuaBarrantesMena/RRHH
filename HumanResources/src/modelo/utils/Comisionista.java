package modelo.utils;
import modelo.inter.*;

public class Comisionista extends Empleado implements Bonificable {

    private double base;
    private double porcentaje;
    private final double ventasQuincena;
    private Incentivo politicaDeIncentivo;
    public Comisionista(String cedula, String nombre, double base, double porcentaje, double ventasQuincena){
    super(cedula,nombre);
    this.base = base;
    this.porcentaje = porcentaje;
    this.ventasQuincena = ventasQuincena;
    this.politicaDeIncentivo= new IncentivoPorDesempeno(base);
    
    }
    @Override
    public double bono() {
    return politicaDeIncentivo.calcularIncentivo(this);
    }
    

    @Override
    public double salarioQuincena() {
        double comision= this.ventasQuincena*this.porcentaje;
        return base+comision;
        
       }

}
