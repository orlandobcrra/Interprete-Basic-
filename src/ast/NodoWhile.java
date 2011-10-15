package ast;

import ast.NodoBase;

public class NodoWhile extends NodoBase {

    private NodoBase condicion;
    private NodoBase cuerpo;

    public NodoWhile() {
    }

    public NodoWhile(NodoBase condicion, NodoBase cuerpo) {
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }

    public NodoBase getCondicion() {
        return condicion;
    }

    public NodoBase getCuerpo() {
        return cuerpo;
    }
}
