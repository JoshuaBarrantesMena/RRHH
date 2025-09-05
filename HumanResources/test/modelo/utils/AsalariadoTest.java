// En src/test/java/modelo/utils/AsalariadoTest.java
package modelo.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class AsalariadoTest {

    @Test
    @DisplayName("salarioQuincena() debe calcular la mitad del salario mensual")
    void testSalarioQuincena() {
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 1);
        Asalariado empleado = new Asalariado("123", "Juan", 1000000.0, fechaIngreso);
        double salarioEsperado = 500000.0;
        double salarioCalculado = empleado.salarioQuincena();
        assertEquals(salarioEsperado, salarioCalculado, "El cálculo del salario quincenal es incorrecto.");
    }
}