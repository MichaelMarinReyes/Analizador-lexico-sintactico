package backend.figuras;

import java.awt.*;

public abstract class Figura {

    private String nombre;
    private String color;

    public abstract void paint(Graphics graphics);

    public String getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }
}
