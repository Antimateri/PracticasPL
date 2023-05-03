package ast;

import java.util.LinkedList;
import java.util.Map;

//Para punteros o argumentos vacios
public class Null extends E{

    public Null() {}

    public String toString(){
        return "null";
    }

    public KindE kind() {
        return KindE.NULL;
    }

    public T type() {
        return new TPointer(new TSimple(KindT.INT, RefMode.VALUE));
    }

    public int getSize(){ return 0; }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs) {return true;}
    
}
