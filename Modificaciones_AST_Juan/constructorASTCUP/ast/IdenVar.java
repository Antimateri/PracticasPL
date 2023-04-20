package ast;

//Identificadores de variables (de cualquier tipo)
public class IdenVar extends Iden{
    int delta = 0; //para la generación de código

    public IdenVar(String str){
        super(str);
    }

    public String toString(){
        return super.toString() + "[delta=" + delta + "]";
    }

    public int getDelta(){ return delta; }

    public int setDelta(int delta){ 
        this.delta = delta; 
        return delta;
    }
}
