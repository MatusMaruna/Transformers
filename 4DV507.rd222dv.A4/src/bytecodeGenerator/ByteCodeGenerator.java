package bytecodeGenerator;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser;
import antlr4.OfpVisitor;
import org.antlr.v4.runtime.tree.*;
import org.objectweb.asm.Type;
import symbolTable.OfpType;
import symbolTable.Scope;
import symbolTable.Symbol;

public class ByteCodeGenerator extends OfpBaseVisitor<Type> {

    private  ParseTreeProperty<Scope> scopes;
    private String progName;
    private Scope currentScope;
    private Scope globalScope;

    public ByteCodeGenerator(ParseTreeProperty<Scope> scopes, String progName) {
        this.scopes = scopes;
        this.progName = progName;

    }


    @Override
    public Type visitStart(OfpParser.StartContext ctx) {
        System.out.println("Hello World");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitMain(OfpParser.MainContext ctx) {
        System.out.println("Visiting main");
        System.out.println(scopes.get(ctx).getFunctionSymbol().indecies.toString());
        System.out.println(scopes.get(ctx).getFunctionSymbol().indexOf(new Symbol("n", "int")));
        return null;
    }

    @Override
    public Type visitMethod(OfpParser.MethodContext ctx) {
        System.out.println("Visiting method");
        System.out.println(scopes.get(ctx).getFunctionSymbol().indecies.toString());
        return null;
    }

    @Override
    public Type visitParameter(OfpParser.ParameterContext ctx) {
        return null;
    }

    @Override
    public Type visitParameterList(OfpParser.ParameterListContext ctx) {
        return null;
    }

    @Override
    public Type visitBlock(OfpParser.BlockContext ctx) {
        return null;
    }

    @Override
    public Type visitReturnStmt(OfpParser.ReturnStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitType(OfpParser.TypeContext ctx) {
        return null;
    }

    @Override
    public Type visitVarType(OfpParser.VarTypeContext ctx) {
        return null;
    }

    @Override
    public Type visitStmt(OfpParser.StmtContext ctx) {
        return null;
    }

    @Override
    public Type visitExpr(OfpParser.ExprContext ctx) {
        return null;
    }

    @Override
    public Type visitMethodAccess(OfpParser.MethodAccessContext ctx) {
        return null;
    }

    @Override
    public Type visitLocalDecl(OfpParser.LocalDeclContext ctx) {
        return null;
    }

    @Override
    public Type visitDeclaration(OfpParser.DeclarationContext ctx) {
        return null;
    }

    @Override
    public Type visitAsgnStmt(OfpParser.AsgnStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitMethodCall(OfpParser.MethodCallContext ctx) {
        return null;
    }

    @Override
    public Type visitArrayList(OfpParser.ArrayListContext ctx) {
        return null;
    }

    @Override
    public Type visitArray(OfpParser.ArrayContext ctx) {
        return null;
    }

    @Override
    public Type visitArrType(OfpParser.ArrTypeContext ctx) {
        return null;
    }

    @Override
    public Type visitWhileStmt(OfpParser.WhileStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitIfStmt(OfpParser.IfStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitElseStmt(OfpParser.ElseStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitCondition(OfpParser.ConditionContext ctx) {
        return null;
    }

    @Override
    public Type visitPrint(OfpParser.PrintContext ctx) {
        return null;
    }

    @Override
    public Type visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Type visitErrorNode(ErrorNode errorNode) {
        return null;
    }

    public byte[] getByteArray() {


        return new byte[0];
    }
}
