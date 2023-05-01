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
        //Muestra del AST en string:
        return des.toString() + "[" + exp.toString() + "]";
        
        //Para debuggear generacion de codigo
        //aux = generateCode();
        //return "\n" + aux + "\n" + "(" + des.toString() + ")" + "[" + exp.toString() + "]";
    }

	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		des.bind(envs);
		exp.bind(envs);
	}

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

    //Tamaño del elemento del array al que estamos accediendo en este designador:
    public int getSize(){ return des.getSize(); } //creo que hay que corregir esto

}