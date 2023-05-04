package ast;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface ASTNode {
    public T type(); // for the future
    public boolean bind(LinkedList<Map<String, Dec>> envs); // for the future
    public String generateCode();
    public String generateDecFun();
    public NodeKind nodeKind();
    public String toString();
    public int setDelta(int last); //Establece los deltas de cada variable local/parámetro/estructura anónima/llamada a función
    public void setDepth(int depth); //Establece la profundidad de ejecución en las declaraciones de variables. Comenzará en 0
    public int maxMem(); //Devuelve el tamaño en memoria que necesita para guardar variables locales + estructuras anónimas + llamadas a función
}
