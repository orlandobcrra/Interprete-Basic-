package ast;

import ast.NodoBase;

public class NodoIf extends NodoBase {

    private NodoBase condicion;
    private NodoBase parteThen;
    private NodoBase parteElse;

    public NodoIf() {
    }

    public NodoIf(NodoBase condicion, NodoBase parteThen) {
        this.condicion = condicion;
        this.parteThen = parteThen;
        this.parteElse = null;
    }

    public NodoIf(NodoBase condicion, NodoBase parteThen, NodoBase parteElse) {
        this.condicion = condicion;
        this.parteThen = parteThen;
        this.parteElse = parteElse;
    }

    public NodoBase getCondicion() {
        return condicion;
    }

    public NodoBase getParteThen() {
        return parteThen;
    }

    public NodoBase getParteElse() {
        return parteElse;
    }
}
