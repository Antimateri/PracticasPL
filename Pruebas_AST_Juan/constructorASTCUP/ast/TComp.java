package ast;

// tipos definidos por el usuario por typedef o struct por ejemplo
public class TComp extends T{
 
    //identificador del tipo
    private Iden iden;
    // modo de referencia
    private RefMode refMode;

    public TComp(Iden iden, RefMode refMode) {
        this.iden = iden;
    }

    public KindT kind() {return KindT.COMP;}

    public RefMode refMode() {return refMode;}

    public String toString() {
        return "("+this.refMode+")"+iden.toString();
    }
}
