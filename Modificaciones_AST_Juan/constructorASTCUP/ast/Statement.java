package ast;

public abstract class Statement implements ASTNode{
    public abstract NodeKind nodeKind();

    public Statement opnd(int i) {throw new UnsupportedOperationException("opnd [" + i + "]");} 

    public String toString() {return "";}
}
