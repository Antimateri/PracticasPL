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
        name.setSize(data.getSize());
    }

    public String toString() {
		StringBuilder strb = new StringBuilder();
        strb.append("struct(");
        strb.append("name="+name.toString()+", ");
        //se usa el sub aqui para escribir menos codigo
        strb.append(data.toStringSub());
		return strb.toString();
	}

    public KindDec kind() { return KindDec.STRUCT;}

    public int getSize(){ return name.getSize(); }

    public int setDelta(int last){
        data.setDelta(0);
        return last;
    }
}
