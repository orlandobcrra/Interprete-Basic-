
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
import ast.NodoOperacionMat;
import ast.NodoOperacionUnaria;
import ast.Tipo;
import ast.Tipo.OpMat;
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
            } else if (valor instanceof NodoIdentificador) {
                NodoIdentificador id = (NodoIdentificador) valor;
                IdValor iv = variables.get(id.getNombre());
                if (iv.getId().getTipo().equals(Tipo.Variable.STRING)) {
                    NodoCadena nodoCadena = (NodoCadena) iv.getValor();
                    String cadena = nodoCadena.getCadena();
                    cadena = cadena.substring(1, cadena.length() - 1);
                    System.out.print(cadena);
                } else {
                    System.out.print(getValorNumerico(valor));
                }
            } else {
                System.out.print(getValorNumerico(valor));
            }            
            //si es una sentencia print con varios valores separados por ";"
            valor = valor.getHermanoDerecha();
            if(valor!=null){
                System.out.print(" ");
            }
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
        int desde = (int) getValorNumerico(nodoFor.getDesde());
        int hasta = (int) getValorNumerico(nodoFor.getHasta());
        int step = (int) getValorNumerico(nodoFor.getStep());
        for (int i = desde; i != hasta; i += step) {
            IdValor iv = variables.get(nodoFor.getVariable());
            ((NodoNumero) iv.getValor()).setValor((double) i);
            interpretarNodo(nodoFor.getCuerpo());
        }
    }

    private void nodoDeclaracion(NodoDeclaracion nodoIdentificador) {
        variables.put(nodoIdentificador.getNombre(), new IdValor(nodoIdentificador));
    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {
        //TODO validar tipo de dato
        //TODO si es tipo integer cast to (int)
        IdValor ladoDerecho = variables.get(nodoAsignacion.getIdentificador());
        ladoDerecho.setValor(nodoAsignacion.getValor());
//        if (!ladoDerecho.getId().getTipo().equals(Tipo.Variable.STRING)) {
//            NodoNumero num = (NodoNumero) ladoDerecho.getValor();
//            num.setValor(getValorNumerico(nodoAsignacion.getValor()));
//        } else {
//            ladoDerecho.getValor().setValor(getValorNumerico(nodoAsignacion.getValor()));
//        }
    }

    private void nodoIf(NodoIf nodoIf) {
        if (nodoOperacionBool(nodoIf.getCondicion())) {
            interpretarNodo(nodoIf.getParteThen());
        } else {
            interpretarNodo(nodoIf.getParteElse());
        }
    }

    private boolean nodoOperacionBool(NodoOperacionBool bool) {
        double derecho = getValorNumerico(bool.getOpDerecho());
        double izquierdo = getValorNumerico(bool.getOpIzquierdo());
        switch (bool.getTipo()) {
            case IGUAL: {
                return derecho == izquierdo;
            }
            case MENOR: {
                return derecho < izquierdo;
            }
            case MENORIGUAL: {
                return derecho <= izquierdo;
            }
            case MAYOR: {
                return derecho > izquierdo;
            }
            case MAYORIGUAL: {
                return derecho >= izquierdo;
            }
            case DIFERENTE: {
                return derecho != izquierdo;
            }
            default:
                return false;
        }
    }

    private double getValorNumerico(NodoBase base) {
        if (base instanceof NodoNumero) {
            return ((NodoNumero) base).getValor();
        } else if (base instanceof NodoOperacionMat) {
            NodoOperacionMat mat = (NodoOperacionMat) base;
            double derecho = getValorNumerico(mat.getOpDerecho());
            double izquierdo = getValorNumerico(mat.getOpIzquierdo());
            return getValorNumerico(derecho, izquierdo, mat.getTipo());
        } else if (base instanceof NodoOperacionUnaria) {
            NodoOperacionUnaria unaria = (NodoOperacionUnaria) base;
            double num = getValorNumerico(unaria.getValor());
            return num * -1;
        } else if (base instanceof NodoIdentificador) {
            NodoIdentificador id = (NodoIdentificador) base;
            IdValor iv = variables.get(id.getNombre());
            if (!iv.getId().getTipo().equals(Tipo.Variable.STRING)) {
                return getValorNumerico(iv.getValor());
                //return ((NodoNumero) iv.getValor()).getValor();
            }
        }
        throw new RuntimeException("Tratando de optener el valor numero de un nodo que no lo contiene");
    }

    private double getValorNumerico(double derecho, double izquierdo, OpMat tipo) {
        switch (tipo) {
            case SUMA: {
                return derecho + izquierdo;
            }
            case REST: {
                return derecho - izquierdo;
            }
            case MULT: {
                return derecho * izquierdo;
            }
            case DIVI: {
                return derecho / izquierdo;
            }
            case POTE: {
                return Math.pow(derecho, izquierdo);
            }
            default:
                return 0.0;
        }
    }
}
