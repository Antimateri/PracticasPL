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

    public String name(){
        return super.name;
    }

    public int getDelta(){ 
        if(nodeDec!=null) return super.nodeDec.getDelta(); 
        return 0;
    }

    public int getDepth(){ 
        if(nodeDec!=null) return super.nodeDec.getDepth(); 
        return 0;
    }

}
