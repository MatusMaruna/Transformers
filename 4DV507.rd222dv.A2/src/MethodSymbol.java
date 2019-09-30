import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MethodSymbol extends Symbol {
	
	private List<Symbol> parameterList = new ArrayList<>();
	private HashMap<String , VariableSymbol> declarationList = new HashMap<>();
	private HashMap<String , VariableSymbol> localDecList = new HashMap<>();
	
	public MethodSymbol(String id, String type) {
		super(id, type);
	}
	
	public void addParamSymbol(Symbol paramSymbol) {
		parameterList.add(paramSymbol);
	}
	
	public List<Symbol> getParametersList() {
		return parameterList;
	}

	public void setParametersList(List<Symbol> parametersList) {
		this.parameterList = parametersList;
	}
	
	public void addDeclarationSymbol(VariableSymbol declSymbol){
		declarationList.put(declSymbol.getId(), declSymbol);
	}
	
	public VariableSymbol getDeclarationSymbol(String declSymbol){
		return declarationList.get(declSymbol);
	}

	public void addLocalDecSymbol(VariableSymbol locDeclSymbol){
		localDecList.put(locDeclSymbol.getId(), locDeclSymbol);
	}
	
	public VariableSymbol getLocalDecSymbol(String locDeclSymbol){
		return localDecList.get(locDeclSymbol);
	}
	
}
