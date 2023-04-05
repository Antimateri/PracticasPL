package ast;

// Devuelve la direccion de una variable, para inicializar punteros
public class GetVarDir extends E{
    
    private Iden name;

    public GetVarDir(Iden name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("getVarDir(");
        strb.append(name.toString()+")");
        return strb.toString();
    }

    @Override
    public KindE kind() {
        return KindE.IDEN;
    }

}
