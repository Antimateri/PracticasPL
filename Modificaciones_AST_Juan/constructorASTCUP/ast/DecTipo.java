package ast;

// Nodo para la definición de un nuevo tipo por parte del usuario (alias, typedef)
public class DecTipo extends Dec{
    // Identificador del nuevo tipo:
    private IdenType name;
    // Tipo al que se le asigna el alias:
    private T type;

    public DecTipo(IdenType name, T type) {
        this.name = name;
        this.type = type;
        name.setSize(type.getSize());
    }

    public String toString() {
        return "typeDef(" + name.toString() + " = " + type.toString()+")";
    }

    public KindDec kind() { return KindDec.TYPE; }
    
}
