import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Mylistener implements ParseTreeListener {
	ArrayList<String> scopeRules = new ArrayList<String>();
	ArrayList<Scope> scopeList = new ArrayList<Scope>();
	ParseTreeProperty<Scope> scopes; // idk
	Scope currentScope;
	Scope globalScope;
	int id = 0;

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule entered: " + resolveName(ctx));
		if (scopeRules.contains(resolveName(ctx))) {
			System.out.println("Entered new Scope : " + resolveName(ctx));
			String name = ctx.getChild(1).getText();
			if (resolveName(ctx) == "ifStmt") {
				name = "ifstmt" + id++;
			}
			Scope s = new Scope(currentScope, name);
			scopeList.add(s);
			currentScope = s;
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// System.out.println("rule exited: " + resolveName(ctx));

		if (scopeRules.contains(resolveName(ctx))) {
			System.out.println("Left Scope : " + resolveName(ctx));
			currentScope = globalScope;
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

	String[] ruleNames;

	public void loadParser(OfpParser parser) {
		ruleNames = parser.getRuleNames();
		scopeRules.add("main");
		scopeRules.add("method");
		scopeRules.add("ifStmt");
	}

	public String resolveName(ParserRuleContext ctx) {
		return ruleNames[ctx.getRuleIndex()];
	}

	public String resolveName(TerminalNode ctx) {
		return ctx.toString();
	}
}
