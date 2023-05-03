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
	 raiz.bind(new LinkedList<Map<String,Dec>>());
	 raiz.type();
	 raiz.setDelta(0);
	 raiz.setDepth(0);
	 System.out.println(raiz);

	 //Generacion de codigo:
	 /*
	 ProgPrincipal prog = new ProgPrincipal(raiz);
	 System.out.println(prog.generateCode());
	 */
 }
}   
   
