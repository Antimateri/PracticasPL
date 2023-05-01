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
		Map<String, Dec> env = des.getDeclaration().getEnv();
		if(env!=null)envs.push(env);
		id.bind(envs);
		if(env!=null)envs.pop();
	}

	@Override
	public Dec getDeclaration() {
		return id.nodeDec;
	}

	public T type() {
		if(des.type().kind()!=KindT.STRUCT) throw new IllegalArgumentException("Se intenta acceder a un campo de un tipo no struct");
		else{
			TStruct t = (TStruct)des.type();
			if(t.getDec(id.toString())!=null) return t.getDec(id.toString()).type();
			else throw new IllegalArgumentException("El struct no contiene el campo " + id.toString());
		}
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