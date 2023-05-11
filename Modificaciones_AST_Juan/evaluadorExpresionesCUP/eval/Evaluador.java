
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Thu May 11 21:15:41 CEST 2023
//----------------------------------------------------

package eval;

import java_cup.runtime.*;
import alex.AnalizadorLexicoEval;
import alex.UnidadLexica;
import alex.TokenValue;
import errors.GestionErroresEval;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Thu May 11 21:15:41 CEST 2023
  */
public class Evaluador extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Evaluador() {super();}

  /** Constructor which sets the default scanner. */
  public Evaluador(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Evaluador(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\007\000\002\002\005\000\002\002\004\000\002\002" +
    "\003\000\002\003\005\000\002\003\003\000\002\004\003" +
    "\000\002\004\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\006\006\007\010\005\001\002\000\012\002" +
    "\ufffd\004\ufffd\005\ufffd\007\ufffd\001\002\000\012\002\ufffc" +
    "\004\ufffc\005\ufffc\007\ufffc\001\002\000\012\002\uffff\004" +
    "\uffff\005\014\007\uffff\001\002\000\006\006\007\010\005" +
    "\001\002\000\006\002\012\004\011\001\002\000\006\006" +
    "\007\010\005\001\002\000\004\002\000\001\002\000\012" +
    "\002\001\004\001\005\014\007\001\001\002\000\006\006" +
    "\007\010\005\001\002\000\012\002\ufffe\004\ufffe\005\ufffe" +
    "\007\ufffe\001\002\000\006\004\011\007\017\001\002\000" +
    "\012\002\ufffb\004\ufffb\005\ufffb\007\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\010\002\007\003\005\004\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\002\015\003\005\004\003\001\001\000\002\001\001\000" +
    "\006\003\012\004\003\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Evaluador$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Evaluador$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Evaluador$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErroresEval();
   AnalizadorLexicoEval alex = (AnalizadorLexicoEval)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresEval errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Evaluador$actions {
  private final Evaluador parser;

  /** Constructor */
  CUP$Evaluador$actions(Evaluador parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Evaluador$do_action_part00000000(
    int                        CUP$Evaluador$act_num,
    java_cup.runtime.lr_parser CUP$Evaluador$parser,
    java.util.Stack            CUP$Evaluador$stack,
    int                        CUP$Evaluador$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Evaluador$result;

      /* select the action based on the action number */
      switch (CUP$Evaluador$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Exp ::= Exp MAS Term 
            {
              Integer RESULT =null;
		Integer exp1 = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.elementAt(CUP$Evaluador$top-2)).value;
		Integer term = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.peek()).value;
		 int aux = exp1.intValue() + term.intValue(); RESULT = Integer.valueOf(aux); 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Exp EOF 
            {
              Object RESULT =null;
		Integer start_val = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.elementAt(CUP$Evaluador$top-1)).value;
		RESULT = start_val;
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$Evaluador$parser.done_parsing();
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Exp ::= Term 
            {
              Integer RESULT =null;
		Integer term = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.peek()).value;
		 RESULT = term; 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Term ::= Term POR Fact 
            {
              Integer RESULT =null;
		Integer term1 = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.elementAt(CUP$Evaluador$top-2)).value;
		Integer fact = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.peek()).value;
		 RESULT = Integer.valueOf(term1.intValue() * fact.intValue()); 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Term ::= Fact 
            {
              Integer RESULT =null;
		Integer fact = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.peek()).value;
		 RESULT = fact; 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Fact ::= NUM 
            {
              Integer RESULT =null;
		TokenValue numValue = (TokenValue)((java_cup.runtime.Symbol) CUP$Evaluador$stack.peek()).value;
		 RESULT = Integer.valueOf(numValue.lexema); 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$Evaluador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Fact ::= PAP Exp PCIERRE 
            {
              Integer RESULT =null;
		Integer exp = (Integer)((java_cup.runtime.Symbol) CUP$Evaluador$stack.elementAt(CUP$Evaluador$top-1)).value;
		 RESULT = exp; 
              CUP$Evaluador$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$Evaluador$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Evaluador$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Evaluador$do_action(
    int                        CUP$Evaluador$act_num,
    java_cup.runtime.lr_parser CUP$Evaluador$parser,
    java.util.Stack            CUP$Evaluador$stack,
    int                        CUP$Evaluador$top)
    throws java.lang.Exception
    {
              return CUP$Evaluador$do_action_part00000000(
                               CUP$Evaluador$act_num,
                               CUP$Evaluador$parser,
                               CUP$Evaluador$stack,
                               CUP$Evaluador$top);
    }
}

