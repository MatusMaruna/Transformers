package pythonGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import symbolTable.*;
import typeCheck.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser.ArrTypeContext;
import antlr4.OfpParser.ArrayContext;
import antlr4.OfpParser.ArrayListContext;
import antlr4.OfpParser.AsgnStmtContext;
import antlr4.OfpParser.BlockContext;
import antlr4.OfpParser.ConditionContext;
import antlr4.OfpParser.DeclarationContext;
import antlr4.OfpParser.ElseStmtContext;
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

public class PythonCodeGenerator extends OfpBaseVisitor<String> {
	private static HashSet<String> reservedIds = new HashSet<String>(Arrays.asList("ArithmeticError", "AssertionError",
			"AttributeError", "BaseException", "BlockingIOError", "BrokenPipeError", "BufferError", "BytesWarning",
			"ChildProcessError", "ConnectionAbortedError", "ConnectionError", "ConnectionRefusedError",
			"ConnectionResetError", "DeprecationWarning", "EOFError", "Ellipsis", "EnvironmentError", "Exception",
			"False", "FileExistsError", "FileNotFoundError", "FloatingPointError", "FutureWarning", "GeneratorExit",
			"IOError", "ImportError", "ImportWarning", "IndentationError", "IndexError", "InterruptedError",
			"IsADirectoryError", "KeyError", "KeyboardInterrupt", "LookupError", "MemoryError", "NameError", "None",
			"NotADirectoryError", "NotImplemented", "NotImplementedError", "OSError", "OverflowError",
			"PendingDeprecationWarning", "PermissionError", "ProcessLookupError", "RecursionError", "ReferenceError",
			"ResourceWarning", "RuntimeError", "RuntimeWarning", "StopAsyncIteration", "StopIteration", "SyntaxError",
			"SyntaxWarning", "SystemError", "SystemExit", "TabError", "TimeoutError", "True", "TypeError",
			"UnboundLocalError", "UnicodeDecodeError", "UnicodeEncodeError", "UnicodeError", "UnicodeTranslateError",
			"UnicodeWarning", "UserWarning", "ValueError", "Warning", "ZeroDivisionError", "__build_class__",
			"__debug__", "__doc__", "__import__", "__loader__", "__name__", "__package__", "__spec__", "abs", "all",
			"any", "ascii", "bin", "bool", "bytearray", "bytes", "callable", "chr", "classmethod", "compile", "complex",
			"copyright", "credits", "delattr", "dict", "dir", "divmod", "enumerate", "eval", "exec", "exit", "filter",
			"float", "format", "frozenset", "getattr", "globals", "hasattr", "hash", "help", "hex", "id", "input",
			"int", "isinstance", "issubclass", "iter", "len", "license", "list", "locals", "map", "max", "memoryview",
			"min", "next", "object", "oct", "open", "ord", "pow", "print", "property", "quit", "range", "repr",
			"reversed", "round", "set", "setattr", "slice", "sorted", "staticmethod", "str", "sum", "super", "tuple",
			"type", "vars", "zip"));
	private int depth = 0;
	private HashMap<Integer, String> indentCache = new HashMap<Integer, String>();
	private Scope currentScope;
	private Scope globalScope;
	private ParseTreeProperty<Scope> scopes;

	public PythonCodeGenerator(ParseTreeProperty<Scope> scopes) {
		this.scopes = scopes;
	}

	private static String getSafePythonId(String id) {
		if (reservedIds.contains(id)) {
			return "ofp_" + id;
		} else {
			return id;
		}
	}

	private String indent(int indentLevel) {
		String ind = indentCache.get(indentLevel);
		if (ind == null) {
			ind = "";
			for (int i = 0; i < indentLevel; i++) {
				ind += "    ";
				indentCache.put(indentLevel, ind);
			}
		}
		return ind;
	}

