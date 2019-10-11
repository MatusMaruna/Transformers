// Generated from Ofp.g4 by ANTLR 4.4

    package antlr4;

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
		FLOAT=33, ID=34, STR=35, CHAR=36, SYM=37, COMMENT=38, SC=39, WS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'main'", "'char'", "'println'", "'new'", "'return'", "'float'", 
		"'while'", "'{'", "'['", "'void'", "'='", "'}'", "']'", "'if'", "'bool'", 
		"'string'", "'int'", "'print'", "'else'", "'.length'", "'('", "')'", "','", 
		"'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "COP", "INT", "FLOAT", 
		"ID", "STR", "CHAR", "SYM", "COMMENT", "';'", "WS"
	};
	public static final int
		RULE_start = 0, RULE_main = 1, RULE_method = 2, RULE_parameter = 3, RULE_parameterList = 4, 
		RULE_block = 5, RULE_returnStmt = 6, RULE_type = 7, RULE_varType = 8, 
		RULE_stmt = 9, RULE_expr = 10, RULE_methodAccess = 11, RULE_localDecl = 12, 
		RULE_declaration = 13, RULE_asgnStmt = 14, RULE_methodCall = 15, RULE_arrayList = 16, 
		RULE_array = 17, RULE_arrType = 18, RULE_whileStmt = 19, RULE_ifStmt = 20, 
		RULE_elseStmt = 21, RULE_condition = 22, RULE_print = 23;
	public static final String[] ruleNames = {
		"start", "main", "method", "parameter", "parameterList", "block", "returnStmt", 
		"type", "varType", "stmt", "expr", "methodAccess", "localDecl", "declaration", 
		"asgnStmt", "methodCall", "arrayList", "array", "arrType", "whileStmt", 
		"ifStmt", "elseStmt", "condition", "print"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
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
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48); method();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(54); main();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__13) | (1L << T__8) | (1L << T__7) | (1L << T__6))) != 0)) {
				{
				{
				setState(55); method();
				}
				}
				setState(60);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(T__13);
			setState(62); match(T__22);
			setState(63); match(T__2);
			setState(64); match(T__1);
			setState(65); block();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_method);
		int _la;
		try {
			setState(88);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); match(T__13);
				setState(68); match(ID);
				setState(69); match(T__2);
				setState(71);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__8) | (1L << T__7) | (1L << T__6))) != 0)) {
					{
					setState(70); parameterList();
					}
				}

				setState(73); match(T__1);
				setState(74); block();
				}
				break;
			case T__21:
			case T__17:
			case T__8:
			case T__7:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); type();
				setState(78);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(76); match(T__14);
					setState(77); match(T__10);
					}
				}

				setState(80); match(ID);
				setState(81); match(T__2);
				setState(83);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__17) | (1L << T__8) | (1L << T__7) | (1L << T__6))) != 0)) {
					{
					setState(82); parameterList();
					}
				}

				setState(85); match(T__1);
				setState(86); block();
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); type();
			setState(91); match(ID);
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

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); parameter();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(94); match(T__0);
				setState(95); parameter();
				}
				}
				setState(100);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(T__15);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << ID))) != 0)) {
				{
				{
				setState(102); stmt();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108); match(T__11);
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
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(T__18);
			setState(111); expr(0);
			setState(112); match(SC);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(114); match(T__6);
				setState(116);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(115); arrType();
					}
					break;
				}
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); match(T__17);
				setState(120);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(119); arrType();
					}
					break;
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(122); match(T__7);
				setState(124);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(123); arrType();
					}
					break;
				}
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(126); match(T__21);
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(127); arrType();
					}
					break;
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(130); match(T__8);
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

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public TerminalNode STR() { return getToken(OfpParser.STR, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varType);
		int _la;
		try {
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(134); match(MINUS);
					}
				}

				setState(137); match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(138); match(MINUS);
					}
				}

				setState(141); match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142); match(STR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143); match(CHAR);
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

	public static class StmtContext extends ParserRuleContext {
		public LocalDeclContext localDecl() {
			return getRuleContext(LocalDeclContext.class,0);
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
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146); asgnStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148); whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149); ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150); print();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(151); returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(152); methodCall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(153); localDecl();
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
		public ArrayListContext arrayList() {
			return getRuleContext(ArrayListContext.class,0);
		}
		public MethodAccessContext methodAccess() {
			return getRuleContext(MethodAccessContext.class,0);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(157); methodAccess();
				}
				break;
			case 3:
				{
				setState(158); match(T__19);
				setState(159); type();
				}
				break;
			case 4:
				{
				setState(160); match(ID);
				setState(161); match(T__3);
				}
				break;
			case 5:
				{
				setState(162); varType();
				}
				break;
			case 6:
				{
				setState(163); arrayList();
				}
				break;
			case 7:
				{
				setState(164); arrType();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(168); match(MULT);
						setState(169); expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(171); match(DIV);
						setState(172); expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(174); match(PLUS);
						setState(175); expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(177); match(MINUS);
						setState(178); expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(180); match(SMALL);
						setState(181); expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(183); match(BIGGER);
						setState(184); expr(8);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186); match(EQ);
						setState(187); expr(7);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class MethodAccessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MethodAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterMethodAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitMethodAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitMethodAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodAccessContext methodAccess() throws RecognitionException {
		MethodAccessContext _localctx = new MethodAccessContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(193); match(ID);
				}
			}

			setState(196); match(T__2);
			setState(197); expr(0);
			setState(198); match(T__1);
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

	public static class LocalDeclContext extends ParserRuleContext {
		public ArrTypeContext arrType() {
			return getRuleContext(ArrTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
		public LocalDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterLocalDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitLocalDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitLocalDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDeclContext localDecl() throws RecognitionException {
		LocalDeclContext _localctx = new LocalDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_localDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); type();
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(201); arrType();
				}
				break;
			}
			setState(204); match(ID);
			setState(205); match(SC);
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
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); type();
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(208); arrType();
				}
				break;
			}
			setState(211); match(ID);
			setState(212); match(T__12);
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(213); expr(0);
				}
				break;
			case 2:
				{
				setState(214); arrType();
				}
				break;
			case 3:
				{
				setState(215); array();
				}
				break;
			}
			setState(218); match(SC);
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
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitAsgnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsgnStmtContext asgnStmt() throws RecognitionException {
		AsgnStmtContext _localctx = new AsgnStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_asgnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(ID);
			setState(222);
			_la = _input.LA(1);
			if (_la==T__14 || _la==ID) {
				{
				setState(221); arrType();
				}
			}

			setState(224); match(T__12);
			setState(225); expr(0);
			setState(226); match(SC);
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OfpParser.ID, 0); }
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(ID);
			setState(229); match(T__2);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << CHAR))) != 0)) {
				{
				{
				setState(230); varType();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236); match(T__1);
			setState(237); match(SC);
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

	public static class ArrayListContext extends ParserRuleContext {
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public ArrayListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterArrayList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitArrayList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitArrayList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayListContext arrayList() throws RecognitionException {
		ArrayListContext _localctx = new ArrayListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239); varType();
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(240); match(T__0);
					setState(241); varType();
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class ArrayContext extends ParserRuleContext {
		public ArrayListContext arrayList(int i) {
			return getRuleContext(ArrayListContext.class,i);
		}
		public List<ArrayListContext> arrayList() {
			return getRuleContexts(ArrayListContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(T__15);
			setState(249); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(248); arrayList();
				}
				}
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << CHAR))) != 0) );
			setState(253); match(T__11);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitArrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrTypeContext arrType() throws RecognitionException {
		ArrTypeContext _localctx = new ArrTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(255); match(ID);
				}
			}

			setState(258); match(T__14);
			setState(259); expr(0);
			setState(260); match(T__10);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(T__16);
			setState(263); match(T__2);
			setState(264); condition();
			setState(265); match(T__1);
			setState(266); block();
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
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(T__9);
			setState(269); match(T__2);
			setState(270); condition();
			setState(271); match(T__1);
			setState(274);
			switch (_input.LA(1)) {
			case T__21:
			case T__20:
			case T__18:
			case T__17:
			case T__16:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
			case T__5:
			case ID:
				{
				setState(272); stmt();
				}
				break;
			case T__15:
				{
				setState(273); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(276); elseStmt();
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

	public static class ElseStmtContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OfpListener ) ((OfpListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(279); match(T__4);
			setState(282);
			switch (_input.LA(1)) {
			case T__21:
			case T__20:
			case T__18:
			case T__17:
			case T__16:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
			case T__5:
			case ID:
				{
				setState(280); stmt();
				}
				break;
			case T__15:
				{
				setState(281); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_condition);
		try {
			setState(289);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(284); expr(0);
				setState(285); match(COP);
				setState(286); expr(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288); expr(0);
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
		public TerminalNode SC() { return getToken(OfpParser.SC, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OfpVisitor ) return ((OfpVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(292); match(T__2);
			setState(298);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(293); match(ID);
				setState(295);
				_la = _input.LA(1);
				if (_la==T__14 || _la==ID) {
					{
					setState(294); arrType();
					}
				}

				}
				break;
			case STR:
				{
				setState(297); match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(300); match(T__1);
			setState(301); match(SC);
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
		case 10: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		case 5: return precpred(_ctx, 7);
		case 6: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\3\4\5\4Q\n"+
		"\4\3\4\3\4\3\4\5\4V\n\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\6\3\6\3\6\7"+
		"\6c\n\6\f\6\16\6f\13\6\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\5\tw\n\t\3\t\3\t\5\t{\n\t\3\t\3\t\5\t\177\n\t\3\t\3\t"+
		"\5\t\u0083\n\t\3\t\5\t\u0086\n\t\3\n\3\n\5\n\u008a\n\n\3\n\3\n\5\n\u008e"+
		"\n\n\3\n\3\n\3\n\5\n\u0093\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u009d\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a8\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u00bf\n\f\f\f\16\f\u00c2\13\f\3\r\5\r\u00c5\n\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\5\16\u00cd\n\16\3\16\3\16\3\16\3\17\3\17\5\17\u00d4"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00db\n\17\3\17\3\17\3\20\3\20\5\20"+
		"\u00e1\n\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00ea\n\21\f\21\16"+
		"\21\u00ed\13\21\3\21\3\21\3\21\3\22\3\22\3\22\7\22\u00f5\n\22\f\22\16"+
		"\22\u00f8\13\22\3\23\3\23\6\23\u00fc\n\23\r\23\16\23\u00fd\3\23\3\23\3"+
		"\24\5\24\u0103\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0115\n\26\3\26\5\26\u0118\n\26\3"+
		"\27\3\27\3\27\5\27\u011d\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u0124\n\30"+
		"\3\31\3\31\3\31\3\31\5\31\u012a\n\31\3\31\5\31\u012d\n\31\3\31\3\31\3"+
		"\31\3\31\2\3\26\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\2\3\4\2\5\5\24\24\u0153\2\65\3\2\2\2\4?\3\2\2\2\6Z\3\2\2\2\b\\\3\2\2"+
		"\2\n_\3\2\2\2\fg\3\2\2\2\16p\3\2\2\2\20\u0085\3\2\2\2\22\u0092\3\2\2\2"+
		"\24\u009c\3\2\2\2\26\u00a7\3\2\2\2\30\u00c4\3\2\2\2\32\u00ca\3\2\2\2\34"+
		"\u00d1\3\2\2\2\36\u00de\3\2\2\2 \u00e6\3\2\2\2\"\u00f1\3\2\2\2$\u00f9"+
		"\3\2\2\2&\u0102\3\2\2\2(\u0108\3\2\2\2*\u010e\3\2\2\2,\u0119\3\2\2\2."+
		"\u0123\3\2\2\2\60\u0125\3\2\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64\67\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\28<\5\4\3\29"+
		";\5\6\4\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\3\3\2\2\2><\3\2\2\2"+
		"?@\7\f\2\2@A\7\3\2\2AB\7\27\2\2BC\7\30\2\2CD\5\f\7\2D\5\3\2\2\2EF\7\f"+
		"\2\2FG\7$\2\2GI\7\27\2\2HJ\5\n\6\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\30"+
		"\2\2L[\5\f\7\2MP\5\20\t\2NO\7\13\2\2OQ\7\17\2\2PN\3\2\2\2PQ\3\2\2\2QR"+
		"\3\2\2\2RS\7$\2\2SU\7\27\2\2TV\5\n\6\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2W"+
		"X\7\30\2\2XY\5\f\7\2Y[\3\2\2\2ZE\3\2\2\2ZM\3\2\2\2[\7\3\2\2\2\\]\5\20"+
		"\t\2]^\7$\2\2^\t\3\2\2\2_d\5\b\5\2`a\7\31\2\2ac\5\b\5\2b`\3\2\2\2cf\3"+
		"\2\2\2db\3\2\2\2de\3\2\2\2e\13\3\2\2\2fd\3\2\2\2gk\7\n\2\2hj\5\24\13\2"+
		"ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\16\2"+
		"\2o\r\3\2\2\2pq\7\7\2\2qr\5\26\f\2rs\7)\2\2s\17\3\2\2\2tv\7\23\2\2uw\5"+
		"&\24\2vu\3\2\2\2vw\3\2\2\2w\u0086\3\2\2\2xz\7\b\2\2y{\5&\24\2zy\3\2\2"+
		"\2z{\3\2\2\2{\u0086\3\2\2\2|~\7\22\2\2}\177\5&\24\2~}\3\2\2\2~\177\3\2"+
		"\2\2\177\u0086\3\2\2\2\u0080\u0082\7\4\2\2\u0081\u0083\5&\24\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0086\7\21\2\2"+
		"\u0085t\3\2\2\2\u0085x\3\2\2\2\u0085|\3\2\2\2\u0085\u0080\3\2\2\2\u0085"+
		"\u0084\3\2\2\2\u0086\21\3\2\2\2\u0087\u0093\7$\2\2\u0088\u008a\7\33\2"+
		"\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0093"+
		"\7\"\2\2\u008c\u008e\7\33\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0093\7#\2\2\u0090\u0093\7%\2\2\u0091\u0093"+
		"\7&\2\2\u0092\u0087\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008d\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\23\3\2\2\2\u0094\u009d\5\36\20"+
		"\2\u0095\u009d\5\34\17\2\u0096\u009d\5(\25\2\u0097\u009d\5*\26\2\u0098"+
		"\u009d\5\60\31\2\u0099\u009d\5\16\b\2\u009a\u009d\5 \21\2\u009b\u009d"+
		"\5\32\16\2\u009c\u0094\3\2\2\2\u009c\u0095\3\2\2\2\u009c\u0096\3\2\2\2"+
		"\u009c\u0097\3\2\2\2\u009c\u0098\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\25\3\2\2\2\u009e\u00a8\b\f\1\2\u009f"+
		"\u00a8\5\30\r\2\u00a0\u00a1\7\6\2\2\u00a1\u00a8\5\20\t\2\u00a2\u00a3\7"+
		"$\2\2\u00a3\u00a8\7\26\2\2\u00a4\u00a8\5\22\n\2\u00a5\u00a8\5\"\22\2\u00a6"+
		"\u00a8\5&\24\2\u00a7\u009e\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a0\3\2"+
		"\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\u00c0\3\2\2\2\u00a9\u00aa\f\16\2\2\u00aa\u00ab\7"+
		"\34\2\2\u00ab\u00bf\5\26\f\17\u00ac\u00ad\f\r\2\2\u00ad\u00ae\7\35\2\2"+
		"\u00ae\u00bf\5\26\f\16\u00af\u00b0\f\f\2\2\u00b0\u00b1\7\32\2\2\u00b1"+
		"\u00bf\5\26\f\r\u00b2\u00b3\f\13\2\2\u00b3\u00b4\7\33\2\2\u00b4\u00bf"+
		"\5\26\f\f\u00b5\u00b6\f\n\2\2\u00b6\u00b7\7\36\2\2\u00b7\u00bf\5\26\f"+
		"\13\u00b8\u00b9\f\t\2\2\u00b9\u00ba\7\37\2\2\u00ba\u00bf\5\26\f\n\u00bb"+
		"\u00bc\f\b\2\2\u00bc\u00bd\7 \2\2\u00bd\u00bf\5\26\f\t\u00be\u00a9\3\2"+
		"\2\2\u00be\u00ac\3\2\2\2\u00be\u00af\3\2\2\2\u00be\u00b2\3\2\2\2\u00be"+
		"\u00b5\3\2\2\2\u00be\u00b8\3\2\2\2\u00be\u00bb\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\27\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c3\u00c5\7$\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\7\27\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\7"+
		"\30\2\2\u00c9\31\3\2\2\2\u00ca\u00cc\5\20\t\2\u00cb\u00cd\5&\24\2\u00cc"+
		"\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7$"+
		"\2\2\u00cf\u00d0\7)\2\2\u00d0\33\3\2\2\2\u00d1\u00d3\5\20\t\2\u00d2\u00d4"+
		"\5&\24\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\7$\2\2\u00d6\u00da\7\r\2\2\u00d7\u00db\5\26\f\2\u00d8\u00db\5&"+
		"\24\2\u00d9\u00db\5$\23\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7)\2\2\u00dd\35\3\2\2\2"+
		"\u00de\u00e0\7$\2\2\u00df\u00e1\5&\24\2\u00e0\u00df\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\r\2\2\u00e3\u00e4\5\26\f\2"+
		"\u00e4\u00e5\7)\2\2\u00e5\37\3\2\2\2\u00e6\u00e7\7$\2\2\u00e7\u00eb\7"+
		"\27\2\2\u00e8\u00ea\5\22\n\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00ef\7\30\2\2\u00ef\u00f0\7)\2\2\u00f0!\3\2\2\2\u00f1\u00f6"+
		"\5\22\n\2\u00f2\u00f3\7\31\2\2\u00f3\u00f5\5\22\n\2\u00f4\u00f2\3\2\2"+
		"\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7#"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb\7\n\2\2\u00fa\u00fc\5\"\22\2"+
		"\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7\16\2\2\u0100%\3\2\2\2\u0101"+
		"\u0103\7$\2\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0105\7\13\2\2\u0105\u0106\5\26\f\2\u0106\u0107\7\17\2\2\u0107"+
		"\'\3\2\2\2\u0108\u0109\7\t\2\2\u0109\u010a\7\27\2\2\u010a\u010b\5.\30"+
		"\2\u010b\u010c\7\30\2\2\u010c\u010d\5\f\7\2\u010d)\3\2\2\2\u010e\u010f"+
		"\7\20\2\2\u010f\u0110\7\27\2\2\u0110\u0111\5.\30\2\u0111\u0114\7\30\2"+
		"\2\u0112\u0115\5\24\13\2\u0113\u0115\5\f\7\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0113\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0118\5,\27\2\u0117\u0116\3\2"+
		"\2\2\u0117\u0118\3\2\2\2\u0118+\3\2\2\2\u0119\u011c\7\25\2\2\u011a\u011d"+
		"\5\24\13\2\u011b\u011d\5\f\7\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2\2"+
		"\u011d-\3\2\2\2\u011e\u011f\5\26\f\2\u011f\u0120\7!\2\2\u0120\u0121\5"+
		"\26\f\2\u0121\u0124\3\2\2\2\u0122\u0124\5\26\f\2\u0123\u011e\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124/\3\2\2\2\u0125\u0126\t\2\2\2\u0126\u012c\7\27\2\2"+
		"\u0127\u0129\7$\2\2\u0128\u012a\5&\24\2\u0129\u0128\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u012d\7%\2\2\u012c\u0127\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7\30\2\2\u012f\u0130\7"+
		")\2\2\u0130\61\3\2\2\2%\65<IPUZdkvz~\u0082\u0085\u0089\u008d\u0092\u009c"+
		"\u00a7\u00be\u00c0\u00c4\u00cc\u00d3\u00da\u00e0\u00eb\u00f6\u00fd\u0102"+
		"\u0114\u0117\u011c\u0123\u0129\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}