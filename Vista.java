import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Vista {

    List<String> Archivo(String nombreArchivo) throws IOException {
        List<String> expresiones = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    expresiones.add(linea.trim());
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return expresiones;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }


    public void mostrarResultado(String expresion, int resultado) {
        System.out.println("Expresión: " + expresion);
        System.out.println("Resultado: " + resultado);
        System.out.println("---");
    }


    public void mostrarError(String expresion, String error) {
        System.out.println("Expresión: " + expresion);
        System.out.println("ERROR: " + error);
        System.out.println("---");
    }
}

