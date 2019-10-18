import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import bytecodeGenerator.ByteCodeGenerator;
import bytecodeGenerator.FunctionSymbol;
import com.sun.tools.javac.Main;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;
import pythonGenerator.PythonCodeGenerator;
import symbolTable.ErrorListener;
import symbolTable.*;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.OfpLexer;
import antlr4.OfpParser;
import symbolTable.Scope;

public class OfpMain {

	public static void main(String[] args) throws Exception {
		// Read test program path from args
		String testProgram = args[0];

		if (!testProgram.endsWith(".ofp")) {
			System.out.println("\nPrograms most end with suffix .ofp! Found " + testProgram);
			System.exit(-1);
		}

		System.out.println("Reading test program from: " + testProgram);
		String progPath = testProgram.substring(0, testProgram.length() - 4);
		File prog = new File(progPath);
		String progName = prog.getName();



		// Parse input program
		System.out.println("\nParsing started");
		OfpParser parser = null;
		OfpParser.StartContext root = null;
		ErrorListener errorListener = new ErrorListener();
		try {
			CharStream inputStream = CharStreams.fromFileName(testProgram);
			OfpLexer lexer = new OfpLexer(inputStream);
			parser = new OfpParser(new BufferedTokenStream(lexer));
			parser.addErrorListener(errorListener);
			root = parser.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int errors = errorListener.getErrorCount();
		if (errors > 0) {
			errorListener.printErrors();
			System.out.println("\nErrors discovered during parsing - Exit!");
			System.exit(-1);
		}

		// Display tree
		//Trees.inspect(root, parser);

		System.out.println("");
		ParseTreeWalker walker = new ParseTreeWalker();
		Mylistener listener = new Mylistener(errorListener);
		listener.loadParser(parser);
		walker.walk(listener, root);

		System.out.println("\n symbolTable.Symbol Table: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%10s%25s%25s%n", "Id", "Type", "symbolTable.Scope Name(Rule)");
		System.out.println("----------------------------------------------------------------------");
		for (Scope s : listener.scopeList) {
			s.printScope();
		}

		for (Scope s : listener.scopeList) {
			System.out.println(s.toString());
		}

		System.out.println("----------------------------------------------------------------------");
		/*typeCheck.TypeCheck typeChecking = new typeCheck.TypeCheck(listener.scopes, errorListener);
		typeChecking.loadParser(parser);
		typeChecking.visit(root);

		errorListener.printErrors();*/

		System.out.println("Generating Python Code");

		PythonCodeGenerator pyGen = new PythonCodeGenerator(listener.scopes);
		String pyProgram = pyGen.visit(root);

		String pyOutputPath = testProgram.replaceAll("\\.ofp$", ".py");
		try {
			PrintWriter pw = new PrintWriter(pyOutputPath);
			pw.print(pyProgram);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nPython program saves as: " + pyOutputPath);

		System.out.println("\nBytecode generation started \n");
		ByteCodeGenerator bcGen = new ByteCodeGenerator(listener.scopes, progName);
		bcGen.visit(root);

		System.out.println("\nPrint bytecode\n");
		byte[] code = bcGen.getByteArray();
		ClassReader cr = new ClassReader(code);
		ClassVisitor tracer = new TraceClassVisitor(new PrintWriter(System.out));
		ClassVisitor checker = new CheckClassAdapter(tracer, true);
		cr.accept(checker, 0);

		File javaOutFile = new File( prog.getParent() + "/" + progName +".class");
		FileOutputStream fos = new FileOutputStream(javaOutFile);
		fos.write(code);
		fos.close();
		System.out.println("Bytecode saved in" + javaOutFile.getAbsolutePath());
		System.out.println("\n Executing bytecode");

		/*Main loader = new Main();
		Class<?> exampleClass = loader.defineClass(progName, code, 0 , code.length);
		exampleClass.getMethods()[0].invoke(null, new Object[] {null});*/






	}

}
