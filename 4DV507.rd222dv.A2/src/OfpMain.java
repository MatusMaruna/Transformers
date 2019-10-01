import java.io.IOException;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class OfpMain {

	public static void main(String[] args) throws Exception {
		// Read test program path from args

		String testDir = "./ofp_example_programs/";
		String testProgram = "tester.ofp";

		if (!testProgram.endsWith(".ofp")) {
			System.out.println("\nPrograms most end with suffix .ofp! Found " + testProgram);
			System.exit(-1);
		}

		System.out.println("Reading test program from: " + testDir + testProgram);
		String progName = testProgram.substring(0, testProgram.length() - 4);
		System.out.println("Program name: " + progName);

		// Parse input program
		System.out.println("\nParsing started");
		OfpParser parser = null;
		OfpParser.StartContext root = null;
		ErrorListener errorListener = new ErrorListener();
		try {
			CharStream inputStream = CharStreams.fromFileName(testDir + testProgram);
			OfpLexer lexer = new OfpLexer(inputStream);
			parser = new OfpParser(new BufferedTokenStream(lexer));
			parser.addErrorListener(errorListener);
			root = parser.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int errors = errorListener.getErrorCount();
		System.out.println("Error count: " + errors);
		if (errors > 0) {
			System.out.println("\nErrors discovered during parsing - Exit!");
			System.exit(-1);
		}

		// Display tree
		// Trees.inspect(root, parser);

		System.out.println("");
		ParseTreeWalker walker = new ParseTreeWalker();
		Mylistener listener = new Mylistener();
		listener.loadParser(parser);
		listener.globalScope = new Scope(null, "global");
		listener.currentScope = listener.globalScope;
		walker.walk(listener, root);

		System.out.println("\n Symbol Table: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%10s%25s%25s%n", "Id", "Type", "Scope Name(Type)");
		System.out.println("----------------------------------------------------------------------");
		for (Scope s : listener.scopeList) {
			s.printScope();
		}
		System.out.println("----------------------------------------------------------------------");

		System.out.println("Done!");
		// System.out.println(listener.scopeList.toString());

	}

}