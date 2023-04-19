package ast;

//Posibles tipos de designadores:
public enum KindDesig {
    VAR,        //Designador a identificador de una variable
    POSARRAY,   //Designador a posición de array
    SELCAMPO,   //Designador a campo de registro
    REF         //Designador a la dirección de un designador dado
}
