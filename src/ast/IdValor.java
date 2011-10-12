package ast;

/**
 *
 * @author Personal
 */
public class IdValor {

    private NodoDeclaracion id;
    private NodoBase valor;

    public IdValor(NodoDeclaracion nodoIdentificador) {
        this.id = nodoIdentificador;
    }

    public IdValor(NodoDeclaracion nodoIdentificador, NodoBase nodoNumero) {
        this.id = nodoIdentificador;
        this.valor = nodoNumero;
    }

    public NodoDeclaracion getId() {
        return id;
    }

    public NodoBase getValor() {
        return valor;
    }

    public void setValor(NodoBase valor) {
        this.valor = valor;
    }
}
