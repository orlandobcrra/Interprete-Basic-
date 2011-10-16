
import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoCadena;
import ast.NodoEscribir;
import ast.NodoNumero;
import ast.NodoFor;
import ast.NodoDeclaracion;
import ast.NodoLeer;
import ast.IdValor;
import ast.IdValorVector;
import ast.NodoAsignacionVector;
import ast.NodoDeclaracionVector;
import ast.NodoDo;
import ast.NodoProcedimientoDeclaracion;
import ast.NodoIdentificador;
import ast.NodoIdentificadorVector;
import ast.NodoIf;
import ast.NodoLeerVector;
import ast.NodoOperacionBool;
import ast.NodoOperacionBoolLogica;
import ast.NodoOperacionBoolUnaria;
import ast.NodoOperacionMat;
import ast.NodoOperacionMatUnaria;
import ast.NodoProcedimientoLlamada;
import ast.NodoWhile;
import ast.Tipo;
import ast.Tipo.OpMat;
import java.util.HashMap;

/**
 * Interpreta cada uno de los nodos hasta el final del programa.
 * 
 * @author Personal
 */
public class Interprete {

    private java.util.Scanner in = new java.util.Scanner(System.in);
    private NodoBase root;
    private NodoProcedimientoDeclaracion rootProcedimientos;
    private HashMap<String, NodoProcedimientoDeclaracion> procedimientos =
            new HashMap<String, NodoProcedimientoDeclaracion>();
    private HashMap<String, IdValor> variables =
            new HashMap<String, IdValor>();
    private HashMap<String, IdValorVector> variablesVector =
            new HashMap<String, IdValorVector>();

    /**
     * Crea una instancia de la clase Interprete partiendo del nodo raiz,
     * interpreta cada uno de los nodos hasta el final del programa.
     * 
     * @param root el nodo raiz
     */
    public Interprete(NodoBase root, NodoBase rootProcedimientos) {
        this.root = root;
        this.rootProcedimientos = (NodoProcedimientoDeclaracion) rootProcedimientos;
    }

    public void start() {
        NodoProcedimientoDeclaracion nodoActual = rootProcedimientos;
        while (nodoActual != null) {
            procedimientos.put(nodoActual.getNombre(), nodoActual);
            nodoActual = (NodoProcedimientoDeclaracion) nodoActual.getHermanoDerecha();
        }

        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("");
        //NodoBase nodoActual = root;
        //if (nodoActual != null) {
        //do {
        interpretarNodo(root);
        //      nodoActual = nodoActual.getHermanoDerecha();
        //    } while (nodoActual != null);

        System.out.println("");
        System.out.println("-----------------------------------");
    }

    /**
     * Realiza la interpretacion de un nodo especifico.
     * 
     * @param nodoActual el nodo
     */
    private void interpretarNodo(NodoBase nodo) {
        NodoBase nodoActual = nodo;
        while (nodoActual != null) {
            if (nodoActual instanceof NodoEscribir) {
                nodoEscribir((NodoEscribir) nodoActual);
            } else if (nodoActual instanceof NodoLeer) {
                nodoLeer((NodoLeer) nodoActual);
            } else if (nodoActual instanceof NodoLeerVector) {
                nodoLeerVector((NodoLeerVector) nodoActual);
            } else if (nodoActual instanceof NodoFor) {
                nodoFor((NodoFor) nodoActual);
            } else if (nodoActual instanceof NodoDeclaracion) {
                nodoDeclaracion((NodoDeclaracion) nodoActual);
            } else if (nodoActual instanceof NodoDeclaracionVector) {
                nodoDeclaracionVector((NodoDeclaracionVector) nodoActual);
            } else if (nodoActual instanceof NodoAsignacion) {
                nodoAsignacion((NodoAsignacion) nodoActual);
            } else if (nodoActual instanceof NodoAsignacionVector) {
                nodoAsignacionVector((NodoAsignacionVector) nodoActual);
            } else if (nodoActual instanceof NodoIf) {
                nodoIf((NodoIf) nodoActual);
            } else if (nodoActual instanceof NodoWhile) {
                nodoWhile((NodoWhile) nodoActual);
            } else if (nodoActual instanceof NodoDo) {
                nodoDo((NodoDo) nodoActual);
            } else if (nodoActual instanceof NodoProcedimientoLlamada) {
                NodoProcedimientoLlamada llamada = (NodoProcedimientoLlamada) nodoActual;
                NodoProcedimientoDeclaracion procedimiento = procedimientos.get(llamada.getNombre());

                NodoDeclaracion declaracion = (NodoDeclaracion) procedimiento.getParametros();
                NodoBase valor = llamada.getParametros();
                while (declaracion != null && valor != null) {
                    variables.put(declaracion.getNombre(), new IdValor(declaracion.getTipo(), getNuevoValor(valor)));
                    declaracion = (NodoDeclaracion) declaracion.getHermanoDerecha();
                    valor = valor.getHermanoDerecha();
                }
                if (valor != null || declaracion != null) {
                    throw new RuntimeException("cantidad de parametros no coincide");
                }
                interpretarNodo(procedimiento.getCuerpo());
            }
            nodoActual = nodoActual.getHermanoDerecha();
        }
    }

