package ast;

/**
 *
 * @author Personal
 */
public interface Tipo {

    public static enum Variable {

        INTEGER, FLOAT, STRING
    }

    public enum OpBool {

        IGUAL, MENOR, MENORIGUAL, MAYOR, MAYORIGUAL, DIFERENTE
    }

    public enum OpBoolLogica {

        AND, OR, NO
    }

    public enum OpMat {

        SUMA, REST, MULT, DIVI, POTE, MOD
    }
}
