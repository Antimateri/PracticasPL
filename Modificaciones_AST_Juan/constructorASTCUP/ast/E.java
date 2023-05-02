package ast;

// nodo basico para representar valores y operaciones que devulenvan valores
public abstract class E extends Statement { //Expresiones aritmético-lógicas
    public abstract KindE kind();

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}
    public int setDelta(int last){ return last; }

    public String codeCopyStack(int d){ return ""; } //solo para las expresiones en los campos de un struct anónimo 
    public String codeCopyReturn(){ return ""; } //solo para las expresiones que devolvemos con la instruccion return
    public String codeCopyAssign(String codeDirDest){ return ""; }
}
