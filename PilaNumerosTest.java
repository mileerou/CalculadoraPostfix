import static org.junit.Assert.*;
import org.junit.Test;

public class PilaNumerosTest {

    @Test
    public void testPushPop() {
        // Probamos con Integer para verificar que el generico <N> funciona
        PilaNumeros<Integer> pila = new PilaNumeros<>();
        pila.push(10);
        pila.push(20);

        // El último en entrar (20) debe ser el primero en salir
        int valor = pila.pop();
        assertEquals(20, valor);
    }

    @Test
    public void testEstaVacia() {
        PilaNumeros<String> pila = new PilaNumeros<>();
        // Al inicio debe estar vacía
        assertTrue(pila.estaVacia());

        pila.push("Hola");
        // Después de insertar, ya no debe estar vacía
        assertFalse(pila.estaVacia());
    }

    @Test
    public void testPeek() {
        PilaNumeros<Integer> pila = new PilaNumeros<>();
        pila.push(5);

        // Peek debe ver el valor sin sacarlo de la pila
        int valor = pila.peek();
        assertEquals(5, valor);

        // El tamaño debe seguir siendo 1 porque no hicimos pop
        assertEquals(1, pila.tamano());
    }
}