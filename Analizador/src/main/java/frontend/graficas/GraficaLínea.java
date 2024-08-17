package frontend.graficas;

import java.awt.*;

public class GraficaLínea {
    public static void hacerLinea(Graphics g, int posicionX, int posicionY, int x1, int y1) {
        g.drawLine(posicionX, posicionY, x1, y1);
    }
}
