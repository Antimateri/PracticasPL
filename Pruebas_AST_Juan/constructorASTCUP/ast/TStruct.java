package ast;

import java.util.ArrayList;

// Tipo declarado como struct anonimo
// (int a, int b) a; por ejemplo 
public class TStruct extends T{
    //lista de elementos de la estructura, son todos declaraciones de variables
    private ArrayList<D> opnd;

    public TStruct(D opnd1) {
        this.opnd = new ArrayList<D>();
        this.opnd.add(opnd1);
    }

    // añade un elemento a la lista de elementos de la estructura
    public void append(D st) { opnd.add(st); }

    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("StructType(");
		for (D s : opnd) {
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
    public KindT kind() { return KindT.STRUCT;}
}
