package ast;

/**
 *
 * @author Personal
 */
public class Tipo {

    public static enum Variable {

        INTEGER, FLOAT, STRING
    }
    
    public enum OpBool {

        IGUAL, MENOR, MENORIGUAL, MAYOR, MAYORIGUAL, DIFERENTE
    }
    
    public enum OpMat {

        SUMA, REST, MULT, DIVI, POTE
    }
}
