public class Calculadora implements IPostfix {
    // Se mantiene el atributo pero se inicializa en el constructor o método
    private IPila<Double> pila;

    @Override
    public double evaluarPostfix(String expresion) throws Exception {
        // Usamos la implementación de Pila que creaste
        pila = new PilaNumeros<Double>();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else {
                // Validación de operandos suficientes (Inciso 78)
                if (pila.tamano() < 2) {
                    throw new Exception("Error: Insuficientes operandos para el operador " + token);
                }
                double b = pila.pop();
                double a = pila.pop();
                double resultado = aplicarOperacion(a, b, token);
                pila.push(resultado);
            }
        }

        if (pila.tamano() != 1) {
            throw new Exception("Error: Expresión mal formada");
        }

        return pila.pop();
    }

    private boolean esNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double aplicarOperacion(double a, double b, String operador) throws Exception {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new Exception("Error: División por cero");
                return a / b;
            case "%": // Agregado según requerimiento del inciso 20
                return a % b;
            default:
                throw new Exception("Error: Carácter desconocido " + operador);
        }
    }
}