package ast;

// Designador a la dirección de un designador dado
public class DesigRef extends Desig{
    private Desig des;

    public KindDesig kind(){ return KindDesig.REF; }

    public DesigRef(Desig des){
        this.des = des;
    }

    public String toString(){
        StringBuilder strb = new StringBuilder();
        strb.append("getVarDir(");
        strb.append(des.toString()+")");
        return strb.toString();
    }
}
