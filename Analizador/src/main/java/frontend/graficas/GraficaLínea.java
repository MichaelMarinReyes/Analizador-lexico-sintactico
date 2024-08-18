package frontend.graficas;

import javax.swing.*;
import java.awt.*;

public class GraficaLínea extends JPanel {


    public static void paint(Graphics g, int posicionX, int posicionY, int x1, int y1) {
        g.drawLine(posicionX, posicionY, x1, y1);
    }
}
