package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Expresiones.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

//Designadores a posición de un array:
public class DesigPosArray extends Desig{
    private E exp;
    private Desig des;

    public DesigPosArray(Desig des, E exp){
        this.des = des;
        this.exp = exp;
    }

    public String toString(){
        // Muestra del AST en string:
        //return generateCode() + "\n";
        return des.toString() + "[" + exp.toString() + "], size = " + this.type().getSize() + "\n";
        //return type().toString();
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
        int cont = 1;
        Desig currDes = des;
        while (currDes.kind() == KindDesig.POSARRAY) {
            ++cont;
            currDes = ((DesigPosArray) currDes).nextDesig();
        }
        T currT = currDes.type();
        for (int i = 0; i < cont; ++i) currT = ((TList) currT).nextType();
        return currT;
    }

    public KindDesig kind() { return KindDesig.POSARRAY; }

    public Desig nextDesig() { return des; }

    public String generateCode(){ // Deja en la cima de la pila la posición referida
        StringBuilder str = new StringBuilder();
        //if (des.kind() == KindDesig.VAR) {
            str.append(des.generateCode());
            str.append(exp.generateCode());
            str.append("i32.const " + type().getSize() + "\n");
            str.append("i32.mul\n");
            str.append("i32.add\n");
        //}
        /*else {
            String aux = des.generateCode();
            str.append(exp.generateCode());
            str.append("i32.const " + des.type().getSize() + "\n");
            str.append("i32.mul\n");
            str.append("i32.add\n");
            str.append(des.generateCode());
        }*/
        
        return str.toString();
    }

    //Tamaño del elemento del array al que estamos accediendo en este designador:
    public int getSize(){ return type().getSize(); }

}