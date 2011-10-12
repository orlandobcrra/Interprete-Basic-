package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionMat extends NodoNumero {

    private NodoNumero opDerecho;
    private NodoNumero opIzquierdo;
    private Tipo.OpMat tipo;

    public NodoOperacionMat(NodoNumero opDerecho, NodoNumero opIzquierdo, Tipo.OpMat tipo) {
        this.opDerecho = opDerecho;
        this.opIzquierdo = opIzquierdo;
        this.tipo = tipo;
    }

    public NodoNumero getOpDerecho() {
        return opDerecho;
    }

    public NodoNumero getOpIzquierdo() {
        return opIzquierdo;
    }

    public Tipo.OpMat getTipo() {
        return tipo;
    }
}
