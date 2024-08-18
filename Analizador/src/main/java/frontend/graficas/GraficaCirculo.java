package frontend.graficas;

import backend.movimientos.CirculoSingleton;

import java.awt.*;

public class GraficaCirculo {

    public static void hacerCirculo(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(CirculoSingleton.getInstancia().getCirculo().getPosicionX(), CirculoSingleton.getInstancia().getCirculo().getPosicionY(), 50, 50);
    }
}
