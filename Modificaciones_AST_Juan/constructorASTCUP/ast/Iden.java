package ast;

import java.util.LinkedList;
import java.util.Map;

// Identificador de variable/funcion/tipo, palabras "reservadas" por el usuario
public abstract class Iden extends Statement{
    protected String name;
    protected Dec nodeDec;
    
    public Iden(String v) {
        this.name = v;   
    }
    public NodeKind nodeKind() {return NodeKind.IDEN;}
    public String toString() {return ((this.nodeDec!=null)? name :"Unknown");}

    public KindE kind() {return KindE.IDEN;}  
    
    @Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
    	boolean found=false;
    	for(Map<String, Dec> i : envs) {
    		if(i.containsKey(name)) {
    			nodeDec = i.get(name);
    			found=true;
    			break;
    		}
    	}
    	if(!found)throw new UndefinedVariableException(name);
    }

    public int getDelta(){ return nodeDec.getDelta(); }

    public T type() {
        return nodeDec.type();
    }

    public int getSize(){ return 0 ;} //type().getSize(); }
}
