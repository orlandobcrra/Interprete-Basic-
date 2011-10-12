package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionMat extends NodoBase {

    private NodoBase opDerecho;
    private NodoBase opIzquierdo;
    private Tipo.OpMat tipo;

    public NodoOperacionMat(NodoBase opDerecho, NodoBase opIzquierdo, Tipo.OpMat tipo) {
        this.opDerecho = opDerecho;
        this.opIzquierdo = opIzquierdo;
        this.tipo = tipo;
    }

    public NodoBase getOpDerecho() {
        return opDerecho;
    }

    public NodoBase getOpIzquierdo() {
        return opIzquierdo;
    }

    public Tipo.OpMat getTipo() {
        return tipo;
    }

//    public Double getValor() {
//        switch (tipo) {
//            case SUMA: {
//                return opDerecho.getValor() + opIzquierdo.getValor();
//            }
//            case REST: {
//                return opDerecho.getValor() - opIzquierdo.getValor();
//            }
//            case MULT: {
//                return opDerecho.getValor() * opIzquierdo.getValor();
//            }
//            case DIVI: {
//                return opDerecho.getValor() / opIzquierdo.getValor();
//            }
//            case POTE: {
//                return Math.pow(opDerecho.getValor(), opIzquierdo.getValor());
//            }
//            default:
//                return 0.0;
//        }
//    }
}
