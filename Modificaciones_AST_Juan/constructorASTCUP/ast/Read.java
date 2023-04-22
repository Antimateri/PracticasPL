package ast;

import java.util.LinkedList;
import java.util.Map;

// Funcion Read de input
public class Read extends I{
    private IdenVar id;

    public Read(IdenVar id) {
        this.id = id;
    }

    public String toString(){
        return "read(" + id.toString() +")";
    }

    @Override
    public KindI kind() {
        return KindI.READ;
    }

	@Override
	public void bind(LinkedList<Map<String, Dec>> envs) {
		id.bind(envs);
	}
    
    
}
