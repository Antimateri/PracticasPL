package ast;

import java.util.LinkedList;
import java.util.Map;

// Designador a la dirección de un designador dado
public class DesigRef extends Desig{
    private Desig des;

    public KindDesig kind(){ return KindDesig.REF; }

    public DesigRef(Desig des){
        this.des = des;
    }

    public String toString(){
        StringBuilder strb = new StringBuilder();
        strb.append("getVarDir(");
        strb.append(des.toString()+")");
        return strb.toString();
    }


	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		des.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return des.getDeclaration();
	}

    public T type() {
        return new TPointer(des.type());
    }
}
