package ast;

public class TSimple extends T{
    private KindT kind;

    public TSimple(KindT kind) {
        this.kind = kind;
    }

    public KindT kind() {return kind;}

    public String toString() {
        switch(kind){
          case INT:
            return "int ";
          case BOOL:
            return "bool ";
          default:
           return super.toString();
        }
    }
}
