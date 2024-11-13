// Generated from CStruct.g4 by ANTLR 4.13.2
 package com.freedom.cn.custom; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CStructLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Identifier=6, VarName=7, TypeName=8, 
		LINE_COMMENT=9, COMMENT=10, WS=11, MultiLineMacro=12, Directive=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "Identifier", "IdentifierNondigit", 
			"Nondigit", "Digit", "VarName", "TypeName", "CW", "LINE_COMMENT", "COMMENT", 
			"WS", "MultiLineMacro", "Directive"
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


	public CStructLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CStruct.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r\u0095\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005:\b\u0005\n\u0005\f\u0005=\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0004\tG\b\t\u000b\t\f\tH\u0001\n\u0001\n\u0004\nM\b\n\u000b\n\f\n"+
		"N\u0001\u000b\u0003\u000bR\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\fX\b\f\n\f\f\f[\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\re\b\r\n\r\f\rh\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0004\u000ep\b\u000e\u000b\u000e\f\u000eq\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0005\u000fx\b\u000f\n\u000f\f\u000f{\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u007f\b\u000f\u0001\u000f\u0004"+
		"\u000f\u0082\b\u000f\u000b\u000f\f\u000f\u0083\u0001\u000f\u0004\u000f"+
		"\u0087\b\u000f\u000b\u000f\f\u000f\u0088\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u008f\b\u0010\n\u0010\f\u0010\u0092\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0003Yfy\u0000\u0011\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011"+
		"\u0000\u0013\u0007\u0015\b\u0017\u0000\u0019\t\u001b\n\u001d\u000b\u001f"+
		"\f!\r\u0001\u0000\u0005\u0003\u0000AZ__az\u0001\u000009\u0007\u0000**"+
		"--09A[]]__az\u0003\u0000\t\n\r\r  \u0001\u0000\n\n\u009e\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0001#\u0001\u0000\u0000\u0000\u0003*\u0001\u0000\u0000\u0000\u0005"+
		"0\u0001\u0000\u0000\u0000\u00072\u0001\u0000\u0000\u0000\t4\u0001\u0000"+
		"\u0000\u0000\u000b6\u0001\u0000\u0000\u0000\r>\u0001\u0000\u0000\u0000"+
		"\u000f@\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013F"+
		"\u0001\u0000\u0000\u0000\u0015L\u0001\u0000\u0000\u0000\u0017Q\u0001\u0000"+
		"\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001b`\u0001\u0000\u0000\u0000"+
		"\u001do\u0001\u0000\u0000\u0000\u001fu\u0001\u0000\u0000\u0000!\u008c"+
		"\u0001\u0000\u0000\u0000#$\u0005s\u0000\u0000$%\u0005t\u0000\u0000%&\u0005"+
		"r\u0000\u0000&\'\u0005u\u0000\u0000\'(\u0005c\u0000\u0000()\u0005t\u0000"+
		"\u0000)\u0002\u0001\u0000\u0000\u0000*+\u0005u\u0000\u0000+,\u0005n\u0000"+
		"\u0000,-\u0005i\u0000\u0000-.\u0005o\u0000\u0000./\u0005n\u0000\u0000"+
		"/\u0004\u0001\u0000\u0000\u000001\u0005{\u0000\u00001\u0006\u0001\u0000"+
		"\u0000\u000023\u0005}\u0000\u00003\b\u0001\u0000\u0000\u000045\u0005;"+
		"\u0000\u00005\n\u0001\u0000\u0000\u00006;\u0003\r\u0006\u00007:\u0003"+
		"\u000f\u0007\u00008:\u0003\u0011\b\u000097\u0001\u0000\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<\f\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>?\u0003\u000f\u0007\u0000?\u000e\u0001\u0000\u0000\u0000@A\u0007"+
		"\u0000\u0000\u0000A\u0010\u0001\u0000\u0000\u0000BC\u0007\u0001\u0000"+
		"\u0000C\u0012\u0001\u0000\u0000\u0000DG\u0003\u000f\u0007\u0000EG\u0003"+
		"\u0011\b\u0000FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"I\u0014\u0001\u0000\u0000\u0000JM\u0003\u0017\u000b\u0000KM\u0005*\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0016"+
		"\u0001\u0000\u0000\u0000PR\u0007\u0002\u0000\u0000QP\u0001\u0000\u0000"+
		"\u0000R\u0018\u0001\u0000\u0000\u0000ST\u0005/\u0000\u0000TU\u0005/\u0000"+
		"\u0000UY\u0001\u0000\u0000\u0000VX\t\u0000\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000X[\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005"+
		"\n\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0006\f\u0000\u0000_\u001a"+
		"\u0001\u0000\u0000\u0000`a\u0005/\u0000\u0000ab\u0005*\u0000\u0000bf\u0001"+
		"\u0000\u0000\u0000ce\t\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0005*\u0000\u0000"+
		"jk\u0005/\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0006\r\u0000\u0000"+
		"m\u001c\u0001\u0000\u0000\u0000np\u0007\u0003\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0006\u000e\u0000\u0000"+
		"t\u001e\u0001\u0000\u0000\u0000u\u0081\u0005#\u0000\u0000vx\b\u0004\u0000"+
		"\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|~\u0005\\\u0000\u0000}\u007f\u0005\r\u0000\u0000~}"+
		"\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0082\u0005\n\u0000\u0000\u0081y\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085\u0087\b\u0004\u0000\u0000\u0086\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0006\u000f\u0001\u0000\u008b \u0001\u0000\u0000\u0000"+
		"\u008c\u0090\u0005#\u0000\u0000\u008d\u008f\b\u0004\u0000\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0006\u0010\u0001\u0000\u0094\"\u0001\u0000\u0000\u0000\u0010\u0000"+
		"9;FHLNQYfqy~\u0083\u0088\u0090\u0002\u0006\u0000\u0000\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}