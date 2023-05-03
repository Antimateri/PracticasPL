package ast;

public abstract class Statement implements ASTNode{
	
	protected int line=-1;
	
	public void setLine(int line) {
		this.line=line;
	}

    public int getLine(){
        return line;
    }
	
    public abstract NodeKind nodeKind();

    public Statement opnd(int i) {throw new UnsupportedOperationException("opnd [" + i + "]");} 

    public String toString() {return "";}

    public int setDelta(int last){ return last; }

    public String generateCode(){ return ""; }

    public int maxMem(){ return 0; }

    public int getSize(){ return 0; }

    public void setDepth(int depth){}

    public String generateDecFun(){ return ""; }
}
