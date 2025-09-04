package modelo.utils;



public final class Practicante extends Empleado { 
    private final double apoyoQuincena;

    public Practicante(String cedula, String nombre, double apoyoQuincena) {
        super(cedula, nombre);
        this.apoyoQuincena = apoyoQuincena;
    }

    @Override
    public double salarioQuincena() {
        return apoyoQuincena;
    }
    
}
