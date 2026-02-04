public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "datos.txt";

        if (args.length > 0) {
            rutaArchivo = args[0];
        }

        Calculadora calculadora = new Calculadora();
        Vista vista = new Vista();
        Controller controller = new Controller(calculadora, vista, rutaArchivo);

        vista.mostrarMensaje("=== Calculadora Postfix ===");
        controller.ejecutar();
        vista.mostrarMensaje("=== Fin ===");
    }
}