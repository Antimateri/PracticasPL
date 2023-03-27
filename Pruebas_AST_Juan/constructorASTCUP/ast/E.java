package ast;

public abstract class E extends Statement {
    public abstract KindE kind();

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

}
