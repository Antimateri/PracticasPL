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

int = int
bool = bool
if = pican
ifelse = si_pican
else = no_pican
while = ajo
fun = cabra
call = come
return = return
struct  = cocido
lleva = lleva

tipo = (int | bool)
condicional = ({if}|{ifelse}|{else})
bucle = {while}
registro = ({struct}|{lleva})
funcion = ({fun}|{come})
reservada = ({tipo}|{condicional}|{bucle}|{registro}|{funcion})


letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
separador = [ \t\r\b\n]
comentario = #[^\n]*
identificador = {letra}({letra}|{digito})*
numeroEntero = [\+\-]?{parteEntera}
numeroReal = [\+\-]?{parteEntera}\.{parteDecimal}
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
igual = \=
coma  = ,
puntoComa = ;


%%

{int}                     {return ops.unidadInt();}
{bool}                    {return ops.unidadBool();}
{if}                      {return ops.unidadIf();}
{ifelse}                  {return ops.unidadIfElse();}
{else}                    {return ops.unidadElse();}
{while}                   {return ops.unidadWhile();}
{fun}                     {return ops.unidadFun();}
{call}                    {return ops.unidadCall();}
{return}                  {return ops.unidadReturn();}
{struct}                  {return ops.unidadStruct();}
{lleva}                   {return ops.unidadLleva();}

{separador}               {}
{comentario}              {}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{numeroReal}              {return ops.unidadReal();}

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
{operadorIgual}           {return ops.unidadIgual();}

{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{llaveApertura}           {return ops.unidadLAp();}
{llaveCierre}             {return ops.unidadLCierre();} 

{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{puntoComa}               {return ops.unidadPuntoComa();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
