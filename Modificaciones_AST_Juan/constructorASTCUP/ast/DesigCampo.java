package ast;

import java.util.LinkedList;
import java.util.Map;

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
        return des.toString() + "." + id.toString() + "]";
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		des.bind(envs);
		System.out.println(des.getDeclaration().toString());
		Map<String, Dec> env = des.getDeclaration().getEnv();
		if(env!=null)envs.push(env);
		id.bind(envs);
		if(env!=null)envs.pop();
	}

	@Override
	public Dec getDeclaration() {
		return id.nodeDec;
	}
}