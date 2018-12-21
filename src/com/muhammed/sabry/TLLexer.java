// Generated from C:/Users/Muhammed/IdeaProjects/tiny-language-github/src/main/antlr4/tl/antlr4\TL.g4 by ANTLR 4.7.2
package com.muhammed.sabry;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, TERMINATOR=2, If=3, Else=4, For=5, Then=6, End=7, Or=8, And=9, 
		Equals=10, NEquals=11, GTEquals=12, LTEquals=13, GT=14, LT=15, Add=16, 
		Subtract=17, Multiply=18, Divide=19, OBrace=20, CBrace=21, OBracket=22, 
		CBracket=23, OParen=24, CParen=25, SColon=26, Assign=27, Comma=28, REPEAT=29, 
		UNTIL=30, READ=31, WRITE=32, Number=33, Identifier=34, String=35, Comment=36, 
		Space=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "TERMINATOR", "If", "Else", "For", "Then", "End", "Or", "And", 
			"Equals", "NEquals", "GTEquals", "LTEquals", "GT", "LT", "Add", "Subtract", 
			"Multiply", "Divide", "OBrace", "CBrace", "OBracket", "CBracket", "OParen", 
			"CParen", "SColon", "Assign", "Comma", "REPEAT", "UNTIL", "READ", "WRITE", 
			"Number", "Identifier", "String", "Comment", "Space", "Int", "Digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'%'", null, "'if'", "'else'", "'for'", "'then'", "'end'", "'||'", 
			"'&&'", "'='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", 
			"'/'", "'{'", "'}'", "'['", "']'", "'('", "')'", "';'", "':='", "','", 
			"'repeat'", "'until'", "'read'", "'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "TERMINATOR", "If", "Else", "For", "Then", "End", "Or", "And", 
			"Equals", "NEquals", "GTEquals", "LTEquals", "GT", "LT", "Add", "Subtract", 
			"Multiply", "Divide", "OBrace", "CBrace", "OBracket", "CBracket", "OParen", 
			"CParen", "SColon", "Assign", "Comma", "REPEAT", "UNTIL", "READ", "WRITE", 
			"Number", "Identifier", "String", "Comment", "Space"
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


	public TLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0101\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\7"+
		"\"\u00b6\n\"\f\"\16\"\u00b9\13\"\5\"\u00bb\n\"\3#\3#\7#\u00bf\n#\f#\16"+
		"#\u00c2\13#\3$\3$\3$\3$\7$\u00c8\n$\f$\16$\u00cb\13$\3$\3$\3$\3$\3$\7"+
		"$\u00d2\n$\f$\16$\u00d5\13$\3$\5$\u00d8\n$\3%\3%\3%\3%\7%\u00de\n%\f%"+
		"\16%\u00e1\13%\3%\3%\3%\3%\7%\u00e7\n%\f%\16%\u00ea\13%\3%\3%\5%\u00ee"+
		"\n%\3%\3%\3&\3&\3&\3&\3\'\3\'\7\'\u00f8\n\'\f\'\16\'\u00fb\13\'\3\'\5"+
		"\'\u00fe\n\'\3(\3(\3\u00e8\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2O\2\3\2\f\5\2C\\aac"+
		"|\6\2\62;C\\aac|\3\2$$\6\2\f\f\17\17$$^^\4\2\f\f\17\17\3\2))\6\2\f\f\17"+
		"\17))^^\5\2\13\f\16\17\"\"\3\2\63;\3\2\62;\2\u010b\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tX\3\2\2\2\13]\3\2\2\2\ra\3\2\2\2"+
		"\17f\3\2\2\2\21j\3\2\2\2\23m\3\2\2\2\25p\3\2\2\2\27r\3\2\2\2\31u\3\2\2"+
		"\2\33x\3\2\2\2\35{\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083"+
		"\3\2\2\2\'\u0085\3\2\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u008b\3\2\2\2"+
		"/\u008d\3\2\2\2\61\u008f\3\2\2\2\63\u0091\3\2\2\2\65\u0093\3\2\2\2\67"+
		"\u0095\3\2\2\29\u0098\3\2\2\2;\u009a\3\2\2\2=\u00a1\3\2\2\2?\u00a7\3\2"+
		"\2\2A\u00ac\3\2\2\2C\u00b2\3\2\2\2E\u00bc\3\2\2\2G\u00d7\3\2\2\2I\u00ed"+
		"\3\2\2\2K\u00f1\3\2\2\2M\u00fd\3\2\2\2O\u00ff\3\2\2\2QR\7\'\2\2R\4\3\2"+
		"\2\2ST\5\65\33\2T\6\3\2\2\2UV\7k\2\2VW\7h\2\2W\b\3\2\2\2XY\7g\2\2YZ\7"+
		"n\2\2Z[\7u\2\2[\\\7g\2\2\\\n\3\2\2\2]^\7h\2\2^_\7q\2\2_`\7t\2\2`\f\3\2"+
		"\2\2ab\7v\2\2bc\7j\2\2cd\7g\2\2de\7p\2\2e\16\3\2\2\2fg\7g\2\2gh\7p\2\2"+
		"hi\7f\2\2i\20\3\2\2\2jk\7~\2\2kl\7~\2\2l\22\3\2\2\2mn\7(\2\2no\7(\2\2"+
		"o\24\3\2\2\2pq\7?\2\2q\26\3\2\2\2rs\7#\2\2st\7?\2\2t\30\3\2\2\2uv\7@\2"+
		"\2vw\7?\2\2w\32\3\2\2\2xy\7>\2\2yz\7?\2\2z\34\3\2\2\2{|\7@\2\2|\36\3\2"+
		"\2\2}~\7>\2\2~ \3\2\2\2\177\u0080\7-\2\2\u0080\"\3\2\2\2\u0081\u0082\7"+
		"/\2\2\u0082$\3\2\2\2\u0083\u0084\7,\2\2\u0084&\3\2\2\2\u0085\u0086\7\61"+
		"\2\2\u0086(\3\2\2\2\u0087\u0088\7}\2\2\u0088*\3\2\2\2\u0089\u008a\7\177"+
		"\2\2\u008a,\3\2\2\2\u008b\u008c\7]\2\2\u008c.\3\2\2\2\u008d\u008e\7_\2"+
		"\2\u008e\60\3\2\2\2\u008f\u0090\7*\2\2\u0090\62\3\2\2\2\u0091\u0092\7"+
		"+\2\2\u0092\64\3\2\2\2\u0093\u0094\7=\2\2\u0094\66\3\2\2\2\u0095\u0096"+
		"\7<\2\2\u0096\u0097\7?\2\2\u00978\3\2\2\2\u0098\u0099\7.\2\2\u0099:\3"+
		"\2\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c\u009d\7r\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7v\2\2\u00a0<\3\2\2\2\u00a1"+
		"\u00a2\7w\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7k\2\2"+
		"\u00a5\u00a6\7n\2\2\u00a6>\3\2\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7g\2"+
		"\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7f\2\2\u00ab@\3\2\2\2\u00ac\u00ad\7"+
		"y\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1B\3\2\2\2\u00b2\u00ba\5M\'\2\u00b3\u00b7\7\60\2\2\u00b4\u00b6"+
		"\5O(\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00b3\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bbD\3\2\2\2\u00bc\u00c0\t\2\2\2\u00bd\u00bf"+
		"\t\3\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1F\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c9\t\4\2\2"+
		"\u00c4\u00c8\n\5\2\2\u00c5\u00c6\7^\2\2\u00c6\u00c8\n\6\2\2\u00c7\u00c4"+
		"\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d8\t\4"+
		"\2\2\u00cd\u00d3\t\7\2\2\u00ce\u00d2\n\b\2\2\u00cf\u00d0\7^\2\2\u00d0"+
		"\u00d2\n\6\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d8\t\7\2\2\u00d7\u00c3\3\2\2\2\u00d7\u00cd\3\2"+
		"\2\2\u00d8H\3\2\2\2\u00d9\u00da\7\61\2\2\u00da\u00db\7\61\2\2\u00db\u00df"+
		"\3\2\2\2\u00dc\u00de\n\6\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00ee\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e8\3\2\2\2\u00e5"+
		"\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\7,\2\2\u00ec\u00ee\7\61\2\2\u00ed\u00d9\3\2\2\2\u00ed\u00e2\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b%\2\2\u00f0J\3\2\2\2\u00f1\u00f2"+
		"\t\t\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b&\2\2\u00f4L\3\2\2\2\u00f5\u00f9"+
		"\t\n\2\2\u00f6\u00f8\5O(\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fe\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fc\u00fe\7\62\2\2\u00fd\u00f5\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"N\3\2\2\2\u00ff\u0100\t\13\2\2\u0100P\3\2\2\2\20\2\u00b7\u00ba\u00c0\u00c7"+
		"\u00c9\u00d1\u00d3\u00d7\u00df\u00e8\u00ed\u00f9\u00fd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}