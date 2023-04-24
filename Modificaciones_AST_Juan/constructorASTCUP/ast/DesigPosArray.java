package ast;

import java.util.LinkedList;
import java.util.Map;

//Designadores a posición de un array:
public class DesigPosArray extends Desig{
    private E exp;
    private Desig des;

    public KindDesig kind(){ return KindDesig.POSARRAY; }

    public DesigPosArray(Desig des, E exp){
        this.des = des;
        this.exp = exp;
    }

    public String toString(){
        return des.toString() + "[" + exp.toString() + "]";
    }


	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		des.bind(envs);
		exp.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return des.getDeclaration();
	}
}