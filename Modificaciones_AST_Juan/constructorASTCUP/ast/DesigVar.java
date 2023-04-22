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
	public void bind(LinkedList<Map<String, Dec>> envs) {
		iden.bind(envs);
	}

	@Override
	public Dec getDeclaration() {
		return iden.nodeDec;
	}
}
