package ast;

import java.util.ArrayList;

// sucesion de nodos, representa los cuerpos de funciones, condicionales, bucles y programas
//en definitiva, todo lo que sea una sucesion de comandos
public class Bloque extends I{
    // la susodicha sucesion de comandos
    private ArrayList<Statement> opnd;

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
}
