import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolTable {

	private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

	public ParseTreeProperty<Scope> getSymbolTable() {
		return scopes;
	}

	private Scope currentScope;
	// private currentFunctionSymbol = null; // for later

	public void enterProgram(OfpParser.StartContext ctx) {
		// enclosing scope == null for the global/program scope
		currentScope = new Scope();
		scopes.put(ctx, currentScope);
	}

}
