package ast;

import ast.Tipo.Variable;

public class NodoDeclaracionVector extends NodoBase {

    private String nombre;
    private NodoBase tam;
    private Tipo.Variable tipo;

    public NodoDeclaracionVector() {
    }

    public NodoDeclaracionVector(String nombre, NodoBase tam, Variable tipo) {
        this.nombre = nombre;
        this.tam = tam;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoBase getTam() {
        return tam;
    }

    public Tipo.Variable getTipo() {
        return tipo;
    }
}
