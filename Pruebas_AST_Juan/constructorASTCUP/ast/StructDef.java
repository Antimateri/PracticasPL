package ast;

import java.util.ArrayList;

public class StructDef extends D{
    private ArrayList<D> opnd;
    private Iden name=null;

    public StructDef(D opnd1) {
        this.opnd = new ArrayList<D>();
        this.opnd.add(opnd1);
    }

    public void append(D st) { opnd.add(st); }
    public void setName(Iden name) { this.name = name; }

    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("struct(");
        if(name!=null) strb.append(name.toString()+", ");
        else strb.append("_anonimo_, ");
		for (D s : opnd) {
            strb.append(s.toString());
            strb.append(", ");
        }
        strb.deleteCharAt(strb.length()-1);
        strb.deleteCharAt(strb.length()-1);
        strb.append(")");
		return strb.toString();
	}

    @Override
    public KindD kind() { return KindD.STRUCT;}
}
