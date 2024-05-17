import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/* Tipos de dato */
int |
double |
string |
bool { return token(yytext(), "TIPO_DATO", yyline, yycolumn); }

/* int */
-?{Numero}+ { return token(yytext(), "NUMERO_INT", yyline, yycolumn); }

/* double */
-?{Numero}+(\.{Numero}+) { return token(yytext(), "NUMERO_DEC", yyline, yycolumn); }

/* bool */
true|false { return token(yytext(), "VALOR_BOOL", yyline, yycolumn); }

/* string */
\"({Letra}|(\s|:)|{Numero})*\" { return token(yytext(), "CADENA_TEXT", yyline, yycolumn); }

/* palabras reservadas */
using { return token(yytext(), "PALABRAS_RESERV_USING", yyline, yycolumn); }
class { return token(yytext(), "PALABRAS_RESERV_CLASS", yyline, yycolumn); }
static { return token(yytext(), "PALABRAS_RESERV_STATIC", yyline, yycolumn); }
void { return token(yytext(), "PALABRAS_RESERV_VOID", yyline, yycolumn); }
return { return token(yytext(), "PALABRAS_RESERV_RETURN", yyline, yycolumn); }


/* estructuras de control */
if { return token(yytext(), "ESTRUCTURA_IF", yyline, yycolumn); }
while { return token(yytext(), "ESTRUCTURA_WHILE", yyline, yycolumn); }
for { return token(yytext(), "ESTRUCTURA_FOR", yyline, yycolumn); }

/* metodos */
\.ToInt32 |
\.ToDouble { return token(yytext(), "PARSE", yyline, yycolumn); }
\.{Letra}* { return token(yytext(), "LLAMAR_METODO", yyline, yycolumn); }


/* Identificador */
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Operadores de agrupación */
"(" { return token(yytext(), "PARENTESIS_A", yyline, yycolumn); }
")" { return token(yytext(), "PARENTESIS_C", yyline, yycolumn); }
"{" { return token(yytext(), "LLAVE_A", yyline, yycolumn); }
"}" { return token(yytext(), "LLAVE_C", yyline, yycolumn); }
"[" { return token(yytext(), "CORCHETE_A", yyline, yycolumn); }
"]" { return token(yytext(), "CORCHETE_C", yyline, yycolumn); }

/* Signos de puntuación */
"," { return token(yytext(), "COMA", yyline, yycolumn); }
";" { return token(yytext(), "PUNTO_COMA", yyline, yycolumn); }
\" { return token(yytext(), "COMILLAS", yyline, yycolumn); }

/* Operador de asignación y operacion*/
= { return token (yytext(), "OP_ASIG", yyline, yycolumn); }

== { return token (yytext(), "OP_COMPARADOR", yyline, yycolumn); }
\< { return token (yytext(), "MAYOR_QUE", yyline, yycolumn); }
\> { return token (yytext(), "MENOR_QUE", yyline, yycolumn); }

\+ { return token (yytext(), "OP_SUMA", yyline, yycolumn); }
\- { return token (yytext(), "OP_RESTA", yyline, yycolumn); }
\/ { return token (yytext(), "OP_DIVISION", yyline, yycolumn); }
\* { return token (yytext(), "OP_MULTIPLICACION", yyline, yycolumn); }

/* Operadores lógicos */
"&" |
"|" { return token(yytext(), "OP_LOGICO", yyline, yycolumn); }

. { return token(yytext(), "ERROR", yyline, yycolumn); }