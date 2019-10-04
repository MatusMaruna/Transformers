
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorListener extends BaseErrorListener {

	private int errorCount = 0;
	ArrayList<Error> errors = new ArrayList<Error>();

	public int getErrorCount() {
		return errorCount;
	}

	public void reportError(ErrorType type, int line, String message) {
		errorCount++;
		errors.add(new Error(type, line, message));
	}
	
	public void printErrors() {
		System.out.println("Total number of errors: " +  getErrorCount());
		for(Error e : errors) {
			System.err.println(e.toString());
		}
	}
	
	@Override
	public void syntaxError(Recognizer<?, ?> arg0, Object offendingSymbol, int line, int charPos, String msg,
			RecognitionException arg5) {
		reportError(ErrorType.ParsingError, line, msg);

	}
	

}


 class Error{
	
	 ErrorType type; 
	 int line; 
	 String message; 
	 
	 public Error(ErrorType type, int line, String message) {
		 this.type = type; this.line = line; this.message = message; 
	 }
	 
	 public String toString() {
		return "[" + type + "] " + "in line: " + line + " " +  message ;
		 
	 }
	 
	 
	 
}
 
 
 enum ErrorType {
	 SemanticError, TypeMismatch , ParsingError, MultipleDeclerationError,
 }
 
