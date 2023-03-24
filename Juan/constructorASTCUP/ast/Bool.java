package ast;

public class Bool extends E{

	private String b;
	public Bool(String b) {
		this.b = b;
	}
	public KindE kind() { return KindE.INT; }
	public String bool() {return b;}
	public String toString() {return b;}
	
}
