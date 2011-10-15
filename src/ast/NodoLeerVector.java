package ast;

public class NodoLeerVector extends NodoBase {

    private String variable;
    private NodoBase ex;

    public NodoLeerVector() {
    }

    public NodoLeerVector(String variable, NodoBase ex) {
        this.variable = variable;
        this.ex = ex;
    }

    public String getVariable() {
        return variable;
    }

    public NodoBase getEx() {
        return ex;
    }
}
