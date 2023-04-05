package ast;

public class Return extends I{

    private E e;

    public Return(E e) {
        super();
        this.e = e;
    }

    public String toString() {
        return "return " + e.toString() + ";";
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }
    
}
