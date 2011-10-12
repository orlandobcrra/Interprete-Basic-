package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionUnaria extends NodoBase {

    private NodoBase valor;

    public NodoOperacionUnaria(NodoBase valor) {
        this.valor = valor;
    }

    public NodoBase getValor() {
        return valor;
    }
}
