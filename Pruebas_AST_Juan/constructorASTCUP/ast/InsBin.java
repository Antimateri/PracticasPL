package ast;

public class InsBin extends I {
    private Statement opnd1;
    private Statement opnd2;
    private KindI kind;

    public InsBin(KindI kind, Statement opnd1, Statement opnd2) {
        this.opnd1 = opnd1;
        this.opnd2 = opnd2;
        this.kind = kind;
    }

    public KindI kind() {return kind;}
    public Statement opnd1() {return opnd1;}
    public Statement opnd2() {return opnd2;}   

    public String toString() {
        switch(kind){
          case IF:
            return "if("+opnd1().toString()+","+opnd2().toString()+")";
          case WHILE:
            return "while("+opnd1().toString()+","+opnd2().toString()+")";
          case BLOQUE:
            return opnd1().toString()+"; \n" + opnd2().toString() + "; \n";
          case ASIG:
            return "asig("+opnd1().toString()+","+opnd2().toString()+")";
          default: 
           return super.toString();
        }
    }
}