package ast;

public class IdenComp extends Iden {

    private Iden iden;

    public IdenComp(String v, Iden iden) {
        super(v);
        this.iden = iden;
    }

    public KindE kind() {return KindE.IDENCOMP;}

    public String toString() {
        return "campo(" + super.toString() + "," + iden.toString()+ ")";
    }
}
