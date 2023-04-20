package ast;

// tipos definidos por el usuario por typedef o struct
public class TComp extends T{
    //identificador del tipo
    private IdenType iden;
    // modo de referencia
    private RefMode refMode;

    public TComp(IdenType iden, RefMode refMode) {
        this.refMode = refMode;
        this.iden = iden;
    }

    public KindT kind() {return KindT.COMP;}

    public RefMode refMode() {return refMode;}

    public String toString() {
        return "("+this.refMode+")"+iden.toString();
    }

    public int getSize(){ 
        if(refMode == RefMode.REF)
            return 1;
        else 
            return iden.getSize(); //devuelve el tamaño asociado al identificador de tipo
    }
}
