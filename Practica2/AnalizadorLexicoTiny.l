package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%column
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

separador = [ \t\r\b\n]
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
numeroEntero = [\+\-]?{parteEntera}
coma  = ,
listaApertura = \[
listaCierre = \]

%%

{separador}               {}
{numeroEntero}            {return ops.unidadEnt();}
{coma}                    {return ops.unidadComa();}
{listaApertura}           {return ops.unidadListaApertura();}
{listaCierre}             {return ops.unidadListaCierre();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
