package modelo.utils;
import java.time.LocalDate;
import modelo.inter.Bonificable;
import modelo.inter.Incentivo;
public class PorHoras extends Empleado implements Bonificable {

    private double tarifaHoras;

    private int horasQuincena;
    private Incentivo politicaDeIncentivo; 
    public PorHoras(double tarifaHoras, int horasQuincena, String cedula, String nombre, LocalDate fechaIngreso) {
        super(cedula, nombre, fechaIngreso);
        this.tarifaHoras = tarifaHoras;
        this.horasQuincena = horasQuincena;
        this.politicaDeIncentivo = new IncentivoPorProductividad(80, 20000.0);

    }
    @Override
    public double bono() {
        return 0.0;
    }

    @Override
    public double salarioQuincena() {
        int topeMaxHoras = 10;
        if (topeMaxHoras >10){
        throw new IllegalArgumentException("Tope máximo de horas trabajadas"); }
        return tarifaHoras*horasQuincena;
    }
public int getHorasQuincena() {
    return this.horasQuincena; 
}
}
