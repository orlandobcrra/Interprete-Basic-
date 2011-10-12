
import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoCadena;
import ast.NodoEscribir;
import ast.NodoNumero;
import ast.NodoFor;
import ast.NodoDeclaracion;
import ast.NodoLeer;
import ast.IdValor;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoOperacionBool;
import ast.Tipo;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interpreta cada uno de los nodos hasta el final del programa.
 * 
 * @author Personal
 */
public class Interprete {

    private NodoBase root;
    private HashMap<String, IdValor> variables =
            new HashMap<String, IdValor>();

    /**
     * Crea una instancia de la clase Interprete partiendo del nodo raiz,
     * interpreta cada uno de los nodos hasta el final del programa.
     * 
     * @param root el nodo raiz
     */
    public Interprete(NodoBase root) {
        this.root = root;
    }

    public void start() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("");
        NodoBase nodoActual = root;
        if (nodoActual != null) {
            do {
                interpretarNodo(nodoActual);
                nodoActual = nodoActual.getHermanoDerecha();
            } while (nodoActual != null);
        }
        System.out.println("");
        System.out.println("-----------------------------------");
    }

    /**
     * Realiza la interpretacion de un nodo especifico.
     * 
     * @param nodo el nodo
     */
    private void interpretarNodo(NodoBase nodo) {
        if (nodo instanceof NodoEscribir) {
            nodoEscribir((NodoEscribir) nodo);
        } else if (nodo instanceof NodoLeer) {
            nodoLeer((NodoLeer) nodo);
        } else if (nodo instanceof NodoFor) {
            nodoFor((NodoFor) nodo);
        } else if (nodo instanceof NodoDeclaracion) {
            nodoDeclaracion((NodoDeclaracion) nodo);
        } else if (nodo instanceof NodoAsignacion) {
            nodoAsignacion((NodoAsignacion) nodo);
        } else if (nodo instanceof NodoIf) {
            nodoIf((NodoIf) nodo);
        }
    }

    /**
     * Interpreta la sentencia <code>PRINT</code>.
     * Ejm: PRINT "hola";999
     *      PRINT "HOLA";
     *      PRINT "NUMERO = ";9+3*7;" JEJE"
     * 
     * @param nodoEscribir el nodo escribir
     */
    private void nodoEscribir(NodoEscribir nodoEscribir) {
        NodoBase valor = nodoEscribir.getValor();
        //Para todos los valores del print
        do {
            if (valor instanceof NodoCadena) {
                NodoCadena nodoCadena = (NodoCadena) valor;
                String cadena = nodoCadena.getCadena();
                //elimina las comillas
                cadena = cadena.substring(1, cadena.length() - 1);
                System.out.print(cadena);
            } else if (valor instanceof NodoNumero) {
                NodoNumero nodoExpresion = (NodoNumero) valor;
                System.out.print(nodoExpresion.getValor());
            } else if (valor instanceof NodoIdentificador) {
                NodoIdentificador identificador = (NodoIdentificador) valor;
                IdValor iv = variables.get(identificador.getNombre());
                if (iv.getNodoIdentificador().getTipo().equals(Tipo.Variable.INTEGER)) {
                    System.out.print((int) iv.getNodoNumero().getValor().doubleValue());
                } else {
                    System.out.print(iv.getNodoNumero().getValor().doubleValue());
                }
            }
            //si es una sentencia print con varios valores separados por ";"
            valor = valor.getHermanoDerecha();
        } while (valor != null);

        if (nodoEscribir.isSaltoDeLinea()) {    //Termina con nueva linea
            System.out.println("");
        } else {                                //Si termina con ;
            System.out.print(" ");
        }
    }

    private void nodoLeer(NodoLeer nodoLeer) {
        try {
            int i = System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Interprete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void nodoFor(NodoFor nodoFor) {
        for (int i = nodoFor.getDesde(); i != nodoFor.getHasta(); i += nodoFor.getStep()) {
            IdValor iv = variables.get(nodoFor.getVariable());
            iv.getNodoNumero().setValor((double) i);
            interpretarNodo(nodoFor.getCuerpo());
        }
    }

    private void nodoDeclaracion(NodoDeclaracion nodoIdentificador) {
        variables.put(nodoIdentificador.getNombre(), new IdValor(nodoIdentificador));
    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {
        //TODO validar tipo de dato
        IdValor iv = variables.get(nodoAsignacion.getIdentificador());
        iv.getNodoNumero().setValor(nodoAsignacion.getNodoNumero().getValor());
    }

    private void nodoIf(NodoIf nodoIf) {
        if (nodoOperacionBool(nodoIf.getCondicion())) {
            interpretarNodo(nodoIf.getParteThen());
        } else {
            interpretarNodo(nodoIf.getParteElse());
        }
    }

    private boolean nodoOperacionBool(NodoOperacionBool bool) {
        switch (bool.getTipo()) {
            case IGUAL: {
                return bool.getOpDerecho().getValor().doubleValue()
                        == bool.getOpIzquierdo().getValor().doubleValue();
            }
            case MENOR: {
                return bool.getOpDerecho().getValor().doubleValue()
                        < bool.getOpIzquierdo().getValor().doubleValue();
            }
            case MENORIGUAL: {
                return bool.getOpDerecho().getValor().doubleValue()
                        <= bool.getOpIzquierdo().getValor().doubleValue();
            }
            case MAYOR: {
                return bool.getOpDerecho().getValor().doubleValue()
                        > bool.getOpIzquierdo().getValor().doubleValue();
            }
            case MAYORIGUAL: {
                return bool.getOpDerecho().getValor().doubleValue()
                        >= bool.getOpIzquierdo().getValor().doubleValue();
            }
            case DIFERENTE: {
                return bool.getOpDerecho().getValor().doubleValue()
                        != bool.getOpIzquierdo().getValor().doubleValue();
            }
            default:
                return false;
        }
    }
}
