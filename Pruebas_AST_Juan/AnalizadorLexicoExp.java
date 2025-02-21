// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: AnalizadorLexicoAbur.l

package alex;

import errors.GestionErroresExp;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class AnalizadorLexicoExp implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\10\0\2\1\1\2\2\0\1\1\22\0\1\1\2\0"+
    "\1\3\1\0\1\4\1\5\1\0\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\11\17\1\20"+
    "\1\21\1\22\1\23\1\24\2\0\4\25\1\26\25\25"+
    "\1\27\1\0\1\30\3\0\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\25\1\37\1\40\2\25\1\41\1\42"+
    "\1\43\1\44\1\45\1\25\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\25\1\56\1\57\1\60"+
    "\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\16\22\1\25"+
    "\1\1\1\26\1\27\1\30\1\31\12\22\1\32\13\22"+
    "\1\33\10\22\1\34\1\35\1\22\1\36\7\22\1\37"+
    "\6\22\1\40\2\22\1\41\1\42\1\43\3\22\1\44"+
    "\2\22\1\45\1\22\1\46\2\22\1\47\3\22\1\50"+
    "\1\22\1\51\3\22\1\52\4\22\1\53\2\22\1\54"+
    "\2\22\1\55\1\56\1\57\3\22\1\60\1\61\1\62"+
    "\2\22\1\63\2\22\1\64";

  private static int [] zzUnpackAction() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\61\0\142\0\61\0\223\0\61\0\61"+
    "\0\304\0\365\0\61\0\365\0\61\0\61\0\u0126\0\61"+
    "\0\61\0\61\0\u0157\0\61\0\u0188\0\61\0\61\0\u01b9"+
    "\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df\0\u0310\0\u0341"+
    "\0\u0372\0\u03a3\0\u03d4\0\u0405\0\u0436\0\61\0\u0467\0\61"+
    "\0\61\0\61\0\61\0\u0498\0\u04c9\0\u04fa\0\u052b\0\u055c"+
    "\0\u058d\0\u05be\0\u05ef\0\u0620\0\u0651\0\u0682\0\u06b3\0\u06e4"+
    "\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a\0\u083b\0\u086c"+
    "\0\u089d\0\61\0\u08ce\0\u08ff\0\u0930\0\u0961\0\u0992\0\u09c3"+
    "\0\u09f4\0\u0a25\0\u0188\0\u0188\0\u0a56\0\u0188\0\u0a87\0\u0ab8"+
    "\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c\0\u0bad\0\u0188\0\u0bde\0\u0c0f"+
    "\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3\0\u0188\0\u0d04\0\u0d35\0\u0188"+
    "\0\u0188\0\u0188\0\u0d66\0\u0d97\0\u0dc8\0\u0188\0\u0df9\0\u0e2a"+
    "\0\u0188\0\u0e5b\0\u0188\0\u0e8c\0\u0ebd\0\u0188\0\u0eee\0\u0f1f"+
    "\0\u0f50\0\u0188\0\u0f81\0\u0188\0\u0fb2\0\u0fe3\0\u1014\0\u0188"+
    "\0\u1045\0\u1076\0\u10a7\0\u10d8\0\u0188\0\u1109\0\u113a\0\u0188"+
    "\0\u116b\0\u119c\0\u0188\0\u0188\0\u0188\0\u11cd\0\u11fe\0\u122f"+
    "\0\u0188\0\u0188\0\u0188\0\u1260\0\u1291\0\u0188\0\u12c2\0\u12f3"+
    "\0\u0188";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\2\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\2\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\25\1\33\1\34\1\35\1\36\1\25"+
    "\1\37\1\40\1\25\1\41\1\42\1\43\1\44\2\25"+
    "\1\45\2\25\1\46\1\47\1\50\61\0\2\4\1\0"+
    "\56\4\5\0\1\51\63\0\1\52\67\0\1\17\57\0"+
    "\2\17\64\0\1\53\53\0\2\25\5\0\2\25\2\0"+
    "\25\25\21\0\2\25\5\0\2\25\2\0\17\25\1\54"+
    "\5\25\21\0\2\25\5\0\2\25\2\0\13\25\1\55"+
    "\11\25\21\0\2\25\5\0\2\25\2\0\10\25\1\56"+
    "\2\25\1\57\11\25\21\0\2\25\5\0\2\25\2\0"+
    "\10\25\1\60\10\25\1\61\1\25\1\62\1\25\21\0"+
    "\2\25\5\0\2\25\2\0\1\63\17\25\1\64\4\25"+
    "\21\0\2\25\5\0\2\25\2\0\1\65\24\25\21\0"+
    "\2\25\5\0\2\25\2\0\5\25\1\66\4\25\1\67"+
    "\12\25\21\0\2\25\5\0\2\25\2\0\4\25\1\70"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\20\25\1\71"+
    "\4\25\21\0\2\25\5\0\2\25\2\0\13\25\1\72"+
    "\1\25\1\73\1\25\1\74\5\25\21\0\2\25\5\0"+
    "\2\25\2\0\4\25\1\75\20\25\21\0\2\25\5\0"+
    "\2\25\2\0\17\25\1\76\5\25\21\0\2\25\5\0"+
    "\2\25\2\0\15\25\1\77\6\25\1\100\21\0\2\25"+
    "\5\0\2\25\2\0\6\25\1\101\16\25\62\0\1\102"+
    "\17\0\2\25\5\0\2\25\2\0\15\25\1\103\7\25"+
    "\21\0\2\25\5\0\2\25\2\0\13\25\1\104\11\25"+
    "\21\0\2\25\5\0\2\25\2\0\1\105\24\25\21\0"+
    "\2\25\5\0\2\25\2\0\12\25\1\106\12\25\21\0"+
    "\2\25\5\0\2\25\2\0\16\25\1\107\6\25\21\0"+
    "\2\25\5\0\2\25\2\0\1\110\24\25\21\0\2\25"+
    "\5\0\2\25\2\0\4\25\1\111\20\25\21\0\2\25"+
    "\5\0\2\25\2\0\10\25\1\112\14\25\21\0\2\25"+
    "\5\0\2\25\2\0\12\25\1\113\12\25\21\0\2\25"+
    "\5\0\2\25\2\0\16\25\1\114\6\25\21\0\2\25"+
    "\5\0\1\25\1\115\2\0\25\25\21\0\2\25\5\0"+
    "\2\25\2\0\17\25\1\116\5\25\21\0\2\25\5\0"+
    "\2\25\2\0\17\25\1\117\5\25\21\0\2\25\5\0"+
    "\2\25\2\0\10\25\1\120\14\25\21\0\2\25\5\0"+
    "\2\25\2\0\7\25\1\121\15\25\21\0\2\25\5\0"+
    "\2\25\2\0\7\25\1\122\3\25\1\123\11\25\21\0"+
    "\2\25\5\0\2\25\2\0\15\25\1\124\7\25\21\0"+
    "\2\25\5\0\2\25\2\0\1\125\4\25\1\126\11\25"+
    "\1\127\5\25\21\0\2\25\5\0\2\25\2\0\15\25"+
    "\1\130\7\25\21\0\2\25\5\0\2\25\2\0\20\25"+
    "\1\131\4\25\21\0\2\25\5\0\2\25\2\0\14\25"+
    "\1\132\10\25\21\0\2\25\5\0\2\25\2\0\7\25"+
    "\1\133\15\25\21\0\2\25\5\0\2\25\2\0\7\25"+
    "\1\134\15\25\21\0\2\25\5\0\2\25\2\0\10\25"+
    "\1\135\14\25\21\0\2\25\5\0\2\25\2\0\16\25"+
    "\1\136\6\25\21\0\2\25\5\0\2\25\2\0\16\25"+
    "\1\137\6\25\21\0\2\25\5\0\2\25\2\0\4\25"+
    "\1\140\20\25\21\0\2\25\5\0\2\25\2\0\10\25"+
    "\1\141\14\25\21\0\2\25\5\0\2\25\2\0\2\25"+
    "\1\142\22\25\21\0\2\25\5\0\2\25\2\0\16\25"+
    "\1\143\6\25\21\0\2\25\5\0\2\25\2\0\10\25"+
    "\1\144\14\25\21\0\2\25\5\0\2\25\2\0\6\25"+
    "\1\145\16\25\21\0\2\25\5\0\2\25\2\0\10\25"+
    "\1\146\14\25\21\0\2\25\5\0\2\25\2\0\12\25"+
    "\1\147\12\25\21\0\2\25\5\0\2\25\2\0\12\25"+
    "\1\150\12\25\21\0\2\25\5\0\2\25\2\0\2\25"+
    "\1\151\22\25\21\0\2\25\5\0\2\25\2\0\21\25"+
    "\1\152\3\25\21\0\2\25\5\0\2\25\2\0\3\25"+
    "\1\153\21\25\21\0\2\25\5\0\2\25\2\0\20\25"+
    "\1\154\4\25\21\0\2\25\5\0\2\25\2\0\20\25"+
    "\1\155\4\25\21\0\2\25\5\0\2\25\2\0\4\25"+
    "\1\156\20\25\21\0\2\25\5\0\2\25\2\0\4\25"+
    "\1\157\20\25\21\0\2\25\5\0\2\25\2\0\10\25"+
    "\1\160\14\25\21\0\2\25\5\0\2\25\2\0\1\25"+
    "\1\161\23\25\21\0\2\25\5\0\2\25\2\0\16\25"+
    "\1\162\6\25\21\0\2\25\5\0\2\25\2\0\17\25"+
    "\1\163\5\25\21\0\2\25\5\0\2\25\2\0\4\25"+
    "\1\164\20\25\21\0\2\25\5\0\2\25\2\0\16\25"+
    "\1\165\6\25\21\0\2\25\5\0\2\25\2\0\13\25"+
    "\1\166\11\25\21\0\2\25\5\0\2\25\2\0\17\25"+
    "\1\167\5\25\21\0\2\25\5\0\2\25\2\0\17\25"+
    "\1\170\5\25\21\0\2\25\5\0\2\25\2\0\1\171"+
    "\24\25\21\0\2\25\5\0\2\25\2\0\15\25\1\172"+
    "\7\25\21\0\2\25\5\0\2\25\2\0\2\25\1\173"+
    "\22\25\21\0\2\25\5\0\2\25\2\0\3\25\1\174"+
    "\21\25\21\0\2\25\5\0\2\25\2\0\4\25\1\175"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\20\25\1\176"+
    "\4\25\21\0\2\25\5\0\2\25\2\0\15\25\1\177"+
    "\7\25\21\0\2\25\5\0\2\25\2\0\4\25\1\200"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\3\25\1\201"+
    "\21\25\21\0\2\25\5\0\2\25\2\0\4\25\1\202"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\10\25\1\203"+
    "\14\25\21\0\2\25\5\0\2\25\2\0\12\25\1\204"+
    "\12\25\21\0\2\25\5\0\2\25\2\0\17\25\1\205"+
    "\5\25\21\0\2\25\5\0\2\25\2\0\4\25\1\206"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\17\25\1\207"+
    "\5\25\21\0\2\25\5\0\2\25\2\0\20\25\1\210"+
    "\4\25\21\0\2\25\5\0\2\25\2\0\16\25\1\211"+
    "\6\25\21\0\2\25\5\0\2\25\2\0\15\25\1\212"+
    "\7\25\21\0\2\25\5\0\2\25\2\0\5\25\1\213"+
    "\17\25\21\0\2\25\5\0\2\25\2\0\4\25\1\214"+
    "\20\25\21\0\2\25\5\0\2\25\2\0\2\25\1\215"+
    "\22\25\21\0\2\25\5\0\2\25\2\0\16\25\1\216"+
    "\6\25\21\0\2\25\5\0\2\25\2\0\17\25\1\217"+
    "\5\25\21\0\2\25\5\0\2\25\2\0\13\25\1\220"+
    "\11\25\21\0\2\25\5\0\2\25\2\0\15\25\1\221"+
    "\7\25\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4900];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\1\1\2\11\2\1\1\11"+
    "\1\1\2\11\1\1\3\11\1\1\1\11\1\1\2\11"+
    "\16\1\1\11\1\1\4\11\26\1\1\11\117\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  private ALexOperations ops;
  private GestionErroresExp errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresExp errores) {
   this.errores = errores;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexicoExp(java.io.Reader in) {
    ops = new ALexOperations(this);
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {   return ops.unidadEof();
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { errores.errorLexico(fila(),columna(),lexema());
            }
            // fall through
          case 53: break;
          case 2:
            { 
            }
            // fall through
          case 54: break;
          case 3:
            { return ops.unidadMod();
            }
            // fall through
          case 55: break;
          case 4:
            { return ops.unidadPAp();
            }
            // fall through
          case 56: break;
          case 5:
            { return ops.unidadPCierre();
            }
            // fall through
          case 57: break;
          case 6:
            { return ops.unidadMul();
            }
            // fall through
          case 58: break;
          case 7:
            { return ops.unidadSuma();
            }
            // fall through
          case 59: break;
          case 8:
            { return ops.unidadComa();
            }
            // fall through
          case 60: break;
          case 9:
            { return ops.unidadResta();
            }
            // fall through
          case 61: break;
          case 10:
            { return ops.unidadPunto();
            }
            // fall through
          case 62: break;
          case 11:
            { return ops.unidadDiv();
            }
            // fall through
          case 63: break;
          case 12:
            { return ops.unidadEnt();
            }
            // fall through
          case 64: break;
          case 13:
            { return ops.unidadDosPuntos();
            }
            // fall through
          case 65: break;
          case 14:
            { return ops.unidadPuntoComa();
            }
            // fall through
          case 66: break;
          case 15:
            { return ops.unidadMenor();
            }
            // fall through
          case 67: break;
          case 16:
            { return ops.unidadIgual();
            }
            // fall through
          case 68: break;
          case 17:
            { return ops.unidadMayor();
            }
            // fall through
          case 69: break;
          case 18:
            { return ops.unidadId();
            }
            // fall through
          case 70: break;
          case 19:
            { return ops.unidadCAp();
            }
            // fall through
          case 71: break;
          case 20:
            { return ops.unidadCCierre();
            }
            // fall through
          case 72: break;
          case 21:
            { return ops.unidadLAp();
            }
            // fall through
          case 73: break;
          case 22:
            { return ops.unidadLCierre();
            }
            // fall through
          case 74: break;
          case 23:
            { return ops.unidadAnd();
            }
            // fall through
          case 75: break;
          case 24:
            { return ops.unidadPot();
            }
            // fall through
          case 76: break;
          case 25:
            { return ops.unidadOpIgual();
            }
            // fall through
          case 77: break;
          case 26:
            { return ops.unidadIf();
            }
            // fall through
          case 78: break;
          case 27:
            { return ops.unidadOr();
            }
            // fall through
          case 79: break;
          case 28:
            { return ops.unidadFun();
            }
            // fall through
          case 80: break;
          case 29:
            { return ops.unidadLleva();
            }
            // fall through
          case 81: break;
          case 30:
            { return ops.unidadTipoInt();
            }
            // fall through
          case 82: break;
          case 31:
            { return ops.unidadRef();
            }
            // fall through
          case 83: break;
          case 32:
            { return ops.unidadTipoBool();
            }
            // fall through
          case 84: break;
          case 33:
            { return ops.unidadElse();
            }
            // fall through
          case 85: break;
          case 34:
            { return ops.unidadCall();
            }
            // fall through
          case 86: break;
          case 35:
            { return ops.unidadExec();
            }
            // fall through
          case 87: break;
          case 36:
            { return ops.unidadNull();
            }
            // fall through
          case 88: break;
          case 37:
            { return ops.unidadProc();
            }
            // fall through
          case 89: break;
          case 38:
            { return ops.unidadRead();
            }
            // fall through
          case 90: break;
          case 39:
            { return ops.unidadTrue();
            }
            // fall through
          case 91: break;
          case 40:
            { return ops.unidadClass();
            }
            // fall through
          case 92: break;
          case 41:
            { return ops.unidadFalse();
            }
            // fall through
          case 93: break;
          case 42:
            { return ops.unidadPrint();
            }
            // fall through
          case 94: break;
          case 43:
            { return ops.unidadWhile();
            }
            // fall through
          case 95: break;
          case 44:
            { return ops.unidadIfElse();
            }
            // fall through
          case 96: break;
          case 45:
            { return ops.unidadValorPunt();
            }
            // fall through
          case 97: break;
          case 46:
            { return ops.unidadReturn();
            }
            // fall through
          case 98: break;
          case 47:
            { return ops.unidadStruct();
            }
            // fall through
          case 99: break;
          case 48:
            { return ops.unidadMethods();
            }
            // fall through
          case 100: break;
          case 49:
            { return ops.unidadPuntero();
            }
            // fall through
          case 101: break;
          case 50:
            { return ops.unidadTipeDef();
            }
            // fall through
          case 102: break;
          case 51:
            { return ops.unidadAtributes();
            }
            // fall through
          case 103: break;
          case 52:
            { return ops.unidadConstructor();
            }
            // fall through
          case 104: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
