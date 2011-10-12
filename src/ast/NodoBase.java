package ast;

public class NodoBase {

    private NodoBase hermanoDerecha;

    public NodoBase() {
    }

    public NodoBase(NodoBase hermanoDerecha) {
        this.hermanoDerecha = hermanoDerecha;
    }

    public NodoBase getHermanoDerecha() {
        return hermanoDerecha;
    }

    public void setHermanoDerecha(NodoBase hermanoDerecha) {
        this.hermanoDerecha = hermanoDerecha;
    }

    public boolean TieneHermano() {
        return (hermanoDerecha != null);
    }
}
