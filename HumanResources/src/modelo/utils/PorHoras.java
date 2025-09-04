package modelo.utils;
import modelo.inter.Bonificable;

public class PorHoras extends Empleado implements Bonificable {

    private double tarifaHoras;

    private int horasQuincena;

    @Override
    public double bono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double salarioQuincena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
