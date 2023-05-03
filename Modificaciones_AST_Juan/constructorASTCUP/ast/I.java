package ast;

// nodo generico de todas las instrucciones
public abstract class I extends Statement{ 
    public abstract KindI kind();
    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}
    public T type(){
        return null;
    }
}
