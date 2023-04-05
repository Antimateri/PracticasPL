package ast;

// nodo basico para representar valores y operaciones que devulenvan valores
public abstract class E extends Statement { //Expresiones aritmético-lógicas
    public abstract KindE kind();

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

}
