package ast;

//Nodo generico para representar sólo un tipo, no tiene información de la propia variable
public abstract class T extends Statement{ 
    public abstract KindT kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public RefMode refMode() {return RefMode.VALUE;}
    public String toString() {return "";}
    public int getSize(){ return 0; };
}
