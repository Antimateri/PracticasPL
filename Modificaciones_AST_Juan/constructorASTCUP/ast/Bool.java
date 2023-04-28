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
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {} 
    public T type() {return new TSimple(KindT.BOOL, RefMode.VALUE);}

    public String generateCode(){
        if(v.equals("true"))
		    return "i32.const" + 1 + "\n" ;
        else
            return "i32.const" + 0 + "\n" ;
	}

    public int getSize(){ return 4; }
}
