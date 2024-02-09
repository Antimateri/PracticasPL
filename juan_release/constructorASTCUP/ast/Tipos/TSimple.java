package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

//tipos predefinidos (int y bool)
public class TSimple extends T{
    // tipo
    private KindT kind;

    public TSimple(KindT kind) {
        this.kind = kind;
    }

    public KindT kind() {return kind;}

    public String toString() {
        switch(kind){
          case INT:
            return "int";
          case BOOL:
            return "bool";
          default:
           return super.toString();
        }
    }

    public int getSize(){ return 4; } //en cualquier caso, sea int o bool, sea por valor o por referencia

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){return true;}
}