	@Override // while (i < x+1) { == in python while i < x + 1:
	public String visitWhileStmt(WhileStmtContext ctx) {
		currentScope = scopes.get(ctx);
		//System.out.println("visit WhileStmt");
		StringBuilder buf = new StringBuilder();

		buf.append(ctx.getChild(0).getText() + " " + visit(ctx.getChild(2)) + ":\n");
		depth = depth + 1;

		buf.append(visit(ctx.getChild(4))); // visit block child

		depth = depth - 1;
		currentScope = currentScope.getEnclosingScope();
		// buf.append("\n");
		return buf.toString();
	}

	@Override
	public String visitMethod(MethodContext ctx) {
		currentScope = scopes.get(ctx);
		//System.out.println("Visiting method" + ctx.getChild(1).getText());
		StringBuilder buf = new StringBuilder();
		buf.append("def " + ctx.getChild(1).getText() + "("); // def functionName(
		if (ctx.getChild(3).getText() != ")") { // check if function has params
			buf.append(visit(ctx.getChild(3)));
		}
		buf.append("):\n");
		depth = depth + 1;

		buf.append(visit(ctx.getChild(ctx.getChildCount() - 1))); // Visit block
		depth = depth - 1;
		buf.append("\n");
		currentScope = currentScope.getEnclosingScope();
		return buf.toString();
	}

