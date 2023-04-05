package ast;

// Nodo de definición de tipo a traves de typedef
public class TypeDef extends D{

    // Nombre del nuevo tipo
    private Iden name;
    // Tipo al que se le asigna el nombre
    private T type;

    public TypeDef(Iden name, T type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return "typeDef(" + name.toString() + " = " + type.toString()+")";
    }

    @Override
    public KindD kind() {
        return KindD.TYPE;
    }
    
}
