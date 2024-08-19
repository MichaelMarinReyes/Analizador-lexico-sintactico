package backend.figuras;

import java.awt.*;

public class Cuadrado extends Figura {
    private String nombre;
    private double posicionX;
    private double posicionY;
    private double tamanio;
    private String color;

    public Cuadrado(String nombre, double posicionX, double posicionY, double tamanio, String color) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tamanio = tamanio;
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

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamañoLado) {
        this.tamanio = tamañoLado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("dibujando cuadrado");
    }


}
