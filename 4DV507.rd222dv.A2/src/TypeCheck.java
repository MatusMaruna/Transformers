
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.RuleNode;
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

	public TypeCheck(ParseTreeProperty<Scope> scopes, ErrorListener errorListener) {
		this.scopes = scopes;
		this.errorListener = errorListener; 
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
	public OfpType visitErrorNode(ErrorNode arg0) {
		//System.out.println("Test ErrorNode " + arg0.getText());
		return null;
	}

	@Override
	public OfpType visitTerminal(TerminalNode arg0) {
		System.out.println("Test Terminal: " + arg0.getText());
		System.out.println(ruleNames[arg0.getSymbol().getType()]);
		
		switch(ruleNames[arg0.getSymbol().getType()]) {
			
			case "STR":
				return OfpType.String;
			case "INT": 
				return OfpType.Int;
			case "CHAR": 
				return OfpType.Char;
			case "FLOAT":
				return OfpType.Float;
			default: 
				return OfpType.Undef;
				
			
		}
		
	} 

	@Override
	public OfpType visitWhileStmt(WhileStmtContext ctx) {
		//System.out.println("Test While " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitMethod(MethodContext ctx) {
		//System.out.println("Test Method " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitStart(StartContext ctx) {
		//System.out.println("Test Start " + ctx.getText());
		//visitAllChildren(ctx);
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitArrType(ArrTypeContext ctx) {
		//System.out.println("Test ArrType " + ctx.getText());
		return null;
	}

	@Override
	public OfpType visitMain(MainContext ctx) {
		//System.out.println("Test Main " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitReturnStmt(ReturnStmtContext ctx) {
		//System.out.println("Test Return " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitType(TypeContext ctx) {
		//System.out.println("Test Type " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitDeclaration(DeclarationContext ctx) {
	//	System.out.println("Test Decl " + ctx.getText());
		
		String type = ctx.getChild(0).getText(); // Type
		String name = ctx.getChild(1).getText(); // Name
		String value = ctx.getChild(3).getText(); // Value
		OfpType exprType = visit(ctx.getChild(3));
		OfpType idType = scopes.get(ctx).resolve(name).getType();
		
		if(exprType != idType) {
			errorListener.reportError(ErrorType.TypeMismatch, ctx.getStart().getLine(),
					"Type mismatch on variable " + name + " [" + idType.name() + "," + exprType.name()+"]");
		}
	 // System.out.println(scopes.get(ctx).resolve(ctx.getChild(1).getText()).getType());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitVarType(VarTypeContext ctx) {
		//System.out.println("Test VarType " + ctx.getText());
		OfpType type = visitChildren(ctx);
		return type;
	}

	@Override
	public OfpType visitCondition(ConditionContext ctx) {
		//System.out.println("Test Condition " + ctx.getText());
		for(int i = 0; i < ctx.getChild(0).getChildCount(); i+=2) {
			String varName = ctx.getChild(0).getChild(i).getText();
			//System.out.println(varName);
		}
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitPrint(PrintContext ctx) {
		//System.out.println("Test Print " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitIfStmt(IfStmtContext ctx) {
		//System.out.println("Test ifstmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitArray(ArrayContext ctx) {
		//System.out.println("Test array " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitAsgnStmt(AsgnStmtContext ctx) {
		//System.out.println("Test AsgnStmt " + ctx.getText());
		String name = ctx.getChild(0).getText(); // Name
		OfpType idType = scopes.get(ctx).resolve(name).getType();
		OfpType exprType = visit(ctx.getChild(2));
		
		
		System.out.println("ID TYPE: " + idType.name());
		System.out.println("EXPR TYPE: " + idType.name());
		
		if(exprType != idType) {
			errorListener.reportError(ErrorType.TypeMismatch, ctx.getStart().getLine(),
					"Type mismatch on variable " + name + " [" + idType.name() + "," + exprType.name()+"]");
		}
	 // System.out.println(scopes.get(ctx).resolve(ctx.getChild(1).getText()).getType());
		visitChildren(ctx);
		
		
		
		
		
		
		
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitParameter(ParameterContext ctx) {
		//System.out.println("Test Parameter " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitLocalDecl(LocalDeclContext ctx) {
		//System.out.println("Test LocalDecl " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitParameterList(ParameterListContext ctx) {
		//System.out.println("Test ParamList " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitBlock(BlockContext ctx) {
		//System.out.println("Test Block " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitExpr(ExprContext ctx) {
		//System.out.println("Test Expr " + ctx.getText());
		OfpType type = visitChildren(ctx);
		return type;
	}

	@Override
	public OfpType visitArrayList(ArrayListContext ctx) {
		//System.out.println("Test ArrayList " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitStmt(StmtContext ctx) {
		//System.out.println("Test Stmt " + ctx.getText());
		visitChildren(ctx);
		return null;
	}

	@Override
	public OfpType visitMethodCall(MethodCallContext ctx) {
		//System.out.println("Test MethodCall " + ctx.getText());
		visitChildren(ctx);
		return null;
	}
	
	public void loadParser(OfpParser parser) {
		ruleNames = parser.getTokenNames();
		//System.out.println(parser.getTokenNames());
		/*for(String s : ruleNames) {
			System.out.println(s);
		}*/
	}
	
	
	/*public String resolveName(ParseTree ctx) {
		return ruleNames[ctx.getRuleIndex()];
	}*/

	/*public void visitAllChildren(ParseTree ctx)
	{
		for(int i = 0; i < ctx.getChildCount(); i++) {
			visit(ctx.getChild(i));
		}
	} */


}
