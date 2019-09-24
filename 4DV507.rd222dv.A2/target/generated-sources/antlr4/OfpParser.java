// Generated from Ofp.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OfpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, PLUS=24, 
		MINUS=25, MULT=26, DIV=27, SMALL=28, BIGGER=29, EQ=30, COP=31, INT=32, 
		FLOAT=33, ID=34, IDmax=35, SYM=36, STR=37, CHAR=38, COMMENT=39, WS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'main'", "'char'", "'println'", "'new'", "'return'", "'float'", 
		"'while'", "'{'", "';'", "'['", "'void'", "'='", "'}'", "']'", "'if'", 
		"'bool'", "'string'", "'int'", "'print'", "'else'", "'('", "')'", "','", 
		"'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "COP", "INT", "FLOAT", 
		"ID", "IDmax", "SYM", "STR", "CHAR", "COMMENT", "WS"
	};
	public static final int
		RULE_start = 0, RULE_method = 1, RULE_main = 2, RULE_stmt = 3, RULE_expr = 4, 
		RULE_block = 5, RULE_returnStmt = 6, RULE_parameter = 7, RULE_varType = 8, 
		RULE_asgnStmt = 9, RULE_declaration = 10, RULE_type = 11, RULE_arrExpr = 12, 
		RULE_array = 13, RULE_inArray = 14, RULE_arrType = 15, RULE_whileStmt = 16, 
		RULE_ifStmt = 17, RULE_condition = 18, RULE_print = 19;
	public static final String[] ruleNames = {
		"start", "method", "main", "stmt", "expr", "block", "returnStmt", "parameter", 
		"varType", "asgnStmt", "declaration", "type", "arrExpr", "array", "inArray", 
		"arrType", "whileStmt", "ifStmt", "condition", "print"
	};

	@Override
	public String getGrammarFileName() { return "Ofp.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OfpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40); method();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(46); main();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__12) | (1L << T__7) | (1L << T__6) | (1L << T__5))) != 0)) {
				{
				{
				setState(47); method();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_method);
		int _la;
		try {
			setState(74);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); match(T__12);
				setState(54); match(ID);
				setState(55); match(T__2);
				setState(57);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__7) | (1L << T__6) | (1L << T__5))) != 0)) {
					{
					setState(56); parameter();
					}
				}

				setState(59); match(T__1);
				setState(60); block();
				}
				break;
			case T__21:
			case T__17:
			case T__7:
			case T__6:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(61); type();
				setState(64);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(62); match(T__13);
					setState(63); match(T__9);
					}
				}

				setState(66); match(ID);
				setState(67); match(T__2);
				setState(69);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__7) | (1L << T__6) | (1L << T__5))) != 0)) {
					{
					setState(68); parameter();
					}
				}

				setState(71); match(T__1);
				setState(72); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(T__12);
			setState(77); match(T__22);
			setState(78); match(T__2);
			setState(79); match(T__1);
			setState(80); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsgnStmtContext asgnStmt() {
			return getRuleContext(AsgnStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); expr(0);
				setState(83); match(T__14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); asgnStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86); declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88); ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(89); print();
				setState(90); match(T__14);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(92); returnStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(OfpParser.MULT, 0); }
		public TerminalNode SMALL() { return getToken(OfpParser.SMALL, 0); }
		public InArrayContext inArray() {
			return getRuleContext(InArrayContext.class,0);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ArrExprContext arrExpr() {
			return getRuleContext(ArrExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(OfpParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(OfpParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(OfpParser.EQ, 0); }
		public TerminalNode BIGGER() { return getToken(OfpParser.BIGGER, 0); }
		public TerminalNode DIV() { return getToken(OfpParser.DIV, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(97);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(96); match(ID);
					}
				}

				setState(99); match(T__2);
				setState(100); expr(0);
				setState(101); match(T__1);
				}
				break;
			case 3:
				{
				setState(103); varType();
				}
				break;
			case 4:
				{
				setState(104); arrExpr();
				}
				break;
			case 5:
				{
				setState(105); arrType();
				}
				break;
			case 6:
				{
				setState(106); inArray();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(110);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(111); expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(113);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(114); expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(116);
						_la = _input.LA(1);
						if ( !(_la==SMALL || _la==BIGGER) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(117); expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(119); match(EQ);
						setState(120); expr(6);
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(T__15);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(127); stmt();
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(133); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(T__18);
			setState(136); expr(0);
			setState(137); match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(OfpParser.ID); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(OfpParser.ID, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); type();
			setState(140); match(ID);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(141); match(T__0);
				setState(142); type();
				setState(143); match(ID);
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public TerminalNode STR() { return getToken(OfpParser.STR, 0); }
		public TerminalNode IDmax() { return getToken(OfpParser.IDmax, 0); }
		public TerminalNode MINUS() { return getToken(OfpParser.MINUS, 0); }
		public TerminalNode CHAR() { return getToken(OfpParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(OfpParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(OfpParser.FLOAT, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(150); match(ID);
				}
				break;
			case 2:
				{
				setState(152);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(151); match(MINUS);
					}
				}

				setState(154); match(INT);
				}
				break;
			case 3:
				{
				setState(156);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(155); match(MINUS);
					}
				}

				setState(158); match(FLOAT);
				}
				break;
			case 4:
				{
				setState(159); match(IDmax);
				}
				break;
			case 5:
				{
				setState(160); match(STR);
				}
				break;
			case 6:
				{
				setState(161); match(CHAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsgnStmtContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsgnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asgnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterAsgnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitAsgnStmt(this);
		}
	}

	public final AsgnStmtContext asgnStmt() throws RecognitionException {
		AsgnStmtContext _localctx = new AsgnStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asgnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(ID);
			setState(166);
			_la = _input.LA(1);
			if (_la==T__13 || _la==ID) {
				{
				setState(165); arrType();
				}
			}

			setState(170);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(168); match(T__11);
				setState(169); expr(0);
				}
			}

			setState(172); match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public List<ArrTypeContext> arrType() {
			return getRuleContexts(ArrTypeContext.class);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrTypeContext arrType(int i) {
			return getRuleContext(ArrTypeContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); type();
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(175); arrType();
				}
				break;
			}
			setState(178); match(ID);
			setState(185);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(179); match(T__11);
				setState(183);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(180); expr(0);
					}
					break;
				case 2:
					{
					setState(181); arrType();
					}
					break;
				case 3:
					{
					setState(182); array();
					}
					break;
				}
				}
			}

			setState(187); match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(189); match(T__5);
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(190); arrType();
					}
					break;
				}
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); match(T__17);
				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(194); arrType();
					}
					break;
				}
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(197); match(T__6);
				setState(199);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(198); arrType();
					}
					break;
				}
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(201); match(T__21);
				setState(203);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(202); arrType();
					}
					break;
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(205); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrExprContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterArrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitArrExpr(this);
		}
	}

	public final ArrExprContext arrExpr() throws RecognitionException {
		ArrExprContext _localctx = new ArrExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(T__19);
			setState(209); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<InArrayContext> inArray() {
			return getRuleContexts(InArrayContext.class);
		}
		public InArrayContext inArray(int i) {
			return getRuleContext(InArrayContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(T__15);
			setState(213); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(212); inArray();
				}
				}
				setState(215); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(217); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InArrayContext extends ParserRuleContext {
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public InArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterInArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitInArray(this);
		}
	}

	public final InArrayContext inArray() throws RecognitionException {
		InArrayContext _localctx = new InArrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_inArray);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219); varType();
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220); match(T__0);
					setState(221); varType();
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterArrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitArrType(this);
		}
	}

	public final ArrTypeContext arrType() throws RecognitionException {
		ArrTypeContext _localctx = new ArrTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(227); match(ID);
				}
			}

			setState(230); match(T__13);
			setState(231); expr(0);
			setState(232); match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(T__16);
			setState(235); match(T__2);
			setState(236); condition();
			setState(237); match(T__1);
			setState(238); match(T__15);
			setState(240); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(239); stmt();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(242); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(244); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(T__8);
			setState(247); match(T__2);
			setState(248); condition();
			setState(249); match(T__1);
			setState(252);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(250); stmt();
				}
				break;
			case 2:
				{
				setState(251); block();
				}
				break;
			}
			setState(259);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(254); match(T__3);
				setState(257);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(255); stmt();
					}
					break;
				case 2:
					{
					setState(256); block();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode COP() { return getToken(OfpParser.COP, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_condition);
		try {
			setState(266);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(261); expr(0);
				setState(262); match(COP);
				setState(263); expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265); expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public TerminalNode STR() { return getToken(OfpParser.STR, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(269); match(T__2);
			setState(275);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(270); match(ID);
				setState(272);
				_la = _input.LA(1);
				if (_la==T__13 || _la==ID) {
					{
					setState(271); arrType();
					}
				}

				}
				break;
			case STR:
				{
				setState(274); match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(277); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u011a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\7\2"+
		"\63\n\2\f\2\16\2\66\13\2\3\3\3\3\3\3\3\3\5\3<\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3C\n\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\5\3M\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5`\n\5\3\6\3\6\5"+
		"\6d\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\7\3\7\7\7\u0083"+
		"\n\7\f\7\16\7\u0086\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\7\t\u0094\n\t\f\t\16\t\u0097\13\t\3\n\3\n\5\n\u009b\n\n\3\n\3\n\5\n"+
		"\u009f\n\n\3\n\3\n\3\n\3\n\5\n\u00a5\n\n\3\13\3\13\5\13\u00a9\n\13\3\13"+
		"\3\13\5\13\u00ad\n\13\3\13\3\13\3\f\3\f\5\f\u00b3\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00ba\n\f\5\f\u00bc\n\f\3\f\3\f\3\r\3\r\5\r\u00c2\n\r\3\r\3\r"+
		"\5\r\u00c6\n\r\3\r\3\r\5\r\u00ca\n\r\3\r\3\r\5\r\u00ce\n\r\3\r\5\r\u00d1"+
		"\n\r\3\16\3\16\3\16\3\17\3\17\6\17\u00d8\n\17\r\17\16\17\u00d9\3\17\3"+
		"\17\3\20\3\20\3\20\7\20\u00e1\n\20\f\20\16\20\u00e4\13\20\3\21\5\21\u00e7"+
		"\n\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u00f3\n\22"+
		"\r\22\16\22\u00f4\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ff\n"+
		"\23\3\23\3\23\3\23\5\23\u0104\n\23\5\23\u0106\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u010d\n\24\3\25\3\25\3\25\3\25\5\25\u0113\n\25\3\25\5\25\u0116"+
		"\n\25\3\25\3\25\3\25\2\3\n\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(\2\6\3\2\34\35\3\2\32\33\3\2\36\37\4\2\5\5\25\25\u013c\2-\3\2\2\2"+
		"\4L\3\2\2\2\6N\3\2\2\2\b_\3\2\2\2\nm\3\2\2\2\f\u0080\3\2\2\2\16\u0089"+
		"\3\2\2\2\20\u008d\3\2\2\2\22\u00a4\3\2\2\2\24\u00a6\3\2\2\2\26\u00b0\3"+
		"\2\2\2\30\u00d0\3\2\2\2\32\u00d2\3\2\2\2\34\u00d5\3\2\2\2\36\u00dd\3\2"+
		"\2\2 \u00e6\3\2\2\2\"\u00ec\3\2\2\2$\u00f8\3\2\2\2&\u010c\3\2\2\2(\u010e"+
		"\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2"+
		"/-\3\2\2\2\60\64\5\6\4\2\61\63\5\4\3\2\62\61\3\2\2\2\63\66\3\2\2\2\64"+
		"\62\3\2\2\2\64\65\3\2\2\2\65\3\3\2\2\2\66\64\3\2\2\2\678\7\r\2\289\7$"+
		"\2\29;\7\27\2\2:<\5\20\t\2;:\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7\30\2\2>M"+
		"\5\f\7\2?B\5\30\r\2@A\7\f\2\2AC\7\20\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2"+
		"DE\7$\2\2EG\7\27\2\2FH\5\20\t\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\30\2"+
		"\2JK\5\f\7\2KM\3\2\2\2L\67\3\2\2\2L?\3\2\2\2M\5\3\2\2\2NO\7\r\2\2OP\7"+
		"\3\2\2PQ\7\27\2\2QR\7\30\2\2RS\5\f\7\2S\7\3\2\2\2TU\5\n\6\2UV\7\13\2\2"+
		"V`\3\2\2\2W`\5\24\13\2X`\5\26\f\2Y`\5\"\22\2Z`\5$\23\2[\\\5(\25\2\\]\7"+
		"\13\2\2]`\3\2\2\2^`\5\16\b\2_T\3\2\2\2_W\3\2\2\2_X\3\2\2\2_Y\3\2\2\2_"+
		"Z\3\2\2\2_[\3\2\2\2_^\3\2\2\2`\t\3\2\2\2an\b\6\1\2bd\7$\2\2cb\3\2\2\2"+
		"cd\3\2\2\2de\3\2\2\2ef\7\27\2\2fg\5\n\6\2gh\7\30\2\2hn\3\2\2\2in\5\22"+
		"\n\2jn\5\32\16\2kn\5 \21\2ln\5\36\20\2ma\3\2\2\2mc\3\2\2\2mi\3\2\2\2m"+
		"j\3\2\2\2mk\3\2\2\2ml\3\2\2\2n}\3\2\2\2op\f\n\2\2pq\t\2\2\2q|\5\n\6\13"+
		"rs\f\t\2\2st\t\3\2\2t|\5\n\6\nuv\f\b\2\2vw\t\4\2\2w|\5\n\6\txy\f\7\2\2"+
		"yz\7 \2\2z|\5\n\6\b{o\3\2\2\2{r\3\2\2\2{u\3\2\2\2{x\3\2\2\2|\177\3\2\2"+
		"\2}{\3\2\2\2}~\3\2\2\2~\13\3\2\2\2\177}\3\2\2\2\u0080\u0084\7\n\2\2\u0081"+
		"\u0083\5\b\5\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0088\7\17\2\2\u0088\r\3\2\2\2\u0089\u008a\7\7\2\2\u008a\u008b\5\n\6"+
		"\2\u008b\u008c\7\13\2\2\u008c\17\3\2\2\2\u008d\u008e\5\30\r\2\u008e\u0095"+
		"\7$\2\2\u008f\u0090\7\31\2\2\u0090\u0091\5\30\r\2\u0091\u0092\7$\2\2\u0092"+
		"\u0094\3\2\2\2\u0093\u008f\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u00a5"+
		"\7$\2\2\u0099\u009b\7\33\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00a5\7\"\2\2\u009d\u009f\7\33\2\2\u009e\u009d\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a5\7#\2\2\u00a1"+
		"\u00a5\7%\2\2\u00a2\u00a5\7\'\2\2\u00a3\u00a5\7(\2\2\u00a4\u0098\3\2\2"+
		"\2\u00a4\u009a\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\23\3\2\2\2\u00a6\u00a8\7$\2\2\u00a7"+
		"\u00a9\5 \21\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00ab\7\16\2\2\u00ab\u00ad\5\n\6\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\13\2\2\u00af\25\3\2\2"+
		"\2\u00b0\u00b2\5\30\r\2\u00b1\u00b3\5 \21\2\u00b2\u00b1\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00bb\7$\2\2\u00b5\u00b9\7\16"+
		"\2\2\u00b6\u00ba\5\n\6\2\u00b7\u00ba\5 \21\2\u00b8\u00ba\5\34\17\2\u00b9"+
		"\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\7\13\2\2\u00be\27\3\2\2\2\u00bf\u00c1\7\24\2\2\u00c0\u00c2\5 \21"+
		"\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00d1\3\2\2\2\u00c3\u00c5"+
		"\7\b\2\2\u00c4\u00c6\5 \21\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00d1\3\2\2\2\u00c7\u00c9\7\23\2\2\u00c8\u00ca\5 \21\2\u00c9\u00c8\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d1\3\2\2\2\u00cb\u00cd\7\4\2\2\u00cc"+
		"\u00ce\5 \21\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1\3\2"+
		"\2\2\u00cf\u00d1\7\22\2\2\u00d0\u00bf\3\2\2\2\u00d0\u00c3\3\2\2\2\u00d0"+
		"\u00c7\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\31\3\2\2"+
		"\2\u00d2\u00d3\7\6\2\2\u00d3\u00d4\5\30\r\2\u00d4\33\3\2\2\2\u00d5\u00d7"+
		"\7\n\2\2\u00d6\u00d8\5\36\20\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2"+
		"\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc"+
		"\7\17\2\2\u00dc\35\3\2\2\2\u00dd\u00e2\5\22\n\2\u00de\u00df\7\31\2\2\u00df"+
		"\u00e1\5\22\n\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3"+
		"\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\37\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e7\7$\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\7\f\2\2\u00e9\u00ea\5\n\6\2\u00ea\u00eb\7\20\2\2\u00eb"+
		"!\3\2\2\2\u00ec\u00ed\7\t\2\2\u00ed\u00ee\7\27\2\2\u00ee\u00ef\5&\24\2"+
		"\u00ef\u00f0\7\30\2\2\u00f0\u00f2\7\n\2\2\u00f1\u00f3\5\b\5\2\u00f2\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\7\17\2\2\u00f7#\3\2\2\2\u00f8\u00f9\7\21\2"+
		"\2\u00f9\u00fa\7\27\2\2\u00fa\u00fb\5&\24\2\u00fb\u00fe\7\30\2\2\u00fc"+
		"\u00ff\5\b\5\2\u00fd\u00ff\5\f\7\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2"+
		"\2\2\u00ff\u0105\3\2\2\2\u0100\u0103\7\26\2\2\u0101\u0104\5\b\5\2\u0102"+
		"\u0104\5\f\7\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0106\3\2"+
		"\2\2\u0105\u0100\3\2\2\2\u0105\u0106\3\2\2\2\u0106%\3\2\2\2\u0107\u0108"+
		"\5\n\6\2\u0108\u0109\7!\2\2\u0109\u010a\5\n\6\2\u010a\u010d\3\2\2\2\u010b"+
		"\u010d\5\n\6\2\u010c\u0107\3\2\2\2\u010c\u010b\3\2\2\2\u010d\'\3\2\2\2"+
		"\u010e\u010f\t\5\2\2\u010f\u0115\7\27\2\2\u0110\u0112\7$\2\2\u0111\u0113"+
		"\5 \21\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0116\7\'\2\2\u0115\u0110\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0118\7\30\2\2\u0118)\3\2\2\2&-\64;BGL_cm{}\u0084\u0095\u009a"+
		"\u009e\u00a4\u00a8\u00ac\u00b2\u00b9\u00bb\u00c1\u00c5\u00c9\u00cd\u00d0"+
		"\u00d9\u00e2\u00e6\u00f4\u00fe\u0103\u0105\u010c\u0112\u0115";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}