    private NodoBase getNuevoValor(NodoBase base) {
        if (base instanceof NodoCadena) {
            return new NodoCadena(((NodoCadena) base).getCadena());
        } else if (base instanceof NodoNumero) {
            return new NodoNumero(((NodoNumero) base).getValor());
        } else if (base instanceof NodoOperacionMat || base instanceof NodoOperacionMatUnaria) {
            return new NodoNumero(getValorNumerico(base));
        } else if (base instanceof NodoIdentificador) {
            NodoIdentificador id = (NodoIdentificador) base;
            IdValor iv = variables.get(id.getNombre());
            if (iv.getTipo().equals(Tipo.Variable.STRING)) {
                return new NodoCadena(((NodoCadena) iv.getValor()).getCadena());
            } else {
                return new NodoNumero(getValorNumerico(iv.getValor()));
            }
        } else if (base instanceof NodoIdentificadorVector) {
            NodoIdentificadorVector id = (NodoIdentificadorVector) base;
            IdValorVector iv = variablesVector.get(id.getNombre());
            if (iv.getTipo().equals(Tipo.Variable.STRING)) {
                return new NodoCadena(((NodoCadena) iv.getValor((int) getValorNumerico(id.getEx()))).getCadena());
            } else {
                return new NodoNumero(getValorNumerico(iv.getValor((int) getValorNumerico(id.getEx()))));
            }
        }
        System.out.println("que cagada :(");
        return null;
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
                if (iv.getTipo().equals(Tipo.Variable.STRING)) {
                    NodoCadena nodoCadena = (NodoCadena) iv.getValor();
                    String cadena = nodoCadena.getCadena();
                    cadena = cadena.substring(1, cadena.length() - 1);
                    System.out.print(cadena);
                } else {
                    double d = getValorNumerico(valor);
                    if (iv.getTipo().equals(Tipo.Variable.INTEGER)) {
                        System.out.print((int) d);
                    } else {
                        System.out.print(d);
                    }
                }
            } else if (valor instanceof NodoIdentificadorVector) {
                NodoIdentificadorVector id = (NodoIdentificadorVector) valor;
                IdValorVector iv = variablesVector.get(id.getNombre());
                int p = (int) getValorNumerico(id.getEx());
                if (iv.getTipo().equals(Tipo.Variable.STRING)) {
                    NodoCadena nodoCadena = (NodoCadena) iv.getValor(p);
                    String cadena = nodoCadena.getCadena();
                    cadena = cadena.substring(1, cadena.length() - 1);
                    System.out.print(cadena);
                } else {
                    double d = getValorNumerico(valor);
                    if (iv.getTipo().equals(Tipo.Variable.INTEGER)) {
                        System.out.print((int) d);
                    } else {
                        System.out.print(d);
                    }
                }
            } else {
                double d = getValorNumerico(valor);
                if (Math.round(d) - d == 0) {
                    System.out.print((int) d);
                } else {
                    System.out.print(d);
                }
            }
            //si es una sentencia print con varios valores separados por ";"
            valor = valor.getHermanoDerecha();
            if (valor != null) {
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
        IdValor iv = variables.get(nodoLeer.getVariable());
        if (iv.getTipo().equals(Tipo.Variable.STRING)) {
            String s = null;
            do {
                s = in.nextLine();
            } while (s == null || s.length() == 0);
            s = "\"" + s + "\"";
            iv.setValor(new NodoCadena(s));
        } else if (iv.getTipo().equals(Tipo.Variable.INTEGER)) {
            long i = in.nextLong();
            iv.setValor(new NodoNumero(i));
        } else if (iv.getTipo().equals(Tipo.Variable.FLOAT)) {
            double i = in.nextDouble();
            iv.setValor(new NodoNumero(i));
        }
    }

