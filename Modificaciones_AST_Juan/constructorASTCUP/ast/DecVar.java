package ast;

import java.util.LinkedList;
import java.util.Map;

// Nodo para la declaración de variables:
public class DecVar extends Dec{
    private T tipo; //Tipo de la variable declarada
    private IdenVar identificador; //Identificador de la variable declarada
    private int delta = 0;

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

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		if(envs.getFirst().containsKey(identificador.name)) 
			throw new RedefinedVariableException(identificador.name);
		envs.getFirst().put(identificador.name, this);
        identificador.bind(envs);
		tipo.bind(envs);
	}

    public T type(){
        return tipo.type();
    }
}
