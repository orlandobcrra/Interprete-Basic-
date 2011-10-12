package ast;

public class NodoAsignacion extends NodoBase {

    private String variable;
    private NodoNumero nodoNumero;

    public NodoAsignacion() {
    }

    public NodoAsignacion(String variable, NodoNumero nodoNumero) {
        this.variable = variable;
        this.nodoNumero = nodoNumero;
    }

    public String getIdentificador() {
        return variable;
    }

    public NodoNumero getNodoNumero() {
        return nodoNumero;
    }
}
