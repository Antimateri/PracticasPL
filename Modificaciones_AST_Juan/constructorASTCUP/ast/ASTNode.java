package ast;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface ASTNode {
    public T type(); // for the future
    public void bind(LinkedList<Map<String, Dec>> envs) throws UndefinedVariableException, RedefinedVariableException; // for the future
    public String generateCode();
    public NodeKind nodeKind();
    public String toString();
    public int setDelta(int last);
    public void setDepth(int depth);
}
