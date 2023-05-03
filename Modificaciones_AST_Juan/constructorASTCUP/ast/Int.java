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
	public boolean bind(LinkedList<Map<String, Dec>> envs){ return true;}  
	public T type() {return new TSimple(KindT.INT, RefMode.VALUE);}

	public String generateCode(){
		return "i32.const" + v + "\n" ;
	}

	public int getSize(){ return 4; }

	public String codeCopyStack(int d){
		StringBuilder str = new StringBuilder();
		str.append("get_local $localsStart\n");
		str.append(this.generateCode());
		str.append("i32.store offset=" + d + "\n");
		return str.toString();
    }

	public String codeCopyAssign(String codeDirDest){
		StringBuilder str = new StringBuilder();
		str.append(codeDirDest);
		str.append(this.generateCode());
		str.append("i32.store\n");
		return str.toString();
    }
}

