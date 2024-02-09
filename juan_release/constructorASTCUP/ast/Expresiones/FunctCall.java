package ast.Expresiones;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

import errors.Log;

//llamada a una funcion
public class FunctCall extends E{
    //funcion llamada:
    private Iden nombre;
    //argumentos de la funcion en forma de struct:
    private StructIns args;

    private int delta = 0; //vamos a tratar las llamadas a funcion como si fueran declaraciones de variables (siempre que devuelvan algo)
    
    public FunctCall(Iden nombre, E args) {
        this.nombre = nombre;
        this.args = (StructIns)args;
    }

    public String toString() {
        if(args==null) 
            return nombre.toString() + "()";
        else
            return nombre.toString() + "(//delta="+ delta +"// "+ args.toString() + ")";
    }

    @Override
    public KindE kind() {
        return KindE.FUNCT;
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean out = true;
		out &= nombre.bind(envs);
		if(args!=null)out &= args.bind(envs);
        return out;
	}

    public T type(){
        if(((DecFun)(nombre.nodeDec)).getParams()!=null){
            TStruct trueArgs = ((DecFun)(nombre.nodeDec)).getParams();
            if(args!=null){
                if(args.type()==null){
                    Log.error(Log.ErrorType.TIPEERROR, this);
                    return new TError();
                }
                if(!args.type().compatible(trueArgs)){
                    Log.error(Log.ErrorType.TIPEERROR, this);
                    return new TError();
                }
            }
            else{
                Log.error(Log.ErrorType.TIPEERROR, this);
                return new TError();
            }
        }
        else if(args != null){
            Log.error(Log.ErrorType.TIPEERROR, this);
            return new TError();
        }
        return nombre.type();
    }

    public int maxMem(){ //Lo que ocupa el valor que devuelve, para guardarlo en memoria despues
        int out = 0;
        if(nombre.type()!=null)
            out += nombre.type().getSize();
        if(args!=null)
            out += args.maxMem();
        return out;
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        //metemos en la memoria los argumentos con los que llamamos a la función:
        if(args!=null)
            str.append(args.paramsToStack());

        //metemos en la cima de la pila el valor $returnDir, que es la dirección en memoria donde guardar el resultado:
        str.append("i32.const " + getDelta()+"\n");
        str.append("get_local $localsStart\n");
        str.append("i32.add\n");

        //llamamos a la funcion declarada en webassembly:
        str.append("call $" + nombre.toString() + "\n");
        if(type()!=null && (type().kind()==KindT.BOOL || type().kind()==KindT.INT)) //Si devuelve bool o int, lo deja en la cima de la pila
            str.append("i32.load\n");
        return str.toString();
    }

    public int getSize(){ return nombre.getSize(); }

    public int setDelta(int last){
        int res = last;
        if(args!=null) args.setDelta(last);
        this.delta = res;

        if(nombre.type() == null) //si no devuelve nada (es un procedimiento)
            return res;
        
        else
            return res + getSize();
        
    }

    public int getDelta(){ return delta; }


    //Método que ejecuta la función (devolviendo en memoria el resultado)
	//Sirve para inicializar structs anónimos 
	public String codeCopyStack(int d){
        return generateCode() + "drop\n";
	}

    public String codeCopyAssign(String codeDirDest){ //recibe en string el codigo necesario para obtener la direccion de destino
		StringBuilder str = new StringBuilder();

        if(type()!=null && (type().kind()==KindT.BOOL || type().kind()==KindT.INT)){
            str.append(codeDirDest);
            str.append(this.generateCode());
            str.append("i32.store\n");
        }
        else{
            //direccion de origen:
            str.append(generateCode());
            
            //direccion destino:
            str.append(codeDirDest);

            //tamaño de los datos:
            str.append("i32.const " + nombre.getSize() + "\n");
            
            //llamamos a la funcion $copyn;
            str.append("call $copyn\n");
        }

		return str.toString();

	}
    
}
