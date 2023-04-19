package ast;

//Identificadores de variables (de cualquier tipo)
public class IdenVar extends Iden{
    int delta = 0; //para la generación de código

    public IdenVar(String str){
        super(str);
    }
}
