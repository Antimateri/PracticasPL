package ast.Instrucciones;

//Identificadores de variables (de cualquier tipo)
public class IdenVar extends Iden{
    public IdenVar(String str){
        super(str);
    }

    public String toString(){
        return super.toString() + "[delta=" + ((super.nodeDec!=null) ? getDelta() : "?") + "]"; 
        //return super.toString();
    }

    public int getDelta(){ return super.nodeDec.getDelta(); }

    public int getDepth(){ return super.nodeDec.getDepth(); }

}
