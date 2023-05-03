package ast;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

// Identificador de variable/funcion/tipo, palabras "reservadas" por el usuario
public abstract class Iden extends Statement{
    protected String name;
    protected Dec nodeDec;
    
    public Iden(String v) {
        this.name = v;   
    }
    public NodeKind nodeKind() {return NodeKind.IDEN;}
    public String toString() {return ((this.nodeDec!=null)? name :"Unknown");}
    
    @Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
    	boolean found=false;
    	for(Map<String, Dec> i : envs) {
    		if(i.containsKey(name)) {
    			nodeDec = i.get(name);
    			found=true;
    			break;
    		}
    	}
    	if(!found){
            Log.error(Log.ErrorType.UNDEFINEDVARIABLE, this);
            return false;
        }
        return true;
    }

    public int getDelta(){ return nodeDec.getDelta(); }

    public T type() {
        return nodeDec.type();
    }

    public int getSize(){ return type().getSize(); }
}