    private void nodoLeerVector(NodoLeerVector nodoLeer) {
        IdValorVector iv = variablesVector.get(nodoLeer.getVariable());
        if (iv.getTipo().equals(Tipo.Variable.STRING)) {
            String s = in.nextLine();
            iv.setValor((int) getValorNumerico(nodoLeer.getEx()), new NodoCadena(s));
        } else if (iv.getTipo().equals(Tipo.Variable.INTEGER)) {
            long i = in.nextLong();
            iv.setValor((int) getValorNumerico(nodoLeer.getEx()), new NodoNumero(i));
        } else if (iv.getTipo().equals(Tipo.Variable.FLOAT)) {
            double i = in.nextDouble();
            iv.setValor((int) getValorNumerico(nodoLeer.getEx()), new NodoNumero(i));
        }
    }

    private void nodoFor(NodoFor nodoFor) {
        int desde = (int) getValorNumerico(nodoFor.getDesde());
        int hasta = (int) getValorNumerico(nodoFor.getHasta());
        int step = (int) getValorNumerico(nodoFor.getStep());
        for (int i = desde; i != hasta; i += step) {
            IdValor iv = variables.get(nodoFor.getVariable());
            if (iv.getValor() instanceof NodoNumero) {
                ((NodoNumero) iv.getValor()).setValor((double) i);
            } else {
                iv.setValor(new NodoNumero(i));
            }
            interpretarNodo(nodoFor.getCuerpo());
        }
    }

    private void nodoDeclaracion(NodoDeclaracion nodoIdentificador) {
        variables.put(nodoIdentificador.getNombre(), new IdValor(nodoIdentificador.getTipo()));
    }

