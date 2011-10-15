package ast;

/**
 * 
 * 
 * @author Orlando Becerra
 * @author Jesus Colmenares
 * @author Anthony Crespo
 * @author Danny Sanchez
 * @version 10/10/2011
 */
public class NodoBase {

    private NodoBase hermanoDerecha;

    /**
     * Crea una instancia de NodoBase sin hermanos.
     */
    public NodoBase() {
    }

    /**
     * Crea una instancia de NodoBase partiendo de un Nodo Hermano.
     * 
     * @param hermanoDerecha el nodo hermano
     */
    public NodoBase(NodoBase hermanoDerecha) {
        this.hermanoDerecha = hermanoDerecha;
    }

    /**
     * Obtiene el nodo hermano de este nodo.
     * 
     * @return el nodo hermano
     */
    public NodoBase getHermanoDerecha() {
        return hermanoDerecha;
    }

    /**
     * Asigna el nodo hermano.
     * 
     * @param hermanoDerecha el nodo hermano.
     */
    public void setHermanoDerecha(NodoBase hermanoDerecha) {
        this.hermanoDerecha = hermanoDerecha;
    }

    /**
     * Tiene un nodo hermano?
     * 
     * @return true si tiene hermanos, false de lo contrario
     */
    public boolean tieneHermano() {
        return (hermanoDerecha != null);
    }
}
