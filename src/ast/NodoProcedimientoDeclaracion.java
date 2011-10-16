package ast;

/**
 *
 * @author Personal
 */
public class NodoProcedimientoDeclaracion extends NodoBase {

    private String nombre;
    private NodoBase parametros;
    private NodoBase cuerpo;

    public NodoProcedimientoDeclaracion() {
    }

    public NodoProcedimientoDeclaracion(String nombre, NodoBase parametros, NodoBase cuerpo) {
        this.nombre = nombre;
        this.parametros = parametros;
        this.cuerpo = cuerpo;
    }

    public NodoBase getCuerpo() {
        return cuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoBase getParametros() {
        return parametros;
    }
}
