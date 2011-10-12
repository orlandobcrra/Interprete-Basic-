package ast;

public class NodoDeclaracion extends NodoBase {

    private String nombre;
    private Tipo.Variable tipo;

    public NodoDeclaracion() {
    }

    public NodoDeclaracion(String nombre, Tipo.Variable  tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo.Variable  getTipo() {
        return tipo;
    }
}
