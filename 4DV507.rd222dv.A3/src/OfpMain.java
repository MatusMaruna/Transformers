import java.io.IOException;
import java.io.PrintWriter;

import pythonGenerator.PythonCodeGenerator;
import symbolTable.ErrorListener;
import symbolTable.*;

import org.antlr.v4.gui.Trees;
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
		String progName = testProgram.substring(0, testProgram.length() - 4);

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
		Trees.inspect(root, parser);

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

	}

}
