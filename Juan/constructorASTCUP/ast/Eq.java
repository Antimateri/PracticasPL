package ast;

public class Eq extends EBin {
   public Eq(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.EQ;}
   public String toString() {return "==("+opnd1().toString()+","+opnd2().toString()+")";}
}
