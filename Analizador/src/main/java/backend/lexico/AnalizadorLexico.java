package backend.lexico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalizadorLexico {

    private Map<String, TokenEnum> tokens = new HashMap<>();
    private ArrayList<Token> listaTokens = new ArrayList<>();

    public AnalizadorLexico(ArrayList<Token> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public void generarLexer(String cadena) {

    }
}
