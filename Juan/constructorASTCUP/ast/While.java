package ast;

public class While extends EBin{
	public While(E opnd1, E opnd2) {
		super(opnd1, opnd2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public KindE kind() { return KindE.WHILE; }
    public String toString() {return "while("+opnd1().toString()+","+opnd2().toString()+")";}
	
}
