package ast;

public class NodoAsignacion extends NodoBase {

    private String variable;
    private NodoBase valor;

    public NodoAsignacion() {
    }

    public NodoAsignacion(String variable, NodoBase valor) {
        this.variable = variable;
        this.valor = valor;
    }

    public String getIdentificador() {
        return variable;
    }

    public NodoBase getValor() {
        return valor;
    }
}
