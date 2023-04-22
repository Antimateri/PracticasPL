package ast;

// Recibe un tipo y devuelve un puntero de ese tipo
public class TList extends T{
    //el tipo a transformar
    private T t;
    private int size;

    public TList(T t, int size) {
        this.t = t;
        this.size = size;
    }

    public String toString(){
        return "T["+Integer.toString(size)+"](" + t.toString() +")";
    }

    public KindT kind() {
        return KindT.LIST;
    }
    
}