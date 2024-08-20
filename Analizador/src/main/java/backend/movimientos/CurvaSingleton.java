package backend.movimientos;

public class CurvaSingleton {
    private static CurvaSingleton instancia;
    private CurvaMovimiento circulo;

    private CurvaSingleton() {
        circulo = new CurvaMovimiento();
    }

    public static CurvaSingleton getInstancia() {
        if (instancia == null) {
            instancia = new CurvaSingleton();
        }
        return instancia;
    }

    public CurvaMovimiento getCirculo() {
        return circulo;
    }
}
