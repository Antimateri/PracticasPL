package ast;

//Designadores a campo de un registro:
public class DesigCampo extends Desig{
    private Desig des;
    private IdenVar id; //identificador del campo del struct correspondiente

    public KindDesig kind(){ return KindDesig.SELCAMPO; }

    public DesigCampo(Desig des, IdenVar id){
        this.des = des;
        this.id = id;
    }

    public String toString(){
        return des.toString() + "." + id.toString() + "]";
    }
}