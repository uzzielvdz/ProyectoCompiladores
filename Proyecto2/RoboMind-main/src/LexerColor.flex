import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }


/* Tipos de dato */
int |
double |
string |
bool { return textColor(yychar, yylength(), Color.BLUE); }

/* int */
-?{Numero}+ { return textColor(yychar, yylength(), new Color(34, 139, 34)); }

/* double */
-?{Numero}+(\.{Numero}+) { return textColor(yychar, yylength(), new Color(34, 139, 34)); }

/* bool */
true|false { return textColor(yychar, yylength(), Color.BLUE); }

/* string */
\"({Letra}|(\s|:)|{Numero})*\" { return textColor(yychar, yylength(), new Color(0, 100, 0)); }

/* palabras reservadas */
using { return textColor(yychar, yylength(), Color.BLUE); }
class { return textColor(yychar, yylength(), Color.BLUE); }
static { return textColor(yychar, yylength(), Color.BLUE); }
void { return textColor(yychar, yylength(), Color.BLUE); }
return { return textColor(yychar, yylength(), Color.BLUE); }

/* estructuras de control */
if |
while |
for { return textColor(yychar, yylength(), Color.BLUE); }

/* metodos */
\.ToInt32 |
\.ToDouble { return textColor(yychar, yylength(), new Color(255, 105, 180)); }
\.{Letra}* { return textColor(yychar, yylength(), new Color(255, 105, 180)); }


/* Identificador */
{Identificador} { /*Ignorar*/ }

/* Operadores de agrupación */
"(" |
")" |
"{" |
"}" |
"[" |
"]" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Signos de puntuación */
"," |
";" |
\" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Operador de asignación y operaciones*/
== |
= |
\+ |
\- |
\/ |
\* |
\< |
\> { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

/* Operadores lógicos */
"&" |
"|" { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
. { /* Ignorar */ }