package backend.lexico;

import java_cup.runtime.*;
import backend.sintactico.*;
import backend.reportes.ErrorReporte;
import java.util.ArrayList;

%%
%public
%class Lexer
%unicode
%line
%column
%ignorecase
%cup
/*
%{
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

%}
*/

%{
    public static ArrayList<ErrorReporte> errores = new ArrayList<>();

    public ArrayList<ErrorReporte> getErrores() {
        return errores;
    }
%}

%state OPERATOR_STATE

%%
"azul"            { return new Symbol(ParserSym.AZUL, yyline+1, yycolumn+1, yytext()); }
"rojo"            { return new Symbol(ParserSym.ROJO, yyline+1, yycolumn+1, yytext()); }
"amarillo"        { return new Symbol(ParserSym.AMARILLO, yyline+1, yycolumn+1, yytext()); }
"verde"           { return new Symbol(ParserSym.VERDE, yyline+1, yycolumn+1, yytext()); }
"negro"           { return new Symbol(ParserSym.NEGRO, yyline+1, yycolumn+1, yytext()); }
"celeste"         { return new Symbol(ParserSym.CELESTE, yyline+1, yycolumn+1, yytext()); }
"rosado"          { return new Symbol(ParserSym.ROSADO, yyline+1, yycolumn+1, yytext()); }
"morado"          { return new Symbol(ParserSym.MORADO, yyline+1, yycolumn+1, yytext()); }

"línea"           { return new Symbol(ParserSym.LINEA, yyline+1, yycolumn+1, yytext()); }
"curva"           { return new Symbol(ParserSym.CURVA, yyline+1, yycolumn+1, yytext()); }

"graficar"        { return new Symbol(ParserSym.GRAFICAR, yyline+1, yycolumn+1, yytext()); }
"circulo"         { return new Symbol(ParserSym.CIRCULO, yyline+1, yycolumn+1, yytext()); }
"cuadrado"        { return new Symbol(ParserSym.CUADRADO, yyline+1, yycolumn+1, yytext()); }
"rectangulo"      { return new Symbol(ParserSym.RECTANGULO, yyline+1, yycolumn+1, yytext()); }
"linea"           { return new Symbol(ParserSym.LINEA_OBJ, yyline+1, yycolumn+1, yytext()); }
"poligono"        { return new Symbol(ParserSym.POLIGONO, yyline+1, yycolumn+1, yytext()); }

[ \t\n\r\f]       { /* Ignorar espacios en blanco */ }

"+"               { return new Symbol(ParserSym.SUMA, yyline+1, yycolumn+1, yytext()); }
"-"               { return new Symbol(ParserSym.RESTA, yyline+1, yycolumn+1, yytext()); }
"*"               { return new Symbol(ParserSym.MULTIPLICACION, yyline+1, yycolumn+1, yytext()); }
"/"               { return new Symbol(ParserSym.DIVISION, yyline+1, yycolumn+1, yytext()); }
"("               { return new Symbol(ParserSym.PARENTESIS_ABRE, yyline+1, yycolumn+1, yytext()); }
")"               { return new Symbol(ParserSym.PARENTESIS_CIERRA, yyline+1, yycolumn+1, yytext()); }
","               { return new Symbol(ParserSym.COMA, yyline+1, yycolumn+1, yytext()); }

[a-zA-Z_][a-zA-Z0-9_]* { return new Symbol(ParserSym.ID, yytext()); }
[0-9]+\.[0-9]+    { return new Symbol(ParserSym.NUMERO, Double.parseDouble(yytext())); }
[0-9]+            { return new Symbol(ParserSym.NUMERO, Integer.parseInt(yytext())); }
<<EOF>>           { return new Symbol(ParserSym.EOF); }
.                 {
                        errores.add(new ErrorReporte(yytext(), yyline + 1, yycolumn + 1, "Léxico", "Caracter desconocido: " + yytext()));
                        System.err.println("Error léxico: " + yytext() + " linea: " + String.valueOf(yyline + 1) + " columna: " + String.valueOf(yycolumn + 1));
                    }
