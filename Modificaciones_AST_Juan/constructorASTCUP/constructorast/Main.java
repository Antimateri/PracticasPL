package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Map;

import alex.AnalizadorLexicoExp;
import ast.*;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexicoExp alex = new AnalizadorLexicoExp(input);
	 ConstructorASTExp constructorast = new ConstructorASTExp(alex);
	 Statement raiz = (Statement)constructorast.parse().value;
	 //System.out.println(constructorast.parse().value);
	 if(!raiz.bind(new LinkedList<Map<String,Dec>>())){
		throw new Exception("Error de enlazado");
	 }
	 T out = raiz.type();
	 if(out != null && out.kind() == KindT.ERROR){
		throw new Exception("Error de tipos");
	 }
	 raiz.setDelta(0);
	 raiz.setDepth(0);
	 String code = new ProgPrincipal(raiz).generateCode();
	 System.out.println(code);
 }
}   
   
