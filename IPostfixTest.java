public interface IPostfix {
    double evaluarPostfix(String expresion) throws Exception;
}

import static org.junit.Assert.*;
import org.junit.Test;

public class IPostfixTest {
    @Test
    public void testSumaYMultiplicacion() throws Exception {
        Calculadora calc = new Calculadora();
        //
        assertEquals(15.0, calc.evaluarPostfix("1 2 + 4 * 3 +"), 0.001);
    }

    @Test(expected = Exception.class)
    public void testDivisionPorCero() throws Exception {
        Calculadora calc = new Calculadora();
        calc.evaluarPostfix("10 0 /");
    }
}