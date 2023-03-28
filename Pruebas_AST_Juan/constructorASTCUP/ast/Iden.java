package ast;

public class Iden extends Statement{
    private String name;
    public Iden(String v) {
        this.name = v;   
    }
    public NodeKind nodeKind() {return NodeKind.IDEN;}
    public String toString() {return name;}  
}
