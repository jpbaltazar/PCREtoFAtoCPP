package gen;// Generated from C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/main/resources\PCREGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PCREGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Quoted=4, BlockQuoted=5, BellChar=6, ControlChar=7, 
		EscapeChar=8, FormFeed=9, NewLine=10, CarriageReturn=11, Tab=12, Backslash=13, 
		HexChar=14, Dot=15, OneDataUnit=16, DecimalDigit=17, NotDecimalDigit=18, 
		HorizontalWhiteSpace=19, NotHorizontalWhiteSpace=20, NotNewLine=21, CharWithProperty=22, 
		CharWithoutProperty=23, NewLineSequence=24, WhiteSpace=25, NotWhiteSpace=26, 
		VerticalWhiteSpace=27, NotVerticalWhiteSpace=28, WordChar=29, NotWordChar=30, 
		ExtendedUnicodeChar=31, CharacterClassStart=32, CharacterClassEnd=33, 
		Caret=34, Hyphen=35, POSIXNamedSet=36, POSIXNegatedNamedSet=37, QuestionMark=38, 
		Plus=39, Star=40, OpenBrace=41, CloseBrace=42, Comma=43, WordBoundary=44, 
		NonWordBoundary=45, StartOfSubject=46, EndOfSubjectOrLine=47, EndOfSubjectOrLineEndOfSubject=48, 
		EndOfSubject=49, PreviousMatchInSubject=50, ResetStartMatch=51, SubroutineOrNamedReferenceStartG=52, 
		NamedReferenceStartK=53, Pipe=54, OpenParen=55, CloseParen=56, LessThan=57, 
		GreaterThan=58, SingleQuote=59, Underscore=60, Colon=61, Hash=62, Equals=63, 
		Exclamation=64, Ampersand=65, ALC=66, BLC=67, CLC=68, DLC=69, ELC=70, 
		FLC=71, GLC=72, HLC=73, ILC=74, JLC=75, KLC=76, LLC=77, MLC=78, NLC=79, 
		OLC=80, PLC=81, QLC=82, RLC=83, SLC=84, TLC=85, ULC=86, VLC=87, WLC=88, 
		XLC=89, YLC=90, ZLC=91, AUC=92, BUC=93, CUC=94, DUC=95, EUC=96, FUC=97, 
		GUC=98, HUC=99, IUC=100, JUC=101, KUC=102, LUC=103, MUC=104, NUC=105, 
		OUC=106, PUC=107, QUC=108, RUC=109, SUC=110, TUC=111, UUC=112, VUC=113, 
		WUC=114, XUC=115, YUC=116, ZUC=117, D1=118, D2=119, D3=120, D4=121, D5=122, 
		D6=123, D7=124, D8=125, D9=126, D0=127, OtherChar=128;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "Quoted", "BlockQuoted", "BellChar", "ControlChar", 
			"EscapeChar", "FormFeed", "NewLine", "CarriageReturn", "Tab", "Backslash", 
			"HexChar", "Dot", "OneDataUnit", "DecimalDigit", "NotDecimalDigit", "HorizontalWhiteSpace", 
			"NotHorizontalWhiteSpace", "NotNewLine", "CharWithProperty", "CharWithoutProperty", 
			"NewLineSequence", "WhiteSpace", "NotWhiteSpace", "VerticalWhiteSpace", 
			"NotVerticalWhiteSpace", "WordChar", "NotWordChar", "ExtendedUnicodeChar", 
			"CharacterClassStart", "CharacterClassEnd", "Caret", "Hyphen", "POSIXNamedSet", 
			"POSIXNegatedNamedSet", "QuestionMark", "Plus", "Star", "OpenBrace", 
			"CloseBrace", "Comma", "WordBoundary", "NonWordBoundary", "StartOfSubject", 
			"EndOfSubjectOrLine", "EndOfSubjectOrLineEndOfSubject", "EndOfSubject", 
			"PreviousMatchInSubject", "ResetStartMatch", "SubroutineOrNamedReferenceStartG", 
			"NamedReferenceStartK", "Pipe", "OpenParen", "CloseParen", "LessThan", 
			"GreaterThan", "SingleQuote", "Underscore", "Colon", "Hash", "Equals", 
			"Exclamation", "Ampersand", "ALC", "BLC", "CLC", "DLC", "ELC", "FLC", 
			"GLC", "HLC", "ILC", "JLC", "KLC", "LLC", "MLC", "NLC", "OLC", "PLC", 
			"QLC", "RLC", "SLC", "TLC", "ULC", "VLC", "WLC", "XLC", "YLC", "ZLC", 
			"AUC", "BUC", "CUC", "DUC", "EUC", "FUC", "GUC", "HUC", "IUC", "JUC", 
			"KUC", "LUC", "MUC", "NUC", "OUC", "PUC", "QUC", "RUC", "SUC", "TUC", 
			"UUC", "VUC", "WUC", "XUC", "YUC", "ZUC", "D1", "D2", "D3", "D4", "D5", 
			"D6", "D7", "D8", "D9", "D0", "OtherChar", "UnderscoreAlphaNumerics", 
			"AlphaNumerics", "AlphaNumeric", "NonAlphaNumeric", "HexDigit", "ASCII"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'\r'", "'\n'", null, null, "'\\a'", "'\\c'", "'\\e'", "'\\f'", 
			"'\\n'", "'\\r'", "'\\t'", "'\\'", null, "'.'", "'\\C'", "'\\d'", "'\\D'", 
			"'\\h'", "'\\H'", "'\\N'", null, null, "'\\R'", "'\\s'", "'\\S'", "'\\v'", 
			"'\\V'", "'\\w'", "'\\W'", "'\\X'", "'['", "']'", "'^'", "'-'", null, 
			null, "'?'", "'+'", "'*'", "'{'", "'}'", "','", "'\\b'", "'\\B'", "'\\A'", 
			"'$'", "'\\Z'", "'\\z'", "'\\G'", "'\\K'", "'\\g'", "'\\k'", "'|'", "'('", 
			"')'", "'<'", "'>'", "'''", "'_'", "':'", "'#'", "'='", "'!'", "'&'", 
			"'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", 
			"'k'", "'l'", "'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", 
			"'u'", "'v'", "'w'", "'x'", "'y'", "'z'", "'A'", "'B'", "'C'", "'D'", 
			"'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", 
			"'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", "'U'", "'V'", "'W'", "'X'", 
			"'Y'", "'Z'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", 
			"'9'", "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Quoted", "BlockQuoted", "BellChar", "ControlChar", 
			"EscapeChar", "FormFeed", "NewLine", "CarriageReturn", "Tab", "Backslash", 
			"HexChar", "Dot", "OneDataUnit", "DecimalDigit", "NotDecimalDigit", "HorizontalWhiteSpace", 
			"NotHorizontalWhiteSpace", "NotNewLine", "CharWithProperty", "CharWithoutProperty", 
			"NewLineSequence", "WhiteSpace", "NotWhiteSpace", "VerticalWhiteSpace", 
			"NotVerticalWhiteSpace", "WordChar", "NotWordChar", "ExtendedUnicodeChar", 
			"CharacterClassStart", "CharacterClassEnd", "Caret", "Hyphen", "POSIXNamedSet", 
			"POSIXNegatedNamedSet", "QuestionMark", "Plus", "Star", "OpenBrace", 
			"CloseBrace", "Comma", "WordBoundary", "NonWordBoundary", "StartOfSubject", 
			"EndOfSubjectOrLine", "EndOfSubjectOrLineEndOfSubject", "EndOfSubject", 
			"PreviousMatchInSubject", "ResetStartMatch", "SubroutineOrNamedReferenceStartG", 
			"NamedReferenceStartK", "Pipe", "OpenParen", "CloseParen", "LessThan", 
			"GreaterThan", "SingleQuote", "Underscore", "Colon", "Hash", "Equals", 
			"Exclamation", "Ampersand", "ALC", "BLC", "CLC", "DLC", "ELC", "FLC", 
			"GLC", "HLC", "ILC", "JLC", "KLC", "LLC", "MLC", "NLC", "OLC", "PLC", 
			"QLC", "RLC", "SLC", "TLC", "ULC", "VLC", "WLC", "XLC", "YLC", "ZLC", 
			"AUC", "BUC", "CUC", "DUC", "EUC", "FUC", "GUC", "HUC", "IUC", "JUC", 
			"KUC", "LUC", "MUC", "NUC", "OUC", "PUC", "QUC", "RUC", "SUC", "TUC", 
			"UUC", "VUC", "WUC", "XUC", "YUC", "ZUC", "D1", "D2", "D3", "D4", "D5", 
			"D6", "D7", "D8", "D9", "D0", "OtherChar"
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


	public PCREGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCREGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u0082\u0274\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k"+
		"\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv"+
		"\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t"+
		"\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u011d\n\6\f\6\16\6\u0120\13\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\6\17\u0146\n\17\r\17\16\17\u0147\3\17\3\17\5\17\u014c"+
		"\n\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-"+
		"\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\39\3"+
		"9\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3"+
		"E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3"+
		"P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3"+
		"\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g"+
		"\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3q\3q\3r\3r"+
		"\3s\3s\3t\3t\3u\3u\3v\3v\3w\3w\3x\3x\3y\3y\3z\3z\3{\3{\3|\3|\3}\3}\3~"+
		"\3~\3\177\3\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\6\u0082"+
		"\u0264\n\u0082\r\u0082\16\u0082\u0265\3\u0083\6\u0083\u0269\n\u0083\r"+
		"\u0083\16\u0083\u026a\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086\3\u0086"+
		"\3\u0087\3\u0087\3\u011e\2\u0088\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099"+
		"N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00ad"+
		"X\u00afY\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1"+
		"b\u00c3c\u00c5d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5"+
		"l\u00d7m\u00d9n\u00dbo\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9"+
		"v\u00ebw\u00edx\u00efy\u00f1z\u00f3{\u00f5|\u00f7}\u00f9~\u00fb\177\u00fd"+
		"\u0080\u00ff\u0081\u0101\u0082\u0103\2\u0105\2\u0107\2\u0109\2\u010b\2"+
		"\u010d\2\3\2\5\5\2\62;C\\c|\5\2\62;CHch\3\2\2\u0081\2\u0273\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2"+
		"\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1"+
		"\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2"+
		"\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3"+
		"\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2"+
		"\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5"+
		"\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2"+
		"\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7"+
		"\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2"+
		"\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9"+
		"\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2"+
		"\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb"+
		"\3\2\2\2\2\u00fd\3\2\2\2\2\u00ff\3\2\2\2\2\u0101\3\2\2\2\3\u010f\3\2\2"+
		"\2\5\u0111\3\2\2\2\7\u0113\3\2\2\2\t\u0115\3\2\2\2\13\u0118\3\2\2\2\r"+
		"\u0124\3\2\2\2\17\u0127\3\2\2\2\21\u012a\3\2\2\2\23\u012d\3\2\2\2\25\u0130"+
		"\3\2\2\2\27\u0133\3\2\2\2\31\u0136\3\2\2\2\33\u0139\3\2\2\2\35\u013b\3"+
		"\2\2\2\37\u014d\3\2\2\2!\u014f\3\2\2\2#\u0152\3\2\2\2%\u0155\3\2\2\2\'"+
		"\u0158\3\2\2\2)\u015b\3\2\2\2+\u015e\3\2\2\2-\u0161\3\2\2\2/\u0168\3\2"+
		"\2\2\61\u016f\3\2\2\2\63\u0172\3\2\2\2\65\u0175\3\2\2\2\67\u0178\3\2\2"+
		"\29\u017b\3\2\2\2;\u017e\3\2\2\2=\u0181\3\2\2\2?\u0184\3\2\2\2A\u0187"+
		"\3\2\2\2C\u0189\3\2\2\2E\u018b\3\2\2\2G\u018d\3\2\2\2I\u018f\3\2\2\2K"+
		"\u0198\3\2\2\2M\u01a2\3\2\2\2O\u01a4\3\2\2\2Q\u01a6\3\2\2\2S\u01a8\3\2"+
		"\2\2U\u01aa\3\2\2\2W\u01ac\3\2\2\2Y\u01ae\3\2\2\2[\u01b1\3\2\2\2]\u01b4"+
		"\3\2\2\2_\u01b7\3\2\2\2a\u01b9\3\2\2\2c\u01bc\3\2\2\2e\u01bf\3\2\2\2g"+
		"\u01c2\3\2\2\2i\u01c5\3\2\2\2k\u01c8\3\2\2\2m\u01cb\3\2\2\2o\u01cd\3\2"+
		"\2\2q\u01cf\3\2\2\2s\u01d1\3\2\2\2u\u01d3\3\2\2\2w\u01d5\3\2\2\2y\u01d7"+
		"\3\2\2\2{\u01d9\3\2\2\2}\u01db\3\2\2\2\177\u01dd\3\2\2\2\u0081\u01df\3"+
		"\2\2\2\u0083\u01e1\3\2\2\2\u0085\u01e3\3\2\2\2\u0087\u01e5\3\2\2\2\u0089"+
		"\u01e7\3\2\2\2\u008b\u01e9\3\2\2\2\u008d\u01eb\3\2\2\2\u008f\u01ed\3\2"+
		"\2\2\u0091\u01ef\3\2\2\2\u0093\u01f1\3\2\2\2\u0095\u01f3\3\2\2\2\u0097"+
		"\u01f5\3\2\2\2\u0099\u01f7\3\2\2\2\u009b\u01f9\3\2\2\2\u009d\u01fb\3\2"+
		"\2\2\u009f\u01fd\3\2\2\2\u00a1\u01ff\3\2\2\2\u00a3\u0201\3\2\2\2\u00a5"+
		"\u0203\3\2\2\2\u00a7\u0205\3\2\2\2\u00a9\u0207\3\2\2\2\u00ab\u0209\3\2"+
		"\2\2\u00ad\u020b\3\2\2\2\u00af\u020d\3\2\2\2\u00b1\u020f\3\2\2\2\u00b3"+
		"\u0211\3\2\2\2\u00b5\u0213\3\2\2\2\u00b7\u0215\3\2\2\2\u00b9\u0217\3\2"+
		"\2\2\u00bb\u0219\3\2\2\2\u00bd\u021b\3\2\2\2\u00bf\u021d\3\2\2\2\u00c1"+
		"\u021f\3\2\2\2\u00c3\u0221\3\2\2\2\u00c5\u0223\3\2\2\2\u00c7\u0225\3\2"+
		"\2\2\u00c9\u0227\3\2\2\2\u00cb\u0229\3\2\2\2\u00cd\u022b\3\2\2\2\u00cf"+
		"\u022d\3\2\2\2\u00d1\u022f\3\2\2\2\u00d3\u0231\3\2\2\2\u00d5\u0233\3\2"+
		"\2\2\u00d7\u0235\3\2\2\2\u00d9\u0237\3\2\2\2\u00db\u0239\3\2\2\2\u00dd"+
		"\u023b\3\2\2\2\u00df\u023d\3\2\2\2\u00e1\u023f\3\2\2\2\u00e3\u0241\3\2"+
		"\2\2\u00e5\u0243\3\2\2\2\u00e7\u0245\3\2\2\2\u00e9\u0247\3\2\2\2\u00eb"+
		"\u0249\3\2\2\2\u00ed\u024b\3\2\2\2\u00ef\u024d\3\2\2\2\u00f1\u024f\3\2"+
		"\2\2\u00f3\u0251\3\2\2\2\u00f5\u0253\3\2\2\2\u00f7\u0255\3\2\2\2\u00f9"+
		"\u0257\3\2\2\2\u00fb\u0259\3\2\2\2\u00fd\u025b\3\2\2\2\u00ff\u025d\3\2"+
		"\2\2\u0101\u025f\3\2\2\2\u0103\u0263\3\2\2\2\u0105\u0268\3\2\2\2\u0107"+
		"\u026c\3\2\2\2\u0109\u026e\3\2\2\2\u010b\u0270\3\2\2\2\u010d\u0272\3\2"+
		"\2\2\u010f\u0110\7\61\2\2\u0110\4\3\2\2\2\u0111\u0112\7\17\2\2\u0112\6"+
		"\3\2\2\2\u0113\u0114\7\f\2\2\u0114\b\3\2\2\2\u0115\u0116\7^\2\2\u0116"+
		"\u0117\5\u0109\u0085\2\u0117\n\3\2\2\2\u0118\u0119\7^\2\2\u0119\u011a"+
		"\7S\2\2\u011a\u011e\3\2\2\2\u011b\u011d\13\2\2\2\u011c\u011b\3\2\2\2\u011d"+
		"\u0120\3\2\2\2\u011e\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0121\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7^\2\2\u0122\u0123\7G\2\2\u0123\f"+
		"\3\2\2\2\u0124\u0125\7^\2\2\u0125\u0126\7c\2\2\u0126\16\3\2\2\2\u0127"+
		"\u0128\7^\2\2\u0128\u0129\7e\2\2\u0129\20\3\2\2\2\u012a\u012b\7^\2\2\u012b"+
		"\u012c\7g\2\2\u012c\22\3\2\2\2\u012d\u012e\7^\2\2\u012e\u012f\7h\2\2\u012f"+
		"\24\3\2\2\2\u0130\u0131\7^\2\2\u0131\u0132\7p\2\2\u0132\26\3\2\2\2\u0133"+
		"\u0134\7^\2\2\u0134\u0135\7t\2\2\u0135\30\3\2\2\2\u0136\u0137\7^\2\2\u0137"+
		"\u0138\7v\2\2\u0138\32\3\2\2\2\u0139\u013a\7^\2\2\u013a\34\3\2\2\2\u013b"+
		"\u013c\7^\2\2\u013c\u013d\7z\2\2\u013d\u014b\3\2\2\2\u013e\u013f\5\u010b"+
		"\u0086\2\u013f\u0140\5\u010b\u0086\2\u0140\u014c\3\2\2\2\u0141\u0142\7"+
		"}\2\2\u0142\u0143\5\u010b\u0086\2\u0143\u0145\5\u010b\u0086\2\u0144\u0146"+
		"\5\u010b\u0086\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3"+
		"\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7\177\2\2\u014a"+
		"\u014c\3\2\2\2\u014b\u013e\3\2\2\2\u014b\u0141\3\2\2\2\u014c\36\3\2\2"+
		"\2\u014d\u014e\7\60\2\2\u014e \3\2\2\2\u014f\u0150\7^\2\2\u0150\u0151"+
		"\7E\2\2\u0151\"\3\2\2\2\u0152\u0153\7^\2\2\u0153\u0154\7f\2\2\u0154$\3"+
		"\2\2\2\u0155\u0156\7^\2\2\u0156\u0157\7F\2\2\u0157&\3\2\2\2\u0158\u0159"+
		"\7^\2\2\u0159\u015a\7j\2\2\u015a(\3\2\2\2\u015b\u015c\7^\2\2\u015c\u015d"+
		"\7J\2\2\u015d*\3\2\2\2\u015e\u015f\7^\2\2\u015f\u0160\7P\2\2\u0160,\3"+
		"\2\2\2\u0161\u0162\7^\2\2\u0162\u0163\7r\2\2\u0163\u0164\7}\2\2\u0164"+
		"\u0165\3\2\2\2\u0165\u0166\5\u0103\u0082\2\u0166\u0167\7\177\2\2\u0167"+
		".\3\2\2\2\u0168\u0169\7^\2\2\u0169\u016a\7R\2\2\u016a\u016b\7}\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016d\5\u0103\u0082\2\u016d\u016e\7\177\2\2\u016e"+
		"\60\3\2\2\2\u016f\u0170\7^\2\2\u0170\u0171\7T\2\2\u0171\62\3\2\2\2\u0172"+
		"\u0173\7^\2\2\u0173\u0174\7u\2\2\u0174\64\3\2\2\2\u0175\u0176\7^\2\2\u0176"+
		"\u0177\7U\2\2\u0177\66\3\2\2\2\u0178\u0179\7^\2\2\u0179\u017a\7x\2\2\u017a"+
		"8\3\2\2\2\u017b\u017c\7^\2\2\u017c\u017d\7X\2\2\u017d:\3\2\2\2\u017e\u017f"+
		"\7^\2\2\u017f\u0180\7y\2\2\u0180<\3\2\2\2\u0181\u0182\7^\2\2\u0182\u0183"+
		"\7Y\2\2\u0183>\3\2\2\2\u0184\u0185\7^\2\2\u0185\u0186\7Z\2\2\u0186@\3"+
		"\2\2\2\u0187\u0188\7]\2\2\u0188B\3\2\2\2\u0189\u018a\7_\2\2\u018aD\3\2"+
		"\2\2\u018b\u018c\7`\2\2\u018cF\3\2\2\2\u018d\u018e\7/\2\2\u018eH\3\2\2"+
		"\2\u018f\u0190\7]\2\2\u0190\u0191\7]\2\2\u0191\u0192\7<\2\2\u0192\u0193"+
		"\3\2\2\2\u0193\u0194\5\u0105\u0083\2\u0194\u0195\7<\2\2\u0195\u0196\7"+
		"_\2\2\u0196\u0197\7_\2\2\u0197J\3\2\2\2\u0198\u0199\7]\2\2\u0199\u019a"+
		"\7]\2\2\u019a\u019b\7<\2\2\u019b\u019c\7`\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019e\5\u0105\u0083\2\u019e\u019f\7<\2\2\u019f\u01a0\7_\2\2\u01a0\u01a1"+
		"\7_\2\2\u01a1L\3\2\2\2\u01a2\u01a3\7A\2\2\u01a3N\3\2\2\2\u01a4\u01a5\7"+
		"-\2\2\u01a5P\3\2\2\2\u01a6\u01a7\7,\2\2\u01a7R\3\2\2\2\u01a8\u01a9\7}"+
		"\2\2\u01a9T\3\2\2\2\u01aa\u01ab\7\177\2\2\u01abV\3\2\2\2\u01ac\u01ad\7"+
		".\2\2\u01adX\3\2\2\2\u01ae\u01af\7^\2\2\u01af\u01b0\7d\2\2\u01b0Z\3\2"+
		"\2\2\u01b1\u01b2\7^\2\2\u01b2\u01b3\7D\2\2\u01b3\\\3\2\2\2\u01b4\u01b5"+
		"\7^\2\2\u01b5\u01b6\7C\2\2\u01b6^\3\2\2\2\u01b7\u01b8\7&\2\2\u01b8`\3"+
		"\2\2\2\u01b9\u01ba\7^\2\2\u01ba\u01bb\7\\\2\2\u01bbb\3\2\2\2\u01bc\u01bd"+
		"\7^\2\2\u01bd\u01be\7|\2\2\u01bed\3\2\2\2\u01bf\u01c0\7^\2\2\u01c0\u01c1"+
		"\7I\2\2\u01c1f\3\2\2\2\u01c2\u01c3\7^\2\2\u01c3\u01c4\7M\2\2\u01c4h\3"+
		"\2\2\2\u01c5\u01c6\7^\2\2\u01c6\u01c7\7i\2\2\u01c7j\3\2\2\2\u01c8\u01c9"+
		"\7^\2\2\u01c9\u01ca\7m\2\2\u01cal\3\2\2\2\u01cb\u01cc\7~\2\2\u01ccn\3"+
		"\2\2\2\u01cd\u01ce\7*\2\2\u01cep\3\2\2\2\u01cf\u01d0\7+\2\2\u01d0r\3\2"+
		"\2\2\u01d1\u01d2\7>\2\2\u01d2t\3\2\2\2\u01d3\u01d4\7@\2\2\u01d4v\3\2\2"+
		"\2\u01d5\u01d6\7)\2\2\u01d6x\3\2\2\2\u01d7\u01d8\7a\2\2\u01d8z\3\2\2\2"+
		"\u01d9\u01da\7<\2\2\u01da|\3\2\2\2\u01db\u01dc\7%\2\2\u01dc~\3\2\2\2\u01dd"+
		"\u01de\7?\2\2\u01de\u0080\3\2\2\2\u01df\u01e0\7#\2\2\u01e0\u0082\3\2\2"+
		"\2\u01e1\u01e2\7(\2\2\u01e2\u0084\3\2\2\2\u01e3\u01e4\7c\2\2\u01e4\u0086"+
		"\3\2\2\2\u01e5\u01e6\7d\2\2\u01e6\u0088\3\2\2\2\u01e7\u01e8\7e\2\2\u01e8"+
		"\u008a\3\2\2\2\u01e9\u01ea\7f\2\2\u01ea\u008c\3\2\2\2\u01eb\u01ec\7g\2"+
		"\2\u01ec\u008e\3\2\2\2\u01ed\u01ee\7h\2\2\u01ee\u0090\3\2\2\2\u01ef\u01f0"+
		"\7i\2\2\u01f0\u0092\3\2\2\2\u01f1\u01f2\7j\2\2\u01f2\u0094\3\2\2\2\u01f3"+
		"\u01f4\7k\2\2\u01f4\u0096\3\2\2\2\u01f5\u01f6\7l\2\2\u01f6\u0098\3\2\2"+
		"\2\u01f7\u01f8\7m\2\2\u01f8\u009a\3\2\2\2\u01f9\u01fa\7n\2\2\u01fa\u009c"+
		"\3\2\2\2\u01fb\u01fc\7o\2\2\u01fc\u009e\3\2\2\2\u01fd\u01fe\7p\2\2\u01fe"+
		"\u00a0\3\2\2\2\u01ff\u0200\7q\2\2\u0200\u00a2\3\2\2\2\u0201\u0202\7r\2"+
		"\2\u0202\u00a4\3\2\2\2\u0203\u0204\7s\2\2\u0204\u00a6\3\2\2\2\u0205\u0206"+
		"\7t\2\2\u0206\u00a8\3\2\2\2\u0207\u0208\7u\2\2\u0208\u00aa\3\2\2\2\u0209"+
		"\u020a\7v\2\2\u020a\u00ac\3\2\2\2\u020b\u020c\7w\2\2\u020c\u00ae\3\2\2"+
		"\2\u020d\u020e\7x\2\2\u020e\u00b0\3\2\2\2\u020f\u0210\7y\2\2\u0210\u00b2"+
		"\3\2\2\2\u0211\u0212\7z\2\2\u0212\u00b4\3\2\2\2\u0213\u0214\7{\2\2\u0214"+
		"\u00b6\3\2\2\2\u0215\u0216\7|\2\2\u0216\u00b8\3\2\2\2\u0217\u0218\7C\2"+
		"\2\u0218\u00ba\3\2\2\2\u0219\u021a\7D\2\2\u021a\u00bc\3\2\2\2\u021b\u021c"+
		"\7E\2\2\u021c\u00be\3\2\2\2\u021d\u021e\7F\2\2\u021e\u00c0\3\2\2\2\u021f"+
		"\u0220\7G\2\2\u0220\u00c2\3\2\2\2\u0221\u0222\7H\2\2\u0222\u00c4\3\2\2"+
		"\2\u0223\u0224\7I\2\2\u0224\u00c6\3\2\2\2\u0225\u0226\7J\2\2\u0226\u00c8"+
		"\3\2\2\2\u0227\u0228\7K\2\2\u0228\u00ca\3\2\2\2\u0229\u022a\7L\2\2\u022a"+
		"\u00cc\3\2\2\2\u022b\u022c\7M\2\2\u022c\u00ce\3\2\2\2\u022d\u022e\7N\2"+
		"\2\u022e\u00d0\3\2\2\2\u022f\u0230\7O\2\2\u0230\u00d2\3\2\2\2\u0231\u0232"+
		"\7P\2\2\u0232\u00d4\3\2\2\2\u0233\u0234\7Q\2\2\u0234\u00d6\3\2\2\2\u0235"+
		"\u0236\7R\2\2\u0236\u00d8\3\2\2\2\u0237\u0238\7S\2\2\u0238\u00da\3\2\2"+
		"\2\u0239\u023a\7T\2\2\u023a\u00dc\3\2\2\2\u023b\u023c\7U\2\2\u023c\u00de"+
		"\3\2\2\2\u023d\u023e\7V\2\2\u023e\u00e0\3\2\2\2\u023f\u0240\7W\2\2\u0240"+
		"\u00e2\3\2\2\2\u0241\u0242\7X\2\2\u0242\u00e4\3\2\2\2\u0243\u0244\7Y\2"+
		"\2\u0244\u00e6\3\2\2\2\u0245\u0246\7Z\2\2\u0246\u00e8\3\2\2\2\u0247\u0248"+
		"\7[\2\2\u0248\u00ea\3\2\2\2\u0249\u024a\7\\\2\2\u024a\u00ec\3\2\2\2\u024b"+
		"\u024c\7\63\2\2\u024c\u00ee\3\2\2\2\u024d\u024e\7\64\2\2\u024e\u00f0\3"+
		"\2\2\2\u024f\u0250\7\65\2\2\u0250\u00f2\3\2\2\2\u0251\u0252\7\66\2\2\u0252"+
		"\u00f4\3\2\2\2\u0253\u0254\7\67\2\2\u0254\u00f6\3\2\2\2\u0255\u0256\7"+
		"8\2\2\u0256\u00f8\3\2\2\2\u0257\u0258\79\2\2\u0258\u00fa\3\2\2\2\u0259"+
		"\u025a\7:\2\2\u025a\u00fc\3\2\2\2\u025b\u025c\7;\2\2\u025c\u00fe\3\2\2"+
		"\2\u025d\u025e\7\62\2\2\u025e\u0100\3\2\2\2\u025f\u0260\13\2\2\2\u0260"+
		"\u0102\3\2\2\2\u0261\u0264\7a\2\2\u0262\u0264\5\u0107\u0084\2\u0263\u0261"+
		"\3\2\2\2\u0263\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0263\3\2\2\2\u0265"+
		"\u0266\3\2\2\2\u0266\u0104\3\2\2\2\u0267\u0269\5\u0107\u0084\2\u0268\u0267"+
		"\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b"+
		"\u0106\3\2\2\2\u026c\u026d\t\2\2\2\u026d\u0108\3\2\2\2\u026e\u026f\n\2"+
		"\2\2\u026f\u010a\3\2\2\2\u0270\u0271\t\3\2\2\u0271\u010c\3\2\2\2\u0272"+
		"\u0273\t\4\2\2\u0273\u010e\3\2\2\2\t\2\u011e\u0147\u014b\u0263\u0265\u026a"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}