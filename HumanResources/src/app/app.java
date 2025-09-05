/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package app;

import infra.RepositorioCSV;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.inter.*;
import modelo.utils.*;
import servicios.FabricaEmpleados;
import servicios.*;

/**
 *
 * @author Josh
 */
public class app {
    
        private static final String RUTA_EMPLEADOS = "data/empleados.csv";
        private static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== SISTEMA DE RECURSOS HUMANOS ===");
            System.out.println("1. Crear empleado");
            System.out.println("2. Mostrar planilla quincenal");
            System.out.println("3. Exportar planilla a CSV");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearEmpleado(sc);
                    break;
                case 2:
                    mostrarPlanilla();
                    break;
                case 3:
                    exportarPlanilla();
                    break;
                default:
                    salir = true;
                    break;
            }
        }

        sc.close();
    }

    private static void cargarEmpleados() {
        try {
            List<String> lineas = RepositorioCSV.leerLineas(RUTA_EMPLEADOS);
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                String tipo = datos[0];
                String cedula = datos[1];
                String nombre = datos[2];

            // Valores por defecto
                double salarioMensual = 0, tarifaHora = 0, base = 0, porcentaje = 0, ventas = 0, tarifaDiaria = 0, apoyo = 0;
                int horas = 0, dias = 0;

                switch (tipo.toUpperCase()) {
                    case "ASALARIADO" -> salarioMensual = Double.parseDouble(datos[3]);
                    case "PORHORAS" -> {
                        tarifaHora = Double.parseDouble(datos[3]);
                        horas = Integer.parseInt(datos[4]);
                    }
                    case "TEMPORAL" -> {
                        tarifaDiaria = Double.parseDouble(datos[3]);
                        dias = Integer.parseInt(datos[4]);
                    }
                    case "COMISIONISTA" -> {
                        base = Double.parseDouble(datos[3]);
                        porcentaje = Double.parseDouble(datos[4]);
                        ventas = Double.parseDouble(datos[5]);
                    }
                    case "PRACTICANTE" -> apoyo = Double.parseDouble(datos[3]);
                    default -> throw new IllegalArgumentException("Tipo de empleado no reconocido: " + tipo);
                }

                Empleado empleado = FabricaEmpleados.crearEmpleado(
                    tipo, cedula, nombre,
                    salarioMensual, tarifaHora, horas,
                    base, porcentaje, ventas,
                    tarifaDiaria, dias, apoyo
                );

                empleados.add(empleado);
            }
            System.out.println("Empleados cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar empleados: " + e.getMessage());
        }
    }

    private static void mostrarPlanilla() {
        double total = Nomina.totalAPagar(empleados);
        System.out.println("\n--- Planilla Quincenal ---");
        for (Empleado e : empleados) {
            double salario = e.salarioQuincena();
            double bono = (e instanceof Bonificable b) ? b.bono() : 0.0;
            System.out.printf("%s - %s - Salario: %.2f - Bono: %.2f - Total: %.2f%n",
                    e.getCedula(), e.getNombre(), salario, bono, salario + bono);
        }
        System.out.println("Total general: " + total);
    }

    private static void exportarPlanilla() {
        try {
            List<String> lineas = new ArrayList<>();
            for (Empleado e : empleados) {
                double salario = e.salarioQuincena();
                double bono = (e instanceof Bonificable b) ? b.bono() : 0.0;
                lineas.add(String.format("%s;%s;%.2f;%.2f;%.2f",
                        e.getCedula(), e.getNombre(), salario, bono, salario + bono));
            }
            RepositorioCSV.escribirLineas("out/planilla_quincena.csv", lineas);
            System.out.println("Planilla exportada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al exportar planilla: " + e.getMessage());
        }
    }

    private static void crearEmpleado(Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
