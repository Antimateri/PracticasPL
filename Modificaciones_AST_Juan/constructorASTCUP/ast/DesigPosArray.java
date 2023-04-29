package ast;

import java.util.LinkedList;
import java.util.Map;

//Designadores a posición de un array:
public class DesigPosArray extends Desig{
    private E exp;
    private Desig des;
    private String aux;

    public KindDesig kind(){ return KindDesig.POSARRAY; }

    public DesigPosArray(Desig des, E exp){
        this.des = des;
        this.exp = exp;
    }

    public String toString(){
        //String ret = "(" + des.toString() + ")" + "[" + exp.toString() + "]";
        //ret = ret + generateCode();
        //return ret;
        aux = generateCode();
        return "\n" + aux + "\n" + "(" + des.toString() + ")" + "[" + exp.toString() + "]";
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

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        if (des.kind() == KindDesig.VAR){
            str.append(des.generateCode());
            str.append(exp.generateCode());
        }
        else{
            str.append(des.generateCode());
            TList arr = (TList) des.type(); // Esto se supone que tiene que ser un array
            str.append("i32.const " + Integer.toString(arr.getDim()) + "\n");
            str.append("i32.mul\n");
            str.append(exp.generateCode());
            str.append("i32.add\n");
        }
        
        return str.toString();
    }
}