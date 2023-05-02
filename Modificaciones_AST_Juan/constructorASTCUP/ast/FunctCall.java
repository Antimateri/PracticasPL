package ast;

import java.util.LinkedList;
import java.util.Map;

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
            return nombre.toString() + "(" + args.toString() + ")";
    }

    @Override
    public KindE kind() {
        return KindE.FUNCT;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		nombre.bind(envs);
		if(args!=null)args.bind(envs);
	}

    public T type(){
        if(((DecFun)(nombre.nodeDec)).getParams()!=null){
            TStruct trueArgs = ((DecFun)(nombre.nodeDec)).getParams();
            if(args.type()==null)
                throw new IllegalArgumentException("Incompatible types");
            if(!args.type().compatible(trueArgs))
            throw new IllegalArgumentException("Incompatible types");
        }
        else if(args != null){
            throw new IllegalArgumentException("Incompatible types");
        }
        return nombre.type();
    }

    public int maxMem(){ //Lo que ocupa el valor que devuelve, para guardarlo en memoria despues
        return nombre.type().getSize();
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        //metemos en la memoria los argumentos con los que llamamos a la función:
        str.append(args.paramsToStack());

        //metemos en la cima de la pila el valor $returnDir, que es la dirección en memoria donde guardar el resultado:
        str.append("i32.const" + nombre.getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //llamamos a la funcion declarada en webassembly:
        str.append("call $" + nombre.toString() + "\n");
        return str.toString();
    }

    public int getSize(){ return nombre.getSize(); }

    public int setDelta(int last){
        int res = args.setDelta(last);

        if(nombre.type() == null){ //si no devuelve nada (es un procedimiento)
            return res;
        }
        else{
            this.delta = res;
            return res + getSize();
        }
    }

    public int getDelta(){ return delta; }


    //Método que ejecuta la función (devolviendo en memoria el resultado) y hace una copia en memoria del resultado, concretamente en la dirección MP+d
	//Sirve para inicializar structs anónimos 
	public String codeCopyStack(int d){
		StringBuilder str = new StringBuilder();

        //Hacemos la llamada a la funcion:
        str.append(generateCode());

        //direccion de origen: MP+8+delta
        str.append("i32.const"+ getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //direccion destino: MP + d
        str.append("get_global $MP\n");
        str.append("i32.const " + d + "\n");
        str.append("i32.add\n");

        //tamaño de los datos:
        str.append("i32.const " + nombre.getSize() + "\n");
        
        //llamamos a la funcion $copyn;
        str.append("call $copyn\n");

		return str.toString();
	}

    public String codeCopyAsign(String codeDirDest){ //recibe en string el codigo necesario para obtener la direccion de destino
		StringBuilder str = new StringBuilder();
        //direccion de origen: MP+8+delta
        str.append("i32.const"+ getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //direccion destino:
        str.append(codeDirDest);

        //tamaño de los datos:
        str.append("i32.const " + nombre.getSize() + "\n");
        
        //llamamos a la funcion $copyn;
        str.append("call $copyn\n");

		return str.toString();

	}
    
}
