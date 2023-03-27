package ast;

public abstract class Statement implements ASTNode{
    public abstract NodeKind nodeKind();

    public Statement opnd1() {throw new UnsupportedOperationException("opnd1");} 
    public Statement opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public Statement opnd3() {throw new UnsupportedOperationException("opnd3");}

    public String toString() {return "";}
}
