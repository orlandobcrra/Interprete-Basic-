/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Personal
 */
public class NodoOperacionBool extends NodoBase {

    private NodoNumero opDerecho;
    private NodoNumero opIzquierdo;
    private Tipo.OpBool tipo;

    public NodoOperacionBool(NodoNumero opDerecho, NodoNumero opIzquierdo, Tipo.OpBool tipo) {
        this.opDerecho = opDerecho;
        this.opIzquierdo = opIzquierdo;
        this.tipo = tipo;
    }

    public NodoNumero getOpDerecho() {
        return opDerecho;
    }

    public NodoNumero getOpIzquierdo() {
        return opIzquierdo;
    }

    public Tipo.OpBool getTipo() {
        return tipo;
    }
}
