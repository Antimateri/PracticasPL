package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Expresiones.*;
import errors.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// Clase de arrays anónimos
public class TListIns extends E {

    private ArrayList <E> listaExp; // Puede ser una expresion o un TListIns
    private T t; // Tipo del array
    public TListIns (ArrayList <E> listaExp){
        this.listaExp = listaExp;
        t = calculateType();
        if (t.kind() == KindT.ERROR) 
            Log.error(Log.ErrorType.TIPEERROR, this);
    }

    private T calculateType () { // Tiene que ser consistente el tipo en todas las expresiones del array
        T ret = listaExp.get(0).type(); 
        for (int i = 1; i < listaExp.size(); ++i) 
            if (!ret.compatible(listaExp.get(i).type()))
                return new TError();
             
        return new TList(ret, listaExp.size());
    }

    public T type() { return t; }
    
    public boolean bind(LinkedList<Map<String, Dec>> envs) { return true; }
    public KindE kind() { return KindE.TLISTINS; }

    public NodeKind nodeKind() { return NodeKind.EXPRESSION; }
    public String toString() {
        //return t.toString();
        StringBuilder str = new StringBuilder();
        str.append("[" + listaExp.get(0).toString());
        for (int i = 1; i < listaExp.size(); ++i) str.append("," + listaExp.get(i).toString());
        str.append("]");
        return str.toString();
    }
    
    public int setDelta(int last){ return last; }
}