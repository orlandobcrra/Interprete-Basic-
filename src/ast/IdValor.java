package ast;

/**
 * Esta clase mantiene asociado el par id / valor. Donde id representa la
 * declaracion de la variable, la cual contiene su tipo de dato; y el valor 
 * contiene el valor verdadero de la variable.
 * Objetos de esta clase, deben ser utilizados en el Map que contiene las 
 * variables del programa.
 * 
 * @author Orlando Becerra
 * @author Jesus Colmenares
 * @author Anthony Crespo
 * @author Danny Sanchez
 * @version 11/10/2011
 */
public class IdValor {

    /**
     * El nodo con el que se realizo la declaracion de la variable.
     */
    private NodoDeclaracion id;
    /**
     * El nodo que contiene el valor de la variable.
     */
    private NodoBase valor;

    /**
     * Crea una instacia de IdValor partiendo del nodo que contiene la
     * declaracion de la variable.
     * 
     * @param nodoDeclaracion el nodo declaracion
     */
    public IdValor(NodoDeclaracion nodoDeclaracion) {
        this.id = nodoDeclaracion;
    }

    /**
     * Obtiene el nodo declaracion de este par.
     * 
     * @return el nodo declaracion 
     */
    public NodoDeclaracion getId() {
        return id;
    }

    /**
     * Obtiene el nodo con valor actual de esta variable.
     * 
     * @return el nodo que contiene el varlo. 
     */
    public NodoBase getValor() {
        return valor;
    }

    /**
     * Asigna el nodo con el valor que debe tener la variable.
     * 
     * @param valor el nodo valor 
     */
    public void setValor(NodoBase valor) {
        this.valor = valor;
    }
}
