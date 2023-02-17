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

letra  = ([A-Z]|[a-z])
separador = [ \t\r\b\n]
comentario = \/\/[^\n]* 
digitoPositivo = [1-9]
map = lmap
reduce = lreduce
pprint = print
filter = lfilter
hash = \#
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
numeroEntero = [\+\-]?{parteEntera}
identificador = {letra}({letra}|{digito})*
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
parentesisApertura = \(
parentesisCierre = \)
igual = \=
iigual = \=\=
dist = \!\=
may = \>
men = \<
coma  = ,
listaApertura = \[
listaCierre = \]

%%

{comentario}              {}
{separador}               {}
{reduce}                  {return ops.unidadLRed();}
{pprint}                  {return ops.unidadPrint();}
{filter}                  {return ops.unidadLFil();}
{hash}                    {return ops.unidadHash();}
{map}                     {return ops.unidadLMap();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{listaApertura}           {return ops.unidadListaApertura();}
{listaCierre}             {return ops.unidadListaCierre();}
{iigual}                  {return ops.unidadIigual();}
{dist}                    {return ops.unidadDist();}
{may}                     {return ops.unidadMay();}
{men}                     {return ops.unidadMen();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
