package ast.Tipos;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import java.util.LinkedList;
import java.util.Map;

// tipos definidos por el usuario por typedef o struct
public class TComp extends T{
    //identificador del tipo
    private IdenType iden;

    public TComp(IdenType iden) {
        this.iden = iden;
    }

    public KindT kind() {return KindT.COMP;}


    public String toString() {
        return iden.toString();
    }

    public int getSize(){ 
        return iden.type().getSize(); //devuelve el tamaño asociado al identificador de tipo
    }

	@Override
	public boolean bind(LinkedList<Map<String, Dec>> envs){
		return iden.bind(envs);
	}
	
	@Override
    public Map<String, Dec> getEnv(){
    	return iden.nodeDec.getEnv();
    }

    public T type(){
        return iden.nodeDec.type();
    }

    public boolean compatible(T t){
        return this.type().compatible(t.type());
    }
}
