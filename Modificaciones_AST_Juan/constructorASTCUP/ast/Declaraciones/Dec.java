package ast.Declaraciones;


import ast.Enumeradores.*;
import ast.Instrucciones.*;

import java.util.HashSet;
import java.util.Map;

// Nodo básico para representar declaraciones
public abstract class Dec extends Statement{

    //pa evitar recursion infinita
    protected static HashSet<String> typed;

    //Nombre de lo que se declara
    protected Iden name;

    public abstract KindDec kind(); //Devuelve el tipo de declaración
    public NodeKind nodeKind() {return NodeKind.DECLARATION;}
    public String toString() {return "";}
    //para structs
    public Map<String, Dec> getEnv(){
    	return null;
    }

    public Iden getName(){
        return name;
    }

    public int getSize() { return 0; }

    public int setDelta(int last){ return last; } 
    public int getDelta(){ return 0; }

    public int getDepth(){
        return 0;
    }
}
