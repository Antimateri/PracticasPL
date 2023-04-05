package ast;

// variable/funcion/tipo, palabras "reservadas" por el usuario
public class Iden extends E{
    private String name;
    public Iden(String v) {
        this.name = v;   
    }
    public NodeKind nodeKind() {return NodeKind.IDEN;}
    public String toString() {return name;}
    @Override
    public KindE kind() {
        return KindE.IDEN;
    }  
}
