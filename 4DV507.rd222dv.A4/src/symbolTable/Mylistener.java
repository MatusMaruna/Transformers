package symbolTable;

import java.util.ArrayList;

import rd222dv.A4.bytecodeGenerator.FunctionSymbol;
import rd222dv.A4.bytecodeGenerator.ParamSymbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import rd222dv.A4.antlr4.OfpParser;


public class Mylistener implements ParseTreeListener {
	ArrayList<String> scopeRules = new ArrayList<String>();
	public ArrayList<Scope> scopeList = new ArrayList<Scope>(); // for printing
	public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
	Scope currentScope;
	FunctionSymbol currentFunction;
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
			// System.out.println("Entered new symbolTable.Scope : " + resolveName(ctx));
			String name = ctx.getChild(1).getText();
			String type = ctx.getChild(0).getText();
			if (resolveName(ctx) == "main") {
				type = ctx.getChild(0).getText();
				currentFunction = new FunctionSymbol();
				currentFunction.setId(name);
				currentFunction.setType(OfpType.getType(type));
				currentFunction.varCount = 1;
				currentScope.define(currentFunction);
			}
			if (resolveName(ctx) == "method") {
				currentFunction = new FunctionSymbol();
				currentFunction.setId(name);
				currentFunction.setType(OfpType.getType(type));
				currentScope.define(currentFunction);
			}
			if (resolveName(ctx) == "ifStmt") {
				name = "ifStmt " + countIf++;
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "whileStmt") {
				name = "whileStmt " + countWhile++;
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "elseStmt") {
				name = "elseStmt " + countElse++;
				;
				currentScope.define(new Symbol(name, type));
			}
			/*
			 * System.out.println( "\n New tester: Type: " + type + " Id: " + name +
			 * " inside symbolTable.Scope : " + resolveName(ctx) + "\n");
			 */

			s = new Scope(currentScope, name);
			s.setFunctionSymbol(currentFunction);
			scopeList.add(s);
			globalScope.addChild(s, name);
			currentScope = s;
			scopes.put(ctx, currentScope);

		}

		if (resolveName(ctx) == "start") {
			String name = resolveName(ctx);
			s = new Scope(null, name);
			scopeList.add(s);
			currentScope = s;
			globalScope = s;
			scopes.put(ctx, currentScope);

		}

		if (resolveName(ctx).equals("declaration")) {
			checkSymbol(ctx);
			/*
			 * System.out.println("New decleration: " + ctx.getText());
			 * System.out.print(" Type: " + ctx.getChild(0).getText());
			 * System.out.print(" Name: " + ctx.getChild(1).getText());
			 * System.out.print(" Value:" + ctx.getChild(3).getText());
			 * System.out.println("");
			 */
			String name = ctx.getChild(1).getText();
			String value = ctx.getChild(3).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());
			currentFunction.addVariable(new Symbol(name, type));
			currentScope.define(new Symbol(name, type));
			scopes.put(ctx, currentScope);

		}

		if (resolveName(ctx).equals("asgnStmt")) {
			/*
			 * System.out.println("New assignment: " + ctx.getText());
			 * System.out.print(" Name: " + ctx.getChild(0).getText());
			 * System.out.print(" Value:" + ctx.getChild(2).getText());
			 * System.out.println("");
			 */
			String name = ctx.getChild(0).getText();
			OfpType type;
			String value = ctx.getChild(2).getText();

			if (currentScope.resolve(name) == null) {
				type = searchType(name);
				currentScope.define(new Symbol(name, type));
				scopes.put(ctx, currentScope);
			} else {
				type = currentScope.resolve(name).getType();
			}

			if (type != null) {
				currentScope.define(new Symbol(name, type));
				scopes.put(ctx, currentScope);
			} else {
				errorListener.reportError(ErrorType.SemanticError, ctx.getStart().getLine(),
						"Variable " + ctx.getChild(0).getText() + " is not defined!");
			}

		}

		if (resolveName(ctx).equals("localDecl")) {
			/*
			 * System.out.println("New local decl: " + ctx.getText());
			 * System.out.print(" Type: " + ctx.getChild(0).getText());
			 * System.out.print(" Name:" + ctx.getChild(1).getText());
			 * System.out.println("");
			 */
			String name = ctx.getChild(1).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());
			currentFunction.addVariable(new Symbol(name, type));
			currentScope.define(new Symbol(name, type));
			scopes.put(ctx, currentScope);
		}
		if (resolveName(ctx).equals("parameter")) {
			/*
			 * System.out.println("New Parameter: " + ctx.getText());
			 * System.out.print(" Type: " + ctx.getChild(0).getText());
			 * System.out.print(" Name:" + ctx.getChild(1).getText());
			 * System.out.println("");
			 */
			String name = ctx.getChild(1).getText();
			OfpType type = OfpType.getType(ctx.getChild(0).getText());

			ParamSymbol s = new ParamSymbol();
			s.setId(name);
			s.setType(type);
			currentFunction.addParameter(s);

			currentScope.define(new Symbol(name, type));
			//currentScope.parameters.add(type);
			//globalScope.parameterMap.put(currentScope.getScopeName(), currentScope.parameters);
			scopes.put(ctx, currentScope);

		}

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule exited: " + resolveName(ctx));

		if (scopeRules.contains(resolveName(ctx))) {
			// System.out.println("Left symbolTable.Scope : " + resolveName(ctx));
			currentScope.setScopeType(resolveName(ctx));
			currentScope = currentScope.setEnclosingScope();
		}
	}

	@Override
	public void visitErrorNode(ErrorNode ctx) {
		/*
		 * errorListener.reportError(ErrorType.SemanticError, ctx.getSymbol().getLine(),
		 * "Could not parse:  "+ ctx.getText() + " , invalid value");
		 * errorListener.printErrors(); System.exit(-1);
		 */

	}

	@Override
	public void visitTerminal(TerminalNode ctx) {
		// System.out.println(resolveName(ctx));

	}

	String[] ruleNames;

	public void loadParser(OfpParser parser) {
		ruleNames = parser.getRuleNames();
		// scopeRules.add("start");
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
		if (currentScope.resolve(ctx.getChild(1).getText()) != null)
			errorListener.reportError(ErrorType.MultipleDeclerationError, ctx.getStart().getLine(),
					"conflicting declared variables " + ctx.getChild(1).getText());

	}

	public String resolveName(TerminalNode ctx) {
		return ctx.toString();
	}

	public boolean search(String varName) {
		if (currentScope.getEnclosingScope() != null) {
			if (currentScope.getEnclosingScope().resolve(varName) == null) {
				Scope s = currentScope.getEnclosingScope();
				while (s.getEnclosingScope() != null) {
					s = s.getEnclosingScope();
					if (s.resolve(varName) != null) {
						return true;
					}
				}
				s.printScope();
				return false;
			}
			return true;
		}
		return false;
	}

	public OfpType searchType(String varName) {
		if (currentScope.getEnclosingScope().resolve(varName) == null) {

			Scope s = currentScope.getEnclosingScope();
			while (s.getEnclosingScope() != null) {
				s = s.getEnclosingScope();
				if (s.resolve(varName) != null) {
					return s.resolve(varName).getType();
				}
			}
			return null;
		}
		return currentScope.getEnclosingScope().resolve(varName).getType();

	}
}