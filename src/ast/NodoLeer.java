package ast;

public class NodoLeer extends NodoBase{

    private String variable;

    public NodoLeer() {
    }

    public NodoLeer(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
