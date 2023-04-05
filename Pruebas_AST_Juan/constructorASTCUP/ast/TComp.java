package ast;

public class TComp extends T{
    private KindT kind;
    private Iden iden;
    private RefMode refMode;

    public TComp(Iden iden, RefMode refMode) {
        this.kind = KindT.COMP;
        this.iden = iden;
    }

    public KindT kind() {return kind;}

    public RefMode refMode() {return refMode;}

    public String toString() {
        return "("+this.refMode+")"+iden.toString();
    }
}
