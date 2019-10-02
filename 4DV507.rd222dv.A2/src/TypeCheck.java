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
import antlr4.OfpParser.ExprContext;
import antlr4.OfpParser.IfStmtContext;
import antlr4.OfpParser.LocalDeclContext;
import antlr4.OfpParser.MainContext;
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





public class TypeCheck extends OfpBaseVisitor<Symbol> {

	@Override
	public Symbol visit(ParseTree arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitChildren(RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitWhileStmt(WhileStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitMethod(MethodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitStart(StartContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitArrType(ArrTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitMain(MainContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitReturnStmt(ReturnStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitVarType(VarTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitCondition(ConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitIfStmt(IfStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitArray(ArrayContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitAsgnStmt(AsgnStmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitParameter(ParameterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitLocalDecl(LocalDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitParameterList(ParameterListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitArrayList(ArrayListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitStmt(StmtContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visitMethodCall(MethodCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
}