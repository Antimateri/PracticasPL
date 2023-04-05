package ast;

//define una funcion
public class FunDef extends D{

    @Override
    public KindD kind() {return KindD.FUN;}

    //nombre de la funcion
    private Iden name;
    //parametros de la funcion en forma de un tipo struct anonimo
    //al hacer el ast ha parecido conveniente hacerlo asi pero contemplamos hacer algo propio si complica mucho el resto del proceso
    private TStruct params;
    //tipo de retorno de la funcion
    private T type;
    //cuerpo de la funcion
    private Bloque body;
    
    public FunDef(T type, Iden name, TStruct params, Bloque body) {
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
