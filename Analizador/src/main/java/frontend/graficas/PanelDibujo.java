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

    public PanelDibujo() {
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
