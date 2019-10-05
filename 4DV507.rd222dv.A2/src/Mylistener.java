import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.OfpParser;

public class Mylistener implements ParseTreeListener {
	ArrayList<String> scopeRules = new ArrayList<String>();
	ArrayList<Scope> scopeList = new ArrayList<Scope>();
	ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>(); // idk
	Scope currentScope;
	Scope s;
	Scope globalScope;
	int countIf = 0;
	int countWhile = 0; 
	int countElse = 0; 
	ErrorListener errorListener; 
	

	public Mylistener(ErrorListener errorListener) {
		this.errorListener = errorListener; 
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule entered: " + resolveName(ctx));
		if (scopeRules.contains(resolveName(ctx))) {
			//System.out.println("Entered new Scope : " + resolveName(ctx));
			String name = ctx.getChild(1).getText();
			String type = ctx.getChild(0).getText();
			if (resolveName(ctx) == "main") {
				type = ctx.getChild(0).getText();
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "method") {
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "ifStmt") {
				name = "ifStmt " + countIf++;
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "whileStmt") {
				name = "whileStmt " + countWhile++;
				currentScope.define(new Symbol(name, type));
			}
			if(resolveName(ctx) == "elseStmt") {
				name = "elseStmt " + countElse++;;
				currentScope.define(new Symbol(name, type));
			}
			/*
			 * System.out.println( "\n New tester: Type: " + type + " Id: " + name +
			 * " inside Scope : " + resolveName(ctx) + "\n");
			 */

			
			s = new Scope(currentScope, name);
			scopeList.add(s);
			currentScope = s;
			scopes.put(ctx, currentScope);

		}
		
		
		if (resolveName(ctx) == "start") {
			String name = resolveName(ctx);
			s = new Scope(null, name);
			scopeList.add(s);
			currentScope = s;
			scopes.put(ctx, currentScope);

			
		} 
		
		

		if (resolveName(ctx).equals("declaration")) {
			checkSymbol(ctx);
			/*System.out.println("New decleration: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name: " + ctx.getChild(1).getText());
			System.out.print(" Value:" + ctx.getChild(3).getText());
			System.out.println("");*/
			String name = ctx.getChild(1).getText();
			String value = ctx.getChild(3).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));
			scopes.put(ctx, currentScope);

		}

		if (resolveName(ctx).equals("asgnStmt")) {
			/*System.out.println("New assignment: " + ctx.getText());
			System.out.print(" Name: " + ctx.getChild(0).getText());
			System.out.print(" Value:" + ctx.getChild(2).getText());
			System.out.println("");*/
			String name = ctx.getChild(0).getText();
			OfpType type; 
			try {
			type = currentScope.resolve(name).getType();
			String value = ctx.getChild(2).getText();
			currentScope.define(new Symbol(name,type));
			scopes.put(ctx, currentScope);
			}catch(Exception e) {
				errorListener.reportError(ErrorType.SemanticError, ctx.getStart().getLine(),
						"Variable "+ ctx.getChild(0).getText() + " is not defined!");
				
			}
			
		}

		if (resolveName(ctx).equals("localDecl")) {
			/*System.out.println("New local decl: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name:" + ctx.getChild(1).getText());
			System.out.println("");*/
			String name = ctx.getChild(1).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));
			scopes.put(ctx, currentScope);
		}
		if (resolveName(ctx).equals("parameter")) {
			/*System.out.println("New Parameter: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name:" + ctx.getChild(1).getText());
			System.out.println("");*/
			String name = ctx.getChild(1).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));
			scopes.put(ctx, currentScope);
		}
		
		if(resolveName(ctx).equals("condition")) {
			System.out.println(ctx.getChild(0).getChildCount());
			System.out.println(currentScope.getEnclosingScope().getScopeName());
			for(int i = 0; i < ctx.getChild(0).getChildCount(); i+=2) {
				String varName = ctx.getChild(0).getChild(i).getText();
				if(search(varName) == false) {
					errorListener.reportError(ErrorType.SemanticError, ctx.getStart().getLine(),
							"Parameter " + varName + " is undefined!");
				};
			}
		}

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule exited: " + resolveName(ctx));

		if (scopeRules.contains(resolveName(ctx))) {
			//System.out.println("Left Scope : " + resolveName(ctx));
			currentScope.setScopeType(resolveName(ctx));
			currentScope = currentScope.setEnclosingScope();
		}
	}

	@Override
	public void visitErrorNode(ErrorNode ctx) {
		/* errorListener.reportError(ErrorType.SemanticError, ctx.getSymbol().getLine(),
					"Could not parse:  "+ ctx.getText() + " , invalid value");
		 errorListener.printErrors();
		 System.exit(-1); */

	}
 
	@Override
	public void visitTerminal(TerminalNode ctx) {
		// System.out.println(resolveName(ctx));

	}

	String[] ruleNames;

	public void loadParser(OfpParser parser) {
		ruleNames = parser.getRuleNames();
		//scopeRules.add("start");
		scopeRules.add("main");
		scopeRules.add("method");
		scopeRules.add("ifStmt");
		scopeRules.add("whileStmt");
		scopeRules.add("elseStmt");
	}

	public String resolveName(ParserRuleContext ctx) {
		return ruleNames[ctx.getRuleIndex()];
	}
	
	
	
	public void checkSymbol(ParserRuleContext ctx) {
		if(currentScope.resolve(ctx.getChild(1).getText()) != null)
			errorListener.reportError(ErrorType.MultipleDeclerationError, ctx.getStart().getLine(),
					"conflicting declared variables " + ctx.getChild(1).getText());
		
		
	}
	

	public String resolveName(TerminalNode ctx) {
		return ctx.toString();
	}
	
	public Boolean search(String varName) {
		
		if(currentScope.getEnclosingScope().resolve(varName) == null) {
		
		Scope s = currentScope.getEnclosingScope();
		while(s.getEnclosingScope() != null) {
			s = s.getEnclosingScope();
			if(s.resolve(varName) != null) {
				return true;
			}
		}
		return false; 
	}
		return true;
	}
}
