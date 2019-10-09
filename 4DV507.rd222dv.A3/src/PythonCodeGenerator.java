import org.antlr.v4.runtime.tree.*;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PythonCodeGenerator extends OfpBaseVisitor<String> {
	private static HashSet<String> reservedIds = new HashSet<String>(Arrays.asList("ArithmeticError",
			"AssertionError", "AttributeError","BaseException", "BlockingIOError", "BrokenPipeError",
			"BufferError", "BytesWarning", "ChildProcessError", "ConnectionAbortedError",
			"ConnectionError", "ConnectionRefusedError", "ConnectionResetError",
			"DeprecationWarning", "EOFError", "Ellipsis", "EnvironmentError",
			"Exception", "False", "FileExistsError", "FileNotFoundError",
			"FloatingPointError", "FutureWarning", "GeneratorExit", "IOError",
			"ImportError", "ImportWarning", "IndentationError", "IndexError",
			"InterruptedError", "IsADirectoryError", "KeyError", "KeyboardInterrupt",
			"LookupError", "MemoryError", "NameError", "None", "NotADirectoryError",
			"NotImplemented", "NotImplementedError", "OSError", "OverflowError",
			"PendingDeprecationWarning", "PermissionError", "ProcessLookupError",
			"RecursionError", "ReferenceError", "ResourceWarning", "RuntimeError",
			"RuntimeWarning", "StopAsyncIteration", "StopIteration", "SyntaxError",
			"SyntaxWarning", "SystemError", "SystemExit", "TabError", "TimeoutError",
			"True", "TypeError", "UnboundLocalError", "UnicodeDecodeError",
			"UnicodeEncodeError", "UnicodeError", "UnicodeTranslateError",
			"UnicodeWarning", "UserWarning", "ValueError", "Warning",
			"ZeroDivisionError", "__build_class__", "__debug__", "__doc__",
			"__import__", "__loader__", "__name__", "__package__", "__spec__",
			"abs", "all", "any", "ascii", "bin", "bool", "bytearray", "bytes",
			"callable", "chr", "classmethod", "compile", "complex", "copyright",
			"credits", "delattr", "dict", "dir", "divmod", "enumerate", "eval",
			"exec", "exit", "filter", "float", "format", "frozenset", "getattr",
			"globals", "hasattr", "hash", "help", "hex", "id", "input", "int",
			"isinstance", "issubclass", "iter", "len", "license", "list", "locals",
			"map", "max", "memoryview", "min", "next", "object", "oct", "open",
			"ord", "pow", "print", "property", "quit", "range", "repr", "reversed",
			"round", "set", "setattr", "slice", "sorted", "staticmethod", "str",
			"sum", "super", "tuple", "type", "vars", "zip"));
    private int depth = 0;
    private HashMap<Integer,String> indentCache = new HashMap<Integer,String>();
    private Scope currentScope;
    private Scope globalScope;
    private ParseTreeProperty<Scope> scopes;



    public PythonCodeGenerator(ParseTreeProperty<Scope> scopes){
    	this.scopes = scopes;
	}


    private static String getSafePythonId(String id){
    	if(reservedIds.contains(id)) {
			return "ofp_" + id;
		}else{
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
			return ind;
		}
		return null; // Not sure what to return here yet
	}

	@Override
	public String visitWhileStmt(WhileStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMethod(MethodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStart(StartContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArrType(ArrTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMain(MainContext ctx) {
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
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArrayList(ArrayListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStmt(StmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMethodCall(MethodCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
