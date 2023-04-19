package ast;

// Devuelve la direccion de una variable, para inicializar punteros
public class GetVarDir extends E{
    
    private E name;

    public GetVarDir(E name) {
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
