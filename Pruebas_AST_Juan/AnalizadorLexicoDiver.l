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
bool = depende
if = padron
ifelse = sipica
else = nopica
while = ajo
fun = cabra
call = come
return = caga
struct  = cocido
lleva = lleva
null = cero
print = pafuera
read = padentro
puntero = apunta
valorpunt = palante
ref = ref
tipedef = segunyo
true = pica
false = vallamierda
exec = rumia
procedure = baca
class = ganado
atributes = miembros
constructor = pare
methods = cosasquehacer

tipo = (int | bool)
condicional = ({if}|{ifelse}|{else})
bucle = {while}
registro = ({struct}|{lleva})
funcion = ({fun}|{call})
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
punto = \.
dospuntos = :
puntoComa = ;


%%

{int}                     {return ops.unidadTipoInt();}
{bool}                    {return ops.unidadTipoBool();}
{if}                      {return ops.unidadIf();}
{ifelse}                  {return ops.unidadIfElse();}
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
{class}                   {return ops.unidadClass();}
{atributes}               {return ops.unidadAtributes();}
{constructor}             {return ops.unidadConstructor();}
{methods}                 {return ops.unidadMethods();}

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
