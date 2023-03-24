package ast;

public class Pow extends EBin {
   public Pow(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.POW;}
   public String toString() {return "pow("+opnd1().toString()+","+opnd2().toString()+")";}
}
