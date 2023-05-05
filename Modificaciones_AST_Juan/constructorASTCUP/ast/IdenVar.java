package ast;

//Identificadores de variables (de cualquier tipo)
public class IdenVar extends Iden{
    public IdenVar(String str){
        super(str);
    }

    public String toString(){
        return super.toString() + "[delta=" + ((super.nodeDec!=null) ? getDelta() : "?") + "]"; 
        //return super.toString();
    }

    public String name(){
        return super.name;
    }

    public int getDelta(){ return super.nodeDec.getDelta(); }

    public int getDepth(){ return super.nodeDec.getDepth(); }

}
