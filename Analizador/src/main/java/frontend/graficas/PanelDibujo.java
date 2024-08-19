package frontend.graficas;

import backend.figuras.*;
import frontend.reportes.ColoresUsados;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 * @author michael
 */
public class PanelDibujo extends JPanel {
    private List<Figura> listaFiguras;

    public PanelDibujo() {
        this.setBackground(Color.GRAY);
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (listaFiguras != null) {
            for (Figura figura : listaFiguras) {
                if (figura instanceof Circulo) {
                    Circulo circulo = (Circulo) figura;
                    g.setColor(devolverColor(circulo.getColor()));
                    g.fillOval((int) circulo.getPosicionX(), (int) circulo.getPosicionY(),
                            (int) circulo.getRadio() * 2, (int) circulo.getRadio() * 2);

                } else if (figura instanceof Linea) {
                    Linea linea = (Linea) figura;
                    g.setColor(devolverColor(linea.getColor()));
                    g.drawLine((int) linea.getPosicionInicialX(), (int) linea.getPosicionInicialY(),
                            (int) linea.getPosicionFinalX(), (int) linea.getPosicionFinalY());

                } else if (figura instanceof Cuadrado) {
                    Cuadrado cuadrado = (Cuadrado) figura;
                    g.setColor(devolverColor(cuadrado.getColor()));
                    g.fillRect((int) cuadrado.getPosicionX(), (int) cuadrado.getPosicionY(),
                            (int) cuadrado.getTamanio(), (int) cuadrado.getTamanio());

                } else if (figura instanceof Rectangulo) {
                    Rectangulo rectangulo = (Rectangulo) figura;
                    g.setColor(devolverColor(rectangulo.getColor()));
                    g.fillRect((int) rectangulo.getPosicionX(), (int) rectangulo.getPosicionY(),
                            (int) rectangulo.getAncho(), (int) rectangulo.getAlto());

                } else if (figura instanceof Poligono) {
                    Poligono poligono = (Poligono) figura;
                    g.setColor(devolverColor(poligono.getColor()));

                    int numLados = poligono.getCantidadLados();
                    int[] xPoints = new int[numLados];
                    int[] yPoints = new int[numLados];

                    double centroX = poligono.getPosicionX();
                    double centroY = poligono.getPosicionY();
                    double radio = Math.min(poligono.getAncho(), poligono.getAlto()) / 2.0;

                    for (int i = 0; i < numLados; i++) {
                        double angulo = 2 * Math.PI * i / numLados;
                        xPoints[i] = (int) (centroX + radio * Math.cos(angulo));
                        yPoints[i] = (int) (centroY + radio * Math.sin(angulo));
                    }

                    g.fillPolygon(xPoints, yPoints, numLados);
                }
            }
        }
        new ColoresUsados().recibirLista(listaFiguras);
    }

    private Color devolverColor(String color) {
        switch (color) {
            case "rojo":
                return Color.RED;
            case "azul":
                return Color.BLUE;
            case "verde":
                return Color.GREEN;
            case "negro":
                return Color.BLACK;
            case "amarillo":
                return Color.YELLOW;
            case "celeste":
                return Color.CYAN;
            case "rosado":
                return Color.PINK;
            case "morado":
                return Color.MAGENTA;
            default:
                return Color.WHITE;
        }
    }
}
