package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import java.util.Map;

//Nodo generico para representar sólo un tipo, no tiene información de la propia variable
public abstract class T extends Statement{ 
    public abstract KindT kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public String toString() {return "";}
    public int getSize(){ return 0; };
    //para structs
    public Map<String, Dec> getEnv(){
    	return null;
    }
    public T type(){ return this;}
    public boolean compatible(T t){
        return this.kind() == t.type().kind();
    }
}
