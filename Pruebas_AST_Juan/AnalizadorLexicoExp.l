package alex;

import errors.GestionErroresExp;

%%
%cup
%column
%line
%class AnalizadorLexicoExp
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresExp errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresExp errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

if = if
while = while
igual = \=

digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
int = [\+\-]?{parteEntera}

separador = [ \t\r\b\n]
comentario = #[^\n]* 


operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
operadorModulo = \%
operadorPotencia = \*\*
operadorAnd = \&\&
operadorOr = \|\|
operadorMayor = \>
operadorMenor = \<
operadorIgual = \=\=


parentesisApertura = \(
parentesisCierre = \)
llaveApertura = \{
llaveCierre = \}
corcheteApertura = \[
corcheteCierre = \]

puntoComa = ;

%%
{int}                     {return ops.unidadEnt();}

{if}                      {return ops.unidadIf();}
{while}                   {return ops.unidadWhile();}
{igual}                   {return ops.unidadIgual();}

{separador}               {}
{comentario}              {}

{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{operadorModulo}          {return ops.unidadMod();}
{operadorPotencia}        {return ops.unidadPot();}
{operadorAnd}             {return ops.unidadAnd();}
{operadorOr}              {return ops.unidadOr();}
{operadorMayor}           {return ops.unidadMayor();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorIgual}           {return ops.unidadOpIgual();}

{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{llaveApertura}           {return ops.unidadLAp();}
{llaveCierre}             {return ops.unidadLCierre();} 

{puntoComa}               {return ops.unidadPuntoComa();}

[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
