import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Mylistener implements ParseTreeListener {
        @Override public void enterEveryRule(ParserRuleContext ctx) {  
            System.out.println("rule entered: " + resolveName(ctx));    
        }

		@Override
		public void exitEveryRule(ParserRuleContext ctx) {
			//System.out.println("rule exited: " +  arg0.getText());
		}

		@Override
		public void visitErrorNode(ErrorNode ctx) {
			//System.err.println("Visit Error: " + arg0.getText());
			
		}

		@Override
		public void visitTerminal(TerminalNode ctx) {
		//	System.out.println("Terminal: " + arg0.getText());
			
		}
		
		String[] ruleNames;
		public void loadParser(OfpParser parser) {  
		    ruleNames = parser.getRuleNames(); 
		}
		
		public String resolveName(ParserRuleContext ctx) {
			return ruleNames[ctx.getRuleIndex()];
		}
    }

