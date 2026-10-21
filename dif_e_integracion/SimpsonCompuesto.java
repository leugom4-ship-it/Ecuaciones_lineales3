package dif_e_integracion;

/**
 * Clase que implementa el método de Integración Numérica por Simpson Compuesto
 * con un criterio de paro basado en el error absoluto y duplicación de subintervalos.
 */
public class SimpsonCompuesto {

    /**
     * Calcula la integral aproximada usando la Regla de Simpson Compuesto.
     * Fórmula: I = (h/3) * [ f(a) + 4·Σ(f(x_impares)) + 2·Σ(f(x_pares)) + f(b) ]
     */
    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            // Separamos los puntos en posiciones impares (×4) y pares (×2)
            if (k % 2 == 1) {  // k es impar → coeficiente 4
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {  // k es par → coeficiente 2
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal = TrapecioCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapecioCompuesto.funcion(b);

        return (h / 3) * sumaTotal;
    }

    /**
     * Integra iterativamente hasta alcanzar la tolerancia deseada.
     * Siempre duplica n → garantiza que n sea par en cada paso.
     */
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;  // Siempre empezamos con n par
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        System.out.println("\n--- ITERACIONES (SIMPSON COMPUESTO) ---");

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.printf("n = %d | Integral = %.8f | Error = %.8f%n",
                    n, integralNueva, errorAbsoluto);

            integralAnterior = integralNueva;
        }
        return integralAnterior;
    }
}