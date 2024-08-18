package backend.movimientos;

import backend.movimientos.CirculoMovimiento;

public class CirculoSingleton {
    private static CirculoSingleton instancia;
    private CirculoMovimiento circulo;

    private CirculoSingleton() {
        circulo = new CirculoMovimiento();
    }

    public static CirculoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new CirculoSingleton();
        }
        return instancia;
    }

    public CirculoMovimiento getCirculo() {
        return circulo;
    }
}
