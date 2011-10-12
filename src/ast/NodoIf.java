package ast;

import ast.NodoBase;

public class NodoIf extends NodoBase {

    private NodoOperacionBool condicion;
    private NodoBase parteThen;
    private NodoBase parteElse;

    public NodoIf(NodoOperacionBool condicion, NodoBase parteThen) {
        this.condicion = condicion;
        this.parteThen = parteThen;
        this.parteElse = null;
    }

    public NodoIf(NodoOperacionBool condicion, NodoBase parteThen, NodoBase parteElse) {
        this.condicion = condicion;
        this.parteThen = parteThen;
        this.parteElse = parteElse;
    }

    public NodoOperacionBool getCondicion() {
        return condicion;
    }

    public NodoBase getParteThen() {
        return parteThen;
    }

    public NodoBase getParteElse() {
        return parteElse;
    }
}
