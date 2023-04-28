package ast;

//Nodo básico para representar designadores
public abstract class Desig extends Statement{
	public abstract Dec getDeclaration();
    public abstract KindDesig kind(); //Devuelve el tipo de declaración
    public NodeKind nodeKind() {return NodeKind.DESIGNATION;}
    public String toString() {return "";}

    public T type() {return getDeclaration().type();}
    
    public String copyParam(int d){ return ""; } //copia a partir de la direccion d de memoria los datos del designador
}
