package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

//Designadores a campo de un registro:
public class DesigCampo extends Desig{
    private Desig des;
    private IdenVar id; //identificador del campo del struct correspondiente

    public KindDesig kind(){ return KindDesig.SELCAMPO; }

    public DesigCampo(Desig des, IdenVar id){
        this.des = des;
        this.id = id;
    }

    public String toString(){
        return des.toString() + "." + id.toString();
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		boolean out = true;
		out &= des.bind(envs);
		Map<String, Dec> env = des.getDeclaration().type().getEnv();
		envs.push(env);
		out &= id.bind(envs);
		envs.pop();
		return out;
	}

	@Override
	public Dec getDeclaration() {
		return id.nodeDec;
	}

	public T type() {
		if(des.type().kind()!=KindT.STRUCT) Log.error(Log.ErrorType.TIPEERROR, this);
		else{
			TStruct t = (TStruct)des.type();
			if(t.getDec(id.name)!=null) return t.getDec(id.name).type();
			else Log.error(Log.ErrorType.UNDEFINEDVARIABLE, this);
		}
		return new TError();
	}

	public String generateCode(){
		StringBuilder str = new StringBuilder();
		str.append(des.generateCode());
		str.append("i32.const " + id.getDelta() + "\n");
		str.append("i32.add\n");
		return str.toString();
	}

	public int getSize(){ return id.getSize(); }

}