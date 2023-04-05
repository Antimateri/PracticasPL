package ast;

public class Pointer extends T{

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
