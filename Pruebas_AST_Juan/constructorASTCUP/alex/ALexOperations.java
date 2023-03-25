package alex;

import constructorast.ClaseLexica;

public class ALexOperations {
   private AnalizadorLexicoExp alex;
   public ALexOperations(AnalizadorLexicoExp alex) {
      this.alex = alex;   
   }
   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.INT,alex.lexema()); 
   } 


   public UnidadLexica unidadSuma() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.SUMA,"+"); 
   } 
   public UnidadLexica unidadMul() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MUL,"*"); 
   } 
   public UnidadLexica unidadDiv() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV,"/"); 
   } 
   public UnidadLexica unidadMod() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MOD,"%"); 
   } 
   public UnidadLexica unidadPot() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POT,"**"); 
   } 
   public UnidadLexica unidadAnd() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.AND,"&&"); 
   } 
   public UnidadLexica unidadOr() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OR,"||"); 
   } 
   public UnidadLexica unidadMayor() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYOR,">"); 
   } 
   public UnidadLexica unidadMenor() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOR,"<"); 
   } 
   public UnidadLexica unidadOpIgual() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OPIGUAL,"=="); 
   } 


   public UnidadLexica unidadPAp() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP,"("); 
   } 
   public UnidadLexica unidadPCierre() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE,")"); 
   } 
   public UnidadLexica unidadCAp() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CAP,"["); 
   } 
   public UnidadLexica unidadCCierre() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CCIERRE,"]"); 
   } 
   public UnidadLexica unidadLAp() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LAP,"{"); 
   } 
   public UnidadLexica unidadLCierre() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LCIERRE,"}"); 
   } 


   public UnidadLexica unidadEof() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF,"<EOF>"); 
   }
}
