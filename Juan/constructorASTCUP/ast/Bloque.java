package ast;

import java.util.ArrayList;

public class Bloque extends E{
	private ArrayList<E> bl;
	public Bloque() { bl = new ArrayList<E>(); }
	
	public KindE kind() { return KindE.BLOQUE; }
	
	public void append(E exp) { bl.add(exp); }
	public String toString() {
		StringBuilder strb = new StringBuilder();
		for (E e : bl) strb.append(e.toString());
		return strb.toString();
	}
	
}
