package ast;

// Nodo que engloba a los nodos de tipo instruccion como por ejemplo control de flujo o entrada/salida
public class Return extends I{

    private E e;

    public Return(E e) {
        super();
        this.e = e;
    }

    public String toString() {
        return "return " + e.toString();
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }
    
}
