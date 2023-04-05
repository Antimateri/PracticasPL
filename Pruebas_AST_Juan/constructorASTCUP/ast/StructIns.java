package ast;

import java.util.ArrayList;

public class StructIns extends E {

    private Iden nombre=null;
    private ArrayList<Statement> args;

    public StructIns() {
        this.args = new ArrayList<Statement>();
    }

    public void addNamedArg(Statement val) {
        args.add(val);
    }

    public void addUnnamedArg(Statement val) {
        args.add(val);
    }

    public void addName(Iden nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        String res = "";
        if (nombre != null) {
            res += nombre.toString() + " ";
        }
        res += "{";
        for (Statement arg : args) {
            res += arg.toString() + ", ";
        }
        res += "}";
        return res;
    }

    @Override
    public KindE kind() {
        return KindE.STRUCTINS;
    }
    
}
