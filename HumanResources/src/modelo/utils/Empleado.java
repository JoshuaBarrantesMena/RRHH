package modelo.utils;

public abstract class Empleado {

    private final String cedula;
    private final String nombre;
public Empleado(String cedula, String nombre){
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        
        this.cedula = cedula;
        this.nombre = nombre;
    }
    public abstract double salarioQuincena();
    
    public String getCedula(){
        return cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
}
