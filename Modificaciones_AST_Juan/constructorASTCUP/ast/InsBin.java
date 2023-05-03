package ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// instrucciones binarias
public class InsBin extends I {
    private ArrayList<Statement> opnd;
    private KindI kind;

    public InsBin(KindI kind, ArrayList<Statement> opnd) {
        this.opnd = opnd;
        this.kind = kind;
    }

    public KindI kind() {return kind;}
    public Statement opnd(int i) {return opnd.get(i);}

    public String toString() {
        switch(kind){
          case IF:
            return "if("+opnd(0).toString()+","+opnd(1).toString()+")";
          case WHILE:
            return "while("+opnd(0).toString()+","+opnd(1).toString()+")";
          case ASIG:
            return "asig("+opnd(0).toString()+","+opnd(1).toString()+")";
          case IFELSE:
            return "ifElse("+opnd(0).toString()+","+opnd(1).toString()+","+opnd(2).toString()+")";
          default:
           return super.toString();
        }
    }

  public T type() {
    switch (kind) {
      case IF:
      case WHILE:
      case IFELSE:
        if(opnd(0).type().kind() != KindT.BOOL)
          throw new RuntimeException("Error de tipos en la condición de un if o while");
        break;
      case ASIG:
        if(opnd(0).type().kind() != opnd(1).type().kind())
          throw new RuntimeException("Error de tipos en la asignación");
        break;
      default:
        return super.type();
    }
    return null;
  }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		//asumo que recibe bloques como argumento
		for(Statement aux: opnd) {
			if(aux!=null)aux.bind(envs);
		}
		
	}

  public int maxMem(){
    int mem = 0;
    for(Statement s : opnd){
        mem = mem + s.maxMem();
    }
    return mem;
  }

  public int setDelta(int last){
    int res = last;
    for (Statement s : opnd) {
        res = s.setDelta(res);
    }
    return res;
  } 
	
  public String generateCode(){
    StringBuilder str = new StringBuilder();
    switch(kind){
      case IF:
        str.append(opnd(0).generateCode() + "\n");
        str.append("if\n");
        str.append(opnd(1).generateCode() + "\n");
        str.append("end\n");
        break;
      case WHILE:
        str.append("block\n");
        str.append("loop\n");
        str.append(opnd(0).generateCode() + "\n");
        str.append("i32.eqz\n");
        str.append("br_if 1\n");
        str.append(opnd(1).generateCode() + "\n");
        str.append("br 0\n");
        str.append("end\n");
      case ASIG: //cambiar para que soporte asignaciones de arrays, structs y definidos por el usuario
        //opnd(0) siempre será un designador
        //opnd(1) siempre será una expresión
        String codeDirDest = ((Desig)opnd(0)).generateCode(); //direccion de destino donde guardar la asignacion
        str.append(((E)opnd(1)).codeCopyAssign(codeDirDest));
      case IFELSE:
        str.append(opnd(0).generateCode() + "\n");
        str.append("if\n");
        str.append(opnd(1).generateCode() + "\n");
        str.append("else\n");
        str.append(opnd(2).generateCode() + "\n");
        str.append("end\n");
        break;
      default:
       return "";
    }
    return str.toString();
  }

  public void setDepth(int depth){
    for (Statement s : opnd) {
      s.setDepth(depth + 1);
    }
  }

}
