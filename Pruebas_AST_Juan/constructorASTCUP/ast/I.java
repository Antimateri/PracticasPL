package ast;

public abstract class I extends Statement{
    public abstract KindI kind();

    public Statement opnd1() {throw new UnsupportedOperationException("opnd1");} 
    public Statement opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public Statement opnd3() {throw new UnsupportedOperationException("opnd3");} 

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}
}
