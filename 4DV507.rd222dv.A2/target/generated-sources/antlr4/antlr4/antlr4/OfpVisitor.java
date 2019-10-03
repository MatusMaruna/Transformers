// Generated from Ofp.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OfpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OfpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OfpParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull OfpParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull OfpParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull OfpParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#arrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrType(@NotNull OfpParser.ArrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(@NotNull OfpParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(@NotNull OfpParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull OfpParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull OfpParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(@NotNull OfpParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull OfpParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull OfpParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull OfpParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull OfpParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#asgnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgnStmt(@NotNull OfpParser.AsgnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull OfpParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#localDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDecl(@NotNull OfpParser.LocalDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(@NotNull OfpParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull OfpParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull OfpParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#arrayList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayList(@NotNull OfpParser.ArrayListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull OfpParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OfpParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull OfpParser.MethodCallContext ctx);
}