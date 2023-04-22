package ast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Nodo para la declaración de variables:
public class DecVar extends Dec{
    private T tipo; //Tipo de la variable declarada
    private IdenVar identificador; //Identificador de la variable declarada

  //El primer operador es el tipo y el segundo el identificador:
    public DecVar(T tipo, IdenVar id) {
        this.tipo = tipo;
        this.identificador = id;
    }

    public KindDec kind() {return KindDec.VAR;}

    public String toString() {
        return "var("+tipo.toString()+","+identificador.toString()+")";
    }

    public int getSize(){ return tipo.getSize(); }

    public int setDelta(int last){ 
        identificador.setDelta(last);
        return last + tipo.getSize();
    }
    
    public Map<String, Dec> getEnv(){
    	boolean x = (this.tipo instanceof TStruct);
    	return x? ((TStruct)tipo).getEnv() : new HashMap<String, Dec>();
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) {
		envs.getFirst().put(identificador.name, this);
		tipo.bind(envs);
	}
}
