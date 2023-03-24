package ast;

public class Print extends E{
	private E exp;
	public Print(E exp) {
		this.exp = exp;
	}
	public KindE kind() {return KindE.FUN;}
	public String toString() {return "print (" + exp.toString() + ")"; }
	
}
