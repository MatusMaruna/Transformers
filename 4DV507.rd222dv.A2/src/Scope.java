import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
	private String name;
	private Scope enclosingScope;
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

	public Scope(Scope enclosingScope, String name) {
		this.name = name;
		this.enclosingScope = enclosingScope;
	}

	public Scope() {
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
		if (enclosingScope != null)
			return "Scope name : " + name + " Enclosing Scope id : " + enclosingScope.name;
		else
			return "Scope name : " + name;
	}
}
