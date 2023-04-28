package ast;

import java.util.LinkedList;
import java.util.Map;

//llamada a una funcion
public class FunctCall extends E{

    //funcion llamada
    private Iden nombre;
    //argumentos de la funcion en forma de struct
    //Parecia conveniente al hacer el ast pero se puede cambiar si complica el resto del proceso
    private StructIns args;
    
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
        //metemos en la pila los argumentos con los que llamamos a la función: (?)
        str.append(args.paramsToStack());

        //metemos en la cima de la pila el valor $returnDir, que es la dirección en memoria donde guardar el resultado:
        str.append("i32.const"+nombre.getDelta()+"\n");
        str.append("get_global $SP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //llamamos a la funcion declarada en webassembly:
        str.append("call $" + nombre.toString() + "\n");
        return str.toString();
    }

    public int getSize(){ return nombre.getSize(); }
    
}
