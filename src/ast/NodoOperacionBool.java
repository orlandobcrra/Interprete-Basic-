package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionBool extends NodoBase {

    private NodoBase opDerecho;
    private NodoBase opIzquierdo;
    private Tipo.OpBool tipo;

    public NodoOperacionBool() {
    }

    public NodoOperacionBool(NodoBase opDerecho, NodoBase opIzquierdo, Tipo.OpBool tipo) {
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

    public Tipo.OpBool getTipo() {
        return tipo;
    }
}
