package dif_e_integracion;
public class Main {
    public static void main(String[] args) {
        double a = 0.0;          // Límite inferior
        double b = 2.0;          // Límite superior
        double tolerancia = 0.0001;

        System.out.println("=== INTEGRACIÓN NUMÉRICA ===");
        System.out.println("Función: f(x) = x²");
        System.out.println("Intervalo: [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia + "\n");

        // Llamada al método del Trapecio
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.printf("\n✅ Resultado final Trapecio: %.8f%n", resultadoTrapecio);

        // Llamada al método de Simpson
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.printf("✅ Resultado final Simpson:  %.8f%n", resultadoSimpson);

        // Valor exacto para comparar: ∫₀² x² dx = 8/3 ≈ 2.66666667
        double valorExacto = 8.0 / 3.0;
        System.out.printf("\n📐 Valor exacto:              %.8f%n", valorExacto);
        System.out.printf("📊 Error Trapecio:            %.8f%n", Math.abs(valorExacto - resultadoTrapecio));
        System.out.printf("📊 Error Simpson:             %.8f%n", Math.abs(valorExacto - resultadoSimpson));
    }
}