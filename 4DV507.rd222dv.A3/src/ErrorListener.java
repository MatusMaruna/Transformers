
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
		
		if(!errors.contains(new Error(type, line, message)))
		errors.add(new Error(type, line, message));
		else
		errorCount--;
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
	
	 public ErrorType type; 
	public  int line; 
	public  String message; 
	 
	 public Error(ErrorType type, int line, String message) {
		 this.type = type; this.line = line; this.message = message; 
	 }
	 
	 public String toString() {
		return "[" + type + "] " + "in line: " + line + " " +  message ;
		 
	 }
	 
	 
	 @Override
	 public boolean equals(Object object) {
		if(object instanceof Error) {
			if(this.type.equals(((Error) object).type) && this.line == ((Error) object).line 
					&& this.message.equals(((Error) object).message)) {
				return true; 
			}else {
				return false; 
			}
		}
		return false;
		 
		 
	 }
	 
	 
	 @Override
	 public int hashCode() {
	     return this.line+this.message.hashCode();
	 }
	 
	 
	 
}
 
 
 enum ErrorType {
	 SemanticError, TypeMismatch , ParsingError, MultipleDeclerationError,
 }
 
