// Generated from Ofp.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OfpParser}.
 */
public interface OfpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OfpParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(@NotNull OfpParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(@NotNull OfpParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(@NotNull OfpParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(@NotNull OfpParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull OfpParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull OfpParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#arrType}.
	 * @param ctx the parse tree
	 */
	void enterArrType(@NotNull OfpParser.ArrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#arrType}.
	 * @param ctx the parse tree
	 */
	void exitArrType(@NotNull OfpParser.ArrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(@NotNull OfpParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(@NotNull OfpParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(@NotNull OfpParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(@NotNull OfpParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull OfpParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull OfpParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull OfpParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull OfpParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(@NotNull OfpParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(@NotNull OfpParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull OfpParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull OfpParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull OfpParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull OfpParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull OfpParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull OfpParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull OfpParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull OfpParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#asgnStmt}.
	 * @param ctx the parse tree
	 */
	void enterAsgnStmt(@NotNull OfpParser.AsgnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#asgnStmt}.
	 * @param ctx the parse tree
	 */
	void exitAsgnStmt(@NotNull OfpParser.AsgnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull OfpParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull OfpParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalDecl(@NotNull OfpParser.LocalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalDecl(@NotNull OfpParser.LocalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(@NotNull OfpParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(@NotNull OfpParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull OfpParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull OfpParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull OfpParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull OfpParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#arrayList}.
	 * @param ctx the parse tree
	 */
	void enterArrayList(@NotNull OfpParser.ArrayListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#arrayList}.
	 * @param ctx the parse tree
	 */
	void exitArrayList(@NotNull OfpParser.ArrayListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull OfpParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull OfpParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OfpParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull OfpParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link OfpParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull OfpParser.MethodCallContext ctx);
}