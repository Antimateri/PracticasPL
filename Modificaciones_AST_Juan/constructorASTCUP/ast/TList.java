package ast;

// Tipo lista con tamaño definido
public class TList extends T{
    private T t; //tipo de sus elementos
    private int length; //longitud de la lista

    public TList(T t, int length) {
        this.t = t;
        this.length = length;
    }

    public String toString(){
        return "T["+Integer.toString(length)+"](" + t.toString() +")";
    }

    public KindT kind() { return KindT.LIST; }
    
    public int getSize(){ return length * t.getSize(); }
}