package modelo.utils;

import static org.junit.jupiter.api.Assertions.*; // Importante para assertEquals
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ComisionistaTest {

    @Test 
    @DisplayName("salarioQuincena() debe sumar el base más la comisión de ventas")
    void testSalarioQuincenaConVentasPositivas() {
        LocalDate fechaIngreso = LocalDate.now();
        Comisionista comisionista = new Comisionista(
            "444", "Sofia Vega", 300000.0, 0.10, 500000.0, fechaIngreso
        );

        double salarioEsperado = 350000.0;

        double salarioCalculado = comisionista.salarioQuincena();

        assertEquals(salarioEsperado, salarioCalculado, "El cálculo del salario del comisionista es incorrecto.");
    }
    @Test
@DisplayName("salarioQuincena() debe ser solo el base si no hay ventas")
        
void testSalarioQuincenaConCeroVentas() {
    LocalDate fechaIngreso = LocalDate.now();
    Comisionista comisionista = new Comisionista(
        "555", "Pedro Nimo", 300000.0, 0.10, 0.0, fechaIngreso
    );

    double salarioEsperado = 300000.0;

    double salarioCalculado = comisionista.salarioQuincena();
    assertEquals(salarioEsperado, salarioCalculado, "El salario con cero ventas debe ser igual al base.");
}
}