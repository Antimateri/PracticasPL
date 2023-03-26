package ast;

public class InsBin extends E {
    private E opnd1;
    private E opnd2;
    private KindE kind;

    public InsBin(KindE kind, E opnd1, E opnd2) {
        this.opnd1 = opnd1;
        this.opnd2 = opnd2;
        this.kind = kind;
    }

    public KindE kind() {return kind;}
    public E opnd1() {return opnd1;}
    public E opnd2() {return opnd2;}   

    public String toString() {
        switch(kind){
          case IF:
            return "if("+opnd1().toString()+","+opnd2().toString()+")";
          case WHILE:
            return "while("+opnd1().toString()+","+opnd2().toString()+")";
          case COMP:
            return "comp("+opnd1().toString()+","+opnd2().toString()+")";
          default: 
           return super.toString();
        }
    }
}