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
        StringBuilder res = new StringBuilder();
        if (nombre != null) {
            res.append(nombre.toString() + " ");
        }
        res.append("{");
        for (Statement arg : args) {
            res.append(arg.toString());
            res.append(", ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.append("}");
        return res.toString();
    }

    @Override
    public KindE kind() {
        return KindE.STRUCTINS;
    }
    
}
