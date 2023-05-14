package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

// Tipo lista con tamaño definido
public class TList extends T{
    private T t; //tipo de sus elementos
    private int length; //longitud de la lista

    public TList(T t, int length) {
        this.t = t;
        this.length = length;
    }

    public void addList(int dim) {
        if (t.kind() != KindT.LIST) t = new TList(t, dim);
        else ((TList) t).addList(dim);
    }

    public String toString(){
        return "T["+Integer.toString(length)+"](" + t.toString() + ")" ;
    }

    public KindT kind() { return KindT.LIST; }
    
    public int getSize(){ return length * t.getSize(); } //tamaño total en memoria del array

    public T nextType(){ return t; }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return t.bind(envs);
	}

    public Map<String, Dec> getEnv(){
        return t.getEnv();
    }

    public int setDelta(int x){ //en este caso ignoramos el parámetro, no nos hace falta
        return t.setDelta(x);
    }

    public boolean compatible(T t){
        return this.kind() == t.type().kind() && this.t.compatible(((TList)(t.type())).t.type()) && ((TList)(t.type())).length == this.length;
    }
}
