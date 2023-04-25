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

    public T type() {
        if(des.type().kind()!=KindT.LIST) throw new IllegalArgumentException("Se intenta acceder a una posición de un tipo no array");
        if(exp.type().kind()!=KindT.INT) throw new IllegalArgumentException("Solo enteros pueden indexar arrays");
        else
            return ((TList)(des.type())).prevType().type();
    }

    public String generateCode(){ //no está bien
        StringBuilder str = new StringBuilder();
        str.append(des.generateCode()+"\n");
        //str.append("i32.const"+des.get+"\n");
        str.append("i32.mul\n");
        str.append(exp.generateCode()+"\n");
        str.append("i32.add\n");
        return str.toString();
    }
}