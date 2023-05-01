package ast;

import java.util.LinkedList;
import java.util.Map;

// Designador al valor apuntado por un puntero 
public class GetPointerVal extends Desig{
    private Desig des; //Designador al puntero

    public GetPointerVal(Desig des) {
        this.des = des;
    }

    public String toString(){
        return "getPointerVal(" + des.toString() +")";
    }

    //Hay que corregir esto:
    public KindDesig kind() {
        return KindDesig.PTRVAL;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		des.bind(envs);
	}

    public T type() {
        if(des.type().kind() == KindT.POINTER) {
            return ((TPointer)(des.type())).prevType();
        }
        throw new RuntimeException("Error: getPointerVal applied to non-pointer type");
    }

    public Dec getDeclaration() {
		return des.getDeclaration();
	} 
    
    public String generateCode(){
        StringBuilder str = new StringBuilder();
        str.append(des.generateCode()+"\n");
        str.append("i32.load\n");
        return str.toString();
    }
}
