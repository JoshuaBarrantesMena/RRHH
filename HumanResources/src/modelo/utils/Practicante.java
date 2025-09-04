package modelo.utils;



public final class Practicante extends Empleado { 
    private final double apoyoQuincena;

    public Practicante(String cedula, String nombre, double apoyoQuincena) {
        super(cedula, nombre); // Llama al constructor simple
        this.apoyoQuincena = apoyoQuincena;
    }

    @Override
    public double salarioQuincena() {
        return apoyoQuincena;
    }
    
}
