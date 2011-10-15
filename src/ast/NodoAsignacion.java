package ast;
/**
 * Nodo utilizado para asociar el nombre de la variable con su valor.
 * El valor puede ser, un numero, una expresion numerica o otra variable.
 * 
 * @author Orlando Becerra
 * @author Jesus Colmenares
 * @author Anthony Crespo
 * @author Danny Sanchez
 * @version 10/10/2011
 */
public class NodoAsignacion extends NodoBase {

    /**
     * Nombre de la variable.
     */
    private String variable;
    /**
     * El valor asignado a la varible.
     */
    private NodoBase valor;

    /**
     * Crea una instancia de NodoAsignacion sin valores.
     */
    public NodoAsignacion() {
    }

    /**
     * Crea una instancia de NodoAsignacion con el par nombre de la variable y
     * el valor que se le quiere asignar.
     * 
     * @param variable el nombre de la variable
     * @param valor el valor que se le asignara
     */
    public NodoAsignacion(String variable, NodoBase valor) {
        this.variable = variable;
        this.valor = valor;
    }

    /**
     * Obtiene el nombre de la variable.
     * 
     * @return el nombre de la variable 
     */
    public String getIdentificador() {
        return variable;
    }

    /**
     * Obtiene el valor de la variable.
     * 
     * @return el valor de la variable 
     */
    public NodoBase getValor() {
        return valor;
    }
}