	@Override
	public String visitStart(StartContext ctx) {
		//System.out.println("Visiting start");
		currentScope = scopes.get(ctx);
		globalScope = currentScope;
		StringBuilder buf = new StringBuilder();
		// main must be generated last
		ParserRuleContext main = new ParserRuleContext();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			ParserRuleContext p = (ParserRuleContext) ctx.getChild(i);
			String fName = p.getChild(1).getText();
			if (fName.equals("main")) {
				main = p;
			} else {
				buf.append(visit(p));
			}

		}
		buf.append(visit(main));
		return buf.toString();
	}

	@Override
	public String visitArrType(ArrTypeContext ctx) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			buf.append(getSafePythonId(visit(ctx.getChild(i)))); // Visit '{' Expr '}'
		}
		return buf.toString();
	}

	@Override
	public String visitMain(MainContext ctx) {
		//System.out.println("Visitng main");
		currentScope = scopes.get(ctx);
		String start = "#\n#  Program entry point - main \n#\n";

		depth = 0;
		String body = visit(ctx.getChild(4));

		currentScope = currentScope.getEnclosingScope();
		return start + body;
	}

	@Override
	public String visitElseStmt(ElseStmtContext ctx) {
		currentScope = scopes.get(ctx);
		StringBuilder buf = new StringBuilder();

		ParseTree ifStmt = ctx.getChild(1).getChild(0);

		// For printing the elif: check if elseStmt-stmt-ifStmt contains an "if" as
		// child 0
		if ((ifStmt.getChildCount() > 1) && (ifStmt.getChild(0).getText().equals("if"))) {
			// if (ifStmt.getChild(0).getText().equals("if")) {
			// if it contains an "if", append the "elif" and visit the second child of the
			// ifStmt scope which is the condition
			buf.append(indent(depth) + "elif " + visit(ifStmt.getChild(2)) + ":\n");
			depth = depth + 1;

			// if this ifStmt child number 4 is not a bracket, we visit this child
			if (!(ifStmt.getChild(4).getChild(0).getText().equals("{"))) { // if first child is // block|stmt
				buf.append(indent(depth) + visit(ifStmt.getChild(4)) + "\n"); // indent if stmt
			} else {
				buf.append(visit(ifStmt.getChild(4))); // no indent if block
			}

			depth = depth - 1;
			// if the else statement has another else at the endor other child
			// we print "else" and visit this child
			if (ifStmt.getChildCount() > 4) {
				for (int i = 5; i < ifStmt.getChildCount(); i++) {
					buf.append(indent(depth) + "else:" + "\n");
					depth = depth + 1;
					// if there is no more if statement after the "else"
					// visit the next childs first child
					if (!ifStmt.getText().equals("if")) {
						buf.append(indent(depth) + visit(ifStmt.getChild(i).getChild(1))); // no indent if block
					}

				}
			}
		} else {
			buf.append(indent(depth) + "else:" + "\n");

			depth = depth + 1;

			/*
			 * if (!(ctx.getChild(1).getChild(0).getText().equals("{")) ||
			 * !ctx.getChild(1).getChild(0).getText().equals("ifStmt")) { // if first child
			 * is block|stmt buf.append(visit(ctx.getChild(1))); // indent if stmt }
			 */

			// indent 4 spaces if if statement has NO bracket "{"
			if (!(ctx.getChild(1).getChild(0).getText().equals("{"))) { // if first child is block|stmt
				buf.append(indent(depth) + visit(ctx.getChild(1))); // indent if stmt
			} else {
				// else no indentation
				buf.append(visit(ctx.getChild(1))); // no indent if block
			}
		}
		depth = depth - 1;
		currentScope = currentScope.getEnclosingScope();
		return buf.toString();
	}

	@Override
	public String visitReturnStmt(ReturnStmtContext ctx) {
		StringBuilder buf = new StringBuilder();

		buf.append("return " + visit(ctx.getChild(1)));

		return buf.toString();
	}

	@Override
	public String visitType(TypeContext ctx) {
		return null;
	}

	@Override
	public String visitDeclaration(DeclarationContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append(getSafePythonId(ctx.getChild(1).getText()) + "="); // get name of the variable

		buf.append(visit(ctx.getChild(3))); // expr|arrType|array

		return buf.toString();
	}

	@Override
	public String visitVarType(VarTypeContext ctx) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i).toString().equals("true")) {
				buf.append("True");
			} else if (ctx.getChild(i).toString().equals("false")) {
				buf.append("False");
			} else {
				buf.append(ctx.getChild(i).toString());
			}
		}

		return buf.toString();
	}

	@Override // weird grammar
	public String visitCondition(ConditionContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append(visit(ctx.getChild(0)));
		return buf.toString();
	}

	@Override // println(f[f.length-1]) == print(f[f.length-1]) ->in py
	// FIX~
	public String visitPrint(PrintContext ctx) {
		//System.out.println("Visiting Print");
		StringBuilder buf = new StringBuilder();

		buf.append("print");

		for (int i = 1; i < ctx.getChildCount(); i++) { // start at child 2 "("
			if (!ctx.getChild(i).getText().equals(";")) { // finish and not print ";"
				buf.append(getSafePythonId(visit(ctx.getChild(i))));
			}
		}

		if(ctx.getChild(0).getText().equals("print")){
			buf.deleteCharAt(buf.lastIndexOf(")"));
			buf.append(", end=\" \")");
		}
		return buf.toString();
	}

	@Override // if (x < 10) { ==> python equal if x < 10:
	public String visitIfStmt(IfStmtContext ctx) {
		currentScope = scopes.get(ctx);
		//System.out.println("visit IfStmt");
		StringBuilder buf = new StringBuilder();

		buf.append(ctx.getChild(0).getText() + " " + visit(ctx.getChild(2)) + ":\n");

		depth = depth + 1;

		if (!(ctx.getChild(4).getChild(0).getText().equals("{"))) { // if first child is block|stmt
			buf.append(indent(depth) + visit(ctx.getChild(4)) + "\n"); // indent if stmt
		} else {
			buf.append(visit(ctx.getChild(4))); // no indent if block
		}

		depth = depth - 1;

		if (ctx.getChildCount() > 4) {
			for (int i = 5; i < ctx.getChildCount(); i++) {
				buf.append(visit(ctx.getChild(i)));
			}
		}
		currentScope = currentScope.getEnclosingScope();
		// buf.append("\n");
		return buf.toString();
	}

	@Override
	public String visitMethodAccess(MethodAccessContext ctx) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			buf.append(getSafePythonId(visit(ctx.getChild(i))));
		}

		return buf.toString();
	}

	@Override
	public String visitArray(ArrayContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append("[");
		buf.append(visit(ctx.getChild(1))); // ArrayList
		buf.append(']');

		return buf.toString();
	}

	@Override
	public String visitAsgnStmt(AsgnStmtContext ctx) {
		//System.out.println("visit Asgn");

		StringBuilder buf = new StringBuilder();
		// System.out.println("COUNT " + ctx.getChildCount() + " " +
		// ctx.getChild(1).getText());
		if (ctx.getChild(1).getText().equals("=")) {
			buf.append(getSafePythonId(visit(ctx.getChild(0))) + "="); // get name of the variable
			buf.append(visit(ctx.getChild(2))); // print what comes after "="
		} else {
			buf.append(getSafePythonId(visit(ctx.getChild(0))) + getSafePythonId(visit(ctx.getChild(1))) + "=");
			buf.append(visit(ctx.getChild(3))); // print what comes after "="
		}
		// buf.append(getSafePythonId(ctx.getChild(0).getText() +
		// ctx.getChild(1).getText()) + "=");

		return buf.toString();
	}

	@Override
	public String visitParameter(ParameterContext ctx) {
		return null;
	}

	@Override
	public String visitLocalDecl(LocalDeclContext ctx) {
		StringBuilder buf = new StringBuilder();
		// int y; => python equal pass (see moodle page)

		if (currentScope.getScopeName().contains("ifStmt")) {
			buf.append("pass");
		}
		return buf.toString();
	}

	@Override
	public String visitParameterList(ParameterListContext ctx) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i += 2) { // param1,param2,param3
			buf.append(getSafePythonId(ctx.getChild(i).getChild(1).getText())); // get name leave type
			if (i + 2 < ctx.getChildCount()) {
				buf.append(","); // seperate params
			}
		}
		return buf.toString();
	}

	@Override
	public String visitBlock(BlockContext ctx) {
		StringBuilder buf = new StringBuilder();

		for (int i = 1; i < ctx.getChildCount() - 1; i++) {
			buf.append(indent(depth) + visit(ctx.getChild(i)) + "\n");
		}

		return buf.toString();
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		StringBuilder buf = new StringBuilder();
		//System.out.println(ctx.getText());
		int children = ctx.getChildCount();
		switch (children) {
		case 1:
			// If first sibling is return and child is true or false do not check
			// for safe python id
			if ((ctx.getChild(0).getChild(0).getText().equals("true")
							|| ctx.getChild(0).getChild(0).getText().equals("false"))) {
				buf.append(visit(ctx.getChild(0)));
			} else {
				buf.append(getSafePythonId(visit(ctx.getChild(0))));
			}
			// System.out.println(ctx.getChild(0).getText());
			break;

		case 2:
			if (ctx.getChild(0).getText().equals("new")) {
				buf.append("[None]*");
				buf.append(getSafePythonId(visit(ctx.getChild(1).getChild(1).getChild(1))));
			} else {
				buf.append("len(" + getSafePythonId(ctx.getChild(0).getText()) + ")");
			}
			break;
		default:
			for (int i = 0; i < ctx.getChildCount(); i++) {
				buf.append(visit(ctx.getChild(i)));
			}
		}
		return buf.toString();
	}

	@Override
	public String visitArrayList(ArrayListContext ctx) {
		StringBuilder buf = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			buf.append(getSafePythonId(visit(ctx.getChild(i))));
		}

		return buf.toString();
	}

	@Override
	public String visitStmt(StmtContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append(visit(ctx.getChild(0)));
		return buf.toString();
	}

	@Override
	public String visitMethodCall(MethodCallContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append(ctx.getChild(0).getText() + "("); // MethodName(
		for (int i = 2; i < ctx.getChildCount(); i++) {
			if (!ctx.getChild(i).getText().equals(";")) { // finish and not print ";"
				buf.append(getSafePythonId(visit(ctx.getChild(i))));
			}
		}

		return buf.toString();
	}

	@Override
	public String visitTerminal(TerminalNode terminalNode) {
		return terminalNode.getText();
	}

	@Override
	public String visitErrorNode(ErrorNode errorNode) {
		return null;
	}
}
