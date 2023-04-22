package ast;

import java.util.LinkedList;
import java.util.Map;

//define una funcion
public class DecFun extends Dec{
    public KindDec kind() {return KindDec.FUN;}

    //nombre de la funcion
    private IdenFun name;
    //parametros de la funcion en forma de un tipo struct anonimo
    //al hacer el ast ha parecido conveniente hacerlo asi pero contemplamos hacer algo propio si complica mucho el resto del proceso
    private TStruct params;
    //tipo de retorno de la funcion
    private T type;
    //cuerpo de la funcion
    private Bloque body;
    
    public DecFun(T type, IdenFun name, TStruct params, Bloque body) {
        this.name = name;
        this.params = params;
        this.type = type;
        this.body = body;
    }

    public String toString() {
		StringBuilder strb = new StringBuilder();
        if(type==null){
            strb.append("procDef(");
        }
        else{
            strb.append("funDef(");
            strb.append(type.toString());
            strb.append(",");
        }
        strb.append(name.toString()+",");
        if(params!=null)strb.append(params.toString()+",");
        else strb.append("null,");
        strb.append(body.toString()+")");
		return strb.toString();
	}

    public int setDelta(int last){
        int aux = 0;
        if(this.params!=null)aux = params.setDelta(0);
        body.setDelta(aux);
        return last;
    }
    
    @Override
	public void bind(LinkedList<Map<String, Dec>> envs) {
		envs.getFirst().put(name.name, this);
        if(this.params!=null)this.params.bind(envs);
<<<<<<< HEAD
        this.type.bind(envs);
        envs.push(params.getEnv());
=======
        this.name.bind(envs);
>>>>>>> 0f218bb3c7cf4bfd83495e767f9112802dbdea1f
        this.body.bind(envs);
        envs.pop();
	}
    
}
