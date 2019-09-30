import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SymbolTableListener extends OfpBaseListener {
//	private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
//	private Scope currentScope;
	private SymbolTable symTable;
	private MethodSymbol currentMethod;
	
	public SymbolTableListener(ISymbolTable symbolTable) {
		super();
		this.symTable = (SymbolTable) symbolTable;
	}
	
/*	public ParseTreeProperty<Scope> getSymbolTable() {
		return scopes;
	} */

	@Override
	public void enterStart(OfpParser.StartContext ctx) {
		// enclosing scope == null for the global/program scope
		System.out.println("*****Start*****");
	/*	currentScope = new Scope();
		scopes.put(ctx, currentScope);*/
		symTable.enterScope();
		symTable.setCurrentScopeType("start");
		symTable.setCurrentScopeName("start");
		
		System.out.println("Enter scope: " + symTable.getCurrentScopeName());
		
		super.enterStart(ctx);
	}
	
	@Override
	public void exitStart(OfpParser.StartContext ctx) {
		System.out.println("Exit Scope ");
		symTable.exitScope();
		super.exitStart(ctx);
	}
	
	@Override
	public void enterMain(OfpParser.MainContext ctx) {
		String id = ctx.getChild(1).toString();
		String type = ctx.getChild(0).toString();
		System.out.println(type + " " + id + " " + symTable.getCurrentScopeType());
		
		currentMethod = new MethodSymbol(id, type);
		symTable.define(currentMethod);		
		symTable.enterScope();
		symTable.setCurrentScopeType("main");
		symTable.setCurrentScopeName(id);
		System.out.println("Enter main scope: " + symTable.getCurrentScopeName());
		
		super.enterMain(ctx);
	}

	@Override
	public void exitMain(OfpParser.MainContext ctx) {
		symTable.exitScope();
		super.exitMain(ctx);
	}	

	@Override
	public void enterMethod(OfpParser.MethodContext ctx) {
		System.out.println("Visited method: " + ctx.getText());
		String id = ctx.getChild(1).toString();
		String type = ctx.getChild(0).getText();
		System.out.println("Method entry: " + type + " " + id +  " | current scope name: " + symTable.getCurrentScopeName());
		
		currentMethod = new MethodSymbol(id, type);		
		symTable.define(currentMethod);
		symTable.enterScope();
		symTable.setCurrentScopeType("method");;
		symTable.setCurrentScopeName(id);
		
		System.out.println("Enter method scope: " + symTable.getCurrentScopeName());
		
		super.enterMethod(ctx);
	}

	@Override
	public void exitMethod(OfpParser.MethodContext ctx) {
		symTable.exitScope();
		super.exitMethod(ctx);
	}
	
	@Override
	public void enterParameter(OfpParser.ParameterContext ctx) {
		String id = ctx.getChild(1).toString();
		String type = ctx.getChild(0).getText();
		System.out.println("Param entry: " + type + " " + id +  " | current scope name: " + symTable.getCurrentScopeName());
		VariableSymbol parameterRecord = new VariableSymbol(id, type);		
		symTable.define(parameterRecord);
		currentMethod.addParamSymbol(parameterRecord);

		super.enterParameter(ctx);
	}
	
	@Override
	public void enterDeclaration(OfpParser.DeclarationContext ctx) {
		String id = ctx.getChild(1).toString();
		String type = ctx.getChild(0).getText();
		
		System.out.println("Declaration entry: " + type + " " + id +  " | current scope name: " + symTable.getCurrentScopeName());
		VariableSymbol localDecl = new VariableSymbol(id, type);		
		symTable.define(localDecl);
		currentMethod.addDeclarationSymbol(localDecl);

		super.enterDeclaration(ctx);
	}
	
	@Override
	public void enterLocalDecl(OfpParser.LocalDeclContext ctx) {
		String id = ctx.getChild(1).toString();
		String type = ctx.getChild(0).getText();
		
		System.out.println("LocalDecl entry: " + type + " " + id +  " | current scope name: " + symTable.getCurrentScopeName());
		VariableSymbol localDecl = new VariableSymbol(id, type);		
		symTable.define(localDecl);
		currentMethod.addLocalDecSymbol(localDecl);

		super.enterLocalDecl(ctx);
	}
}
