package ast.Declaraciones;

import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import errors.Log;

// Nodo para la declaración de variables:
public class DecVar extends Dec{
    private T tipo; //Tipo de la variable declarada
    private int delta = 0;
    private int depth = 0;

  //El primer operador es el tipo y el segundo el identificador:
    public DecVar(T tipo, IdenVar id) {
        if(typed == null){
            typed = new HashSet<String>();
        }
        this.tipo = tipo;
        this.name = id;
    }

    public KindDec kind() {return KindDec.VAR;}

    public String toString() {
        return "var("+ tipo.toString()+","+ name.toString() + ")";
    }

    public int getSize(){ return tipo.getSize(); }

    public int setDelta(int last){ 
        this.delta = last;
        tipo.setDelta(0);
        return last + tipo.getSize();
    }

    public int getDelta(){ return delta; }
    
    public Map<String, Dec> getEnv(){
    	return tipo.getEnv();
    }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean out = true;
		if(envs.getFirst().containsKey(name.name)){
            Log.error(Log.ErrorType.REDEFINEDVARIABLE, this);
            out = false;
        }
		envs.getFirst().put(name.name, this);
        out &= name.bind(envs);
		out &= tipo.bind(envs);
        return out;
	}

    public T type(){
        return tipo.type();
    }

    public int maxMem(){
        return getSize();
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public int getDepth(){
        return depth;
    }
}
