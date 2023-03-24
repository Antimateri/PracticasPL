package ast;

public class Mayor extends EBin {
   public Mayor(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public KindE kind() {return KindE.MAY;}
   public String toString() {return ">("+opnd1().toString()+","+opnd2().toString()+")";}
}
