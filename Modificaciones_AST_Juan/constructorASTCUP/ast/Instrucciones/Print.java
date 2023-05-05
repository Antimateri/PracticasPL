package ast.Instrucciones;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Expresiones.*;
import ast.Tipos.*;
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
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return e.bind(envs);
	}
    
    public int maxMem(){
        return e.getSize();
    }

    public T type(){
        if(e.type().kind()==KindT.ERROR)return e.type();
        else return null;
    }

    public int setDelta(int last){
        return e.setDelta(last);
    }
    
    public String generateCode(){
        StringBuilder strb = new StringBuilder();
        strb.append(e.generateCode() + "\n");
        strb.append("call $print\n");
        return strb.toString();
    }
}
