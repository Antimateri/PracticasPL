package ast;

public class TypeDef extends D{

    private Iden name;
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
