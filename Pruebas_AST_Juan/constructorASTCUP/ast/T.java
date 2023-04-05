package ast;

//tipo generico, representa solo el tipo, no tiene informacion de la propia variable
public abstract class T extends Statement{ //Constructoras de tipos
    public abstract KindT kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public RefMode refMode() {return RefMode.VALUE;}
    public String toString() {return "";}
}
