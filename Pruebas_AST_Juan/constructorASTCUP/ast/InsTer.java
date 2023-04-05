package ast;

// instrucciones ternarias de momento solo esta el if-else
public class InsTer extends I {
    private Statement opnd1;
    private Statement opnd2;
    private Statement opnd3;
    private KindI kind;

    public InsTer(KindI kind, Statement opnd1, Statement opnd2, Statement opnd3) {
        this.opnd1 = opnd1;
        this.opnd2 = opnd2;
        this.opnd3 = opnd3;
        this.kind = kind;
    }

    public KindI kind() {return kind;}
    public Statement opnd1() {return opnd1;}
    public Statement opnd2() {return opnd2;}   
    public Statement opnd3() {return opnd3;}  

    public String toString() {
        switch(kind){
          case IFELSE:
            return "ifElse("+opnd1().toString()+","+opnd2().toString()+","+opnd3().toString()+")";
          default: 
           return super.toString();
        }
    }
}