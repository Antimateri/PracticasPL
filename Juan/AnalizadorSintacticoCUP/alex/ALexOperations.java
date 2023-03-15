package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  

   public UnidadLexica unidadInt(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.INT); 
   } 
   public UnidadLexica unidadBool(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.BOOL); 
   }
   public UnidadLexica unidadIf(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IF); 
   }
   public UnidadLexica unidadIfElse(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IFELSE); 
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
   public UnidadLexica unidadId(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,alex.lexema()); 
   } 
   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
   } 
   public UnidadLexica unidadReal(){
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REAL,alex.lexema()); 
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
   public UnidadLexica unidadPuntoComa() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTOCOMA); 
   } 
}
