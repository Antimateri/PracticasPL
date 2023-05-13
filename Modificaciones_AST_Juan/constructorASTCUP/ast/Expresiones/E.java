package ast.Expresiones;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
// nodo basico para representar valores y operaciones que devulenvan valores
public abstract class E extends Statement { //Expresiones aritmético-lógicas
    public abstract KindE kind();

    //public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}
    public int setDelta(int last){ return last; }

    public String codeCopyStack(int d){ return ""; } //solo para las expresiones en los campos de un struct anónimo 
    //public String codeCopyAssign(String codeDirDest){ return ""; }
    public String codeCopyAssign(String codeDirDest){ //recibe en string el codigo necesario para obtener la direccion de destino
        StringBuilder str = new StringBuilder();
        str.append(codeDirDest);
        str.append(this.generateCode());
        str.append("i32.store\n");
        return str.toString();
	}
}
