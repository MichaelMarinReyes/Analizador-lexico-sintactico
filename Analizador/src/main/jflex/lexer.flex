package backend.lexico;

import java_cup.runtime.*;
import backend.sintactico.*;

%%
%public
%class Lexer
%unicode
%line
%column
%cup

%{
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

%}

%state OPERATOR_STATE

%%
"azul"            { return symbol(ParserSym.AZUL); }
"rojo"            { return symbol(ParserSym.ROJO); }
"amarillo"        { return symbol(ParserSym.AMARILLO); }
"verde"           { return symbol(ParserSym.VERDE); }
"negro"           { return symbol(ParserSym.NEGRO); }
"celeste"         { return symbol(ParserSym.CELESTE); }
"rosado"          { return symbol(ParserSym.ROSADO); }
"morado"          { return symbol(ParserSym.MORADO); }

"línea"           { return symbol(ParserSym.LINEA); }
"curva"           { return symbol(ParserSym.CURVA); }

"graficar"        { return symbol(ParserSym.GRAFICAR); }
"circulo"         { return symbol(ParserSym.CIRCULO); }
"cuadrado"        { return symbol(ParserSym.CUADRADO); }
"rectangulo"      { return symbol(ParserSym.RECTANGULO); }
"linea"           { return symbol(ParserSym.LINEA_OBJ); }
"poligono"        { return symbol(ParserSym.POLIGONO); }

[ \t\n\r\f]       { /* Ignorar espacios en blanco */ }

"+"               { return symbol(ParserSym.SUMA); }
"-"               { return symbol(ParserSym.RESTA); }
"*"               { return symbol(ParserSym.MULTIPLICACION); }
"/"               { return symbol(ParserSym.DIVISION); }
"("               { return symbol(ParserSym.PARENTESIS_ABRE); }
")"               { return symbol(ParserSym.PARENTESIS_CIERRA); }
","               { return symbol(ParserSym.COMA); }

[a-zA-Z_][a-zA-Z0-9_-]* { return symbol(ParserSym.ID, yytext()); }
[0-9]+           { return symbol(ParserSym.NUMERO, Integer.parseInt(yytext())); }
<<EOF>>          { return new Symbol(ParserSym.EOF); }
.                { System.err.println("Error léxico: " + yytext()); }
