package Modelos;

public class NodoMatriz {

    public NodoMatriz() {
    }

    public NodoMatriz(int x, int y, ArbolAVL arbolAVL) {
        this.x = x;
        this.y = y;
        this.arbolAVL = arbolAVL;
    }

    private NodoMatriz arriba;
    private NodoMatriz abajo;
    private NodoMatriz izquierda;
    private NodoMatriz derecha;
    private int y;
    private int x;
    private ArbolAVL arbolAVL;

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public NodoMatriz getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoMatriz izquierda) {
        this.izquierda = izquierda;
    }

    public NodoMatriz getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoMatriz derecha) {
        this.derecha = derecha;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ArbolAVL getArbolAVL() {
        return arbolAVL;
    }

    public void setArbolAVL(ArbolAVL arbolAVL) {
        this.arbolAVL = arbolAVL;
    }
}
