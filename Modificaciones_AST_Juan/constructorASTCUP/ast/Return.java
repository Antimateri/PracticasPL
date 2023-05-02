package ast;

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
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		e.bind(envs);
	}

    public T type() {
        return e.type();
    }

    public int maxMem(){
        return e.getSize();
    }

    public int setDelta(int last){
        return e.setDelta(last);
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();

        str.append(e.codeCopyReturn());

        str.append("call $freeStack \n )");
        str.append("return \n )");
        return str.toString();
    }
    
}
