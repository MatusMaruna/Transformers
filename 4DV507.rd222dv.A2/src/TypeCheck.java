import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser;
import antlr4.OfpParser.ArrTypeContext;
import antlr4.OfpParser.ArrayContext;
import antlr4.OfpParser.ArrayListContext;
import antlr4.OfpParser.AsgnStmtContext;
import antlr4.OfpParser.BlockContext;
import antlr4.OfpParser.ConditionContext;
import antlr4.OfpParser.DeclarationContext;
import antlr4.OfpParser.ExprContext;
import antlr4.OfpParser.IfStmtContext;
import antlr4.OfpParser.LocalDeclContext;
import antlr4.OfpParser.MainContext;
import antlr4.OfpParser.MethodAccessContext;
import antlr4.OfpParser.MethodCallContext;
import antlr4.OfpParser.MethodContext;
import antlr4.OfpParser.ParameterContext;
import antlr4.OfpParser.ParameterListContext;
import antlr4.OfpParser.PrintContext;
import antlr4.OfpParser.ReturnStmtContext;
import antlr4.OfpParser.StartContext;
import antlr4.OfpParser.StmtContext;
import antlr4.OfpParser.TypeContext;
import antlr4.OfpParser.VarTypeContext;
import antlr4.OfpParser.WhileStmtContext;

public class TypeCheck extends OfpBaseVisitor<OfpType> {
	Scope currentScope;
	ParseTreeProperty<Scope> scopes;
	ErrorListener errorListener;
	String[] ruleNames;
	OfpType temp;
	String name;
	OfpType methodType;
	private Map<OfpType, OfpType> arrayValueMap = new LinkedHashMap<OfpType, OfpType>();

	public TypeCheck(ParseTreeProperty<Scope> scopes, ErrorListener errorListener) {
		this.scopes = scopes;
		this.errorListener = errorListener;
	}

	@Override
	public OfpType visitErrorNode(ErrorNode arg0) {
		// System.out.println("Test ErrorNode " + arg0.getText());
		return null;
	}

	@Override
	public OfpType visitTerminal(TerminalNode arg0) {
		switch (ruleNames[arg0.getSymbol().getType()]) {

		case "STR":
			return OfpType.String;
		case "INT":
			return OfpType.Int;
		case "CHAR":
			return OfpType.Char;
		case "FLOAT":
			return OfpType.Float;
		default:
			if (currentScope != null) {
				if (currentScope.resolve(arg0.getText()) != null) {
					return currentScope.resolve(arg0.getText()).getType();
				} else if (search(arg0.getText())) {
					return getType(arg0.getText());
				}

			}
			return OfpType.Undef;

		}

	}

