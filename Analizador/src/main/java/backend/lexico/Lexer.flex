package backend.lexico;

import backed.lexico.Token;

%%
%public
%class Lexer
%type Token
%line
%column
%cup

letra = [a-zA-Z]+
digito = [0-9]+
espacio = [ ,\t,\n,\r]+

%{
    public string lexema;
%}

%%
linea |
curva |
while {return new Token(TokenEnum.RESERVADA, yytext(), yyline+1, yycolumn+1);}
{espacio} {/*Ignorar*/}
"//".* {/*Ignorar*/}
"+" {return new Token(TokenEnum.SUMA, yytext(), yyline+1, yycolumn+1);}
"-" {return new Token(TokenEnum.RESTA, yytext(), yyline+1, yycolumn+1);}
"*" {return new Token(TokenEnum.MULTIPLICACION, yytext(), yyline+1, yycolumn+1);}
"/" {return new Token(TokenEnum.DIVISION, yytext(), yyline+1, yycolumn+1);}
"(" {return new Token(TokenEnum.PARENTESIS_ABRE, yytext(), yyline+1, yycolumn+1);}
")" {return new Token(TokenEnum.PARENTESIS_CIERRA, yytext(), yyline+1, yycolumn+1);}
"," {return new Token(TokenEnum.COMA, yytext(), yyline+1, yycolumn+1);}
("(-"{digito}+")") | {digito}+ {lexema=yytext(); return Numero;}
 [^] {return new Token(TokenEnum.ERROR_LEXICO, yytext(), yyline+1, yycolumn+1);}