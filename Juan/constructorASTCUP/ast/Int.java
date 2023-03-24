package ast;

public class Int extends E{

	private String num;
	public Int(String num) {
		this.num = num;
	}
	public KindE kind() { return KindE.INT; }
	public String num() {return num;}
	public String toString() {return num;}
	
}
