package ast;

import java.util.LinkedList;
import java.util.Map;

// nodo que representa valores binarios (true o false)
public class Bool extends E{
    private String v;
    public Bool(String v) {
     this.v = v;   
    }
    //public String num() {return v;}
    public KindE kind() {return KindE.BOOL;}
    public String toString() {return v;}

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){ return true;} 
    public T type() {return new TSimple(KindT.BOOL, RefMode.VALUE);}

    public String generateCode(){
        if(v.equals("true"))
		    return "i32.const" + 1 + "\n" ;
        else
            return "i32.const" + 0 + "\n" ;
	}

    public int getSize(){ return 4; }

    public String codeCopyStack(int d){
		StringBuilder str = new StringBuilder();
		str.append("get_global $MP\n");
		str.append(this.generateCode());
		str.append("i32.store offset=" + (d + 8) + "\n");
		return str.toString();
    }

    public String codeCopyAssign(String codeDirDest){
		StringBuilder str = new StringBuilder();
		str.append(codeDirDest);
		str.append(this.generateCode());
		str.append("i32.store offset= \n");
		return str.toString();
    }
}
