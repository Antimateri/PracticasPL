package ast;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Identificadores para nuevos tipos definidos por el usuario
public class IdenType extends Iden{
    int size = 0; //tamaño del tipo

    public IdenType(String id){
        super(id);
    }

    public void setSize(int size){ this.size = size; }
    public int getSize(){ return size; }
    
}
