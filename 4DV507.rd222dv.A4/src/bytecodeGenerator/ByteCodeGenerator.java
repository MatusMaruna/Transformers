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

        visitChildren(ctx);

        mg.returnValue();
        mg.endMethod();

        return null;
    }

    @Override
    public Type visitMethod(OfpParser.MethodContext ctx) {
        System.out.println("Visiting method");
        System.out.println(scopes.get(ctx).getFunctionSymbol().paramIndecies.toString());
 /*       StringBuilder sb = new StringBuilder();

        Type methodType = visit(ctx.getChild(0));
        System.out.println("From visited method: "+ methodType.getClassName());
        String id = ctx.getChild(1).getText();

        sb.append(methodType.getClassName()+ " ");
        sb.append(id + " ");
        sb.append("(");
        if(ctx.getChild(3).getText() != ")"){ // if the method doesnt have 0 params
            for(int i  = 0; i<ctx.getChild(3).getChildCount(); i+=2){
                sb.append(visit(ctx.getChild(3).getChild(i)).getClassName());
                if(i+2 < ctx.getChild(3).getChildCount()){
                    sb.append(",");
                }
            }
        }

        sb.append(")");

        System.out.println(sb.toString());

        Method m = Method.getMethod(sb.toString());
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, m, null, null, cw);
        for(int i = 0; i < scopes.get(ctx).getFunctionSymbol().paramIndecies.size(); i++){
            mg.loadArg(i);
        }


        visit(ctx.getChild(ctx.getChildCount()-1));

        mg.returnValue();
        mg.endMethod();



*/

        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitParameter(OfpParser.ParameterContext ctx) {
        System.out.println("Visiting param");
        switch(ctx.getChild(0).getText()){
            case "int":
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "char" :
                return Type.CHAR_TYPE;
        }
        return null;
    }

    @Override
    public Type visitParameterList(OfpParser.ParameterListContext ctx) {
        System.out.println("Visiting paramList");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitBlock(OfpParser.BlockContext ctx) {
        System.out.println("visiting Block");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitReturnStmt(OfpParser.ReturnStmtContext ctx) {
        System.out.println("return Stmt");
        visitChildren(ctx);

        return null;
    }

    @Override
    public Type visitType(OfpParser.TypeContext ctx) {
        System.out.println("visiting Type");

     /*  switch(ctx.getChild(0).getText()){
            case "int":
                System.out.println("IIIIINT");
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "char" :
                return Type.CHAR_TYPE;
            case "bool":
                return Type.BOOLEAN_TYPE;

        }*/
    /*    Type eType = visit(ctx.getChild(0)); // Push expr, return ASM expr type
        String type = null; // Select print type
        if (eType == Type.INT_TYPE) type = "int";
        else if (eType == Type.DOUBLE_TYPE) type = "double";
        else if (eType == Type.CHAR_TYPE) type = "char";
        else if (eType == Type.BOOLEAN_TYPE) type = "boolean";
*/
        return null;
    }

    @Override
    public Type visitVarType(OfpParser.VarTypeContext ctx) {

        return null;
    }

    @Override
    public Type visitStmt(OfpParser.StmtContext ctx) {
        System.out.println("visiting Stmt");
     /*   StringBuilder buf = new StringBuilder();
        buf.append(visit(ctx.getChild(0)));*/
        // System.out.println("stmtChild " + buf.toString() + " ");
        visit(ctx.getChild(0));
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
        System.out.println("visiting LocalDecl");
        System.out.println("LocalDecl "+scopes.get(ctx).getFunctionSymbol().variableIndecies.toString()); // b=0
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello LocalDecl!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));

        Type varType = visit(ctx.getChild(0));


        StringBuilder buf = new StringBuilder();
        buf.append(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText()); // get name of the variable
        System.out.println(buf.toString());


        visitChildren(ctx);

        return null;
    }

    @Override
    public Type visitDeclaration(OfpParser.DeclarationContext ctx) {
        System.out.println("visiting Declaration");
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello Declaration!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));

        Type varType = visit(ctx.getChild(0));
        Type valueT = visit(ctx.getChild(3));
        String value = ctx.getChild(3).getText();
        System.out.println("****value " + value);

     /*   mg.newLocal(varType);
        mg.push(valueT);*/

        mg.push(new Integer(25));
        mg.storeLocal(1,Type.INT_TYPE); // a = 25
        mg.push(new Integer(25));
        mg.push(new Integer(3));
        mg.loadLocal(1,Type.INT_TYPE);
        mg.math(GeneratorAdapter.MUL, Type.INT_TYPE);
        mg.math(GeneratorAdapter.ADD, Type.INT_TYPE);
        mg.storeLocal(2,Type.INT_TYPE); // b = 25 + 3*a

      /*  mg.loadLocal(1,Type.INT_TYPE);
        mg.loadLocal(2,Type.INT_TYPE);
        mg.invokeStatic(Type.getType("L"+"Plus"+";"),
                Method.getMethod("int plus(int,int)"));
        mg.storeLocal(3,Type.INT_TYPE); // Call Plus.plus(a,b)
*/
        // mg.storeLocal(1,varType.getReturnType()); // sum = 0
        //   mg.loadLocal(1, Type.INT_TYPE);

        visitChildren(ctx);
        
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


        switch(terminalNode.getText()){
            case "void":
                return Type.VOID_TYPE;
        }


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
