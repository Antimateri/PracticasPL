package ast;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

// Nodo para la definición de un nuevo tipo por parte del usuario (alias, typedef)
public class DecTipo extends Dec{
    // Identificador del nuevo tipo:
    private IdenType name;
    // Tipo al que se le asigna el alias:
    private T type;

    public DecTipo(IdenType name, T type) {
        this.name = name;
        this.type = type;
        name.setSize(type.getSize());
    }

    public String toString() {
        return "typeDef(" + name.toString() + " = " + type.toString()+")";
    }

    public KindDec kind() { return KindDec.TYPE; }
    
	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		boolean out = true;
        if(envs.getFirst().containsKey(name.name)){
            Log.error(Log.ErrorType.REDEFINEDVARIABLE, this);
            out = false;
        }
		envs.getFirst().put(name.name, this);
        out &= name.bind(envs);
		out &= type.bind(envs);
        return out;
	}

    public int setDelta(int last){
        type.setDelta(0);
        return last;
    }

    public T type(){
        return type.type();
    }
	
}
