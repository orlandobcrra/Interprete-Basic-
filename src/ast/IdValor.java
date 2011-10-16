package ast;

import ast.Tipo.Variable;

/**

 * Esta clase mantiene asociado el tipo / valor. Donde tipo representa el
 * tipo de declaracion de la variable; y el valor 
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
    private Tipo.Variable tipo;
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
    public IdValor(Tipo.Variable tipo) {
        this.tipo = tipo;
    }

    /**
     * Crea una instacia de IdValor partiendo del nodo que contiene la
     * declaracion de la variable y su valor.
     * 
     * @param nodoDeclaracion el nodo declaracion
     * @param valor el nodo que contiene el valor de la variable
     */
    public IdValor(Tipo.Variable tipo, NodoBase valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Obtiene el tipo de variable.
     * 
     * @return el tipo de variable
     */
    public Variable getTipo() {
        return tipo;
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
