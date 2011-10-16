package ast;

import ast.Tipo.Variable;

/**
 * Esta clase mantiene asociado el tipo / valor para vectores. Donde tipo representa el
 * tipo de declaracion de la variable; y el valor 
 * contiene el valor verdadero de la variable.
 * Objetos de esta clase, deben ser utilizados en el Map que contiene las 
 * variables de vectores del programa.
 * 
 * @author Orlando Becerra
 * @author Jesus Colmenares
 * @author Anthony Crespo
 * @author Danny Sanchez
 * @version 11/10/2011
 */
public class IdValorVector {

    /**
     * El nodo con el que se realizo la declaracion de la variable.
     */
    private Tipo.Variable tipo;
    /**
     * El nodo que contiene el valor de la variable.
     */
    private NodoBase[] valor;

    /**
     * Crea una instacia de IdValor partiendo del nodo que contiene la
     * declaracion de la variable.
     * 
     * @param nodoDeclaracion el nodo declaracion
     */
    public IdValorVector(int tam, Tipo.Variable tipo) {
        this.tipo = tipo;
        valor = new NodoBase[tam];
        for (int i = 0; i < valor.length; i++) {
            if (tipo.equals(Tipo.Variable.STRING)) {
                valor[i] = new NodoCadena("");
            } else {
                valor[i] = new NodoNumero(0.0);
            }
        }
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
     * Obtiene el nodo con valor actual de esta variable en la posicion p.
     * 
     * @param p la posicion
     * @return el nodo que contiene el varlo. 
     */
    public NodoBase getValor(int p) {
        return valor[p];
    }

    /**
     * Asigna el nodo con el valor que debe tener el vector en la posicion p.
     * 
     * @param p la posicion
     * @param valor el nodo valor 
     */
    public void setValor(int p, NodoBase valor) {
        this.valor[p] = valor;
    }

    public void setValor(NodoBase[] valor) {
        this.valor = valor;
    }

    public NodoBase[] getValor() {
        return valor;
    }
}
