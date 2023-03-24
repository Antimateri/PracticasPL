package ast;

public class Mod extends EBin {
   public Mod(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.MOD;}
   public String toString() {return "mod("+opnd1().toString()+","+opnd2().toString()+")";}
}
