package ast.Expresiones;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Tipos.*;

import java.util.LinkedList;
import java.util.Map;

// Funcion Read de input
public class Read extends E{

    public Read() {}

    public String toString(){
        return "read()";
    }

    @Override
    public KindE kind() {
        return KindE.READ;
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return true;
	}

    @Override
    public T type(){
        return new TSimple(KindT.INT, RefMode.VALUE);
    }

    @Override
    public String generateCode(){
        return "call $read\n";
    }

    public String codeCopyStack(int d){
        StringBuilder str = new StringBuilder();
        str.append("get_local $localsStart\n");
        str.append(this.generateCode());
        str.append("i32.store offset=" + d + "\n");
        return str.toString();
      }
  
      public String codeCopyAssign(String codeDirDest){
        StringBuilder str = new StringBuilder();
        str.append(codeDirDest);
        str.append(this.generateCode());
        str.append("i32.store\n");
        return str.toString();
      }
    
    
}
