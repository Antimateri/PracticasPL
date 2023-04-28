package ast;

import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;

// Tipo lista de varias dimensiones
public class TListMultDim extends T{

    private T t; // tipo de sus elementos
    private ArrayList <Integer> dim; // tamaño de cada dimensión
    private int length;

    public TListMultDim(T t, ArrayList <Integer> dim) {
        this.t = t;
        this.dim = dim;
        this.length = 1;
        for (Intger i: dim) this.length *= i;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(t.toString());
        for (Integer i : dim) str.append("[" + i + "]");
        return str.toString();
    }

    // Esto no sé para qué sirve pero yo lo copio
    public KindT kind() { return KindT.LISTMULTIDIM; }
    
    public int getSize(){ return length * t.getSize(); }
    
    // Esto tampoco sé para qué sirve 
    public T prevType(){ return t; }

	// Esto no sé cómo se hace jeje ayuda
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		//t.bind(envs);
	}
    // Sorpresa, esto tampoco
    public boolean compatible(T t){
        //return this.kind() == t.type().kind() && this.t.compatible(((TListMultDim)(t.type())).t.type()) && ((TListMultDim)(t.type())).length == this.length;
        return true;
    }
}
