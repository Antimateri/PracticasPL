package ast;

public abstract class Statement implements ASTNode{
    public abstract NodeKind nodeKind();

    public Statement opnd(int i) {throw new UnsupportedOperationException("opnd [" + i + "]");} 

    public String toString() {return "";}

    public int setDelta(int last){ return last; }

    public String generateCode(){ return ""; }

    public int maxMem(){ return 0; }

    public int getSize(){ return 0; }

    public void setDepth(int depth){}
}
