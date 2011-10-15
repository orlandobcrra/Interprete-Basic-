package ast;

public class NodoNumero extends NodoBase {

    private Double valor = 0.0;

    public NodoNumero() {
    }

    public NodoNumero(double d) {
        valor = d;
    }

    public NodoNumero(String s) {
        this.valor = Double.parseDouble(s);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
