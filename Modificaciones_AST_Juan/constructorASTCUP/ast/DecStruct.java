package ast;

//Declaración de tipo struct
public class DecStruct extends Dec{
    //Identificador del nuevo tipo struct:
    private IdenType name;
    //definicion de la estructura como struct anonimo:
    private TStruct data;
    
    public DecStruct(IdenType name, TStruct data) {
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
    public KindDec kind() { return KindDec.STRUCT;}
}
