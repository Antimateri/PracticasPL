package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
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
}
