package ast;

/**
 *
 * @author Personal
 */
public class NodoProcedimientoLlamada extends NodoBase {

    private String nombre;
    private NodoBase parametros;

    public NodoProcedimientoLlamada() {
    }

    public NodoProcedimientoLlamada(String nombre, NodoBase parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoBase getParametros() {
        return parametros;
    }
}
