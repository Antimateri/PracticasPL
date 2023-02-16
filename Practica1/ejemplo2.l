package alex;

%%
%char
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
separador = [ \t\r\b\n]
comentario = #[^\n]* 
palabra = {letra}{letra}*
patron = ({palabra}\* | {palabra}\*{palabra} | \*{palabra} | \*)
otro = [^\n][^\n]*

%%
{separador}               {}
{comentario}              {}
{palabra}                 {return ops.unidadPALABRA();}
{patron}                  {return ops.unidadPATRON();}
{otro}                    {return ops.unidadOTRO();}
