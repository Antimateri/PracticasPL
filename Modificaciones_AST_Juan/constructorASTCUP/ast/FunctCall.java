package ast;

import java.util.LinkedList;
import java.util.Map;

//llamada a una funcion
public class FunctCall extends E{

    //funcion llamada
    private Iden nombre;
    //argumentos de la funcion en forma de struct
    //Parecia conveniente al hacer el ast pero se puede cambiar si complica el resto del proceso
    private E args;
    
    public FunctCall(Iden nombre, E args) {
        this.nombre = nombre;
        this.args = args;
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
    
}
