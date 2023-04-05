package ast;

import java.util.ArrayList;

// nodo principal de declaracion de variables
public class Dec extends D{
    //el primer operador es el tipo y el segundo el identificador
    private ArrayList<Statement> opnd;
    private KindD kind;

    public Dec(KindD kind, ArrayList<Statement> opnd) {
        this.opnd = opnd;
        this.kind = kind;
    }

    public KindD kind() {return kind;}
    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
        switch(kind){
          case VAR:
            return "var("+opnd(0).toString()+","+opnd(1).toString()+")";
          default:
           return super.toString();
        }
    }
}
