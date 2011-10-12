package ast;

/**
 *
 * @author Personal
 */
public class NodoCadena extends NodoBase {

    private String cadena;

    public NodoCadena() {
    }

    public NodoCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }
}
