package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// inicializador de estructuras
public class StructIns extends E {

    //lista de argumentos, 
    //pueden ser un solo valor, en tal caso se asignan en orden de definicion
    //o una asignacion de nombre a valor en tal caso se buscara el nombre de la variable a asignar
    private ArrayList<Statement> args;

    public StructIns() {
        this.args = new ArrayList<Statement>();
    }

    // Añade una valor con nombre con el que se asignara: (a=2, b=3)
    public void addNamedArg(Statement val) {
        args.add(val);
    }

    // Añade un valor sin nombre que se asignara segun posicion: (2, 3)
    public void addUnnamedArg(Statement val) {
        args.add(val);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (Statement arg : args) {
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
		for(Statement a : args) {
			a.bind(envs);
		}
	}

    public T type(){
        TStruct t = new TStruct();
        for(Statement a : args) {
            if(a.type()!=null)
                t.append(new DecVar(a.type(), null));
            else
                throw new RuntimeException("Error en tipado");
        }
        return t;
    }

    public String paramsToStack(){
        StringBuilder str = new StringBuilder();

        for(Statement a : args){
            //copiar en la memoria del nuevo marco todos los parámetros que vayamos a pasar (en orden)
            str.append("get_global $SP\n");
            str.append("i32.const 8 \n");
            str.append("i32.add\n");
            //hemos dejado SP+8 en la cima de la pila
            if(a.nodeKind() == NodeKind.DESIGNATION){
                str.append(a.generateCode());
                str.append("memory.copy\n"); //esta instruccion hay que ver bien como es 
            }
            else if(a.nodeKind() == NodeKind.EXPRESSION){
                //copiar en memoria el valor resultante de la expresion
            }
            
        }

        return str.toString();
    }
    
}
