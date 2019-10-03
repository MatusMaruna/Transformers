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
		System.out.println("Test ErrorNode " + arg0.getText());
		return null;
	}

	@Override
	public Symbol visitTerminal(TerminalNode arg0) {
		System.out.println("Test Terminal: " + arg0.getText());
		return null;
	}

	@Override
	public Symbol visitWhileStmt(WhileStmtContext ctx) {
		System.out.println("Test While " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitMethod(MethodContext ctx) {
		System.out.println("Test Method " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitStart(StartContext ctx) {
		System.out.println("Test Start " + ctx.getText());
		//visitAllChildren(ctx);
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArrType(ArrTypeContext ctx) {
		System.out.println("Test ArrType " + ctx.getText());
		return null;
	}

	@Override
	public Symbol visitMain(MainContext ctx) {
		System.out.println("Test Main " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitReturnStmt(ReturnStmtContext ctx) {
		System.out.println("Test Return " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitType(TypeContext ctx) {
		System.out.println("Test Type " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitDeclaration(DeclarationContext ctx) {
		System.out.println("Test Decl " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitVarType(VarTypeContext ctx) {
		System.out.println("Test VarType " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitCondition(ConditionContext ctx) {
		System.out.println("Test Condition " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitPrint(PrintContext ctx) {
		System.out.println("Test Print " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitIfStmt(IfStmtContext ctx) {
		System.out.println("Test ifstmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArray(ArrayContext ctx) {
		System.out.println("Test array " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitAsgnStmt(AsgnStmtContext ctx) {
		System.out.println("Test AsgnStmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitParameter(ParameterContext ctx) {
		System.out.println("Test Parameter " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitLocalDecl(LocalDeclContext ctx) {
		System.out.println("Test LocalDecl " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitParameterList(ParameterListContext ctx) {
		System.out.println("Test ParamList " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitBlock(BlockContext ctx) {
		System.out.println("Test Block " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitExpr(ExprContext ctx) {
		System.out.println("Test Expr " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitArrayList(ArrayListContext ctx) {
		System.out.println("Test ArrayList " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitStmt(StmtContext ctx) {
		System.out.println("Test Stmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Symbol visitMethodCall(MethodCallContext ctx) {
		System.out.println("Test MethodCall " + ctx.getText());
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
