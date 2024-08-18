package frontend.graficas;

import backend.figuras.Figura;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author michael
 */
public class PanelDibujo extends JPanel {

    private Figura figura;
    
    public void setFigura(Figura figura) {
        this.figura = figura;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figura != null) {
            figura.dibujar(g);
        }
    }
}
