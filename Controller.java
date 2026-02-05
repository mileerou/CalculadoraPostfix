import java.util.List;

public class Controller {
    private Calculadora calculadora;
    private Vista vista;
    private String rutaArchivo;

    public Controller(Calculadora calculadora, Vista vista, String rutaArchivo) {
        this.calculadora = calculadora;
        this.vista = vista;
        this.rutaArchivo = rutaArchivo;
    }

    public void ejecutar() {
        try {
            List<String> expresiones = vista.Archivo(rutaArchivo);
            for (String exp : expresiones) {
                try {
                    double resultado = calculadora.evaluarPostfix(exp);
                    // ejemplo muestra 15 como entero
                    vista.mostrarResultado(exp, (int) resultado);
                } catch (Exception e) {
                    vista.mostrarError(exp, e.getMessage());
                }
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error fatal: " + e.getMessage());
        }
    }
}