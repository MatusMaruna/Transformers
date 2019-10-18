package bytecodeGenerator;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser;
import antlr4.OfpVisitor;
import org.antlr.v4.runtime.tree.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import symbolTable.OfpType;
import symbolTable.Scope;
import symbolTable.Symbol;

import java.io.PrintStream;

import static org.objectweb.asm.Opcodes.*;

public class ByteCodeGenerator extends OfpBaseVisitor<Type> {

    private  ParseTreeProperty<Scope> scopes;
    private String progName;
    private Scope currentScope;
    private Scope globalScope;
    private ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    GeneratorAdapter mg;

    public ByteCodeGenerator(ParseTreeProperty<Scope> scopes, String progName) {
        this.scopes = scopes;
        this.progName = progName;

    }


    @Override
    public Type visitStart(OfpParser.StartContext ctx) {
        Method m = Method.getMethod("void <init>()");
        cw.visit(V1_1, ACC_PUBLIC, progName, null, "java/lang/Object", null);
        mg = new GeneratorAdapter(ACC_PUBLIC , m, null,null, cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();
        cw.visitEnd();
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitMain(OfpParser.MainContext ctx) {
        //System.out.println(scopes.get(ctx).getFunctionSymbol().indecies.toString());
        //System.out.println(scopes.get(ctx).getFunctionSymbol().indexOf(new Symbol("n", "int")));
        Method main = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, main, null,null, cw);
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello World!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
        mg.returnValue();
        mg.endMethod();

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


        return cw.toByteArray();
    }
}
