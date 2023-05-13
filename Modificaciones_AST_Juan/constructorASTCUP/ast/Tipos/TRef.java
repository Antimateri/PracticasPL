package ast.Tipos;

import java.util.LinkedList;
import java.util.Map;

import ast.Declaraciones.Dec;
import ast.Enumeradores.KindT;

@Deprecated
public class TRef extends T {

    private T t;
    private boolean fAsig;

    public TRef(T t) {
        this.t = t;
        fAsig = false;
    }

    public String toString(){
        return "ref(" + t.toString() +")";
    }

    public void asignado(){
        fAsig = true;
    }

    public void noAsignado(){
        fAsig = false;
    }

    @Override
    public T type(){
        if(fAsig)
            return prevType();
        else
            return new TPointer(prevType());
    }

    public KindT kind() { 
        if(fAsig)
            return t.kind();
        else
            return KindT.POINTER; 
    }

    public int getSize(){ return 4; } //el tamaño de un puntero es la de la dirección, que es 32b

    public T prevType(){ return t.type(); }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return t.bind(envs);
	}
}
