package ast;

public class Print extends I{

    private E e;

    public Print(E e) {
        this.e = e;
    }

    public String toString(){
        return "print(" + e.toString() +")";
    }

    @Override
    public KindI kind() {
        return KindI.PRINT;
    }
    
}
