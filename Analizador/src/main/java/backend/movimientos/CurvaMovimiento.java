package backend.movimientos;

public class CurvaMovimiento extends Thread {
    private int posicionX;
    private int posicionY;
    private int movimientoX;
    private int movimientoY;
    private int distanciaMaximaX;
    private int distanciaMaximaY;

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getMovimientoX() {
        return movimientoX;
    }

    public void setMovimientoX(int movimientoX) {
        this.movimientoX = movimientoX;
    }

    public int getMovimientoY() {
        return movimientoY;
    }

    public void setMovimientoY(int movimientoY) {
        this.movimientoY = movimientoY;
    }

    public int getDistanciaMaximaX() {
        return distanciaMaximaX;
    }

    public void setDistanciaMaximaX(int distanciaMaximaX) {
        this.distanciaMaximaX = distanciaMaximaX;
    }

    public int getDistanciaMaximaY() {
        return distanciaMaximaY;
    }

    public void setDistanciaMaximaY(int distanciaMaximaY) {
        this.distanciaMaximaY = distanciaMaximaY;
    }

    public void mover() {
        posicionX += movimientoX;
        posicionY += movimientoY;
    }

    @Override
    public void run() {
        while (true) {
            if (posicionX >= distanciaMaximaX - 50) {
                movimientoX = -1;
            }
            if (posicionY >= distanciaMaximaY - 50) {
                movimientoY = -1;
            }
            if (posicionX <= 0) {
                movimientoX = 1;
            }
            if (posicionY <= 0) {
                movimientoY = 1;
            }

            mover();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
