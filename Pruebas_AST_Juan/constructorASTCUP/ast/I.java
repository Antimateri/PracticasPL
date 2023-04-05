package ast;

// nodo generico de todas las instrucciones, es decir que no devuelven nada
public abstract class I extends Statement{ //Instrucciones
    public abstract KindI kind();
    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}
}
