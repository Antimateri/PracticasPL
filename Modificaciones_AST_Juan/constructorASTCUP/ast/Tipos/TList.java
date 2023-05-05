package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

// Tipo lista con tamaño definido
public class TList extends T{
    private T t; //tipo de sus elementos
    private int length; //longitud de la lista
    private int dim; // dimensión de la lista

    public TList(T t, int length) {
        this.t = t;
        this.length = length;
        this.dim = length;
        if (this.t.kind() == KindT.LIST) this.dim *= ((TList) t).getDim();
    }

    public String toString(){
        return "T["+Integer.toString(length)+"](" + t.toString() + ",  dim: " + Integer.toString(dim) +" )" ;
    }

    public KindT kind() { return KindT.LIST; }
    
    public int getSize(){ return length * t.getSize(); } //tamaño total en memoria del array

    public int getDim() { return dim; } //dimension total (en numero de elementos) del array

    public T prevType(){ return t; }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return t.bind(envs);
	}

    public boolean compatible(T t){
        return this.kind() == t.type().kind() && this.t.compatible(((TList)(t.type())).t.type()) && ((TList)(t.type())).length == this.length;
    }
}
