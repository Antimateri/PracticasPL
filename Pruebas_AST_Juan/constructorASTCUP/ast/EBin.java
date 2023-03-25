package ast;

public class EBin extends E {
   private E opnd1;
   private E opnd2;
   private KindE kind;

   public EBin(KindE kind, E opnd1, E opnd2) {
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
     this.kind = kind;
   }

   public KindE kind() {return kind;}
   public E opnd1() {return opnd1;}
   public E opnd2() {return opnd2;}    
   
   public String toString() {
    switch(kind){
      case SUMA:
        return "sum("+opnd1().toString()+","+opnd2().toString()+")";
      case MUL:
        return "mul("+opnd1().toString()+","+opnd2().toString()+")";
      case DIV:
        return "div("+opnd1().toString()+","+opnd2().toString()+")";
      case MOD:
        return "mod("+opnd1().toString()+","+opnd2().toString()+")";
      case POT:
        return "pot("+opnd1().toString()+","+opnd2().toString()+")";
      case AND:
        return "and("+opnd1().toString()+","+opnd2().toString()+")";
      case OR:
        return "or("+opnd1().toString()+","+opnd2().toString()+")";
      case MAY:
        return ">("+opnd1().toString()+","+opnd2().toString()+")";
      case MEN:
        return "<("+opnd1().toString()+","+opnd2().toString()+")";
      case EQ:
        return "==("+opnd1().toString()+","+opnd2().toString()+")";
      default: 
       return super.toString();
    }
  }
}
