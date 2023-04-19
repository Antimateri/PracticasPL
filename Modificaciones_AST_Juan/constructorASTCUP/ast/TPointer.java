package ast;

// Recibe un tipo y devuelve un puntero de ese tipo
public class TPointer extends T{
    //el tipo a transformar
    private T t;

    public TPointer(T t) {
        this.t = t;
    }

    public String toString(){
        return "pointer(" + t.toString() +")";
    }

    public KindT kind() {
        return KindT.POINTER;
    }
    
}
