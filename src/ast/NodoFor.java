package ast;

import ast.NodoBase;

public class NodoFor extends NodoBase {

    private String variable;
    private Integer desde;
    private Integer hasta;
    private NodoBase cuerpo;
    private String variable2;
    private Integer step=1;

    public NodoFor() {
    }

    public NodoFor(String variable, Integer desde, Integer hasta, NodoBase cuerpo, String variable2) {
        this.variable = variable;
        this.desde = desde;
        this.hasta = hasta;
        this.cuerpo = cuerpo;
        this.variable2 = variable2;
    }

    public NodoFor(String variable, Integer desde, Integer hasta, NodoBase cuerpo, String variable2, Integer step) {
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

    public Integer getDesde() {
        return desde;
    }

    public Integer getHasta() {
        return hasta;
    }

    public String getVariable() {
        return variable;
    }

    public String getVariable2() {
        return variable2;
    }

    public Integer getStep() {
        return step;
    }
}
