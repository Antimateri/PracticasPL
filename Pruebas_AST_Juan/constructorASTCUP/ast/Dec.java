package ast;

// Nodo básico para representar declaraciones
public abstract class Dec extends Statement{
    public abstract KindDec kind(); //Devuelve el tipo de declaración
    public NodeKind nodeKind() {return NodeKind.DECLARATION;}
    public String toString() {return "";}
}
