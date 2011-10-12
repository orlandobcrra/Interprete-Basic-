package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionMatUnaria extends NodoBase {

    private NodoBase valor;

    public NodoOperacionMatUnaria() {
    }

    public NodoOperacionMatUnaria(NodoBase valor) {
        this.valor = valor;
    }

    public NodoBase getValor() {
        return valor;
    }
}
