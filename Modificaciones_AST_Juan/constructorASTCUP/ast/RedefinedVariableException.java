package ast;

public class RedefinedVariableException extends Exception {

	private static final long serialVersionUID = 7966508773037751618L;

	public RedefinedVariableException(String name) {
		super(name + " ya ha sido declarada en este entorno");
	}

}
