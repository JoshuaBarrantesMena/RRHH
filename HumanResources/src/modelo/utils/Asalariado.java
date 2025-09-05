package modelo.utils;
import modelo.inter.*;
import java.time.LocalDate;
public class Asalariado extends Empleado implements Bonificable {

    private final double salarioMensual;
    private Incentivo politicaDeIncentivo;
    public Asalariado(String cedula, String nombre, double salarioMensual, LocalDate fechaIngreso) {
        super(cedula, nombre,fechaIngreso);
        this.salarioMensual = salarioMensual;
        this.politicaDeIncentivo = new IncentivoPorAntiguedad();
    }
    @Override
    public double bono() {
       return politicaDeIncentivo.calcularIncentivo(this);
    }

    @Override
    public double salarioQuincena() {return salarioMensual/2.0; 
    }
 public void setPoliticaDeIncentivo(Incentivo nuevaPolitica) {
        this.politicaDeIncentivo = nuevaPolitica;
    }
}
