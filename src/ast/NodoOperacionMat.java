package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionMat extends NodoBase {

    private NodoBase opDerecho;
    private NodoBase opIzquierdo;
    private Tipo.OpMat tipo;

    public NodoOperacionMat(NodoBase opDerecho, NodoBase opIzquierdo, Tipo.OpMat tipo) {
        this.opDerecho = opDerecho;
        this.opIzquierdo = opIzquierdo;
        this.tipo = tipo;
    }

    public NodoBase getOpDerecho() {
        return opDerecho;
    }

    public NodoBase getOpIzquierdo() {
        return opIzquierdo;
    }

    public Tipo.OpMat getTipo() {
        return tipo;
    }
}
