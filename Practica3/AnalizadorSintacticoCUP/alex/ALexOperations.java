package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }

  public UnidadLexica unidadId(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,alex.lexema()); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadListaApertura() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LISTAP); 
  } 
  public UnidadLexica unidadListaCierre() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LISTCIERRE); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
  }
  // Cambia esto TODO
  public UnidadLexica unidadLRed(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RED); 
  } 
  public UnidadLexica unidadPrint(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PRINT); 
  } 
  public UnidadLexica unidadLFil(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FILTER); 
  } 
  public UnidadLexica unidadHash(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.HASH); 
  } 
  public UnidadLexica unidadLMap(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAP); 
  } 
  public UnidadLexica unidadSuma(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadResta(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POR); 
  } 
  public UnidadLexica unidadDiv(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV); 
  } 
  public UnidadLexica unidadPAp(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PARAP); 
  } 
  public UnidadLexica unidadPCierre(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PARCIERRE); 
  }  
  public UnidadLexica unidadIgual(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EQ);
  } 
  public UnidadLexica unidadIigual(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EQQ); 
  } 
  public UnidadLexica unidadDist(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIS); 
  } 
  public UnidadLexica unidadMay(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAY); 
  } 
  public UnidadLexica unidadMen(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MEN); 
  } 
}
