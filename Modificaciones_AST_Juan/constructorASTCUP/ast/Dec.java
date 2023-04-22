package ast;

import java.util.HashMap;
import java.util.Map;

// Nodo básico para representar declaraciones
public abstract class Dec extends Statement{
    public abstract KindDec kind(); //Devuelve el tipo de declaración
    public NodeKind nodeKind() {return NodeKind.DECLARATION;}
    public String toString() {return "";}
    //para structs
    public Map<String, Dec> getEnv(){
    	return new HashMap<String, Dec>();
    }

    public int getSize() { return 0; }

    public int setDelta(int last){ return last; } 
}
