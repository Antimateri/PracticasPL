package ast;

public abstract class T extends Statement{ //Constructoras de tipos
    public abstract KindT kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public RefMode refMode() {return RefMode.VALUE;}
    public String toString() {return "";}
}
