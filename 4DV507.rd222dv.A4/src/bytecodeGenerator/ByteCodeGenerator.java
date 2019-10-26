package bytecodeGenerator;

import antlr4.OfpBaseVisitor;
import antlr4.OfpParser;
import org.antlr.v4.runtime.tree.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import symbolTable.OfpType;
import symbolTable.Scope;
import symbolTable.Symbol;

import java.io.PrintStream;
import java.util.Stack;

import static org.objectweb.asm.Opcodes.*;

public class ByteCodeGenerator extends OfpBaseVisitor<Type> {

    private ParseTreeProperty<Scope> scopes;
    private String progName;
    private Scope currentScope;
    private Scope globalScope;
    private ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    GeneratorAdapter mg;
    String[] ruleNames;
    Stack<Label> labelStack = new Stack();

    public ByteCodeGenerator(ParseTreeProperty<Scope> scopes, String progName) {
        this.scopes = scopes;
        this.progName = progName;

    }

    public void loadParser(OfpParser parser) {
        ruleNames = parser.getTokenNames();
    }

    @Override
    public Type visitStart(OfpParser.StartContext ctx) {
        Method m = Method.getMethod("void <init>()");
        currentScope = scopes.get(ctx);
        globalScope = scopes.get(ctx);
        cw.visit(V1_1, ACC_PUBLIC, progName, null, "java/lang/Object", null);
        mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null, cw);
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
        System.out.println(currentScope.getFunctionSymbol().paramIndecies.toString());
        System.out.println(currentScope.getFunctionSymbol().variableIndecies.toString());
        Method main = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, main, null, null, cw);
        /*mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        mg.push("Hello World!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (String)"));*/
        System.out.println(" IN MAIN: " + mg.hashCode());
        visit(ctx.getChild(ctx.getChildCount() - 1));
        mg.returnValue();
        mg.endMethod();

        return null;
    }

    @Override
    public Type visitMethod(OfpParser.MethodContext ctx) {
        StringBuilder sb = new StringBuilder();
        currentScope = scopes.get(ctx);
        System.out.println("Param indecies: " + currentScope.getFunctionSymbol().paramIndecies.toString());
        System.out.println("variable indecies: " + currentScope.getFunctionSymbol().variableIndecies.toString());
       // Type methodType = getTypeFromString(ctx.getChild(0).getText());
        Type methodType = visit(ctx.getChild(0));
        String id = ctx.getChild(1).getText();

        sb.append(methodType.getClassName() + " ");
        sb.append(id + " ");
        sb.append("(");
        if (ctx.getChild(3).getText() != ")") { // if the method doesnt have 0 params
            for (int i = 0; i < ctx.getChild(3).getChildCount(); i += 2) {
                String param = ctx.getChild(3).getChild(i).getChild(1).getText();
               String strType = searchSymbol(param).getType().toString();
                Type t = getTypeFromString(strType);
               // Type t = searchSymbol(param);
                sb.append(t.getClassName());
                if (i + 2 < ctx.getChild(3).getChildCount()) {
                    sb.append(",");
                }
            }
        }

        sb.append(")");

        System.out.println(sb.toString());

        Method m = Method.getMethod(sb.toString());
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, m, null, null, cw);
        /*for(int i = 0; i < scopes.get(ctx).getFunctionSymbol().paramIndecies.size(); i++){
            mg.loadArg(i);
        }*/


        visit(ctx.getChild(ctx.getChildCount() - 1)); // Body



       // mg.loadLocal(2, Type.INT_TYPE);
        if(ctx.getChild(0).getText().equals("void") || ctx.getChild(0).getText().equals("\'void\'")) {
            mg.returnValue();
        }
        mg.endMethod();


        // visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitParameter(OfpParser.ParameterContext ctx) {
        switch (ctx.getChild(0).getText()) {
            case "int":
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "string":
                return Type.getType(String.class);
            case "char":
                return Type.CHAR_TYPE;
            case "char[]":
                return Type.getType("[C");
            case "int[]":
                return Type.getType("[I");
            case "float[]":
                return Type.getType("[D");
            case "bool":
                return Type.BOOLEAN_TYPE;
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
        visit(ctx.getChild(1));
        mg.returnValue();
        return null;
    }

    @Override
    public Type visitType(OfpParser.TypeContext ctx) {

        Type t = null;
        switch (ctx.getChild(0).getText()) {
            case "int":
                if(ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("[]")){
                    return Type.getType("[I");
                }
                t = Type.INT_TYPE;
                break;
            case "float":
                if(ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("[]")){
                    return Type.getType("[D");
                }
                t = Type.DOUBLE_TYPE;
                break;
            case "char":
                if(ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("[]")){
                    return Type.getType("[C");
                }
                t = Type.CHAR_TYPE;
                break;
            case "string":
                if(ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("[]")){
                    return Type.getType(String.class);
                }
                t = Type.getType(String.class);
                break;
            case "void":
                t = Type.VOID_TYPE;
                break;
            case "bool":
                t = Type.BOOLEAN_TYPE;
                break;
        }

        if(ctx.getChildCount() >1) {
            visit(ctx.getChild(1));
        }


        return t;
    }

    @Override
    public Type visitVarType(OfpParser.VarTypeContext ctx) {
        if (ctx.getChildCount() > 1)
            return visit(ctx.getChild(1));
        else
            return visit(ctx.getChild(0));

    }

    @Override
    public Type visitStmt(OfpParser.StmtContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Type visitExpr(OfpParser.ExprContext ctx) {
        int children = ctx.getChildCount();
        switch (children) {
            case 1: // methodAccess, varType, arrType, arrayList
                return visit(ctx.getChild(0));


            case 2: // id.length, new type
                Type t1;
                if(ctx.getChild(0).getText().equals("new")) {
                t1 =  visit(ctx.getChild(1));
                mg.newArray(t1);

                }else{
                   Type t =  visit(ctx.getChild(0));
                    t1 = Type.INT_TYPE;
                    System.out.println(t.getClassName());
                    if(t.getClassName().equals("java.lang.String")){
                        mg.invokeVirtual(Type.getType(String.class),
                                Method.getMethod("int length()"));
                    }else {
                        mg.arrayLength();
                    }
                }
                return t1;
            default: // expr (multi|div|plus|minus|small|bigger|eq) expr

              Type t =  visit(ctx.getChild(0));
                int cop = getCopSymbol(ctx.getChild(1).getText());
                System.err.println("EXPR1: " + ctx.getChild(0).getText());
                System.err.println("COP SYMBOL: " + ctx.getChild(1).getText());
                System.err.println("EXPR2: " + ctx.getChild(2).getText());
                visit(ctx.getChild(2));
                if(cop != GeneratorAdapter.EQ && cop != GeneratorAdapter.GT && cop != GeneratorAdapter.LT){
                    System.out.println(t);
                    System.out.println(cop);
                    mg.math(cop, t);
                }else{
                    if(!labelStack.isEmpty()){
                        mg.ifCmp(t, cop, labelStack.pop());
                    }
                }
               return t;

        }
        //return null;
    }

    // methodAccess : ID? '(' expr ')';

    @Override
    public Type visitMethodAccess(OfpParser.MethodAccessContext ctx) {
        System.out.println("MethodAccess name: " + ctx.getChild(0).getText());
        String methodName = ctx.getChild(0).getText();
        Type methodType = getTypeFromString(globalScope.resolve(ctx.getChild(0).getText()).getType().toString());
        System.out.println("MethodAccess type: " + methodType.toString());
        System.out.println("MethodAccess params: " + globalScope.getChild(ctx.getChild(0).getText()).getFunctionSymbol().paramIndecies.toString());
        StringBuilder sb = new StringBuilder();
        Scope s = globalScope.getChild(ctx.getChild(0).getText());
        sb.append(methodType.getClassName() + " ");
        sb.append(methodName + " ");
        sb.append("(");

        for (String key : s.getFunctionSymbol().paramIndecies.keySet()) {
            sb.append(getTypeFromString(s.resolve(key).getType().toString()).getClassName());
            sb.append(",");
        }
        if(sb.lastIndexOf(",") != -1) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }

        sb.append(")");


        if (!ctx.getChild(2).getText().equals(")") && !ctx.getChild(2).getText().equals("")) {
            System.out.println("METHOD ACCESS TEST: " + ctx.getChild(2).getText());
              visit(ctx.getChild(2));
        }


        //ID LOAD LOCAL VISIT TERMINAL ID

      /*  mg.loadLocal(s.getFunctionSymbol().indexOf(s.resolve("n")), getTypeFromString(s.resolve("n").getType().toString()));
        System.out.println("Load local: " + s.getFunctionSymbol().indexOf(s.resolve("n")) + " " + getTypeFromString(s.resolve("n").getType().toString()));
       */



        Type t = Type.getType(methodType + ctx.getChild(0).getText() + ";");
        System.out.println("Type: " + methodType + ctx.getChild(0).getText() + ";");
        Method m = Method.getMethod(sb.toString());
        System.out.println("Method: " + sb.toString());
        mg.invokeStatic(Type.getType("L" + progName + ";"),
                Method.getMethod(sb.toString()));
        //Store to calling variable;

        return methodType;
    }

    @Override
    public Type visitLocalDecl(OfpParser.LocalDeclContext ctx) {
        return null;
    }

    // declaration : type arrType? ID '=' (expr | arrType | array) SC ;
    @Override
    public Type visitDeclaration(OfpParser.DeclarationContext ctx) {
        System.out.println("Declaration: " + ctx.getText());
        Type declType = visit(ctx.getChild(0));
        System.out.println("Type: " + declType.getClassName());
        String id = ctx.getChild(1).getText();
        int index = searchSymbolIndex(id);
        System.out.println("Index: " + index);

        visit(ctx.getChild(3));

        mg.storeLocal(index, declType);
        System.out.println();


        return null;
    }
   // asgnStmt : ID arrType? '=' expr SC ;
    @Override
    public Type visitAsgnStmt(OfpParser.AsgnStmtContext ctx) {
        System.out.println("Visited assignment statement : " + ctx.getText());
        int length = ctx.getChildCount();
        String id = ctx.getChild(0).getText();
        //int index = currentScope.getFunctionSymbol().indexOf(new Symbol(id, OfpType.Undef));
        int index = searchSymbolIndex(id);
       // Type varType = getTypeFromString((currentScope.resolve(id).getType().toString()));
        Type varType = getTypeFromString(searchSymbol(id).getType().toString());

        if(length == 5){
            //load array aload
            if(isParam(id)){
                mg.loadArg(index);
            }else {
                mg.loadLocal(index);
            }
            //iconst position
            visit(ctx.getChild(1));
            //iconst value
           Type t = visit(ctx.getChild(3));
            //iastore, below
            mg.arrayStore(t);
        }else{
            Type t = visit(ctx.getChild(2));
            mg.storeLocal(index, t);
        }

        System.out.println();


        return null;
    }

    @Override
    public Type visitMethodCall(OfpParser.MethodCallContext ctx) {
        return null;
    }

    @Override
    public Type visitArrayList(OfpParser.ArrayListContext ctx) {
        for(int i = 0; i<ctx.getChildCount(); i+=2) {
            visit(ctx.getChild(i));

        }
        return null;
    }

    @Override
    public Type visitArray(OfpParser.ArrayContext ctx) {
        int numOfVars = 0;
        for(int i = 0; i<ctx.getChild(1).getChildCount(); i+=2) {
            numOfVars++;
        }
        mg.push(numOfVars);
        Type arrayType = visit(ctx.getParent().getChild(0));
        arrayType = arrayMap(arrayType.getClassName());
        mg.newArray(arrayType);
        int counter = 0;
        for(int i = 0; i<ctx.getChild(1).getChildCount(); i+=2){
            mg.dup();
            mg.push(counter++);
            Type t = visit(ctx.getChild(1).getChild(i));
            mg.arrayStore(t);

        }
        return null;
    }
