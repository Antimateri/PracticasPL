package ast;

// Nodo para la declaración de variables:
public class DecVar extends Dec{
    private T tipo; //Tipo de la variable declarada
    private IdenVar identificador; //Identificador de la variable declarada

  //El primer operador es el tipo y el segundo el identificador:
    public DecVar(T tipo, IdenVar id) {
        this.tipo = tipo;
        this.identificador = id;
    }

    public KindDec kind() {return KindDec.VAR;}

    public String toString() {
        return "var("+tipo.toString()+","+identificador.toString()+")";
    }
}
