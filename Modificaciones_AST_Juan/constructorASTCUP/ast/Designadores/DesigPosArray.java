package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Expresiones.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

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
        //Muestra del AST en string:
        return des.toString() + "[" + exp.toString() + "]";
        
        //Para debuggear generacion de codigo
        //aux = generateCode();
        //return "\n" + aux + "\n" + "(" + des.toString() + ")" + "[" + exp.toString() + "]";
    }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean out = true;
		out &= des.bind(envs);
		out &= exp.bind(envs);
        return out;
	}

	public Dec getDeclaration() {
		return des.getDeclaration();
	}

    public T type() {
        T out;
        if(des.type().kind()!=KindT.LIST){
            Log.error(Log.ErrorType.TIPEERROR, this);
            out = new TError();
        }
        else
            out = ((TList)(des.type())).prevType().type();
        if(exp.type().kind()!=KindT.INT){
            Log.error(Log.ErrorType.TIPEERROR, this);
            out = new TError();
        }
        return out;
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