	@Override
	public OfpType visitWhileStmt(WhileStmtContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitMethod(MethodContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		System.out.println("ENTERING NEW METHOD " + ctx.getText());
		System.out.println(currentScope.getScopeName());
		temp = visit(ctx.getChild(0));
		currentScope.printScope();

		methodType = OfpType.getType(ctx.getChild(0).getText());
		System.out.println("--------------RETURN------------------------ ");
		System.out.println("--------------methodType: " + methodType);
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitStart(StartContext ctx) {
		// System.out.println("Test Start " + ctx.getText());
		// visitAllChildren(ctx);

		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitArrType(ArrTypeContext ctx) {
		OfpType exprType = visit(ctx.getChild(0));
		typeEqual(temp, exprType, ctx, name, ctx.getStart().getLine());

		return null;
	}

	@Override
	public OfpType visitMain(MainContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitReturnStmt(ReturnStmtContext ctx) {
		/*
		 * System.err.println("Test Return " + ctx.getText()); String varName =
		 * ctx.getChild(1).getText(); System.out.println("Test var " +
		 * ctx.getChild(1).getText());
		 */

		System.out.println("MethType " + methodType);
		OfpType returnType = visit(ctx.getChild(1));

		System.out.println("return type " + returnType);

		if (methodType != returnType) {
			System.err.println("WRONG RETURN TYPE");
			typeEqual(methodType, returnType, ctx, name, ctx.getStart().getLine());
		}

		visitChildren(ctx);
		return null;

		/*
		 * visitChildren(ctx); return null;
		 */
	}

	@Override
	public OfpType visitType(TypeContext ctx) {
		// System.out.println("Test Type " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitDeclaration(DeclarationContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}

		String type = ctx.getChild(0).getText(); // Type
		name = ctx.getChild(1).getText(); // Name
		String value = ctx.getChild(3).getText(); // Value

		temp = scopes.get(ctx).resolve(name).getType();

		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitVarType(VarTypeContext ctx) {
		OfpType type = visitChildren(ctx);
		return type;
	}

	@Override
	public OfpType visitCondition(ConditionContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		for (int i = 0; i < ctx.getChild(0).getChildCount(); i += 2) {
			String varName = ctx.getChild(0).getChild(i).getText();
			// System.out.println(varName);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitPrint(PrintContext ctx) {
		// System.out.println("Test Print " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitIfStmt(IfStmtContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		// System.out.println("Test ifstmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitArray(ArrayContext ctx) {
		for (int i = 0; i < ctx.getChild(1).getChildCount(); i += 2) {
			OfpType exprType = visit(ctx.getChild(1).getChild(i));
			System.out.println("1COMPARISON: " + exprType + " " + temp);
			typeEqual(temp, exprType, ctx, name, ctx.getStart().getLine());
		}
		return null;
	}

	@Override
	public OfpType visitAsgnStmt(AsgnStmtContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		// System.out.println("Test AsgnStmt " + ctx.getText());
		String name = ctx.getChild(0).getText(); // Name
		// currentScope = scopes.get(ctx);
		if (currentScope.resolve(name) != null || search(name) == true) {
			if (currentScope.resolve(name) == null) {
				checkExist(name, ctx, ctx.getStart().getLine());
			}
			OfpType idType;
			if (currentScope.resolve(name) != null) {
				idType = currentScope.resolve(name).getType();
				temp = idType;
			} else {
				idType = getType(name);
				temp = getType(name);
			}
			OfpType exprType = visit(ctx.getChild(2));
			typeEqual(idType, exprType, ctx, name, ctx.getStart().getLine());
			// System.out.println(scopes.get(ctx).resolve(ctx.getChild(1).getText()).getType());

			// visitChildren(ctx);
		}
		return null;
	}

	@Override
	public OfpType visitParameter(ParameterContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitLocalDecl(LocalDeclContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitParameterList(ParameterListContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitBlock(BlockContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitExpr(ExprContext ctx) {
		// System.out.println("visitExpr " + ctx.getText());
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		OfpType type = visitChildren(ctx);
		if (temp == OfpType.Undef) {
			// temp = visit(ctx.getParent().getChild(0));
			name = ctx.getText();
			System.out.println(ctx.getText() + " " + ctx.getStart().getLine() + " " + currentScope.getScopeName());
			if (search(ctx.getText())) {
				System.out.println("Taken");
				type = getType(ctx.getText());
			}
		}
		typeEqual(temp, type, ctx, name, ctx.getStart().getLine());

		return type;
	}

	@Override
	public OfpType visitMethodAccess(MethodAccessContext ctx) {
		OfpType type = visit(ctx.getChild(0));
		// System.out.println("METHOD ACCESS: " + type.name());
		typeEqual(temp, type, ctx, name, ctx.getStart().getLine());
		return type;
	}

	@Override
	public OfpType visitArrayList(ArrayListContext ctx) {
		// System.out.println("Test ArrayList " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitStmt(StmtContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitMethodCall(MethodCallContext ctx) {
		if (scopes.get(ctx) != null) {
			currentScope = scopes.get(ctx);
		}
		visitChildren(ctx);
		return null;
	}

	public void loadParser(OfpParser parser) {
		ruleNames = parser.getTokenNames();
		// System.out.println(parser.getTokenNames());
		/*
		 * for(String s : ruleNames) { System.out.println(s); }
		 */

		arrayValueMap.put(OfpType.FloatArray, OfpType.Float);
		arrayValueMap.put(OfpType.IntArray, OfpType.Int);
		arrayValueMap.put(OfpType.StringArray, OfpType.String);
		arrayValueMap.put(OfpType.CharArray, OfpType.Char);
	}

	public void typeEqual(OfpType idType, OfpType exprType, ParseTree ctx, String name, int line) {
		if (exprType != idType) {
			if (arrayValueMap.get(idType) != exprType) {

				if (idType != null && exprType != null) {
					errorListener.reportError(ErrorType.TypeMismatch, line,
							"Type mismatch on variable " + name + " [" + idType.name() + "," + exprType.name() + "]");
				}
			}
		}
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
				return false;
			}
			return true;
		}
		return false;
	}

	public OfpType getType(String varName) {
		if (currentScope.getEnclosingScope() != null) {
			if (currentScope.getEnclosingScope().resolve(varName) == null) {

				Scope s = currentScope.getEnclosingScope();
				while (s.getEnclosingScope() != null) {
					s = s.getEnclosingScope();
					if (s.resolve(varName) != null) {
						return s.resolve(varName).getType();
					}
				}
				return OfpType.Undef;
			}
			return currentScope.getEnclosingScope().resolve(varName).getType();
		}
		return OfpType.Undef;
	}

	public void checkExist(String varName, ParseTree ctx, int line) {
		if (!search(varName)) {
			errorListener.reportError(ErrorType.SemanticError, line, "Variable " + varName + " is not defined!");
		}
	}

	/*
	 * public String resolveName(ParseTree ctx) { return
	 * ruleNames[ctx.getRuleIndex()]; }
	 */

	/*
	 * public void visitAllChildren(ParseTree ctx) { for(int i = 0; i <
	 * ctx.getChildCount(); i++) { visit(ctx.getChild(i)); } }
	 */

}
