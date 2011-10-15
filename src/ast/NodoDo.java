package ast;

import ast.NodoBase;

public class NodoDo extends NodoBase {

    private NodoBase condicion;
    private NodoBase cuerpo;

    public NodoDo() {
    }

    public NodoDo(NodoBase condicion, NodoBase cuerpo) {
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
