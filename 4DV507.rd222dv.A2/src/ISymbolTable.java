
public interface ISymbolTable {
	
	public void enterScope();
	public void exitScope();
	public void define(Symbol symbol);
	public Symbol resolve(String key);
	public void printSymbolTable();
	public void resetTable();
	
}
