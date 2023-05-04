package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// Clase de arrays anónimos
public class TListIns extends E {


    private ArrayList <E> listaExp; // Puede ser una expresion o un TListIns

    public TListIns (ArrayList <E> listaExp){
        this.listaExp = listaExp;
    }

    public T type() {
        return new TSimple(KindT.INT, RefMode.VALUE); // Esto hay que cambiarlo es por ahora solo
        // Hay que añadir métodos a la clase TList para poder crear un tipo a partir de esto...
    }
    
    public boolean bind(LinkedList<Map<String, Dec>> envs) { return true; }
    public KindE kind() { return KindE.TLISTINS; }

    public NodeKind nodeKind() { return NodeKind.EXPRESSION; }
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + listaExp.get(0).toString());
        for (int i = 1; i < listaExp.size(); ++i) str.append("," + listaExp.get(i).toString());
        str.append("]");
        return str.toString();
    }
    public int setDelta(int last){ return last; }
}