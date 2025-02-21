package ast.Designadores;
import ast.Declaraciones.*;
import ast.Enumeradores.*;
import ast.Instrucciones.*;
import ast.Tipos.*;
//Nodo básico para representar designadores
public abstract class Desig extends Statement{
	public abstract Dec getDeclaration();
    public abstract KindDesig kind(); //Devuelve el tipo de declaración
    public NodeKind nodeKind() {return NodeKind.DESIGNATION;}
    public String toString() {return "";}

    public T type() {return getDeclaration().type();}

}
