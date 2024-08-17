package frontend.graficas;

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
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(100, 100, 200, 200);
        g.setColor(Color.yellow);
        g.fillRect(300, 300, 100, 100);
        g.fillOval(500, 100, 100, 100);
    }
}
