package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

//tipos predefinidos (int y bool)
public class TSimple extends T{
    // tipo
    private KindT kind;
    // modo de referencia (valor o referencia). En principio solo afectará a la asignación
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

    public int getSize(){ return 4; } //en cualquier caso, sea int o bool, sea por valor o por referencia

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){return true;}
}
