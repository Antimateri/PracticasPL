package ast;

import java.util.ArrayList;

public class InsBin extends I {
    private ArrayList<Statement> opnd;
    private KindI kind;

    public InsBin(KindI kind, ArrayList<Statement> opnd) {
        this.opnd = opnd;
        this.kind = kind;
    }

    public KindI kind() {return kind;}
    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
        switch(kind){
          case IF:
            return "if("+opnd(0).toString()+","+opnd(1).toString()+")";
          case WHILE:
            return "while("+opnd(0).toString()+","+opnd(1).toString()+")";
          case ASIG:
            return "asig("+opnd(0).toString()+","+opnd(1).toString()+")";
          case IFELSE:
            return "ifElse("+opnd(0).toString()+","+opnd(1).toString()+","+opnd(2).toString()+")";
          default:
           return super.toString();
        }
    }
	
}
	