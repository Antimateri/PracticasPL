package ast.Expresiones;

import java.util.LinkedList;
import java.util.Map;

import ast.Declaraciones.Dec;
import ast.Designadores.Desig;
import ast.Enumeradores.KindE;
import ast.Tipos.T;
import ast.Tipos.TPointer;

public class GetVarDir extends E {

    private Desig des;

    public KindE kind(){ return KindE.REF; }

    public GetVarDir(Desig des){
        this.des = des;
    }

    public String toString(){
        StringBuilder strb = new StringBuilder();
        strb.append("getVarDir(");
        strb.append(des.toString()+")");
        return strb.toString();
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return des.bind(envs);
	}

    public T type() {
        return new TPointer(des.type());
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        str.append(des.generateCode()+"\n");
        return str.toString();
    }

    public int getSize(){ return 4; }

}
