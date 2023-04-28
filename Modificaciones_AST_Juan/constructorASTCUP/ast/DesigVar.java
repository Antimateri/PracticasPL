package ast;

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
        return iden.toString();
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		iden.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return iden.nodeDec;
	}

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        str.append("i32.const"+iden.getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");
        return str.toString();
    }

    public int getSize(){ return iden.getSize(); }


    
    public String copyParam(int d){ //falta por terminar
        StringBuilder str = new StringBuilder();
        str.append("get_global $SP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        //hemos dejado SP+8 en la cima de la pila

        return str.toString();
    }
}
