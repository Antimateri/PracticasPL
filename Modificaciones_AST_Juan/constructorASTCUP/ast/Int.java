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
}

