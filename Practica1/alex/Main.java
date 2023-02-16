package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Main {

   public static boolean checkPatron(String patr, String pal){
     // Buscar asterisco
     boolean ret = true;
     if (patr.length() > pal.length()) return false;
     for (int i = 0; i < patr.length() && ret; ++i){
          if (patr.charAt(i) == '*') break;
          if (patr.charAt(i) != pal.charAt(i)) ret = false;
     }
     int j = patr.length() - 1;
     for (int i = pal.length() - 1; i >= 0 && ret; --i, --j){
      if (patr.charAt(j) == '*') break;
      if (patr.charAt(j) != pal.charAt(i)) ret = false;
     }
     return ret;
   }

   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     ArrayList <String> palabras = new ArrayList <String>();
     ArrayList <String> patrones = new ArrayList <String>();
     do {
       unidad = al.yylex();
       if (unidad.clase() == 17) //Palabra
          palabras.add(unidad.lexema());
       if (unidad.clase() == 18)
          patrones.add(unidad.lexema());
          
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);


     System.out.println("PALABRAS");
     for (String i : palabras) System.out.println(i);
     System.out.println("PATRONES");
     for (String p : patrones){
      System.out.print(p + ": ");
      int cnt = 0;
      for (String pal : palabras){
        if (checkPatron(p, pal)) ++cnt;
      }
      System.out.println(cnt);
     }

    }        
} 
