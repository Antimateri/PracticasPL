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
    // modo de referencia
    private RefMode refMode;

    public TComp(IdenType iden, RefMode refMode) {
        this.refMode = refMode;
        this.iden = iden;
    }

    public KindT kind() {return KindT.COMP;}

    public RefMode refMode() {return refMode;}

    public String toString() {
        return "("+this.refMode+")"+iden.toString();
    }

    public int getSize(){ 
        if(refMode == RefMode.REF)
            return 1;
        else 
            return iden.getSize(); //devuelve el tamaño asociado al identificador de tipo
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
