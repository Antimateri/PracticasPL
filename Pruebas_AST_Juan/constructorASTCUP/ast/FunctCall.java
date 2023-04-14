package ast;

import java.sql.Struct;

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
    
}
