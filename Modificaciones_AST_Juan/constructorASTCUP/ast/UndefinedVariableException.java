package ast;

public class UndefinedVariableException extends Exception {

	private static final long serialVersionUID = 5026200528505061057L;

	public UndefinedVariableException(String var) {
		super(var + " no ha sido declarada en este entorno");
	}

}
