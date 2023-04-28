package ast;

import java.util.LinkedList;
import java.util.Map;

// valor entero
public class Int extends E {
	
	private String v;
	
	public Int(String v) {
		this.v = v;   
	}
	public String num() {return v;}
	public KindE kind() {return KindE.INT;}
	public String toString() {return "int("+v+")";}
	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {}  
	public T type() {return new TSimple(KindT.INT, RefMode.VALUE);}

	public String generateCode(){
		return "i32.const" + v + "\n" ;
	}

	public int getSize(){ return 4; }
}

