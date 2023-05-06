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
    private int delta; // delta para la posición de memoria

    public TListIns (ArrayList <E> listaExp){
        this.listaExp = listaExp;
        t = calculateType();
        delta = 0; // Por ahora, luego se calcula
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
    
    public int setDelta(int last){
        this.delta = last;
        int ret = last;
        for (E e : listaExp){
            e.setDelta(ret);
            ret += e.getSize();
        }
        return ret;
    }

    public int getDelta() { return delta; }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        int daux = delta; 
        for (E e : listaExp) {
            // copiar en memoria el valor resultante de la expresión
            str.append(e.codeCopyStack(daux));
            daux += e.getSize();
        }
        return str.toString();
    }

    public String codeCopyStack(int line){
        StringBuilder str = new StringBuilder();
        for (E e : listaExp) {
            str.append(e.codeCopyStack(line));
            line += e.getSize();
        }
        return str.toString();
    }

    public String codeCopyAssign(String codeDirDest){
		StringBuilder str = new StringBuilder();

        str.append(generateCode());

        //direccion de origen: $localsStart+delta
        str.append("i32.const "+ getDelta()+"\n");
        str.append("get_local $localsStart\n");
        str.append("i32.add\n");

        //direccion de destino:
		str.append(codeDirDest);

		//tamaño de los datos:
        str.append("i32.const " + getSize() + "\n");
        
        //llamamos a la funcion $copyn;
        str.append("call $copyn\n");

		return str.toString();
    }

    public int getSize() { return t.getSize(); }
}