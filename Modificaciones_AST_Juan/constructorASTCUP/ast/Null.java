package ast;

import java.util.LinkedList;
import java.util.Map;

//Para punteros vacios
public class Null extends E{

    public Null() {}

    public String toString(){
        return "null";
    }

    @Override
    public KindE kind() {
        return KindE.NULL;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {}
    
}
