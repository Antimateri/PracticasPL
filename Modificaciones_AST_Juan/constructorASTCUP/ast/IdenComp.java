package ast;


//     en proceso de eliminación, será sustituido por un designador    //


// identificador compuesto: para acceder a campos de registros
public class IdenComp extends Iden {
    // identificador del campo de v al que se quiere acceder
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
