package bytecodeGenerator;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser;
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
        currentScope = scopes.get(ctx);
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
        //System.out.println(scopes.get(ctx).getFunctionSymbol().indexOf(new Symbol("n", "int")));
        currentScope = scopes.get(ctx);
        Method main = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, main, null,null, cw);
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello World!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
        visit(ctx.getChild(ctx.getChildCount()-1));
        mg.returnValue();
        mg.endMethod();

        return null;
    }

    @Override
    public Type visitMethod(OfpParser.MethodContext ctx) {
        StringBuilder sb = new StringBuilder();
        currentScope = scopes.get(ctx);

        Type methodType = visit(ctx.getChild(0));
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





        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitParameter(OfpParser.ParameterContext ctx) {
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
        visitChildren(ctx);
        return null;
    }
   // block: '{' stmt* '}' ;
    @Override
    public Type visitBlock(OfpParser.BlockContext ctx) {
        visitChildren(ctx);

        return null;
    }

    @Override
    public Type visitReturnStmt(OfpParser.ReturnStmtContext ctx) {
        return null;
    }

    @Override
    public Type visitType(OfpParser.TypeContext ctx) {
        System.out.println("Visiting a type "   + ctx.getText());
        switch(ctx.getText()){
            case "int":
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "char" :
                return Type.CHAR_TYPE;
            case "void" :
                return Type.VOID_TYPE;
        }



        return null;
    }

    @Override
    public Type visitVarType(OfpParser.VarTypeContext ctx) {
        if(ctx.getChildCount() > 1)
        visit(ctx.getChild(1));
        else
        visit(ctx.getChild(0));

        return null;
    }

    @Override
    public Type visitStmt(OfpParser.StmtContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitExpr(OfpParser.ExprContext ctx) {
        System.out.println(ctx.getText());
        int children = ctx.getChildCount();
        switch (children) {
            case 1: // methodAccess, varType, arrType, arrayList
                visit(ctx.getChild(0));
                mg.push(10);
                break;

            case 2: // id.length, new type

                break;
            default: // expr (multi|div|plus|minus|small|bigger|eq)

        }
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
    // declaration : type arrType? ID '=' (expr | arrType | array) SC ;
    @Override
    public Type visitDeclaration(OfpParser.DeclarationContext ctx) {
        System.out.println("decl test "   + ctx.getText());
        Type declType = visit(ctx.getChild(0));
        System.out.println(declType.getClassName());
        String id = ctx.getChild(1).getText();
        int index = currentScope.getFunctionSymbol().indexOf(new Symbol(id, OfpType.Undef));
        System.out.println(index);

        visit(ctx.getChild(3));

        mg.storeLocal(index, declType);
        System.out.println();


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
    //print : ('println'|'print') '(' (expr|STR) ')' SC ;
    @Override
    public Type visitPrint(OfpParser.PrintContext ctx) {

        System.err.println("test printstmt");
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        visit(ctx.getChild(2));
        mg.push(ctx.getChild(2).getText());
        if(!ctx.getChild(0).getText().equals("print")) {
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));
        }else{
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void print (String)"));
        }



        return null;
    }

    @Override
    public Type visitTerminal(TerminalNode terminalNode) {
        System.out.println("Visiting terminal: " + terminalNode.getText());

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
