package ast.Expresiones;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

public class New extends E{
    private T tipo; 

    public New(T tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "new(type: "+ tipo +", size: "+getSize()+")";
    }

    public int getSize(){ return tipo.getSize(); }

    public KindE kind() {
        return KindE.NEW;
    }

	public boolean bind(LinkedList<Map<String, Dec>> envs){
        boolean out = true;
		out &= tipo.bind(envs);
        return out;
	}

    public T type(){
        return new TPointer(tipo);
    }

    public String generateCode(){ //reserva memoria y devuelve la posición en la que se encuentra ($NP)
        StringBuilder str = new StringBuilder();
        int size = getSize();

        str.append("i32.const "+ size + "\n");
        str.append("call $reserveHeap\n");
        str.append("get_global $NP\n");

        return str.toString();
    }
    
    public String codeCopyAssign(String codeDirDest){ //recibe en string el codigo necesario para obtener la direccion de destino
        StringBuilder str = new StringBuilder();
        str.append(codeDirDest);
        str.append(this.generateCode());
        str.append("i32.store\n");
        return str.toString();
	}
}
