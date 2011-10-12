package ast;

import ast.NodoBase;

public class NodoFor extends NodoBase {

    private String variable;
    private NodoBase desde;
    private NodoBase hasta;
    private NodoBase cuerpo;
    private String variable2;
    private NodoBase step;

    public NodoFor(String variable, NodoBase desde, NodoBase hasta, NodoBase cuerpo, String variable2) {
        this(variable, desde, hasta, cuerpo, variable2, new NodoNumero("1"));
    }

    public NodoFor(String variable, NodoBase desde, NodoBase hasta, NodoBase cuerpo, String variable2, NodoBase step) {
        this.variable = variable;
        this.desde = desde;
        this.hasta = hasta;
        this.cuerpo = cuerpo;
        this.variable2 = variable2;
        this.step = step;
    }

    public NodoBase getCuerpo() {
        return cuerpo;
    }

    public NodoBase getDesde() {
        return desde;
    }

    public NodoBase getHasta() {
        return hasta;
    }

    public String getVariable() {
        return variable;
    }

    public String getVariable2() {
        return variable2;
    }

    public NodoBase getStep() {
        return step;
    }
}
