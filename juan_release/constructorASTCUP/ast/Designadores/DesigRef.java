package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Tipos.*;
import java.util.LinkedList;
import java.util.Map;

// Designador a la dirección de un designador dado
@Deprecated
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
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return des.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return des.getDeclaration();
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
