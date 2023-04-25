package ast;

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

    public String toString(){
        return "T["+Integer.toString(length)+"](" + t.toString() +")";
    }

    public KindT kind() { return KindT.LIST; }
    
    public int getSize(){ return length * t.getSize(); }

    public T prevType(){ return t; }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		t.bind(envs);
	}

    public boolean compatible(T t){
        return this.kind() == t.type().kind() && this.t.compatible(((TList)(t.type())).t.type()) && ((TList)(t.type())).length == this.length;
    }
}
