package backend.lexico;

import backend.TokenEnum;

public class Token {

    private TokenEnum tokenEnum;
    private String lexema;
    private int linea;
    private int columna;

    public Token() {
        //Constructor vacío
    }

    public Token(String lexema, int linea, int columna) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public Token(TokenEnum tokenEnum, String lexema, int linea, int columna) {
        this.tokenEnum = tokenEnum;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public TokenEnum getTokenEnum() {
        return tokenEnum;
    }

    public void setTokenEnum(TokenEnum tokenEnum) {
        this.tokenEnum = tokenEnum;
    }
}
