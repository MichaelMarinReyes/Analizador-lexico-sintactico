package backend.reportes;

public class ErrorReporte {

    private String lexema;
    private int linea;
    private int columna;
    private String tipo;
    private String descripcion;

    public ErrorReporte(String lexema, int linea, int columna, String tipo, String descripcion) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ErrorReporte{" +
                "lexema='" + lexema + '\'' +
                ", linea=" + linea +
                ", columna=" + columna +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
