import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.OfpParser;

public class Mylistener implements ParseTreeListener {
	ArrayList<String> scopeRules = new ArrayList<String>();
	ArrayList<Scope> scopeList = new ArrayList<Scope>();
	ParseTreeProperty<Scope> scopes; // idk
	Scope currentScope;
	ParseTree node; 
	Scope s; 
	Scope globalScope;
	int id = 0;

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule entered: " + resolveName(ctx));
		if (scopeRules.contains(resolveName(ctx))) {
			//scopes.put(node, currentScope);
			//node.setParent(ctx);
			System.out.println("Entered new Scope : " + resolveName(ctx));
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
				name = "ifStmt " + id++;
				currentScope.define(new Symbol(name, type));
			}
			if (resolveName(ctx) == "whileStmt") {
				name = "whileStmt";
				currentScope.define(new Symbol(name, type));
			}
			/*System.out.println(
					"\n New tester: Type: " + type + " Id: " + name + " inside Scope : " + resolveName(ctx) + "\n");*/
			
			if (resolveName(ctx) == "start") {
				name = resolveName(ctx);
				s = new Scope(null, name);
				}else{
				s = new Scope(currentScope, name);
				}
			scopeList.add(s);
			currentScope = s;
			
		}

		if (resolveName(ctx).equals("declaration")) {
			System.out.println("New decleration: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name: " + ctx.getChild(1).getText());
			System.out.print(" Value:" + ctx.getChild(3).getText());
			System.out.println("");
			String name = ctx.getChild(1).getText();
			String value = ctx.getChild(3).getText();
			OfpType type = getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));

		}

		if (resolveName(ctx).equals("asgnStmt")) {
			System.out.println("New assignment: " + ctx.getText());
			System.out.print(" Name: " + ctx.getChild(0).getText());
			System.out.print(" Value:" + ctx.getChild(2).getText());
			System.out.println("");
			String name = ctx.getChild(0).getText();
			OfpType type; 
			try {
			type = currentScope.resolve(name).getType();
			}catch(Exception e) {
				System.err.println("Variable " + ctx.getChild(0).getText() + " is not defined!");
				System.out.println("");
				type = OfpType.Undef;
			}
			String value = ctx.getChild(2).getText();
			currentScope.define(new Symbol(name,type ));
		}

		if (resolveName(ctx).equals("localDecl")) {
			System.out.println("New local decl: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name:" + ctx.getChild(1).getText());
			System.out.println("");
			String name = ctx.getChild(1).getText();
			OfpType type = getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));
		}
		if (resolveName(ctx).equals("parameter")) {
			System.out.println("New Parameter: " + ctx.getText());
			System.out.print(" Type: " + ctx.getChild(0).getText());
			System.out.print(" Name:" + ctx.getChild(1).getText());
			System.out.println("");
			String name = ctx.getChild(1).getText();
			OfpType type = getType(ctx.getChild(0).getText());
			currentScope.define(new Symbol(name, type));
		}

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule exited: " + resolveName(ctx));

		if (scopeRules.contains(resolveName(ctx))) {
			System.out.println("Left Scope : " + resolveName(ctx));
			currentScope.setScopeType(resolveName(ctx));
			currentScope = currentScope.setEnclosingScope();
		}
	}

	@Override
	public void visitErrorNode(ErrorNode ctx) {
		// System.err.println("Visit Error: " + arg0.getText());

	}

	@Override
	public void visitTerminal(TerminalNode ctx) {
		// System.out.println(resolveName(ctx));

	}

	public OfpType getType(String type) {

		switch (type) {
		case "int":
			return OfpType.Int;
		case "int[]":
			return OfpType.IntArray;
		case "string":
			return OfpType.String;
		case "float":
			return OfpType.Float;
		case "float[]":
			return OfpType.FloatArray;
		case "char":
			return OfpType.Char;
		case "char[]":
			return OfpType.CharArray;
		case "string[]":
			return OfpType.StringArray;
		case "bool":
			return OfpType.Bool;
		default:
			return null;
		}
	}

	String[] ruleNames;

	public void loadParser(OfpParser parser) {
		ruleNames = parser.getRuleNames();
		scopeRules.add("start");
		scopeRules.add("main");
		scopeRules.add("method");
		scopeRules.add("ifStmt");
		scopeRules.add("whileStmt");
	}

	public String resolveName(ParserRuleContext ctx) {
		return ruleNames[ctx.getRuleIndex()];
	}

	public String resolveName(TerminalNode ctx) {
		return ctx.toString();
	}

}
