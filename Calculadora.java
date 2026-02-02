public class Calculadora implements IPostfix {
    private IPila<Double> pila;
    
    @Override
    public double evaluarPostfix(String expresion) throws Exception {
        PilaNumeros pila = new PilaNumeros();
        String[] tokens = expresion.split(" ");
        
        for (String token : tokens) {
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else {
                double b = (double) pila.pop();
                double a = (double) pila.pop();
                double resultado = aplicarOperacion(a, b, token);
                pila.push(resultado);
            }
        }
        
        return (double) pila.pop();
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
                if (b == 0) {
                    throw new Exception("División por cero");
                }
                return a / b;
            default:
                throw new Exception("Operador desconocido: " + operador);
        }
    }
}