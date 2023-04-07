package ast;

// Recibe una expresion (se asumira que es una lista) y un indice y devuelve el elemento de la lista en esa posicion
public class ListAccess extends E{
    //el indice
    private E index;
    //la lista
    private E list;
    
    public ListAccess(E index, E list) {
        this.index = index;
        this.list = list;
    }

    public String toString(){
        return "ListAcces(" + index.toString() + ", " + list.toString() + ")";
    }

    @Override
    public KindE kind() {
        return KindE.LISTACCESS;
    }
}
