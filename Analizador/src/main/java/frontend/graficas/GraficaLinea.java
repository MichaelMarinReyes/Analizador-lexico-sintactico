package frontend.graficas;

import javax.swing.*;
import java.awt.*;

public class GraficaLinea extends JPanel {

    private double inicialX;
    private double inicialY;
    private double finalX;
    private double finalY;
    private String color;

    public GraficaLinea() {

    }

    public static void paint(Graphics g, int posicionX, int posicionY, int x1, int y1) {
        g.drawLine(posicionX, posicionY, x1, y1);
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

    public double getFinalX() {
        return finalX;
    }

    public void setFinalX(double finalX) {
        this.finalX = finalX;
    }

    public double getFinalY() {
        return finalY;
    }

    public void setFinalY(double finalY) {
        this.finalY = finalY;
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

        g.fillRect((int) inicialX, (int) inicialY, (int) finalX, (int) finalY);
    }
}
