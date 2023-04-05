package ast;

import java.util.ArrayList;

public class Bloque extends I{
    private ArrayList<Statement> opnd;

    public Bloque(Statement opnd1) {
        this.opnd = new ArrayList<Statement>();
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
}
