package ast.Instrucciones;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Expresiones.*;
import ast.Tipos.*;
import java.util.LinkedList;
import java.util.Map;

// Nodo que engloba a los nodos de tipo instruccion como por ejemplo control de flujo o entrada/salida
public class Return extends I{
    private E e;

    public Return(E e) {
        super();
        this.e = e;
    }

    public String toString() {
        return "return " + e.toString();
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return e.bind(envs);
	}

    public T type() {
        return e.type();
    }

    public int maxMem(){
        return e.maxMem();
    }

    public int setDelta(int last){
        return e.setDelta(last);
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();

        String codeDirDest = "get_local $returnDir\n";
        str.append(e.codeCopyAssign(codeDirDest));

        str.append("call $freeStack \n");
        str.append("get_local $returnDir\n");
        str.append("return \n");
        return str.toString();
    }
    
}
