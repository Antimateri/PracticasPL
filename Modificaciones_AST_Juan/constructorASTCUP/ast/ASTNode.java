package ast;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface ASTNode {
    //public ?? type() // for the future
    public void bind(LinkedList<Map<String, Dec>> envs); // for the future
    // public ?? generateCode() // for the future
    public NodeKind nodeKind();
    public String toString();
    public int setDelta(int last);
}
