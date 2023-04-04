package ast;

import java.sql.Struct;

public class FunctCall extends E{

    private Iden nombre;
    private StructIns args;

    public FunctCall(Iden nombre, StructIns args) {
        this.nombre = nombre;
        this.args = args;
    }

    public String toString() {
        return nombre.toString() + "(" + args.toString() + ")";
    }

    @Override
    public KindE kind() {
        return KindE.FUNCT;
    }
    
}
