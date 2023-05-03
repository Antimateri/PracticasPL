package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import errors.Log;

// inicializador de estructuras
public class StructIns extends E {

    //lista de argumentos, 
    //pueden ser un solo valor, en tal caso se asignan en orden de definicion
    //o una asignacion de nombre a valor en tal caso se buscara el nombre de la variable a asignar
    private ArrayList<E> args;

    private int delta = 0;

    public StructIns() {
        this.args = new ArrayList<E>();
    }

    // Añade una valor con nombre con el que se asignara: (a=2, b=3)
    public void addNamedArg(E val) {
        args.add(val);
    }

    // Añade un valor sin nombre que se asignara segun posicion: (2, 3)
    public void addUnnamedArg(E val) {
        args.add(val);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (E arg : args) {
            res.append(arg.toString());
            res.append(", ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.append("}");
        return res.toString();
    }

    @Override
    public KindE kind() {
        return KindE.STRUCTINS;
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean res = true;
		for(E a : args) {
			res &= a.bind(envs);
		}
        return res;
	}

    public T type(){
        TStruct t = new TStruct();
        T out = null;
        for(E a : args) {
            if(a.type()!=null)
                t.append(new DecVar(a.type(), null));
            else{
                Log.error(Log.ErrorType.TIPEERROR, this);
                out = new TError();
            }
        }
        if(out != null)
            return out;
        else
            return t;
    }

    public int getSize(){
        int size = 0;
        for(E e : args){
            size = size + e.getSize();
        }
        return size;
    }

    public int setDelta(int last){
        this.delta = last;
        int res = last;
        for(E arg : args){
            if(arg != null){ //por si es un procedimiento sin parámetros
                arg.setDelta(res);
                res = res + arg.getSize();
            }
        }
        return last + this.getSize(); // == res
    }

    public int getDelta(){ return delta; }

    public int maxMem(){ return getSize(); }


    //Funcion que almacena en memoria (una copia de) los parámetros con los que llamamos a una función, en forma de struct anónimo
    //Los almacenará en orden y a partir de SP+8, que es la primera dirección disponible para el marco que se va a crear con la llamada
    public String paramsToStack(){
        StringBuilder str = new StringBuilder();

        //direccion de origen: MP+8+delta
        str.append("i32.const"+ getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //direccion destino: SP + 8 (inicio del nuevo marco que vamos a crear con la llamada a la funcion)
        str.append("get_global $SP\n");
        str.append("i32.const " + 8 + "\n");
        str.append("i32.add\n");

        //tamaño de los datos:
        str.append("i32.const " + getSize() + "\n");
        
        //llamamos a la funcion $copyn;
        str.append("call $copyn\n");

        return str.toString();
    }

    //Inicializacion del struct anónimo: copia en su espacio de memoria todos los campos del struct anónimo definido
    public String generateCode(){
        StringBuilder str = new StringBuilder();
        int d = delta + 8; //desplazamiento desde MP
        for(E a : args){
            //copiar en memoria el valor resultante de la expresión:
            str.append(a.codeCopyStack(d));
            d = d + a.getSize(); 
        }
        return str.toString();
    }

    public String codeCopyStack(int d){
        StringBuilder str = new StringBuilder();
        for(E a : args){
            //copiar en memoria el valor resultante de la expresión:
            str.append(a.codeCopyStack(d));
            d = d + a.getSize(); 
        }
        return str.toString();
    }

    public String codeCopyAssign(String codeDirDest){
		StringBuilder str = new StringBuilder();

        //direccion de origen: MP+8+delta
        str.append("i32.const"+ getDelta()+"\n");
        str.append("get_global $MP\n");
        str.append("i32.const 8 \n");
        str.append("i32.add\n");
        str.append("i32.add\n");

        //direccion de destino:
		str.append(codeDirDest);

		//tamaño de los datos:
        str.append("i32.const " + getSize() + "\n");
        
        //llamamos a la funcion $copyn;
        str.append("call $copyn\n");

		return str.toString();
    }


    
}
