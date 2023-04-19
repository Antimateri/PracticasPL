package ast;

// devuelve el valor al que apunta un puntero
public class GetPointerVal extends E{

    private E e;

    public GetPointerVal(E e) {
        this.e = e;
    }

    public String toString(){
        return "getPointerVal(" + e.toString() +")";
    }

    @Override
    public KindE kind() {
        return KindE.IDEN;
    }
    
}
