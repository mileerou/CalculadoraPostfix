import java.util.ArrayList;
import java.util.EmptyStackException;
public class PilaNumeros<N> implements IPila<N> {
    private ArrayList<N> elementos;

    public PilaNumeros() {
        elementos = new ArrayList<>();
    }

    @Override
    public void push(N elemento) {
        elementos.add(elemento);
    }

    @Override
    public N pop() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    @Override
    public N peek() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public int tamano() {
        return elementos.size();
    }
}
