package ast;

public class Read extends I{

    private Iden e;

    public Read(Iden e) {
        this.e = e;
    }

    public String toString(){
        return "read(" + e.toString() +")";
    }

    @Override
    public KindI kind() {
        return KindI.READ;
    }
    
    
}
