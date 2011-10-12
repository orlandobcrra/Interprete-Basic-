package ast;

/**
 *
 * @author Personal
 */
public class IdValor {

    private NodoDeclaracion nodoIdentificador;
    private NodoNumero nodoNumero = new NodoNumero();

    public IdValor(NodoDeclaracion nodoIdentificador) {
        this.nodoIdentificador = nodoIdentificador;
    }

    public IdValor(NodoDeclaracion nodoIdentificador, NodoNumero nodoNumero) {
        this.nodoIdentificador = nodoIdentificador;
        this.nodoNumero = nodoNumero;
    }

    public NodoDeclaracion getNodoIdentificador() {
        return nodoIdentificador;
    }

    public NodoNumero getNodoNumero() {
        return nodoNumero;
    }

    public void setNodoNumero(NodoNumero nodoNumero) {
        this.nodoNumero = nodoNumero;
    }
}
