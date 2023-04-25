package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// sucesion de nodos, representa los cuerpos de funciones, condicionales, bucles y programas
//en definitiva, todo lo que sea una sucesion de comandos
public class Bloque extends I{
    // la susodicha sucesion de comandos
    private List<Statement> opnd;

    public Bloque(Statement opnd1) {
        this.opnd = new ArrayList<Statement>();
        //usamos null para lineas que solo contienen un ;
        if(opnd1!=null)this.opnd.add(opnd1);
    }

    public void append(Statement st) { if(st!=null)opnd.add(st); }

    public KindI kind() {return KindI.BLOQUE;}
    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("\n{\n");
		for (Statement s : opnd) {
            strb.append(s.toString());
            strb.append(";\n");
        }
        strb.append("}");
		return strb.toString();
	}

    public int setDelta(int last){
        int res = last;
        for (Statement s : opnd) {
            res = s.setDelta(res);
        }
        return res;
    }

    @Override
    public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
        envs.push(new HashMap<String, Dec>());
        for (Statement s : opnd) {
            s.bind(envs);
        }
        envs.pop();
    }

    public T type() {
        T out=null;
        for(Statement s : opnd){
            T aux = s.type();
            if(s.nodeKind()==NodeKind.INSTRUCTION && ((I)s).kind()==KindI.RETURN){
                if(out==null)out=aux;
                else if(!out.compatible(aux)){
                    throw new RuntimeException("Return statements with different types in the same function");
                }
            }
        }
        return out;
    }
    public String generateCode(){
        StringBuilder str = new StringBuilder();
        for(Statement s : opnd){
            str.append(s.generateCode());
        }
        return str.toString();
    }
}
