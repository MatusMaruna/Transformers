import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
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
		System.out.println("visit WhileStmt");
		StringBuilder buf = new StringBuilder();
		buf.append(ctx.getChild(0).getText() + " " + ctx.getChild(2).getText() + ":\n");

		for (int i = 5; i < ctx.getChildCount(); i++) {
			buf.append(visit(ctx.getChild(i)) + "\n");
		}
		// currentScope = currentScope.getEnclosingScope();
		// buf.append("\n");
		return buf.toString();
	}

	@Override
	public String visitMethod(MethodContext ctx) {
		currentScope = scopes.get(ctx);
		System.out.println("Visiting method" + ctx.getChild(1).getText());
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
		return buf.toString();
	}

	@Override
	public String visitStart(StartContext ctx) {
		System.out.println("Visiting start");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMain(MainContext ctx) {
		System.out.println("Visitng main");
		currentScope = scopes.get(ctx);
		String start = "#\n#  Program entry point - main \n#\n";

		depth = 0;
		String body = visit(ctx.getChild(4));

		currentScope = currentScope.getEnclosingScope();
		return start + body;
	}

	@Override
	public String visitElseStmt(ElseStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitReturnStmt(ReturnStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // println(f[f.length-1]) == print(f[f.length-1]) ->in py
	public String visitPrint(PrintContext ctx) {
		System.out.println("Visiting Print");
		StringBuilder buf = new StringBuilder();
		buf.append("print(");

		for (int i = 2; i < ctx.getChildCount(); i++) { // start at child 2 "("
			if (!ctx.getChild(i).getText().equals(";")) { // finish and not print ";"
				buf.append(ctx.getChild(i).getText());
			}
		}

		buf.append("\n");
		return buf.toString();
	}

	@Override
	public String visitIfStmt(IfStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMethodAccess(MethodAccessContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArray(ArrayContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitAsgnStmt(AsgnStmtContext ctx) {
		System.out.println("visit Asgn");

		StringBuilder buf = new StringBuilder();
		System.out.println("COUNT " + ctx.getChildCount() + " " + ctx.getChild(1).getText());
		if (ctx.getChild(1).getText().equals("=")) {
			buf.append(getSafePythonId(ctx.getChild(0).getText()) + "="); // get name of the variable
			buf.append(visit(ctx.getChild(2))); // print what comes after "="
		} else {
			buf.append(getSafePythonId(ctx.getChild(0).getText() + ctx.getChild(1).getText()) + "=");
			buf.append(visit(ctx.getChild(3))); // print what comes after "="
		}
		// buf.append(getSafePythonId(ctx.getChild(0).getText() +
		// ctx.getChild(1).getText()) + "=");

		return buf.toString();
	}

	@Override
	public String visitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
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
		buf.append(indent(depth) + "# Test in method\n"); // test declaration in Block

		for (int i = 0; i < ctx.getChildCount(); i++) {
			buf.append(indent(depth) + visit(ctx.getChild(i)) + "\n");
		}

		return buf.toString();
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		StringBuilder buf = new StringBuilder();

		// int[] a=new int[10,11]; = python equal is a=[10,11] FIXME?
		if (ctx.getChild(0).getText().equals("new")) {
			buf.append(ctx.getChild(1).getChild(1).getText());
			// if childcount is > 1 => ex: q = 3*3; -> so expr is 3*3, loop over all
			// children +append text
		} else if (ctx.getChildCount() > 1) {
			for (int i = 0; i < ctx.getChildCount(); i++) {
				buf.append(ctx.getChild(i).getText());
			}
		} else {
			buf.append(ctx.getChild(0).getText());
		}
		return buf.toString();

	}

	@Override
	public String visitArrayList(ArrayListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStmt(StmtContext ctx) {
		StringBuilder buf = new StringBuilder();
		buf.append(visit(ctx.getChild(0)));
		return buf.toString();
	}

	@Override
	public String visitMethodCall(MethodCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTerminal(TerminalNode terminalNode) {
		return null;
	}

	@Override
	public String visitErrorNode(ErrorNode errorNode) {
		return null;
	}
}
