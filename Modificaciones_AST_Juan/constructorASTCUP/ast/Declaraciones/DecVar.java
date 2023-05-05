package ast.Declaraciones;

import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

// Nodo para la declaración de variables:
public class DecVar extends Dec{
    private T tipo; //Tipo de la variable declarada
    private IdenVar identificador; //Identificador de la variable declarada
    private int delta = 0;
    private int depth = 0;

  //El primer operador es el tipo y el segundo el identificador:
    public DecVar(T tipo, IdenVar id) {
        this.tipo = tipo;
        this.identificador = id;
    }

    public KindDec kind() {return KindDec.VAR;}

    public String toString() {
        return "var("+ tipo.toString()+","+ identificador.toString() + ")";
    }

    public int getSize(){ return tipo.getSize(); }

    public int setDelta(int last){ 
        this.delta = last;
        return last + tipo.getSize();
    }

    public int getDelta(){ return delta; }
    
    public Map<String, Dec> getEnv(){
    	return tipo.getEnv();
    }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean out = true;
		if(envs.getFirst().containsKey(identificador.name)){
            Log.error(Log.ErrorType.REDEFINEDVARIABLE, this);
            out = false;
        }
		envs.getFirst().put(identificador.name, this);
        out &= identificador.bind(envs);
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
