public interface IPila<N> {
    void push (N elemento);
    N pop();
    N peek();
    boolean estaVacia();
    int tamano();
}