package ast;

public class Menor extends EBin {
   public Menor(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.MEN;}
   public String toString() {return "<("+opnd1().toString()+","+opnd2().toString()+")";}
}
