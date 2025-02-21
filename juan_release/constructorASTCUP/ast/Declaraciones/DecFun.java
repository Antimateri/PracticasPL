package ast.Declaraciones;

import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import errors.Log;

//define una funcion
public class DecFun extends Dec{
    public KindDec kind() {return KindDec.FUN;}

    //parametros de la funcion en forma de un tipo struct anonimo
    //al hacer el ast ha parecido conveniente hacerlo asi pero contemplamos hacer algo propio si complica mucho el resto del proceso
    private TStruct params;
    //tipo de retorno de la funcion
    private T type;
    //cuerpo de la funcion
    private Statement body;
    
    public DecFun(T type, IdenFun name, TStruct params, Statement body) {
        if(typed == null){
            typed = new HashSet<String>();
        }
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
        if(type!=null) type.setDelta(0);
        if(this.params!=null)aux = params.setDelta(0);
        body.setDelta(aux);
        return last;
    }
    
    @Override
	public boolean bind(LinkedList<Map<String, Dec>> envs) {
        boolean out = true;
    	if(envs.getFirst().containsKey(name.name)){
			Log.error(Log.ErrorType.REDEFINEDVARIABLE, this);
            out=false;
        }
    	envs.getFirst().put(name.name, this);
        out &= name.bind(envs);
        if(this.params!=null) out &= this.params.bind(envs);
        if(this.type != null) out &= this.type.bind(envs);
        if(this.params!=null) envs.push(params.getEnv());
        out &= this.body.bind(envs);
        if(this.params!=null) envs.pop();
        return out;
	}

    public T type(){
        if(typed.contains(name.name)) return type;
        typed.add(name.name);
        T b= body.type();
        if((b==null && type!=null) || (type==null && b!=null) || (b!=null && type!=null && !type.type().compatible(b))){
            Log.error(Log.ErrorType.FUNCTIONRETURNMISSMATCH, this);
            return new TError();
        }
        if(type!=null) return type.type();
        else return null; 
    }

    public String generateDecFun(){
        StringBuilder str = new StringBuilder();
        //cabecera:
        str.append("(func $"+name.toString()); //en princpio las funciones de webassembly no devolverán nada
        if(type()!=null) str.append(" (type $_sig_i32ri32)\n");
        else str.append(" (type $_sig_i32)\n");
        //secuencia de entrada:
        str.append("(param $returnDir i32) \n"); //es el primer el valor que hemos de encontrar en la pila
        if(type()!=null) str.append("(result i32) \n");
        //el parámetro returnDir guardará la dirección en memoria en la que guardar el resultado de la funcion (el espacio ya se ha reservado)
        str.append("(local $localsStart i32) \n");
        str.append("(local $temp i32) \n");

        //str.append("set_local $returnDir \n");//recibimos de pila el valor de $returnDir

        int memParams = 0;
        if(params!=null) memParams = params.getSize(); //tamaño de los parametros que vamos a recibir por pila (todos serán así)
        int memLocals = body.maxMem(); //tamaño de las variables locales + llamadas a función que se hagan en el cuerpo
        int mem = memParams + memLocals + 8; //+8 para guardar MP y SP
        //Creamos el nuevo marco de ejecución:
        str.append("i32.const " + mem + " \n");
        str.append("call $reserveStack \n"); //reservamos la memoria necesaria para el nuevo marco
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
        str.append("set_local $localsStart \n\n ;;Aqui empieza el cuerpo de la funcion\n\n"); //$localsStart es la dirección desde la que se empeizan a guardar todas las variables/estructuras locales
        
        //instrucciones del cuerpo:
        str.append(body.generateCode());
   
        str.append("call $freeStack \n");
        str.append("return \n)\n\n");
        return str.toString();
    }

    public void setDepth(int depth){
        body.setDepth(depth+1);
        if(params!=null) params.setDepth(depth+1);
    }
    
}

