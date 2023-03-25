
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Sat Mar 25 20:55:22 CET 2023
//----------------------------------------------------

package constructorast;

import java_cup.runtime.*;
import alex.AnalizadorLexicoExp;
import alex.UnidadLexica;
import alex.TokenValue;
import errors.GestionErroresExp;
import ast.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Sat Mar 25 20:55:22 CET 2023
  */
public class ConstructorASTExp extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public ConstructorASTExp() {super();}

  /** Constructor which sets the default scanner. */
  public ConstructorASTExp(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ConstructorASTExp(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\005\000\002\002\004\000\002\002" +
    "\003\000\002\003\005\000\002\003\005\000\002\003\005" +
    "\000\002\003\005\000\002\003\003\000\002\004\003\000" +
    "\002\004\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\023\000\006\034\006\045\010\001\002\000\020\002" +
    "\ufffa\021\ufffa\023\ufffa\024\ufffa\025\ufffa\026\ufffa\035\ufffa" +
    "\001\002\000\020\002\uffff\021\uffff\023\015\024\017\025" +
    "\014\026\016\035\uffff\001\002\000\006\034\006\045\010" +
    "\001\002\000\006\002\012\021\011\001\002\000\020\002" +
    "\ufff9\021\ufff9\023\ufff9\024\ufff9\025\ufff9\026\ufff9\035\ufff9" +
    "\001\002\000\006\034\006\045\010\001\002\000\004\002" +
    "\000\001\002\000\020\002\001\021\001\023\015\024\017" +
    "\025\014\026\016\035\001\001\002\000\006\034\006\045" +
    "\010\001\002\000\006\034\006\045\010\001\002\000\006" +
    "\034\006\045\010\001\002\000\006\034\006\045\010\001" +
    "\002\000\020\002\ufffd\021\ufffd\023\ufffd\024\ufffd\025\ufffd" +
    "\026\ufffd\035\ufffd\001\002\000\020\002\ufffc\021\ufffc\023" +
    "\ufffc\024\ufffc\025\ufffc\026\ufffc\035\ufffc\001\002\000\020" +
    "\002\ufffe\021\ufffe\023\ufffe\024\ufffe\025\ufffe\026\ufffe\035" +
    "\ufffe\001\002\000\020\002\ufffb\021\ufffb\023\ufffb\024\ufffb" +
    "\025\ufffb\026\ufffb\035\ufffb\001\002\000\006\021\011\035" +
    "\025\001\002\000\020\002\ufff8\021\ufff8\023\ufff8\024\ufff8" +
    "\025\ufff8\026\ufff8\035\ufff8\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\023\000\010\002\006\003\004\004\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\002\023\003\004" +
    "\004\003\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\003\012\004\003\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\022\001\001\000\004\004\021\001" +
    "\001\000\004\004\020\001\001\000\004\004\017\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ConstructorASTExp$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ConstructorASTExp$actions(this);
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
    return action_obj.CUP$ConstructorASTExp$do_action(act_num, parser, stack, top);
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
 
   errores = new GestionErroresExp();
   AnalizadorLexicoExp alex = (AnalizadorLexicoExp)getScanner(); 
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresExp errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ConstructorASTExp$actions {
  private final ConstructorASTExp parser;

  /** Constructor */
  CUP$ConstructorASTExp$actions(ConstructorASTExp parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ConstructorASTExp$do_action_part00000000(
    int                        CUP$ConstructorASTExp$act_num,
    java_cup.runtime.lr_parser CUP$ConstructorASTExp$parser,
    java.util.Stack            CUP$ConstructorASTExp$stack,
    int                        CUP$ConstructorASTExp$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ConstructorASTExp$result;

      /* select the action based on the action number */
      switch (CUP$ConstructorASTExp$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Exp ::= Exp SUMA Term 
            {
              E RESULT =null;
		E aDeexp1 = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-2)).value;
		E aDeterm = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT= new EBin(KindE.SUMA,aDeexp1,aDeterm); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Exp EOF 
            {
              Object RESULT =null;
		E start_val = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-1)).value;
		RESULT = start_val;
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$ConstructorASTExp$parser.done_parsing();
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Exp ::= Term 
            {
              E RESULT =null;
		E aDeterm = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT=aDeterm; 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Exp",0, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Term ::= Term MUL Fact 
            {
              E RESULT =null;
		E aDeterm1 = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-2)).value;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT= new EBin(KindE.MUL,aDeterm1,aDefact); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Term ::= Term DIV Fact 
            {
              E RESULT =null;
		E aDeterm1 = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-2)).value;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT= new EBin(KindE.DIV,aDeterm1,aDefact); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Term ::= Term POT Fact 
            {
              E RESULT =null;
		E aDeterm1 = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-2)).value;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT= new EBin(KindE.POT,aDeterm1,aDefact); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Term ::= Term MOD Fact 
            {
              E RESULT =null;
		E aDeterm1 = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-2)).value;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT= new EBin(KindE.MOD,aDeterm1,aDefact); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Term ::= Fact 
            {
              E RESULT =null;
		E aDefact = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT=aDefact; 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Term",1, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Fact ::= INT 
            {
              E RESULT =null;
		TokenValue intValue = (TokenValue)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.peek()).value;
		 RESULT = new Int(intValue.lexema); 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Fact ::= PAP Exp PCIERRE 
            {
              E RESULT =null;
		E aDeexp = (E)((java_cup.runtime.Symbol) CUP$ConstructorASTExp$stack.elementAt(CUP$ConstructorASTExp$top-1)).value;
		 RESULT = aDeexp; 
              CUP$ConstructorASTExp$result = parser.getSymbolFactory().newSymbol("Fact",2, RESULT);
            }
          return CUP$ConstructorASTExp$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ConstructorASTExp$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ConstructorASTExp$do_action(
    int                        CUP$ConstructorASTExp$act_num,
    java_cup.runtime.lr_parser CUP$ConstructorASTExp$parser,
    java.util.Stack            CUP$ConstructorASTExp$stack,
    int                        CUP$ConstructorASTExp$top)
    throws java.lang.Exception
    {
              return CUP$ConstructorASTExp$do_action_part00000000(
                               CUP$ConstructorASTExp$act_num,
                               CUP$ConstructorASTExp$parser,
                               CUP$ConstructorASTExp$stack,
                               CUP$ConstructorASTExp$top);
    }
}

