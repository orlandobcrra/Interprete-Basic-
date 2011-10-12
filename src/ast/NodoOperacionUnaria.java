package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionUnaria extends NodoNumero {

    private NodoNumero nodoNumero;

    public NodoOperacionUnaria(NodoNumero nodoNumero) {
        this.nodoNumero = nodoNumero;
    }

    @Override
    public Double getValor() {
        return nodoNumero.getValor() * -1;
    }
}
