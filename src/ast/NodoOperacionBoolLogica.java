package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionBoolLogica extends NodoBase {

    private NodoBase opDerecho;
    private NodoBase opIzquierdo;
    private Tipo.OpBoolLogica tipo;

    public NodoOperacionBoolLogica() {
    }

    public NodoOperacionBoolLogica(NodoBase opDerecho, NodoBase opIzquierdo, Tipo.OpBoolLogica tipo) {
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

    public Tipo.OpBoolLogica getTipo() {
        return tipo;
    }
}
