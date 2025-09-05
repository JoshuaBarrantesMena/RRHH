/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import modelo.utils.*;

/**
 *
 * @author Josh
 */
public class FabricaEmpleados {
    
    public static Empleado crearEmpleado(String tipoEmpleado,
        String cedula,
        String nombre,
        double salarioMensual,
        double tarifaHora,
        int horasQuincena,
        double base,
        double porcentaje,
        double ventasQuincena,
        double tarifaDiaria,
        int diasActivos,
        double apoyoQuincena){
        
        if (tipoEmpleado.equalsIgnoreCase("ASALARIADO")){
            return new Asalariado(cedula, nombre, salarioMensual);
        }else if (tipoEmpleado.equalsIgnoreCase("COMISIONISTA")){
            return new Comisionista(cedula, nombre, base, porcentaje, ventasQuincena);
        }else if (tipoEmpleado.equalsIgnoreCase("PORHORAS")){
            return new PorHoras(cedula, nombre, tarifaHora, horasQuincena);
        }else if (tipoEmpleado.equalsIgnoreCase("TEMPORAL")){
            return new Temporal(cedula, nombre, tarifaDiaria, diasActivos);
        } else{
            return new Practicante(cedula, nombre, apoyoQuincena);
        }
    }
}
