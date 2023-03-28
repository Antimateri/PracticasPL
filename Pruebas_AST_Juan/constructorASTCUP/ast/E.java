package ast;

public abstract class E extends Statement { //Expresiones aritmético-lógicas
    public abstract KindE kind();

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

}
