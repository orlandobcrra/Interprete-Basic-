package ast;

/**
 *
 * @author Personal
 */
public class NodoIdentificador extends NodoBase {

    private String nombre;

    public NodoIdentificador() {
    }

    public NodoIdentificador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
