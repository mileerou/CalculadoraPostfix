import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class IPostfixTest {
    private IPostfix calculadora;

    @Before
    public void setUp() {
        IPila<Integer> pila = new PilaNumeros<>();
        calculadora = new Calculadora(pila);
    }

    @Test
    public void testSumaSimple() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("1 2 +");
        assertEquals("1 + 2 debería ser 3", 3, resultado);
    }

    @Test
    public void testRestaSimple() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("5 3 -");
        assertEquals("5 - 3 debería ser 2", 2, resultado);
    }

    @Test
    public void testMultiplicacionSimple() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("4 3 *");
        assertEquals("4 * 3 debería ser 12", 12, resultado);
    }

    @Test
    public void testDivisionSimple() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("10 2 /");
        assertEquals("10 / 2 debería ser 5", 5, resultado);
    }

    @Test
    public void testModuloSimple() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("8 3 %");
        assertEquals("8 % 3 debería ser 2", 2, resultado);
    }

    @Test
    public void testExpresionCompleja() throws Exception {
        // ((1 + 2) * 4) + 3 = 15
        int resultado = (int) calculadora.evaluarPostfix("1 2 + 4 * 3 +");
        assertEquals("((1 + 2) * 4) + 3 debería ser 15", 15, resultado);
    }

    @Test
    public void testOtraExpresionCompleja() throws Exception {
        // 6 * (2 + 3) = 30
        int resultado = (int) calculadora.evaluarPostfix("6 2 3 + *");
        assertEquals("6 * (2 + 3) debería ser 30", 30, resultado);
    }

    @Test
    public void testExpresionConNumerosGrandes() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("100 50 + 2 *");
        assertEquals("(100 + 50) * 2 debería ser 300", 300, resultado);
    }

    @Test
    public void testExpresionConVariosDigitos() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("123 456 +");
        assertEquals("123 + 456 debería ser 579", 579, resultado);
    }

    @Test(expected = Exception.class)
    public void testDivisionPorCero() throws Exception {
        calculadora.evaluarPostfix("5 0 /");
    }

    @Test(expected = Exception.class)
    public void testModuloPorCero() throws Exception {
        calculadora.evaluarPostfix("5 0 %");
    }

    @Test(expected = Exception.class)
    public void testOperandosInsuficientes() throws Exception {
        calculadora.evaluarPostfix("1 +");
    }

    @Test(expected = Exception.class)
    public void testOperandosInsuficientesComplejo() throws Exception {
        calculadora.evaluarPostfix("1 2 3 + +");
    }

    @Test(expected = Exception.class)
    public void testCaracterInvalido() throws Exception {
        calculadora.evaluarPostfix("1 2 # +");
    }

    @Test(expected = Exception.class)
    public void testExpresionIncompleta() throws Exception {
        // Sobran operandos
        calculadora.evaluarPostfix("1 2 3 +");
    }

    @Test
    public void testExpresionConEspaciosExtra() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("  1   2   +   ");
        assertEquals("Debería manejar espacios extra", 3, resultado);
    }

    @Test
    public void testOrdenOperandosResta() throws Exception {
        // Verifica que el orden sea correcto: 10 - 3 = 7, no 3 - 10 = -7
        int resultado = (int) calculadora.evaluarPostfix("10 3 -");
        assertEquals("10 - 3 debería ser 7", 7, resultado);
    }

    @Test
    public void testOrdenOperandosDivision() throws Exception {
        // Verifica que el orden sea correcto: 20 / 4 = 5, no 4 / 20 = 0
        int resultado = (int) calculadora.evaluarPostfix("20 4 /");
        assertEquals("20 / 4 debería ser 5", 5, resultado);
    }

    @Test
    public void testExpresionLarga() throws Exception {
        // 15 7 1 1 + - / 3 * 2 1 1 + + -
        // = ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))
        // = ((15 / (7 - 2)) * 3) - (2 + 2)
        // = ((15 / 5) * 3) - 4
        // = (3 * 3) - 4
        // = 9 - 4
        // = 5
        int resultado = (int) calculadora.evaluarPostfix("15 7 1 1 + - / 3 * 2 1 1 + + -");
        assertEquals("Expresión larga debería dar 5", 5, resultado);
    }

    @Test
    public void testUnSoloNumero() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("42");
        assertEquals("Un solo número debería devolver ese número", 42, resultado);
    }

    @Test
    public void testCero() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("0 5 +");
        assertEquals("0 + 5 debería ser 5", 5, resultado);
    }

    @Test
    public void testResultadoNegativo() throws Exception {
        int resultado = (int) calculadora.evaluarPostfix("3 10 -");
        assertEquals("3 - 10 debería ser -7", -7, resultado);
    }
}