    private void nodoDeclaracionVector(NodoDeclaracionVector nodoIdentificador) {
        variablesVector.put(nodoIdentificador.getNombre(),
                new IdValorVector((int) getValorNumerico(nodoIdentificador.getTam()), nodoIdentificador.getTipo()));
    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {
        IdValor ladoDerecho = variables.get(nodoAsignacion.getIdentificador());
        if (!ladoDerecho.getTipo().equals(Tipo.Variable.STRING) && !(nodoAsignacion.getValor() instanceof NodoCadena)) {
            NodoNumero nodoNumero = (NodoNumero) ladoDerecho.getValor();
            if (nodoNumero == null) {
                nodoNumero = new NodoNumero();
                ladoDerecho.setValor(nodoNumero);
            }
            if (ladoDerecho.getTipo().equals(Tipo.Variable.INTEGER)) {
                nodoNumero.setValor((double) (int) getValorNumerico(nodoAsignacion.getValor()));
                return;
            } else {
                nodoNumero.setValor(getValorNumerico(nodoAsignacion.getValor()));
                return;
            }
        } else if (nodoAsignacion.getValor() instanceof NodoCadena) {
            ladoDerecho.setValor(nodoAsignacion.getValor());
            return;
        }
        throw new RuntimeException("Asignacion de tipo de datos incorrecto,,,");
    }

    private void nodoAsignacionVector(NodoAsignacionVector nodoAsignacion) {
        IdValorVector ladoDerecho = variablesVector.get(nodoAsignacion.getIdentificador());
        int p = (int) getValorNumerico(nodoAsignacion.getEx());
        if (!ladoDerecho.getTipo().equals(Tipo.Variable.STRING) && !(nodoAsignacion.getValor() instanceof NodoCadena)) {
            NodoNumero nodoNumero = (NodoNumero) ladoDerecho.getValor(p);
            if (nodoNumero == null) {
                nodoNumero = new NodoNumero();
                ladoDerecho.setValor(p, nodoNumero);
            }
            if (ladoDerecho.getTipo().equals(Tipo.Variable.INTEGER)) {
                nodoNumero.setValor((double) (int) getValorNumerico(nodoAsignacion.getValor()));
                return;
            } else {
                nodoNumero.setValor(getValorNumerico(nodoAsignacion.getValor()));
                return;
            }
        } else if (nodoAsignacion.getValor() instanceof NodoCadena) {
            ladoDerecho.setValor(p, nodoAsignacion.getValor());
            return;
        }
        throw new RuntimeException("Asignacion de tipo de datos incorrecto,,,");
    }

    private void nodoIf(NodoIf nodoIf) {
        boolean b = getValorBool(nodoIf.getCondicion());
        if (b) {
            interpretarNodo(nodoIf.getParteThen());
        } else {
            interpretarNodo(nodoIf.getParteElse());
        }
    }

    private void nodoWhile(NodoWhile nodoWhile) {
        boolean b = getValorBool(nodoWhile.getCondicion());
        while (b) {
            interpretarNodo(nodoWhile.getCuerpo());
            b = getValorBool(nodoWhile.getCondicion());
        }
    }

    private void nodoDo(NodoDo nododo) {
        boolean b = false;
        do {
            interpretarNodo(nododo.getCuerpo());
            b = getValorBool(nododo.getCondicion());
        } while (!b);
    }

    private boolean getValorBool(NodoBase base) {
        if (base instanceof NodoOperacionBoolLogica) {
            return getValorBool((NodoOperacionBoolLogica) base);
        } else if (base instanceof NodoOperacionBool) {
            return getValorBool((NodoOperacionBool) base);
        } else if (base instanceof NodoOperacionBoolUnaria) {
            return !getValorBool(((NodoOperacionBoolUnaria) base).getValor());
        }
        throw new RuntimeException("Tratando de optener valor bool de un nodo que no lo contiene");
    }

    private boolean getValorBool(NodoOperacionBoolLogica bool) {
        boolean derecho = getValorBool(bool.getOpDerecho());
        boolean izquierdo = getValorBool(bool.getOpIzquierdo());
        switch (bool.getTipo()) {
            case AND: {
                return derecho && izquierdo;
            }
            case OR: {
                return derecho || izquierdo;
            }
            default:
                return false;
        }
    }

    private boolean getValorBool(NodoOperacionBool bool) {
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
        } else if (base instanceof NodoOperacionMatUnaria) {
            NodoOperacionMatUnaria unaria = (NodoOperacionMatUnaria) base;
            double num = getValorNumerico(unaria.getValor());
            return num * -1;
        } else if (base instanceof NodoIdentificador) {
            NodoIdentificador id = (NodoIdentificador) base;
            IdValor iv = variables.get(id.getNombre());
            if (!iv.getTipo().equals(Tipo.Variable.STRING)) {
                return getValorNumerico(iv.getValor());
            }
        } else if (base instanceof NodoIdentificadorVector) {
            NodoIdentificadorVector id = (NodoIdentificadorVector) base;
            IdValorVector iv = variablesVector.get(id.getNombre());
            if (!iv.getTipo().equals(Tipo.Variable.STRING)) {
                return getValorNumerico(iv.getValor((int) getValorNumerico(id.getEx())));
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
            case MOD: {
                return derecho % izquierdo;
            }
            case POTE: {
                return Math.pow(derecho, izquierdo);
            }
            default:
                return 0.0;
        }
    }
}
