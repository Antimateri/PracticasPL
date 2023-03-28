package ast;

import java.util.ArrayList;

public class Bloque extends I{
    private ArrayList<Statement> opnd;

    public Bloque(Statement opnd1) {
        this.opnd = new ArrayList<Statement>();
        this.opnd.add(opnd1);
    }

    public void append(Statement st) { opnd.add(st); }

    public KindI kind() {return KindI.BLOQUE;}
    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
		StringBuilder strb = new StringBuilder();
		for (Statement s : opnd) strb.append(s.toString());
		return strb.toString();
	}
}
