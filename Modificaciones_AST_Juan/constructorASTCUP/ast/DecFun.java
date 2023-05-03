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

    public TStruct getParams(){
        return params;
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
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
    	if(envs.getFirst().containsKey(name.name)) 
			throw new RedefinedVariableException(name.name);
    	envs.getFirst().put(name.name, this);
        if(this.params!=null)this.params.bind(envs);
        this.type.bind(envs);
        envs.push(params.getEnv());
        this.body.bind(envs);
        envs.pop();
	}

    public T type(){
        T b= body.type();
        if((b==null && type!=null) || (type==null && b!=null) || (b!=null && type!=null && !type.type().compatible(b)))
            throw new RuntimeException("Return type does not match function type");
        if(type!=null)return type.type();
        else return null; 
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        //cabecera:
        str.append("(fun $"+name.toString()+"\n"); //en princpio las funciones de webassembly no devolverán nada
        //secuencia de entrada:
        str.append("(param $returnDir i32) \n"); //es el primer el valor que hemos de encontrar en la pila
        //el parámetro returnDir guardará la dirección en memoria en la que guardar el resultado de la funcion (el espacio ya se ha reservado)
        str.append("(local $localsStart i32) \n");
        str.append("(local $temp i32) \n");
        str.append("set_local $returnDir \n");
        int memParams = params.getSize(); //tamaño de los parametros que vamos a recibir por pila (todos serán así)
        int memLocals = body.maxMem(); //tamaño de las variables locales + llamadas a función que se hagan en el cuerpo
        int mem = memParams + memLocals + 8; //+8 para guardar MP y SP
        str.append("i32.const " + mem + " \n");
        str.append("call $reserveStack \n");
        str.append("set_local $temp \n");
        str.append("get_global $MP \n");
        str.append("get_local $temp \n"); 
        str.append("i32.store \n");
        str.append("get_global $MP \n");
        str.append("get_global $SP \n");
        str.append("i32.store offset=4 \n");
        str.append("get_global $MP \n");
        str.append("i32.const 8 \n");
        str.append("i32.add \n");
        str.append("set_local $localsStart \n");
        
        //instrucciones del cuerpo:
        str.append(body.generateCode());
   
        str.append("call $freeStack \n )");
        str.append("return \n )");
        return str.toString();
    }

    public void setDepth(int depth){
        body.setDepth(depth+1);
    }
    
}
