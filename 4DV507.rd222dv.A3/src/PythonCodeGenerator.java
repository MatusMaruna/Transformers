import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
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
import antlr4.OfpVisitor;

public class PythonCodeGenerator extends OfpBaseVisitor<OfpType> {

	@Override
	public OfpType visitWhileStmt(WhileStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitMethod(MethodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitStart(StartContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitArrType(ArrTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitMain(MainContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitElseStmt(ElseStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitReturnStmt(ReturnStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitVarType(VarTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitIfStmt(IfStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitMethodAccess(MethodAccessContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitArray(ArrayContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitAsgnStmt(AsgnStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitArrayList(ArrayListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitStmt(StmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfpType visitMethodCall(MethodCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
