package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import java.util.LinkedList;
import java.util.Map;

// Recibe un tipo y devuelve un puntero de ese tipo
public class TPointer extends T{
    //el tipo a transformar
    private T t;

    public TPointer(T t) {
        this.t = t;
    }

    public String toString(){
        return "pointer(" + t.toString() +")";
    }

    public KindT kind() { return KindT.POINTER; }

    public int getSize(){ return 4; } //el tamaño de un puntero es la de la dirección, que es 32b

    public T prevType(){ return t; }

    public int setDelta(int x){ //en este caso ignoramos el parámetro, no nos hace falta
        return t.setDelta(x);
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return t.bind(envs);
	}

    public Map<String, Dec> getEnv(){
    	return t.getEnv();
    }

    
}
