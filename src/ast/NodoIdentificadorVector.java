package ast;

/**
 *
 * @author Personal
 */
public class NodoIdentificadorVector extends NodoBase {

    private String nombre;
    private NodoBase ex;

    public NodoIdentificadorVector() {
    }

    public NodoIdentificadorVector(String nombre, NodoBase ex) {
        this.nombre = nombre;
        this.ex = ex;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoBase getEx() {
        return ex;
    }
}
