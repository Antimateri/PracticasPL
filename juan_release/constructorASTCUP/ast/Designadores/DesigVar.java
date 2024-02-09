package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import java.util.LinkedList;
import java.util.Map;

//Designadores a identificadores de variables:
public class DesigVar extends Desig{
    private IdenVar iden;

    public KindDesig kind(){ return KindDesig.VAR; }

    public DesigVar(IdenVar iden){
        this.iden = iden;
    }

    public String toString(){
        return iden.toString() + "depth=" + iden.getDepth();
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return iden.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return iden.nodeDec;
	}

    //devuelve la direccion del MP en el que fue declarada la variable (no necesariamente en el actual)
    public String getRealMP(){
        if(iden.getDepth() == 0) 
            return "i32.const 0\n";
        else 
            return "get_global $MP\n";
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        str.append("i32.const "+iden.getDelta()+"\n");
        str.append(getRealMP()); 
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n"); //Aun no funciona
        return str.toString();
    }

    public int getSize(){ return iden.getSize(); }

}
