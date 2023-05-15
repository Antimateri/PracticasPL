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

int = int
bool = bool
if = if
else = else
while = while
fun = fun
call = eval
return = return
struct  = struct
lleva = has
null = null
print = print
read = read
puntero = pointer
valorpunt = ptrval
ref = ref
tipedef = typedef
true = true
false = false
exec = exec
procedure = proc
new = new


letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digito}{digito}*
separador = [ \t\r\b\n]
comentario = #[^\n]*
identificador = {letra}({letra}|{digito})*
numeroEntero = {parteEntera}
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
operadorNot = \!
operadorDist = \!\=
parentesisApertura = \(
parentesisCierre = \)
llaveApertura = \{
llaveCierre = \}
corcheteApertura = \[
corcheteCierre = \]
igual = \=
coma  = ,
punto = \.
dospuntos = \:
puntoComa = ;


%%

{int}                     {return ops.unidadTipoInt();}
{bool}                    {return ops.unidadTipoBool();}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{while}                   {return ops.unidadWhile();}
{fun}                     {return ops.unidadFun();}
{call}                    {return ops.unidadCall();}
{return}                  {return ops.unidadReturn();}
{struct}                  {return ops.unidadStruct();}
{lleva}                   {return ops.unidadLleva();}
{null}                    {return ops.unidadNull();}
{print}                   {return ops.unidadPrint();}
{read}                    {return ops.unidadRead();}
{ref}                     {return ops.unidadRef();}
{puntero}                 {return ops.unidadPuntero();}
{valorpunt}               {return ops.unidadValorPunt();}
{tipedef}                 {return ops.unidadTipeDef();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{exec}                    {return ops.unidadExec();}
{procedure}               {return ops.unidadProc();}
{new}                     {return ops.unidadNew();}

{separador}               {}
{comentario}              {}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}

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
{operadorNot}             {return ops.unidadNot();}
{operadorDist}            {return ops.unidadDist();}

{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{llaveApertura}           {return ops.unidadLAp();}
{llaveCierre}             {return ops.unidadLCierre();} 

{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{punto}                   {return ops.unidadPunto();}
{dospuntos}               {return ops.unidadDosPuntos();}
{puntoComa}               {return ops.unidadPuntoComa();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
