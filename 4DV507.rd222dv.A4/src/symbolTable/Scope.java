package symbolTable;

import bytecodeGenerator.FunctionSymbol;

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
	private FunctionSymbol fs = new FunctionSymbol();

	// Useless
	public ArrayList<OfpType> parameters = new ArrayList<OfpType>();
	public Map<String, ArrayList<OfpType>> parameterMap = new LinkedHashMap<String, ArrayList<OfpType>>();

	// *

	public Scope(Scope enclosingScope, String name) {
		this.enclosingScope = enclosingScope;
		this.name = name;
	}

	public String getScopeType() {
		return type;
	}

	public Scope getEnclosingScope() {
		return enclosingScope;
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


	public void setFunctionSymbol(FunctionSymbol fs){
		this.fs = fs;
	}

	public FunctionSymbol getFunctionSymbol(){
		return fs;
	}

	public Symbol resolve(String name) {
		if (symbols.containsKey(name)) // if in current scope
			return symbols.get(name);
		else { // move to enclosing scope
			return null;
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
		if (enclosingScope != null)
			return "symbolTable.Scope name : " + name + " Enclosing symbolTable.Scope id : " + enclosingScope.name;
		else
			return "symbolTable.Scope name : " + name;
	}

}