package ast;

public class TSimple extends T{
    private KindT kind;
    private RefMode refMode;

    public TSimple(KindT kind, RefMode refMode) {
        this.kind = kind;
        this.refMode = refMode;
    }

    public KindT kind() {return kind;}

    public RefMode refMode() {return refMode;}

    public String toString() {
        switch(kind){
          case INT:
            return "("+this.refMode+")int";
          case BOOL:
            return "("+this.refMode+")bool";
          default:
           return super.toString();
        }
    }
}
