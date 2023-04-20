package ast;

// Funcion Read de input
public class Read extends I{
    private IdenVar id;

    public Read(IdenVar id) {
        this.id = id;
    }

    public String toString(){
        return "read(" + id.toString() +")";
    }

    @Override
    public KindI kind() {
        return KindI.READ;
    }
    
    
}
