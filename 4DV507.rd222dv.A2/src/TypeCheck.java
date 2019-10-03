import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

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
	Scope currentScope;
	ParseTreeProperty<Scope> scopes;

	public TypeCheck(ParseTreeProperty<Scope> scopes) {
		this.scopes = scopes;
		scopes.toString();
	}



	/*
	@Override
	public Symbol visit(ParseTree arg0) {
		//System.out.println(arg0.getText());
		System.out.println(scopes.get(arg0));
		System.out.println(arg0.getChildCount());
		System.out.println(arg0.getChild(0).getText());
		//visit(arg0.getChild(0));
		return null;
	} */

/*	@Override
	public Symbol visitChildren(RuleNode arg0) {
		System.out.println("Test Child");
		visitAllChildren(ctx);
		return null;
	} */

	@Override
	public Symbol visitErrorNode(ErrorNode arg0) {
		System.out.println("Test ErrorNode");
		return null;
	}

	@Override
	public Symbol visitTerminal(TerminalNode arg0) {
		System.out.println("Test Terminal");
		return null;
	}

	@Override
	public Symbol visitWhileStmt(WhileStmtContext ctx) {
		System.out.println("Test While");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitMethod(MethodContext ctx) {
		System.out.println("Test Method");
		return null;
	}

	@Override
	public Symbol visitStart(StartContext ctx) {
		System.out.println("Test Start");
		//visitAllChildren(ctx);
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArrType(ArrTypeContext ctx) {
		System.out.println("Test ArrType");
		return null;
	}

	@Override
	public Symbol visitMain(MainContext ctx) {
		System.out.println("Test Main");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitReturnStmt(ReturnStmtContext ctx) {
		System.out.println("Test Return");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitType(TypeContext ctx) {
		System.out.println("Test Type");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitDeclaration(DeclarationContext ctx) {
		System.out.println("Test Decl");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitVarType(VarTypeContext ctx) {
		System.out.println("Test VarType");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitCondition(ConditionContext ctx) {
		System.out.println("Test Condition");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitPrint(PrintContext ctx) {
		System.out.println("Test Print");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitIfStmt(IfStmtContext ctx) {
		System.out.println("Test ifstmt");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArray(ArrayContext ctx) {
		System.out.println("Test array");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitAsgnStmt(AsgnStmtContext ctx) {
		System.out.println("Test AsgnStmt");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitParameter(ParameterContext ctx) {
		System.out.println("Test Parameter");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitLocalDecl(LocalDeclContext ctx) {
		System.out.println("Test LocalDecl");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitParameterList(ParameterListContext ctx) {
		System.out.println("Test ParamList");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitBlock(BlockContext ctx) {
		System.out.println("Test Block");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitExpr(ExprContext ctx) {
		System.out.println("Test Expr");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArrayList(ArrayListContext ctx) {
		System.out.println("Test ArrayList");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitStmt(StmtContext ctx) {
		System.out.println("Test Stmt");
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitMethodCall(MethodCallContext ctx) {
		System.out.println("Test MethodCall");
		visitChildren(ctx);
		return null;
	}

	/*public void visitAllChildren(ParseTree ctx)
	{
		for(int i = 0; i < ctx.getChildCount(); i++) {
			visit(ctx.getChild(i));
		}
	} */


}
