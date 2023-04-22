package ast;

import java.util.LinkedList;
import java.util.Map;

// funcion print de output
public class Print extends I{

    //recibe una expresion ya que deberia poder imprimir cualquier cosa con valor
    private E e;

    public Print(E e) {
        this.e = e;
    }

    public String toString(){
        return "print(" + e.toString() +")";
    }

    @Override
    public KindI kind() {
        return KindI.PRINT;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) {
		e.bind(envs);
	}
    
    
}
