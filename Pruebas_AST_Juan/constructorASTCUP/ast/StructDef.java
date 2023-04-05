package ast;

//definicion de tipo struct
public class StructDef extends D{
    //nombre del tipo
    private TStruct data;
    //definicion de la estructura como struct anonimo
    private Iden name;

    public StructDef(Iden name, TStruct data) {
        this.name = name;
        this.data = data;
    }

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("struct(");
        strb.append("name="+name.toString()+", ");
        //se usa el sub aqui para escribir menos codigo
        strb.append(data.toStringSub());
		return strb.toString();
	}

    @Override
    public KindD kind() { return KindD.STRUCT;}
}
