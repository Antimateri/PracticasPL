package ast;

// Recibe un tipo y devuelve un puntero de ese tipo
public class Pointer extends T{

    //el tipo a transformar
    private T t;

    public Pointer(T t) {
        this.t = t;
    }

    public String toString(){
        return "pointer(" + t.toString() +")";
    }

    @Override
    public KindT kind() {
        return KindT.POINTER;
    }
    
}
