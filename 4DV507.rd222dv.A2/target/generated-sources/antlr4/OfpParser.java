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
		"'while'", "'['", "';'", "'{'", "'void'", "']'", "'='", "'}'", "'if'", 
		"'bool'", "'string'", "'int'", "'print'", "'else'", "'('", "')'", "','", 
		"'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "COP", "INT", "FLOAT", 
		"ID", "IDmax", "SYM", "STR", "CHAR", "COMMENT", "WS"
	};
	public static final int
		RULE_start = 0, RULE_method = 1, RULE_main = 2, RULE_stmt = 3, RULE_expr = 4, 
		RULE_returnStmt = 5, RULE_parameter = 6, RULE_varType = 7, RULE_asgnStmt = 8, 
		RULE_declaration = 9, RULE_type = 10, RULE_arrExpr = 11, RULE_array = 12, 
		RULE_inArray = 13, RULE_arrType = 14, RULE_whileStmt = 15, RULE_ifStmt = 16, 
		RULE_ifStmtOne = 17, RULE_condition = 18, RULE_print = 19;
	public static final String[] ruleNames = {
		"start", "method", "main", "stmt", "expr", "returnStmt", "parameter", 
		"varType", "asgnStmt", "declaration", "type", "arrExpr", "array", "inArray", 
		"arrType", "whileStmt", "ifStmt", "ifStmtOne", "condition", "print"
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
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
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
			int _alt;
			setState(86);
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
				setState(60); match(T__13);
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(61); stmt();
					}
					}
					setState(64); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
				setState(66); match(T__9);
				}
				break;
			case T__21:
			case T__17:
			case T__7:
			case T__6:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); type();
				setState(69); match(ID);
				setState(70); match(T__2);
				setState(72);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__7) | (1L << T__6) | (1L << T__5))) != 0)) {
					{
					setState(71); parameter();
					}
				}

				setState(74); match(T__1);
				setState(75); match(T__13);
				setState(77); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(76); stmt();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(79); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(82);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(81); returnStmt();
					}
				}

				setState(84); match(T__9);
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
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(T__12);
			setState(89); match(T__22);
			setState(90); match(T__2);
			setState(91); match(T__1);
			setState(92); match(T__13);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93); stmt();
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(98); match(T__9);
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
		public IfStmtOneContext ifStmtOne() {
			return getRuleContext(IfStmtOneContext.class,0);
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
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100); expr(0);
				setState(101); match(T__14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103); asgnStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104); declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105); whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106); ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(107); ifStmtOne();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(108); print();
				setState(109); match(T__14);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(111); returnStmt();
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
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(115); match(T__2);
				setState(116); expr(0);
				setState(117); match(T__1);
				}
				break;
			case 2:
				{
				setState(119); varType();
				}
				break;
			case 3:
				{
				setState(120); arrExpr();
				}
				break;
			case 4:
				{
				setState(121); arrType();
				}
				break;
			case 5:
				{
				setState(122); inArray();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(139);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(126);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(127); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(129);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(130); expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(132);
						_la = _input.LA(1);
						if ( !(_la==SMALL || _la==BIGGER) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(133); expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(135); match(EQ);
						setState(136); expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(138); expr(0);
						}
						break;
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 10, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(T__18);
			setState(145); expr(0);
			setState(146); match(T__14);
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
		enterRule(_localctx, 12, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); type();
			setState(149); match(ID);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(150); match(T__0);
				setState(151); type();
				setState(152); match(ID);
				}
				}
				setState(158);
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
		enterRule(_localctx, 14, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 16, RULE_asgnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(ID);
			setState(163);
			_la = _input.LA(1);
			if (_la==T__15 || _la==ID) {
				{
				setState(162); arrType();
				}
			}

			setState(167);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(165); match(T__10);
				setState(166); expr(0);
				}
			}

			setState(169); match(T__14);
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
		enterRule(_localctx, 18, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); type();
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(172); arrType();
				}
				break;
			}
			setState(175); match(ID);
			setState(182);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(176); match(T__10);
				setState(180);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(177); expr(0);
					}
					break;
				case 2:
					{
					setState(178); arrType();
					}
					break;
				case 3:
					{
					setState(179); array();
					}
					break;
				}
				}
			}

			setState(184); match(T__14);
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(186); match(T__5);
				setState(188);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(187); arrType();
					}
					break;
				}
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(190); match(T__17);
				setState(192);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(191); arrType();
					}
					break;
				}
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(194); match(T__6);
				setState(196);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(195); arrType();
					}
					break;
				}
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(198); match(T__21);
				setState(200);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(199); arrType();
					}
					break;
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(202); match(T__7);
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
		enterRule(_localctx, 22, RULE_arrExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); match(T__19);
			setState(206); type();
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
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(T__13);
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209); inArray();
				}
				}
				setState(212); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(214); match(T__9);
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
		enterRule(_localctx, 26, RULE_inArray);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216); varType();
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(217); match(T__0);
					setState(218); varType();
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 28, RULE_arrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(224); match(ID);
				}
			}

			setState(227); match(T__15);
			setState(229);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__15) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0)) {
				{
				setState(228); expr(0);
				}
			}

			setState(231); match(T__11);
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
		enterRule(_localctx, 30, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(T__16);
			setState(234); match(T__2);
			setState(235); condition();
			setState(236); match(T__1);
			setState(237); match(T__13);
			setState(239); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(238); stmt();
				}
				}
				setState(241); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(243); match(T__9);
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
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
		enterRule(_localctx, 32, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(T__8);
			setState(246); match(T__2);
			setState(247); condition();
			setState(248); match(T__1);
			setState(249); match(T__13);
			setState(251); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(250); stmt();
				}
				}
				setState(253); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(255); match(T__9);
				setState(256); match(T__3);
				setState(257); match(T__13);
				setState(259); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(258); stmt();
					}
					}
					setState(261); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__15) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << IDmax) | (1L << STR) | (1L << CHAR))) != 0) );
				}
				break;
			}
			setState(265); match(T__9);
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

	public static class IfStmtOneContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfStmtOneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmtOne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterIfStmtOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitIfStmtOne(this);
		}
	}

	public final IfStmtOneContext ifStmtOne() throws RecognitionException {
		IfStmtOneContext _localctx = new IfStmtOneContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStmtOne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(T__8);
			setState(268); match(T__2);
			setState(269); condition();
			setState(270); match(T__1);
			setState(271); stmt();
			setState(274);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(272); match(T__3);
				setState(273); stmt();
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
			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(276); expr(0);
				setState(277); match(COP);
				setState(278); expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280); expr(0);
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
			setState(283);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(284); match(T__2);
			setState(290);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(285); match(ID);
				setState(287);
				_la = _input.LA(1);
				if (_la==T__15 || _la==ID) {
					{
					setState(286); arrType();
					}
				}

				}
				break;
			case STR:
				{
				setState(289); match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(292); match(T__1);
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
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0129\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\7\2"+
		"\63\n\2\f\2\16\2\66\13\2\3\3\3\3\3\3\3\3\5\3<\n\3\3\3\3\3\3\3\6\3A\n\3"+
		"\r\3\16\3B\3\3\3\3\3\3\3\3\3\3\3\3\5\3K\n\3\3\3\3\3\3\3\6\3P\n\3\r\3\16"+
		"\3Q\3\3\5\3U\n\3\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4a\n\4\r\4"+
		"\16\4b\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5s\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6~\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008e\n\6\f\6\16\6\u0091\13\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u009d\n\b\f\b\16\b\u00a0\13"+
		"\b\3\t\3\t\3\n\3\n\5\n\u00a6\n\n\3\n\3\n\5\n\u00aa\n\n\3\n\3\n\3\13\3"+
		"\13\5\13\u00b0\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b7\n\13\5\13\u00b9"+
		"\n\13\3\13\3\13\3\f\3\f\5\f\u00bf\n\f\3\f\3\f\5\f\u00c3\n\f\3\f\3\f\5"+
		"\f\u00c7\n\f\3\f\3\f\5\f\u00cb\n\f\3\f\5\f\u00ce\n\f\3\r\3\r\3\r\3\16"+
		"\3\16\6\16\u00d5\n\16\r\16\16\16\u00d6\3\16\3\16\3\17\3\17\3\17\7\17\u00de"+
		"\n\17\f\17\16\17\u00e1\13\17\3\20\5\20\u00e4\n\20\3\20\3\20\5\20\u00e8"+
		"\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00f2\n\21\r\21\16"+
		"\21\u00f3\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u00fe\n\22\r\22"+
		"\16\22\u00ff\3\22\3\22\3\22\3\22\6\22\u0106\n\22\r\22\16\22\u0107\5\22"+
		"\u010a\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0115\n"+
		"\23\3\24\3\24\3\24\3\24\3\24\5\24\u011c\n\24\3\25\3\25\3\25\3\25\5\25"+
		"\u0122\n\25\3\25\5\25\u0125\n\25\3\25\3\25\3\25\2\3\n\26\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(\2\7\3\2\34\35\3\2\32\33\3\2\36\37\4\2\""+
		"%\'(\4\2\5\5\25\25\u0148\2-\3\2\2\2\4X\3\2\2\2\6Z\3\2\2\2\br\3\2\2\2\n"+
		"}\3\2\2\2\f\u0092\3\2\2\2\16\u0096\3\2\2\2\20\u00a1\3\2\2\2\22\u00a3\3"+
		"\2\2\2\24\u00ad\3\2\2\2\26\u00cd\3\2\2\2\30\u00cf\3\2\2\2\32\u00d2\3\2"+
		"\2\2\34\u00da\3\2\2\2\36\u00e3\3\2\2\2 \u00eb\3\2\2\2\"\u00f7\3\2\2\2"+
		"$\u010d\3\2\2\2&\u011b\3\2\2\2(\u011d\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\64\5\6\4\2\61\63\5"+
		"\4\3\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\3\3"+
		"\2\2\2\66\64\3\2\2\2\678\7\r\2\289\7$\2\29;\7\27\2\2:<\5\16\b\2;:\3\2"+
		"\2\2;<\3\2\2\2<=\3\2\2\2=>\7\30\2\2>@\7\f\2\2?A\5\b\5\2@?\3\2\2\2AB\3"+
		"\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\20\2\2EY\3\2\2\2FG\5\26\f\2G"+
		"H\7$\2\2HJ\7\27\2\2IK\5\16\b\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\30\2"+
		"\2MO\7\f\2\2NP\5\b\5\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2"+
		"\2SU\5\f\7\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\20\2\2WY\3\2\2\2X\67\3"+
		"\2\2\2XF\3\2\2\2Y\5\3\2\2\2Z[\7\r\2\2[\\\7\3\2\2\\]\7\27\2\2]^\7\30\2"+
		"\2^`\7\f\2\2_a\5\b\5\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2"+
		"\2de\7\20\2\2e\7\3\2\2\2fg\5\n\6\2gh\7\13\2\2hs\3\2\2\2is\5\22\n\2js\5"+
		"\24\13\2ks\5 \21\2ls\5\"\22\2ms\5$\23\2no\5(\25\2op\7\13\2\2ps\3\2\2\2"+
		"qs\5\f\7\2rf\3\2\2\2ri\3\2\2\2rj\3\2\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2\2\2"+
		"rn\3\2\2\2rq\3\2\2\2s\t\3\2\2\2tu\b\6\1\2uv\7\27\2\2vw\5\n\6\2wx\7\30"+
		"\2\2x~\3\2\2\2y~\5\20\t\2z~\5\30\r\2{~\5\36\20\2|~\5\34\17\2}t\3\2\2\2"+
		"}y\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\u008f\3\2\2\2\177\u0080\f\13"+
		"\2\2\u0080\u0081\t\2\2\2\u0081\u008e\5\n\6\f\u0082\u0083\f\n\2\2\u0083"+
		"\u0084\t\3\2\2\u0084\u008e\5\n\6\13\u0085\u0086\f\t\2\2\u0086\u0087\t"+
		"\4\2\2\u0087\u008e\5\n\6\n\u0088\u0089\f\b\2\2\u0089\u008a\7 \2\2\u008a"+
		"\u008e\5\n\6\t\u008b\u008c\f\3\2\2\u008c\u008e\5\n\6\2\u008d\177\3\2\2"+
		"\2\u008d\u0082\3\2\2\2\u008d\u0085\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\13\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\7\2\2\u0093\u0094\5\n\6"+
		"\2\u0094\u0095\7\13\2\2\u0095\r\3\2\2\2\u0096\u0097\5\26\f\2\u0097\u009e"+
		"\7$\2\2\u0098\u0099\7\31\2\2\u0099\u009a\5\26\f\2\u009a\u009b\7$\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u0098\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\17\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2"+
		"\t\5\2\2\u00a2\21\3\2\2\2\u00a3\u00a5\7$\2\2\u00a4\u00a6\5\36\20\2\u00a5"+
		"\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\7\17"+
		"\2\2\u00a8\u00aa\5\n\6\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\7\13\2\2\u00ac\23\3\2\2\2\u00ad\u00af\5\26"+
		"\f\2\u00ae\u00b0\5\36\20\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b8\7$\2\2\u00b2\u00b6\7\17\2\2\u00b3\u00b7\5\n"+
		"\6\2\u00b4\u00b7\5\36\20\2\u00b5\u00b7\5\32\16\2\u00b6\u00b3\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b2\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\13\2\2\u00bb"+
		"\25\3\2\2\2\u00bc\u00be\7\24\2\2\u00bd\u00bf\5\36\20\2\u00be\u00bd\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00ce\3\2\2\2\u00c0\u00c2\7\b\2\2\u00c1"+
		"\u00c3\5\36\20\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00ce\3"+
		"\2\2\2\u00c4\u00c6\7\23\2\2\u00c5\u00c7\5\36\20\2\u00c6\u00c5\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\u00ce\3\2\2\2\u00c8\u00ca\7\4\2\2\u00c9\u00cb"+
		"\5\36\20\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2"+
		"\u00cc\u00ce\7\22\2\2\u00cd\u00bc\3\2\2\2\u00cd\u00c0\3\2\2\2\u00cd\u00c4"+
		"\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\27\3\2\2\2\u00cf"+
		"\u00d0\7\6\2\2\u00d0\u00d1\5\26\f\2\u00d1\31\3\2\2\2\u00d2\u00d4\7\f\2"+
		"\2\u00d3\u00d5\5\34\17\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\7\20"+
		"\2\2\u00d9\33\3\2\2\2\u00da\u00df\5\20\t\2\u00db\u00dc\7\31\2\2\u00dc"+
		"\u00de\5\20\t\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\35\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e4\7$\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\7\n\2\2\u00e6\u00e8\5\n\6\2\u00e7\u00e6\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\16\2\2\u00ea\37\3\2\2"+
		"\2\u00eb\u00ec\7\t\2\2\u00ec\u00ed\7\27\2\2\u00ed\u00ee\5&\24\2\u00ee"+
		"\u00ef\7\30\2\2\u00ef\u00f1\7\f\2\2\u00f0\u00f2\5\b\5\2\u00f1\u00f0\3"+
		"\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\20\2\2\u00f6!\3\2\2\2\u00f7\u00f8\7\21\2"+
		"\2\u00f8\u00f9\7\27\2\2\u00f9\u00fa\5&\24\2\u00fa\u00fb\7\30\2\2\u00fb"+
		"\u00fd\7\f\2\2\u00fc\u00fe\5\b\5\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0109\3\2\2\2\u0101"+
		"\u0102\7\20\2\2\u0102\u0103\7\26\2\2\u0103\u0105\7\f\2\2\u0104\u0106\5"+
		"\b\5\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\20\2\2\u010c#\3\2\2\2\u010d\u010e"+
		"\7\21\2\2\u010e\u010f\7\27\2\2\u010f\u0110\5&\24\2\u0110\u0111\7\30\2"+
		"\2\u0111\u0114\5\b\5\2\u0112\u0113\7\26\2\2\u0113\u0115\5\b\5\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115%\3\2\2\2\u0116\u0117\5\n\6\2"+
		"\u0117\u0118\7!\2\2\u0118\u0119\5\n\6\2\u0119\u011c\3\2\2\2\u011a\u011c"+
		"\5\n\6\2\u011b\u0116\3\2\2\2\u011b\u011a\3\2\2\2\u011c\'\3\2\2\2\u011d"+
		"\u011e\t\6\2\2\u011e\u0124\7\27\2\2\u011f\u0121\7$\2\2\u0120\u0122\5\36"+
		"\20\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0125\7\'\2\2\u0124\u011f\3\2\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0127\7\30\2\2\u0127)\3\2\2\2&-\64;BJQTXbr}\u008d\u008f\u009e"+
		"\u00a5\u00a9\u00af\u00b6\u00b8\u00be\u00c2\u00c6\u00ca\u00cd\u00d6\u00df"+
		"\u00e3\u00e7\u00f3\u00ff\u0107\u0109\u0114\u011b\u0121\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}