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
            // Llama al método de la vista para leer el archivo datos.txt
            List<String> expresiones = vista.Archivo(rutaArchivo);

            for (String expresion : expresiones) {
                try {
                    double resultado = calculadora.evaluarPostfix(expresion);
                    // El PDF pide resultados enteros si es posible, puedes castear o mostrar double
                    vista.mostrarResultado(expresion, (int) resultado);
                } catch (Exception e) {
                    vista.mostrarError(expresion, e.getMessage());
                }
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al leer el archivo: " + e.getMessage());
        }
    }
}