package ast;

import java.util.LinkedList;
import java.util.Map;

//operaciones binarias
public class EBin extends E {
   //un lado de la operación binaria
   private Statement opnd1;
   //otro lado de la operación binaria
   private Statement opnd2;
   //tipo de operación
   private KindE kind;

   public EBin(KindE kind, Statement opnd1, Statement opnd2) {
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
     this.kind = kind;
   }

   public KindE kind() {return kind;}
   public Statement opnd1() {return opnd1;}
   public Statement opnd2() {return opnd2;}    
   
   public String toString() {
    switch(kind){
      case SUMA:
        return "sum("+opnd1().toString()+","+opnd2().toString()+")";
	  case RESTA:
	    return "resta("+opnd1().toString()+","+opnd2().toString()+")";
	  case MUL:
	    return "mul("+opnd1().toString()+","+opnd2().toString()+")";
	  case DIV:
	    return "div("+opnd1().toString()+","+opnd2().toString()+")";
	  case MOD:
	    return "mod("+opnd1().toString()+","+opnd2().toString()+")";
	  case POT:
	    return "pot("+opnd1().toString()+","+opnd2().toString()+")";
	  case AND:
	    return "and("+opnd1().toString()+","+opnd2().toString()+")";
	  case OR:
	    return "or("+opnd1().toString()+","+opnd2().toString()+")";
	  case MAY:
	    return ">("+opnd1().toString()+","+opnd2().toString()+")";
	  case MEN:
	    return "<("+opnd1().toString()+","+opnd2().toString()+")";
	  case EQ:
	    return "==("+opnd1().toString()+","+opnd2().toString()+")";
	  case NEQ:
	    return "!=("+opnd1().toString()+","+opnd2().toString()+")";
	  case NOT:
	    return "not("+opnd1().toString()+")";
	  case MEM:
	    return opnd1().toString();
	  default: 
	    return super.toString();
	    }
	  }

	public T type() {
		switch (kind) {
			case SUMA:
			case RESTA:
			case MUL:
			case DIV:
			case MOD:
			case POT:
			case MAY:
			case MEN:
				if(opnd1.type().kind() == KindT.INT && opnd2.type().kind() == KindT.INT)
					return opnd1.type();
				else
					throw new RuntimeException("Error de tipos en operacion binaria");
			case AND:
			case OR:
				if(opnd1.type().kind() == KindT.BOOL && opnd2.type().kind() == KindT.BOOL)
					return opnd1.type();
				else
					throw new RuntimeException("Error de tipos en operacion binaria");
			case EQ:
			case NEQ:
				if(opnd1.type().compatible(opnd2.type()))
					return new TSimple(KindT.BOOL, RefMode.VALUE);
				else
					throw new RuntimeException("tipos no compatibles en igualacion");
			case MEM:
				return opnd1.type();
			case NOT:
				if(opnd1.type().kind() == KindT.BOOL)
					return opnd1.type();
				else
					throw new RuntimeException("Error de tipos en operacion binaria");
			default:
				
		};
		return null;
	}

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException {
		opnd1.bind(envs);
		if(opnd2!=null)opnd2.bind(envs);
	}


	
	public String generateCode(){
		StringBuilder strb = new StringBuilder();
		if(kind == KindE.MEM){
			strb.append(((Desig)opnd1).generateCode() + "\n");
			strb.append("i32.load\n");
		}
		else{
			strb.append(opnd2.generateCode() + "\n");
			strb.append(opnd1.generateCode() + "\n");
			switch(kind){
				case SUMA:
					strb.append("i32.add\n");
				break;
				case RESTA:
					strb.append("i32.sub\n");
				break;
				case MUL:
					strb.append("i32.mul\n");
				break;
				case DIV:
					strb.append("i32.div_s\n");
				break;
				case MOD:
					strb.append("i32.rem_u\n");
				break;
				case POT:
					//
				break;
				case AND:
					strb.append("i32.and\n");
				break;
				case OR:
					strb.append("i32.or\n");
				break;
				case MAY:
					strb.append("i32.gt_u\n");
				break;
				case MEN:
					strb.append("i32.lt_u\n");
				break;
				case EQ:
					strb.append("i32.eq\n");
				break;
				default: 
				break;
			}
		}
		return strb.toString();
	}

	//Devuelve el tamaño del resultado (típticamente un int o bool)
	public int getSize(){ return opnd1.getSize(); }


	//Funcion que copia en memoria el valor de la expresión, concretamente en la dirección MP+d
	//Sirve para inicializar structs anónimos 
	public String codeCopyStack(int d){
		StringBuilder str = new StringBuilder();
		if(kind==KindE.MEM){ //si es un acceso a un designador
			//direccion de origen:
			str.append(((Desig)opnd1).generateCode());
	
			//direccion destino: MP+d
			str.append("get_global $MP\n");
			str.append("i32.const " + d + "\n");
			str.append("i32.add\n");
	
			//tamaño de los datos:
			str.append("i32.const " + opnd1.getSize() + "\n");
			
			//llamamos a la funcion $copyn;
			str.append("call $copyn\n");
		}
		else{ //si es una expresión aritmetico-lógica:
			str.append("get_global $MP\n");
			str.append(this.generateCode()); //genera el resultado
			str.append("i32.store offset=" + d + "\n");
		}
		return str.toString();
	}

	public String codeCopyReturn(){
		StringBuilder str = new StringBuilder();
		if(kind==KindE.MEM){ //si es un acceso a un designador
			//direccion de origen:
			str.append(((Desig)opnd1).generateCode());
	
			//direccion destino: $returnDir
			str.append("get_local $returnDir\n");

			//tamaño de los datos:
			str.append("i32.const " + opnd1.getSize() + "\n");
			
			//llamamos a la funcion $copyn;
			str.append("call $copyn\n");
		}
		else{ //si es una expresión aritmetico-lógica:
			str.append("get_local $returnDir\n"); //direccion de destino
			str.append(this.generateCode()); //genera el resultado
			str.append("i32.store \n");
		}
		return str.toString();
	}

	public String codeCopyAssign(String codeDirDest){ //recibe en string el codigo necesario para obtener la direccion de destino
		StringBuilder str = new StringBuilder();
		if(kind==KindE.MEM){ //si es un acceso a un designador
			//direccion de origen:
			str.append(((Desig)opnd1).generateCode());
	
			//direccion destino:
			str.append(codeDirDest);

			//tamaño de los datos:
			str.append("i32.const " + opnd1.getSize() + "\n");
			
			//llamamos a la funcion $copyn;
			str.append("call $copyn\n");
		}
		else{ //si es una expresión aritmetico-lógica:
			str.append(codeDirDest); //direccion de destino
			str.append(this.generateCode()); //genera el resultado
			str.append("i32.store \n");
		}
		return str.toString();
	}
}
