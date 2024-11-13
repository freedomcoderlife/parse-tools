// Generated from CStruct.g4 by ANTLR 4.13.2
 package com.freedom.cn.custom; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CStructParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Identifier=6, VarName=7, TypeName=8, 
		LINE_COMMENT=9, COMMENT=10, WS=11, MultiLineMacro=12, Directive=13;
	public static final int
		RULE_porg = 0, RULE_struct = 1, RULE_union = 2, RULE_structDefine = 3, 
		RULE_structFields = 4, RULE_unionInStruct = 5, RULE_structInStruct = 6, 
		RULE_structField = 7, RULE_structOrUnionField = 8, RULE_typeSpecifier = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"porg", "struct", "union", "structDefine", "structFields", "unionInStruct", 
			"structInStruct", "structField", "structOrUnionField", "typeSpecifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'union'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "Identifier", "VarName", "TypeName", 
			"LINE_COMMENT", "COMMENT", "WS", "MultiLineMacro", "Directive"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CStruct.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CStructParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PorgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CStructParser.EOF, 0); }
		public List<StructDefineContext> structDefine() {
			return getRuleContexts(StructDefineContext.class);
		}
		public StructDefineContext structDefine(int i) {
			return getRuleContext(StructDefineContext.class,i);
		}
		public PorgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_porg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterPorg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitPorg(this);
		}
	}

	public final PorgContext porg() throws RecognitionException {
		PorgContext _localctx = new PorgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_porg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				structDefine();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(25);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStruct(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnionContext extends ParserRuleContext {
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitUnion(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDefineContext extends ParserRuleContext {
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CStructParser.Identifier, 0); }
		public StructFieldsContext structFields() {
			return getRuleContext(StructFieldsContext.class,0);
		}
		public StructDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStructDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStructDefine(this);
		}
	}

	public final StructDefineContext structDefine() throws RecognitionException {
		StructDefineContext _localctx = new StructDefineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDefine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			struct();
			setState(32);
			match(Identifier);
			setState(33);
			match(T__2);
			setState(34);
			structFields();
			setState(35);
			match(T__3);
			setState(36);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldsContext extends ParserRuleContext {
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public StructFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structFields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStructFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStructFields(this);
		}
	}

	public final StructFieldsContext structFields() throws RecognitionException {
		StructFieldsContext _localctx = new StructFieldsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				structField();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 262L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnionInStructContext extends ParserRuleContext {
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public StructFieldsContext structFields() {
			return getRuleContext(StructFieldsContext.class,0);
		}
		public TerminalNode VarName() { return getToken(CStructParser.VarName, 0); }
		public UnionInStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionInStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterUnionInStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitUnionInStruct(this);
		}
	}

	public final UnionInStructContext unionInStruct() throws RecognitionException {
		UnionInStructContext _localctx = new UnionInStructContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unionInStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			union();
			setState(44);
			match(T__2);
			setState(45);
			structFields();
			setState(46);
			match(T__3);
			setState(47);
			match(VarName);
			setState(48);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructInStructContext extends ParserRuleContext {
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public StructInStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStructInStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStructInStruct(this);
		}
	}

	public final StructInStructContext structInStruct() throws RecognitionException {
		StructInStructContext _localctx = new StructInStructContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structInStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			struct();
			setState(51);
			typeSpecifier();
			setState(52);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldContext extends ParserRuleContext {
		public StructOrUnionFieldContext structOrUnionField() {
			return getRuleContext(StructOrUnionFieldContext.class,0);
		}
		public UnionInStructContext unionInStruct() {
			return getRuleContext(UnionInStructContext.class,0);
		}
		public StructInStructContext structInStruct() {
			return getRuleContext(StructInStructContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStructField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStructField(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structField);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeName:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				structOrUnionField();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				unionInStruct();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				structInStruct();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructOrUnionFieldContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public StructOrUnionFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnionField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterStructOrUnionField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitStructOrUnionField(this);
		}
	}

	public final StructOrUnionFieldContext structOrUnionField() throws RecognitionException {
		StructOrUnionFieldContext _localctx = new StructOrUnionFieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structOrUnionField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			typeSpecifier();
			setState(60);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public List<TerminalNode> TypeName() { return getTokens(CStructParser.TypeName); }
		public TerminalNode TypeName(int i) {
			return getToken(CStructParser.TypeName, i);
		}
		public List<TerminalNode> WS() { return getTokens(CStructParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CStructParser.WS, i);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CStructListener ) ((CStructListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(TypeName);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(63);
					match(WS);
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(68);
				match(TypeName);
				}
				}
				setState(73);
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

	public static final String _serializedATN =
		"\u0004\u0001\rK\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004(\b\u0004\u000b"+
		"\u0004\f\u0004)\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007:\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0004\tA\b\t\u000b\t\f\tB\u0001\t\u0005"+
		"\tF\b\t\n\t\f\tI\t\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0000\u0000F\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0002\u001b\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000"+
		"\u0006\u001f\u0001\u0000\u0000\u0000\b\'\u0001\u0000\u0000\u0000\n+\u0001"+
		"\u0000\u0000\u0000\f2\u0001\u0000\u0000\u0000\u000e9\u0001\u0000\u0000"+
		"\u0000\u0010;\u0001\u0000\u0000\u0000\u0012>\u0001\u0000\u0000\u0000\u0014"+
		"\u0016\u0003\u0006\u0003\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016"+
		"\u0017\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0005\u0001\u0000\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0005\u0002\u0000\u0000\u001e\u0005\u0001\u0000\u0000\u0000\u001f"+
		" \u0003\u0002\u0001\u0000 !\u0005\u0006\u0000\u0000!\"\u0005\u0003\u0000"+
		"\u0000\"#\u0003\b\u0004\u0000#$\u0005\u0004\u0000\u0000$%\u0005\u0005"+
		"\u0000\u0000%\u0007\u0001\u0000\u0000\u0000&(\u0003\u000e\u0007\u0000"+
		"\'&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*\t\u0001\u0000\u0000\u0000+,\u0003\u0004"+
		"\u0002\u0000,-\u0005\u0003\u0000\u0000-.\u0003\b\u0004\u0000./\u0005\u0004"+
		"\u0000\u0000/0\u0005\u0007\u0000\u000001\u0005\u0005\u0000\u00001\u000b"+
		"\u0001\u0000\u0000\u000023\u0003\u0002\u0001\u000034\u0003\u0012\t\u0000"+
		"45\u0005\u0005\u0000\u00005\r\u0001\u0000\u0000\u00006:\u0003\u0010\b"+
		"\u00007:\u0003\n\u0005\u00008:\u0003\f\u0006\u000096\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u000f\u0001"+
		"\u0000\u0000\u0000;<\u0003\u0012\t\u0000<=\u0005\u0005\u0000\u0000=\u0011"+
		"\u0001\u0000\u0000\u0000>G\u0005\b\u0000\u0000?A\u0005\u000b\u0000\u0000"+
		"@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0005\b\u0000"+
		"\u0000E@\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0013\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000\u0005\u0017)9BG";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}