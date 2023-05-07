package alex;

import constructorast.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoExp alex;
  public ALexOperations(AnalizadorLexicoExp alex) {
   this.alex = alex;   
  }
  

   public UnidadLexica unidadInt(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.INT); 
   } 
   public UnidadLexica unidadIf(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IF); 
   }
   public UnidadLexica unidadElse(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ELSE); 
   }
   public UnidadLexica unidadWhile(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WHILE); 
   }
   public UnidadLexica unidadFun(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FUN); 
   }
   public UnidadLexica unidadCall(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CALL); 
   }
   public UnidadLexica unidadReturn(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RETURN); 
   }
   public UnidadLexica unidadStruct(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.STRUCT); 
   }
   public UnidadLexica unidadLleva(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LLEVA); 
   }
   public UnidadLexica unidadNull(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NULL); 
   }
   public UnidadLexica unidadPrint(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PRINT); 
   }
   public UnidadLexica unidadRead(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.READ); 
   }
   public UnidadLexica unidadRef(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REF); 
   }
   public UnidadLexica unidadPuntero(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTERO); 
   }
   public UnidadLexica unidadValorPunt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.VALPTR); 
   }
   public UnidadLexica unidadTrue(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TRUE); 
   }
   public UnidadLexica unidadFalse(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FALSE); 
   }
   public UnidadLexica unidadExec(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EXEC); 
   }
   public UnidadLexica unidadProc(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PROC); 
   }
   public UnidadLexica unidadNew(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NEW); 
   }
   public UnidadLexica unidadTipeDef(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPEDEF); 
   }
   public UnidadLexica unidadId(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,alex.lexema()); 
   } 
   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.INT,alex.lexema()); 
   } 
   public UnidadLexica unidadTipoBool(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPOBOOL); 
   }
   public UnidadLexica unidadTipoInt(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPOINT); 
   }
   public UnidadLexica unidadSuma(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.SUMA); 
   } 
   public UnidadLexica unidadResta(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RESTA); 
   } 
   public UnidadLexica unidadMul(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MUL); 
   } 
   public UnidadLexica unidadEof() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
   }
   public UnidadLexica unidadDiv(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV); 
   } 
   public UnidadLexica unidadMod(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MOD); 
   } 
   public UnidadLexica unidadPot(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POT); 
   } 
   public UnidadLexica unidadAnd(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.AND); 
   } 
   public UnidadLexica unidadOr(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OR); 
   } 
   public UnidadLexica unidadMayor(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYOR); 
   } 
   public UnidadLexica unidadMenor(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOR); 
   } 
   public UnidadLexica unidadOpIgual(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OPIGUAL); 
   } 
   public UnidadLexica unidadDist(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIST); 
   }
   public UnidadLexica unidadNot(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NOT); 
   }
   public UnidadLexica unidadPAp(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP); 
   } 
   public UnidadLexica unidadPCierre(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE); 
   }  
   public UnidadLexica unidadCAp(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CAP); 
   } 
   public UnidadLexica unidadCCierre(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CCIERRE); 
   }  
   public UnidadLexica unidadLAp(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LAP); 
   } 
   public UnidadLexica unidadLCierre(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LCIERRE); 
   }  
   public UnidadLexica unidadIgual(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUAL);
   }
   public UnidadLexica unidadComa() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.COMA); 
   } 
   public UnidadLexica unidadPunto() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTO); 
   }
   public UnidadLexica unidadDosPuntos() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DOSPUNTOS); 
   }
   public UnidadLexica unidadPuntoComa() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTOCOMA); 
   } 
}
