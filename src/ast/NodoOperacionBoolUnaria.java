package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionBoolUnaria extends NodoBase {

    private NodoBase valor;

    public NodoOperacionBoolUnaria() {
    }

    public NodoOperacionBoolUnaria(NodoBase valor) {
        this.valor = valor;
    }

    public NodoBase getValor() {
        return valor;
    }
}
