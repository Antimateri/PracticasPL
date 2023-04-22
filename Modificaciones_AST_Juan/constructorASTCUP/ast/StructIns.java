package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    
}
