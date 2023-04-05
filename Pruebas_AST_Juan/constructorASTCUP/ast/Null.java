package ast;

public class Null extends E{

    public Null() {}

    public String toString(){
        return "null";
    }

    @Override
    public KindE kind() {
        return KindE.NULL;
    }
    
}
