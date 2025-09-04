package modelo.utils;
import modelo.inter.Incentivo;

public class IncentivoPorDesempeno implements Incentivo {
        
    private final double salarioBaseParaCalculo;
    
    public IncentivoPorDesempeno(double salarioMensual) {
        this.salarioBaseParaCalculo = salarioMensual;
    }
    
    @Override
    public double calcularIncentivo(Empleado e) {
        return salarioBaseParaCalculo * 0.05;
    }
}
