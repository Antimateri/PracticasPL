package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

//tipo que se usa en tipado
public class TError extends T{

    public TError() {}

    public KindT kind() {return KindT.ERROR;}

    public String toString() {
        return "esto no deberia salir, ups?";
    }

    public boolean compatible(T t){
      return true;
  }

    public int getSize(){ return 0; } //en cualquier caso, sea int o bool, sea por valor o por referencia

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs) {
    return false;
  }
}
