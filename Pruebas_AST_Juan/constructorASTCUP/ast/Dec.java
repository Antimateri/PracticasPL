package ast;

import java.util.ArrayList;

public class Dec extends D{
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
