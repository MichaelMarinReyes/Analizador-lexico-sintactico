package backend.figuras;

public class Cuadrado {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private double tamañoLado;
    private String color;

    public Cuadrado(String nombre, double posicionX, double posicionY, double tamañoLado, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tamañoLado = tamañoLado;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double getTamañoLado() {
        return tamañoLado;
    }

    public void setTamañoLado(double tamañoLado) {
        this.tamañoLado = tamañoLado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
