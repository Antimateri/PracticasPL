package ast;

public abstract class D extends Statement{ //Declaraciones
    public abstract KindD kind();

    public NodeKind nodeKind() {return NodeKind.DECLARATION;}
    public String toString() {return "";}
}
