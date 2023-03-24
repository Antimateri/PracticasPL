package ast;

public class Or extends EBin {
   public Or(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.OR;}
   public String toString() {return "or("+opnd1().toString()+","+opnd2().toString()+")";}
}
