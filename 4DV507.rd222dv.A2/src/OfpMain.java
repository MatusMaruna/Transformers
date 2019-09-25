

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



public class OfpMain {

	public static void main(String[] args) throws Exception {
		// Read test program path from args
		// For example: /Users/jlnmsi/Documents/Software/antlr4/Expressions-Main/test-programs/expr_input.txt
		String testProgram = args[0];
		System.out.println("Reading test program from: "+testProgram);
		
		// Parse input program
		CharStream cs = CharStreams.fromFileName(testProgram);
		OfpLexer lexer = new OfpLexer(cs);
		OfpParser parser = new OfpParser(new BufferedTokenStream(lexer));	
		//ParseTreeListener errorListener = new ParseTreeListener();
		//parser.addErrorListener(errorListener);
		OfpParser.StartContext root = parser.start();
		// Display tree
		Trees.inspect(root, parser);
		
		ParseTreeWalker walker = new ParseTreeWalker(); 
		Mylistener listener = new Mylistener();
		listener.loadParser(parser);
	    walker.walk(listener,root);
		System.out.println("Done!");
	}

}
