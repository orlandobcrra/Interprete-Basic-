package ast;

public class NodoEscribir extends NodoBase {

    private NodoBase valor;
    private boolean saltoDeLinea = true;

    public NodoEscribir() {
    }

    public NodoEscribir(NodoBase valor) {
        this.valor = valor;
    }

    public NodoEscribir(NodoBase valor, boolean saltoDeLinea) {
        this.valor = valor;
        this.saltoDeLinea = saltoDeLinea;
    }

    public NodoBase getValor() {
        return valor;
    }

    public void setValor(NodoBase valor) {
        this.valor = valor;
    }

    public boolean isSaltoDeLinea() {
        return saltoDeLinea;
    }
}
