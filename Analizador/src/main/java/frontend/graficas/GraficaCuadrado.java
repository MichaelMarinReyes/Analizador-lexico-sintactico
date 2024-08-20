package frontend.graficas;

import javax.swing.*;
import java.awt.*;

public class GraficaCuadrado extends JPanel {
    private double inicialX;
    private double inicialY;
    private double tamanio;
    private String color;

    public GraficaCuadrado() {

    }

    public double getInicialX() {
        return inicialX;
    }

    public void setInicialX(double inicialX) {
        this.inicialX = inicialX;
    }

    public double getInicialY() {
        return inicialY;
    }

    public void setInicialY(double inicialY) {
        this.inicialY = inicialY;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (this.color) {
            case "rojo":
                g.setColor(Color.RED);
                break;
            case "azul":
                g.setColor(Color.BLUE);
                break;
            case "verde":
                g.setColor(Color.GREEN);
                break;
            case "negro":
                g.setColor(Color.BLACK);
                break;
            case "amarillo":
                g.setColor(Color.YELLOW);
                break;
            case "celeste":
                g.setColor(Color.CYAN);
                break;
            case "rosado":
                g.setColor(Color.PINK);
                break;
            case "morado":
                g.setColor(Color.MAGENTA);
                break;
            default:
                g.setColor(Color.WHITE);
        }
        g.fillRect((int) this.inicialX, (int) this.inicialY, (int) this.tamanio, this.color.length());
    }
}
