package ast;

// Funcion Read de input
public class Read extends I{

    private Iden e;

    //Iden pues tenemos que asegurarnos de que reciba una variable
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
