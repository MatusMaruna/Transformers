

public class SymbolTable implements ISymbolTable {

	private Scope currentScope;
	private Scope rootScope;
	// private currentFunctionSymbol = null; // for later

	public SymbolTable() {
		super();
		this.rootScope = new Scope(null);
		this.currentScope = rootScope;
	}
	
	public String getCurrentScopeName(){
		return currentScope.getScopeName();
	}
	
	public void setCurrentScopeName(String scopeName){
		currentScope.setScopeName(scopeName);
	}
	
	public String getCurrentScopeType(){
		return currentScope.getScopeType();
	}
	
	public void setCurrentScopeType(String scopeType){
		currentScope.setScopeType(scopeType);
	}
		
	public String getRootScopeName(){
		return rootScope.getScopeName();
	}

	@Override
	public void enterScope() {
		currentScope = currentScope.nextChild();
		
	}

	@Override
	public void exitScope() {
		currentScope = currentScope.getEnclosingScope();
		
	}

	@Override
	public void define(Symbol symbol) {
		currentScope.define(symbol);
		
	}

	@Override
	public Symbol resolve(String key) {
		return currentScope.resolve(key);
	}
	
	@Override
	public void printSymbolTable() {
		System.out.println("\n Symbol Table: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%10s%25s%25s%n", "Id", "Type", "Scope Name(Type)");
		System.out.println("----------------------------------------------------------------------");
		rootScope.printScope();
		System.out.println("----------------------------------------------------------------------");
	}
	public void printScope(){
		currentScope.printScope();
	}
	
	public void resetTable() {
		rootScope.resetScope();
	}

}
