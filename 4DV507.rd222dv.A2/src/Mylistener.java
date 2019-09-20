import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Mylistener implements ParseTreeListener {
        @Override public void enterEveryRule(ParserRuleContext ctx) {  
            System.out.println("rule entered: " + ctx.getText());    
        }

		@Override
		public void exitEveryRule(ParserRuleContext arg0) {
			System.out.println("rule exited: " +  arg0.getText());
			
		}

		@Override
		public void visitErrorNode(ErrorNode arg0) {
			//System.err.println("Visit Error: " + arg0.getText());
			
		}

		@Override
		public void visitTerminal(TerminalNode arg0) {
			System.out.println("Terminal: " + arg0.getText());
			
		}
    }

