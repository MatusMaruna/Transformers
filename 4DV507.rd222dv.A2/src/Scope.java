import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
	private String name; 
	private Scope encolsingScope; 
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
	public Scope (Scope enclosingScope, String name) {
		this.name = name; 
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
	
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name; 
	}
	
	@Override 
	
	public String toString() {
		if(encolsingScope != null)
		return "Scope name : " + name +  " Enclosing Scope id : " +  encolsingScope.name;
		else
		return "Scope name : " + name;
	}
}
