import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
	private int id; 
	private Scope encolsingScope; 
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
	public Scope (Scope enclosingScope, int id) {
		this.id = id; 
		this.encolsingScope = enclosingScope; 
	}
	
	public Scope getEnclosingScope() {
		return null; 
	}
	
	public void define(Symbol sym) {
		symbols.put(sym.getName(), sym);
	}
	
	public Symbol resolve(String name) {
		return null;
		
	}
	@Override 
	
	public String toString() {
		if(encolsingScope != null)
		return "Scope id : " + id +  " Enclosing Scope id : " +  Integer.toString(encolsingScope.id);
		else
		return "Scope id : " + id;
	}
}
