package ast;

public abstract class T extends Statement{ //Constructoras de tipos
    public abstract KindT kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public String toString() {return "";}
}
