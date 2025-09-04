package modelo.utils;
import java.time.LocalDate;
public abstract class Empleado {

    private final String cedula;
    private final String nombre;
    private final LocalDate fechaIngreso;
public Empleado(String cedula, String nombre, LocalDate fechaIngreso){
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if(fechaIngreso==null){
        throw new IllegalArgumentException("la feicha de ingreso no puede ser null");
        }
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaIngreso= fechaIngreso;
    }
public Empleado(String cedula, String nombre){
this(cedula,nombre,LocalDate.now());
}
    public abstract double salarioQuincena();
    
    public String getCedula(){
        return cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
    public LocalDate getFechaIngreso(){
    return fechaIngreso;   
    }
}
