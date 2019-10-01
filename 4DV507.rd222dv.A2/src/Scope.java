import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
	private String name;
	private String type;
	private int next = 0; // visit next child
	private Scope enclosingScope;
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
	private ArrayList<Scope> scopeChildren = new ArrayList<>();

	public Scope(Scope enclosingScope, String name) {
		this.enclosingScope = enclosingScope;
		this.name = name;
	}

	public String getScopeType() {
		return type;
	}

	public void setScopeType(String type) {
		this.type = type;
	}

	public String getScopeName() {
		return name;
	}

	public void setScopeName(String name) {
		this.name = name;
	}

	/*
	 * public Scope nextChild() { // creates new children Scope nextChild; if (next
	 * >= scopeChildren.size()) { // child does not exist nextChild = new
	 * Scope(this); // create new Scope scopeChildren.add(nextChild); } else {
	 * //Child exists nextChild = (Scope) scopeChildren.get(next); // visit child }
	 * next++; return nextChild; }
	 */

	public Symbol resolve(String name) {
		if (symbols.containsKey(name)) // if in current scope
			return symbols.get(name);
		else { // move to enclosing scope
			if (enclosingScope == null) {
				return null; // not in table
			} else
				return enclosingScope.resolve(name);
		}

	}

	public Scope setEnclosingScope() {
		return this.enclosingScope;
	}

	public void define(Symbol sym) {
		symbols.put(sym.getId(), sym);
	}

	public void printScope() {
		symbols.forEach((id, symbol) -> {

			if (symbol.getType() == null) {
				System.out.printf("%10s%25s%25s%n", id, symbol.getStringType(), name + "(" + type + ")");
			} else {
				System.out.printf("%10s%25s%25s%n", id, symbol.getType(), name + "(" + type + ")");
			}
		});

		scopeChildren.forEach((scope) -> {
			scope.printScope();
		});

	}

	public void resetScope() { // called after each traversal
		next = 0;
		for (int i = 0; i < scopeChildren.size(); i++)
			scopeChildren.get(i).resetScope();
	}

	@Override
	public String toString() {
		return this.symbols.toString();
	}
}