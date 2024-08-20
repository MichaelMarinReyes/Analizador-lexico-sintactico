package frontend.graficas;


import javax.swing.*;
import java.awt.*;

public class GraficaCirculo extends JPanel {

    private double posicionX;
    private double posicionY;
    private double radio;
    private String color;

    public GraficaCirculo() {
        System.out.println("cir");
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

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
        g.fillOval((int) this.posicionX, (int) this.posicionY, (int) this.radio * 2, (int) this.radio * 2);
    }
}
