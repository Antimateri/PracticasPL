package errors;
import ast.Statement;

public class Log {
    
    public enum ErrorType {
        INCONSISTENTRETURN, REDEFINEDVARIABLE, FUNCTIONRETURNMISSMATCH, TIPEERROR, UNDEFINEDVARIABLE
    }

    public static void error(ErrorType type, Statement lineInfo){
        switch(type){
            case INCONSISTENTRETURN:
                System.err.println("Error: Inconsistent return type in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
            case REDEFINEDVARIABLE:
                System.err.println("Error: Redefined variable in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
            case FUNCTIONRETURNMISSMATCH:
                System.err.println("Error: Function return type missmatch in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
            case TIPEERROR:
                System.err.println("Error: Type error in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
            case UNDEFINEDVARIABLE:
                System.err.println("Error: Undefined variable in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
            default:
                System.err.println("Error: Unknown error in line " + lineInfo.getLine() + "\n\t" + lineInfo.toString());
                break;
        }
    }

}
