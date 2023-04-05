package ast;

public class FunDef extends D{

    @Override
    public KindD kind() {return KindD.FUN;}

    private Iden name;
    private StructDef params;
    private T type;
    private Bloque body;
    
    public FunDef(T type, Iden name, StructDef params, Bloque body) {
        this.name = name;
        this.params = params;
        this.type = type;
        this.body = body;
    }

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("funDef(");
        strb.append(type.toString());
        strb.append(",");
        strb.append(name.toString()+",");
        strb.append(params.toString()+",");
        strb.append(body.toString()+")");
		return strb.toString();
	}
    
}