//arrType : ID? '[' expr ']' ;
    @Override
    public Type visitArrType(OfpParser.ArrTypeContext ctx) {
        Type t;
        if(ctx.getChildCount() == 4){
            String arrayName = ctx.getChild(0).getText();
            //System.out.println("ARRAY NAME: " + arrayName + currentScope.getEnclosingScope().resolve("arr"));
            Symbol s = searchSymbol(arrayName);
            t = arrayMap(s.getType().toString());
            System.out.println("ARRAY TYPE : " +  s.getType().toString());
            arrayMap(visit(ctx.getChild(0)).getClassName()); //CHANGED!

            visit(ctx.getChild(2));
            if(s.getType().toString().equals("string")){
                t = Type.CHAR_TYPE;
                mg.invokeVirtual(Type.getType(String.class),
                        Method.getMethod("char charAt(int)"));
            }else {
                mg.arrayLoad(t);
            }
        }else {
           t =  visit(ctx.getChild(1));
        }


        return t;
    }


    //whileStmt : 'while' '(' condition ')' block;
    @Override
    public Type visitWhileStmt(OfpParser.WhileStmtContext ctx) {
        currentScope = scopes.get(ctx);
        System.out.println("Visiting while stmt");
        Label exitWhile = new Label(); // jump to condition
        mg.goTo(exitWhile);
        Label enterWhile = mg.mark(); // Loop body
        visit(ctx.getChild(ctx.getChildCount() - 1));

        mg.mark(exitWhile); // backpatching
        labelStack.push(enterWhile);
        visit(ctx.getChild(2));  // visit condition
      //  System.out.println(ctx.getChild(2).getChild(0).getText());
       // int cmp = getCopSymbol(ctx.getChild(2).getChild(0).getChild(1).getText());
       // mg.ifICmp(cmp, enterWhile); // Jump to loop body
       // mg.loadLocal(2, Type.INT_TYPE); // Push result ??????? FIXED
      //  mg.returnValue();
        currentScope = currentScope.getEnclosingScope();
        return null;
    }


  //  ifStmt : 'if' '(' condition ')' (stmt|block) elseStmt?;

    @Override
    public Type visitIfStmt(OfpParser.IfStmtContext ctx) {
        currentScope = scopes.get(ctx);
        System.out.println("Visiting ifStmt");
        Label enterIf = new Label();
        Label exitIf = new Label();
        Label endIf = new Label();
        labelStack.push(enterIf);
        visit(ctx.getChild(2)); // visit condition
        mg.goTo(exitIf);
        mg.mark(enterIf);
        visit(ctx.getChild(4)); // visit body
        mg.goTo(endIf);
        mg.mark(exitIf);
        if(ctx.getChildCount()==6){
            visit(ctx.getChild(5));
        }
        mg.mark(endIf);
        currentScope = currentScope.getEnclosingScope();
        return null;
    }
    //elseStmt : ('else' (stmt|block)) ;
    @Override
    public Type visitElseStmt(OfpParser.ElseStmtContext ctx) {
        currentScope = scopes.get(ctx);
        Label enterElse = new Label();
        System.out.println("Visiting elseStmt");
        visit(ctx.getChild(1));
        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    @Override
    public Type visitCondition(OfpParser.ConditionContext ctx) {
        /*mg.loadLocal(2, Type.INT_TYPE); // visit Condition
        mg.loadArg(0); // Read n
        mg.push(1);
        mg.math(GeneratorAdapter.ADD, Type.INT_TYPE);*/
        visit(ctx.getChild(0));
        return null;
    }

    //print : ('println'|'print') '(' (expr|STR) ')' SC ;
    @Override
    public Type visitPrint(OfpParser.PrintContext ctx) {
        System.out.println("Visiting print stmt");
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));
        Type t = visit(ctx.getChild(2));
        String type = t.getClassName();
        if(type == null){
            t = getPrintTypeFromString(t.toString());
            type = t.getClassName();
        }
        System.out.println("Print class name: " + t);
        if (!ctx.getChild(0).getText().equals("print")) {
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println (" + t.getClassName() + ")"));
        } else {
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void print (" + t.getClassName() + ")"));
        }


        return null;
    }

    @Override
    public Type visitTerminal(TerminalNode terminalNode) {
        System.out.println("Visiting terminal: " + terminalNode.getText() + " " + ruleNames[terminalNode.getSymbol().getType()]);

        switch (ruleNames[terminalNode.getSymbol().getType()]) {
            case "\'void\'":
                return Type.VOID_TYPE;

            case "INT":
                mg.push(new Integer(terminalNode.getText()));
                return Type.INT_TYPE;

            case "ID":
                //mg.push(terminalNode.getText());
                Symbol s = searchSymbol(terminalNode.getText());
//                System.err.println(s.getType().toString());
                Type t = getTypeFromString(s.getType().toString());
                //System.out.println(currentScope.getFunctionSymbol().paramIndecies.toString());
                if(isParam(s.getId())){
                    mg.loadArg(searchSymbolIndex(s.getId()));
                }else {
                    mg.loadLocal(searchSymbolIndex(s.getId()), t);
                }
                System.out.println("CLASS NAME: " + getTypeFromString(s.getType().toString()).getClassName());
                return getTypeFromString(s.getType().toString());

            case "FLOAT":
                mg.push(new Double(terminalNode.getText()));
                return Type.DOUBLE_TYPE;
            case "STR":
                StringBuilder sb = new StringBuilder();
                sb.append(terminalNode.getText());
                sb.deleteCharAt(0); // remove quotation marks
                sb.deleteCharAt(sb.length() - 1);
                mg.push(sb.toString());
                return Type.getType(String.class);

            case "CHAR":
                mg.push(new Character(terminalNode.getText().charAt(1)));
                return Type.CHAR_TYPE;
            case "BOOL":
                if(terminalNode.getText().equals("true")) {
                    mg.push(new Boolean(true));
                }else {
                    mg.push(new Boolean(false));
                }
                return Type.BOOLEAN_TYPE;

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


    public Type getPrintTypeFromString(String s) {

        switch (s) {
            case "int":
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "void":
                return Type.VOID_TYPE;
            case "Ljava/lang/String":
                return Type.getType(String.class);
            case "string":
                return Type.getType(String.class);
            case "int[]":
                return Type.getType(Object.class);
            case "float[]":
                return Type.getType(Object.class);
            case "char[]":
                return Type.getType(Object.class);
            case "string[]":
                return Type.CHAR_TYPE;
            case "char":
                return Type.CHAR_TYPE;
            case "bool":
                return Type.BOOLEAN_TYPE;


        }
        return null;

    }

    public Type getTypeFromString(String s) {
        switch (s) {
            case "int":
                return Type.INT_TYPE;
            case "float":
                return Type.DOUBLE_TYPE;
            case "string":
                return Type.getType(String.class);
            case "Ljava/lang/String":
                return Type.getType(String.class);
            case "char":
                return Type.CHAR_TYPE;
            case "int[]":
                return Type.getType("[I");
            case "float[]":
                return Type.getType("[D");
            case "char[]":
                return Type.getType("[C");
            case "bool":
                return Type.BOOLEAN_TYPE;
        }
        return null;
    }






    public Type arrayMap(String s){
        System.out.println("ARRAY MAP : " + s);
        switch(s){
            case "int[]":
                return Type.INT_TYPE;
            case "double[]":
                return Type.DOUBLE_TYPE;
            case "float[]":
                return Type.DOUBLE_TYPE;
            case "char[]":
                return Type.CHAR_TYPE;
            case "java.lang.Object":
                return Type.getType(Object.class);
            case "java.lang.String":
                return Type.CHAR_TYPE;
            case "Ljava/lang/String":
                return Type.CHAR_TYPE;
            case "string":
                return Type.CHAR_TYPE;
        }
        System.err.println("Returned null");
        return null;
    }



    public int getNotSymbol(String s) {
        switch (s) {
            case "<":
                return GeneratorAdapter.GE;
            case ">":
                return GeneratorAdapter.LE;
            case "==":
                return GeneratorAdapter.NE;
        }
        return -1;
    }


    public Symbol searchSymbol(String varName){

        if(currentScope.resolve(varName) != null){
            return currentScope.resolve(varName);
        }else{
            Scope s = currentScope;
            while(s.resolve(varName) == null){
                s = s.getEnclosingScope();
            }
          return  s.resolve(varName);
        }

    }


    public int searchSymbolIndex(String varName){
        Symbol sim = new Symbol(varName, OfpType.Undef);
        if(currentScope.getFunctionSymbol().indexOf(sim) !=  -1){
            return currentScope.getFunctionSymbol().indexOf(sim);
        }else{
            Scope s = currentScope;
            while(s.getFunctionSymbol().indexOf(sim) == -1){
                s = s.getEnclosingScope();
            }
            return  s.getFunctionSymbol().indexOf(sim);
        }

    }

    public boolean isParam(String varName){
        Symbol sim = new Symbol(varName, OfpType.Undef);
        if(currentScope.getFunctionSymbol().paramIndecies.containsKey(sim.getId())){
            return true;
        }else{
            Scope s = currentScope;
            while(s.getEnclosingScope() != null){
                s = s.getEnclosingScope();
                if(s.getFunctionSymbol().paramIndecies.containsKey(sim.getId())){
                    return true;
                }
            }
            return false;
        }

    }




    public int getCopSymbol(String s) {
        switch(s){
            case "<":
                return GeneratorAdapter.LT;
            case ">":
                return GeneratorAdapter.GT;
            case "==":
                return GeneratorAdapter.EQ;
            case "+":
                return GeneratorAdapter.ADD;
            case "-":
                return GeneratorAdapter.SUB;
            case "*":
                return GeneratorAdapter.MUL;
            case "/":
                return GeneratorAdapter.DIV;

        }
        return -1;
    }
}