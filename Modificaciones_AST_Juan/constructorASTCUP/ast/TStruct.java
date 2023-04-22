package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Tipo declarado como struct anonimo
// (int a, int b) a; por ejemplo 
public class TStruct extends T{
    //lista de elementos de la estructura, son todos declaraciones de variables
    private ArrayList<Dec> opnd;
    //definimos su env particular
    private Map<String, Dec> env;

    public TStruct(Dec opnd1) {
        this.opnd = new ArrayList<Dec>();
        this.opnd.add(opnd1);
    }

    // añade un elemento a la lista de elementos de la estructura
    public void append(Dec st) { opnd.add(st); }

    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("StructType(");
		for (Dec s : opnd) {
            strb.append(s.toString());
            strb.append(", ");
        }
        strb.deleteCharAt(strb.length()-1);
        strb.deleteCharAt(strb.length()-1);
        strb.append(")");
		return strb.toString();
	}

    // para struct con nombre
    public String toStringSub() {
		StringBuilder strb = new StringBuilder();
		for (Dec s : opnd) {
            strb.append(s.toString());
            strb.append(", ");
        }
        strb.deleteCharAt(strb.length()-1);
        strb.deleteCharAt(strb.length()-1);
        strb.append(")");
		return strb.toString();
	}

    public KindT kind() { return KindT.STRUCT;}


    public int getSize(){ 
        int res = 0;
        for (Dec d : opnd) { //sumamos el total de variables declaradas dentro del struct
            res = res + d.getSize();
        }
        return res;
    }

    public int setDelta(int x){ //en este caso ignoramos el parámetro, no nos hace falta
        int res = 0;
        for (Dec d : opnd) { 
            res = res + d.setDelta(res);
        }
        return res;
    }
    
    public Map<String, Dec> getEnv(){
    	return new HashMap<String, Dec>();
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) {
		this.env=new HashMap<String, Dec>();
		envs.push(env);
		for(Dec aux : opnd) {
			aux.bind(envs);
		}
		envs.pop();
	}
}
