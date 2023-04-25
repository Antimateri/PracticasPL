package ast;

import java.util.LinkedList;
import java.util.Map;

// Devuelve la direccion de una variable, para inicializar punteros
public class GetVarDir extends E{
    
    private E name;

    public GetVarDir(E name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("getVarDir(");
        strb.append(name.toString()+")");
        return strb.toString();
    }

    @Override
    public KindE kind() {
        return KindE.IDEN;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		name.bind(envs);
		
	}

    public T type() {
        return new TPointer(name.type());
    }

}
