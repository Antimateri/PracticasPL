package ast.Declaraciones;

import ast.Designadores.Desig;
import ast.Designadores.DesigVar;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;
import errors.Log;
import errors.Log.ErrorType;

import java.util.LinkedList;
import java.util.Map;

// Nodo para la definición de un nuevo tipo por parte del usuario (alias, typedef)
public class DecRef extends Dec{
    // Tipo al que se le asigna el alias:
    private Desig copia;
    private T t;

    public DecRef(T t, IdenVar name, Desig copia) {
        this.name = name;
        this.copia = copia;
        this.t= t;
    }

    public String toString() {
        return "refDef(" + name.toString() + " = " + copia.toString()+")";
    }

    public KindDec kind() { return KindDec.VAR; }

    public Map<String, Dec> getEnv(){
        return copia.getDeclaration().getEnv();
    }
    
	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
        if(copia.bind(envs)){
            envs.getFirst().put(name.name, copia.getDeclaration());
            return true;
        }
        return false;
	}
    
    public int setDelta(int last){
        return last;
    }

    public T type(){
        if(t.compatible(copia.type()))
            return t;
        Log.error(ErrorType.TIPEERROR, this);
        return new TError();
    }
	
}
