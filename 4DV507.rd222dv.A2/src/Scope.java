import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
	private Scope encolsingScope; 
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
	public Scope (Scope enclosingScope) {
		
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
}
