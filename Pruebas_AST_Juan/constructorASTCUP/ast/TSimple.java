package ast;

//tipos predefinidos (int y bool)
public class TSimple extends T{
    // tipo
    private KindT kind;
    // modo de referencia (valor o referencia). en principio solo afectara a la asignacion
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
