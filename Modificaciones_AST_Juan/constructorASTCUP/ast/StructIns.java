package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// inicializador de estructuras
public class StructIns extends E {

    //lista de argumentos, 
    //pueden ser un solo valor, en tal caso se asignan en orden de definicion
    //o una asignacion de nombre a valor en tal caso se buscara el nombre de la variable a asignar
    private ArrayList<E> args;

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
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		for(E a : args) {
			a.bind(envs);
		}
	}

    public T type(){
        TStruct t = new TStruct();
        for(E a : args) {
            if(a.type()!=null)
                t.append(new DecVar(a.type(), null));
            else
                throw new RuntimeException("Error en tipado");
        }
        return t;
    }

    public int getSize(){
        int size = 0;
        for(E e : args){
            size = size + e.getSize();
        }
        return size;
    }

    //Funcion que almacena en memoria los parámetros con los que llamamos a una función, en forma de struct anónimo
    //Los almacenará en orden y a partir de SP+8, que es la primera dirección disponible para el marco que se va a crear con la llamada
    public String paramsToStack(){
        StringBuilder str = new StringBuilder();
        int d = 8; //desplazamiento desde SP

        for(E a : args){
            //copiar en memoria el valor resultante de la expresión:
            str.append(a.codeCopyParam(d));
            d = d + a.getSize();   
        }

        return str.toString();
    }
    
}
