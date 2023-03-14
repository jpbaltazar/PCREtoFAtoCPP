package gen;// Generated from C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/main/resources\PCREGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PCREGrammarParser extends Parser {
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
	public static final int
		RULE_parse = 0, RULE_singleRule = 1, RULE_directives = 2, RULE_alternation = 3, 
		RULE_expr = 4, RULE_element = 5, RULE_quantifier = 6, RULE_quantifier_type = 7, 
		RULE_character_class = 8, RULE_backreference = 9, RULE_backreference_or_octal = 10, 
		RULE_capture = 11, RULE_non_capture = 12, RULE_comment = 13, RULE_option = 14, 
		RULE_option_flags = 15, RULE_option_flag = 16, RULE_look_around = 17, 
		RULE_subroutine_reference = 18, RULE_conditional = 19, RULE_backtrack_control = 20, 
		RULE_newline_convention = 21, RULE_callout = 22, RULE_atom = 23, RULE_cc_atom = 24, 
		RULE_shared_atom = 25, RULE_literal = 26, RULE_cc_literal = 27, RULE_shared_literal = 28, 
		RULE_number = 29, RULE_octal_char = 30, RULE_octal_digit = 31, RULE_digits = 32, 
		RULE_digit = 33, RULE_name = 34, RULE_alpha_nums = 35, RULE_non_close_parens = 36, 
		RULE_non_close_paren = 37, RULE_letter = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "singleRule", "directives", "alternation", "expr", "element", 
			"quantifier", "quantifier_type", "character_class", "backreference", 
			"backreference_or_octal", "capture", "non_capture", "comment", "option", 
			"option_flags", "option_flag", "look_around", "subroutine_reference", 
			"conditional", "backtrack_control", "newline_convention", "callout", 
			"atom", "cc_atom", "shared_atom", "literal", "cc_literal", "shared_literal", 
			"number", "octal_char", "octal_digit", "digits", "digit", "name", "alpha_nums", 
			"non_close_parens", "non_close_paren", "letter"
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

	@Override
	public String getGrammarFileName() { return "PCREGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCREGrammarParser(CommonTokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PCREGrammarParser.EOF, 0); }
		public List<SingleRuleContext> singleRule() {
			return getRuleContexts(SingleRuleContext.class);
		}
		public SingleRuleContext singleRule(int i) {
			return getRuleContext(SingleRuleContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				singleRule();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(83);
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

	public static class SingleRuleContext extends ParserRuleContext {
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
		}
		public TerminalNode Caret() { return getToken(PCREGrammarParser.Caret, 0); }
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public SingleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterSingleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitSingleRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitSingleRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleRuleContext singleRule() throws RecognitionException {
		SingleRuleContext _localctx = new SingleRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(85);
			match(T__0);
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(86);
				match(Caret);
				}
				break;
			}
			setState(89);
			alternation();
			setState(90);
			match(T__0);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (Underscore - 60)) | (1L << (ALC - 60)) | (1L << (BLC - 60)) | (1L << (CLC - 60)) | (1L << (DLC - 60)) | (1L << (ELC - 60)) | (1L << (FLC - 60)) | (1L << (GLC - 60)) | (1L << (HLC - 60)) | (1L << (ILC - 60)) | (1L << (JLC - 60)) | (1L << (KLC - 60)) | (1L << (LLC - 60)) | (1L << (MLC - 60)) | (1L << (NLC - 60)) | (1L << (OLC - 60)) | (1L << (PLC - 60)) | (1L << (QLC - 60)) | (1L << (RLC - 60)) | (1L << (SLC - 60)) | (1L << (TLC - 60)) | (1L << (ULC - 60)) | (1L << (VLC - 60)) | (1L << (WLC - 60)) | (1L << (XLC - 60)) | (1L << (YLC - 60)) | (1L << (ZLC - 60)) | (1L << (AUC - 60)) | (1L << (BUC - 60)) | (1L << (CUC - 60)) | (1L << (DUC - 60)) | (1L << (EUC - 60)) | (1L << (FUC - 60)) | (1L << (GUC - 60)) | (1L << (HUC - 60)) | (1L << (IUC - 60)) | (1L << (JUC - 60)) | (1L << (KUC - 60)) | (1L << (LUC - 60)) | (1L << (MUC - 60)) | (1L << (NUC - 60)) | (1L << (OUC - 60)) | (1L << (PUC - 60)) | (1L << (QUC - 60)) | (1L << (RUC - 60)) | (1L << (SUC - 60)) | (1L << (TUC - 60)) | (1L << (UUC - 60)) | (1L << (VUC - 60)) | (1L << (WUC - 60)) | (1L << (XUC - 60)) | (1L << (YUC - 60)) | (1L << (ZUC - 60)))) != 0)) {
				{
				setState(91);
				directives();
				}
			}

			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(94);
				match(T__1);
				}
			}

			setState(97);
			match(T__2);
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

	public static class DirectivesContext extends ParserRuleContext {
		public List<Alpha_numsContext> alpha_nums() {
			return getRuleContexts(Alpha_numsContext.class);
		}
		public Alpha_numsContext alpha_nums(int i) {
			return getRuleContext(Alpha_numsContext.class,i);
		}
		public DirectivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterDirectives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitDirectives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitDirectives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectivesContext directives() throws RecognitionException {
		DirectivesContext _localctx = new DirectivesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_directives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				alpha_nums();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (Underscore - 60)) | (1L << (ALC - 60)) | (1L << (BLC - 60)) | (1L << (CLC - 60)) | (1L << (DLC - 60)) | (1L << (ELC - 60)) | (1L << (FLC - 60)) | (1L << (GLC - 60)) | (1L << (HLC - 60)) | (1L << (ILC - 60)) | (1L << (JLC - 60)) | (1L << (KLC - 60)) | (1L << (LLC - 60)) | (1L << (MLC - 60)) | (1L << (NLC - 60)) | (1L << (OLC - 60)) | (1L << (PLC - 60)) | (1L << (QLC - 60)) | (1L << (RLC - 60)) | (1L << (SLC - 60)) | (1L << (TLC - 60)) | (1L << (ULC - 60)) | (1L << (VLC - 60)) | (1L << (WLC - 60)) | (1L << (XLC - 60)) | (1L << (YLC - 60)) | (1L << (ZLC - 60)) | (1L << (AUC - 60)) | (1L << (BUC - 60)) | (1L << (CUC - 60)) | (1L << (DUC - 60)) | (1L << (EUC - 60)) | (1L << (FUC - 60)) | (1L << (GUC - 60)) | (1L << (HUC - 60)) | (1L << (IUC - 60)) | (1L << (JUC - 60)) | (1L << (KUC - 60)) | (1L << (LUC - 60)) | (1L << (MUC - 60)) | (1L << (NUC - 60)) | (1L << (OUC - 60)) | (1L << (PUC - 60)) | (1L << (QUC - 60)) | (1L << (RUC - 60)) | (1L << (SUC - 60)) | (1L << (TUC - 60)) | (1L << (UUC - 60)) | (1L << (VUC - 60)) | (1L << (WUC - 60)) | (1L << (XUC - 60)) | (1L << (YUC - 60)) | (1L << (ZUC - 60)))) != 0) );
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

	public static class AlternationContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Pipe() { return getTokens(PCREGrammarParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(PCREGrammarParser.Pipe, i);
		}
		public AlternationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterAlternation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitAlternation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitAlternation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternationContext alternation() throws RecognitionException {
		AlternationContext _localctx = new AlternationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alternation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			expr();
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(105);
					match(Pipe);
					setState(106);
					expr();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (OneDataUnit - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (ExtendedUnicodeChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (CharacterClassEnd - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (NonWordBoundary - 4)) | (1L << (StartOfSubject - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (EndOfSubjectOrLineEndOfSubject - 4)) | (1L << (EndOfSubject - 4)) | (1L << (PreviousMatchInSubject - 4)) | (1L << (ResetStartMatch - 4)) | (1L << (SubroutineOrNamedReferenceStartG - 4)) | (1L << (NamedReferenceStartK - 4)) | (1L << (OpenParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0)) {
				{
				{
				setState(112);
				element();
				}
				}
				setState(117);
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

	public static class ElementContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			atom();
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(119);
				quantifier();
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

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public Quantifier_typeContext quantifier_type() {
			return getRuleContext(Quantifier_typeContext.class,0);
		}
		public TerminalNode Plus() { return getToken(PCREGrammarParser.Plus, 0); }
		public TerminalNode Star() { return getToken(PCREGrammarParser.Star, 0); }
		public TerminalNode OpenBrace() { return getToken(PCREGrammarParser.OpenBrace, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode CloseBrace() { return getToken(PCREGrammarParser.CloseBrace, 0); }
		public TerminalNode Comma() { return getToken(PCREGrammarParser.Comma, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_quantifier);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(QuestionMark);
				setState(123);
				quantifier_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(Plus);
				setState(125);
				quantifier_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(Star);
				setState(127);
				quantifier_type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(OpenBrace);
				setState(129);
				number();
				setState(130);
				match(CloseBrace);
				setState(131);
				quantifier_type();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(OpenBrace);
				setState(134);
				number();
				setState(135);
				match(Comma);
				setState(136);
				match(CloseBrace);
				setState(137);
				quantifier_type();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				match(OpenBrace);
				setState(140);
				number();
				setState(141);
				match(Comma);
				setState(142);
				number();
				setState(143);
				match(CloseBrace);
				setState(144);
				quantifier_type();
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

	public static class Quantifier_typeContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(PCREGrammarParser.Plus, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public Quantifier_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterQuantifier_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitQuantifier_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitQuantifier_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quantifier_typeContext quantifier_type() throws RecognitionException {
		Quantifier_typeContext _localctx = new Quantifier_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_quantifier_type);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(Plus);
				}
				break;
			case QuestionMark:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(QuestionMark);
				}
				break;
			case T__0:
			case Quoted:
			case BlockQuoted:
			case BellChar:
			case ControlChar:
			case EscapeChar:
			case FormFeed:
			case NewLine:
			case CarriageReturn:
			case Tab:
			case Backslash:
			case HexChar:
			case Dot:
			case OneDataUnit:
			case DecimalDigit:
			case NotDecimalDigit:
			case HorizontalWhiteSpace:
			case NotHorizontalWhiteSpace:
			case NotNewLine:
			case CharWithProperty:
			case CharWithoutProperty:
			case NewLineSequence:
			case WhiteSpace:
			case NotWhiteSpace:
			case VerticalWhiteSpace:
			case NotVerticalWhiteSpace:
			case WordChar:
			case NotWordChar:
			case ExtendedUnicodeChar:
			case CharacterClassStart:
			case CharacterClassEnd:
			case Caret:
			case Hyphen:
			case POSIXNamedSet:
			case POSIXNegatedNamedSet:
			case OpenBrace:
			case CloseBrace:
			case Comma:
			case WordBoundary:
			case NonWordBoundary:
			case StartOfSubject:
			case EndOfSubjectOrLine:
			case EndOfSubjectOrLineEndOfSubject:
			case EndOfSubject:
			case PreviousMatchInSubject:
			case ResetStartMatch:
			case SubroutineOrNamedReferenceStartG:
			case NamedReferenceStartK:
			case Pipe:
			case OpenParen:
			case CloseParen:
			case LessThan:
			case GreaterThan:
			case SingleQuote:
			case Underscore:
			case Colon:
			case Hash:
			case Equals:
			case Exclamation:
			case Ampersand:
			case ALC:
			case BLC:
			case CLC:
			case DLC:
			case ELC:
			case FLC:
			case GLC:
			case HLC:
			case ILC:
			case JLC:
			case KLC:
			case LLC:
			case MLC:
			case NLC:
			case OLC:
			case PLC:
			case QLC:
			case RLC:
			case SLC:
			case TLC:
			case ULC:
			case VLC:
			case WLC:
			case XLC:
			case YLC:
			case ZLC:
			case AUC:
			case BUC:
			case CUC:
			case DUC:
			case EUC:
			case FUC:
			case GUC:
			case HUC:
			case IUC:
			case JUC:
			case KUC:
			case LUC:
			case MUC:
			case NUC:
			case OUC:
			case PUC:
			case QUC:
			case RUC:
			case SUC:
			case TUC:
			case UUC:
			case VUC:
			case WUC:
			case XUC:
			case YUC:
			case ZUC:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case D0:
			case OtherChar:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Character_classContext extends ParserRuleContext {
		public TerminalNode CharacterClassStart() { return getToken(PCREGrammarParser.CharacterClassStart, 0); }
		public TerminalNode Caret() { return getToken(PCREGrammarParser.Caret, 0); }
		public List<TerminalNode> CharacterClassEnd() { return getTokens(PCREGrammarParser.CharacterClassEnd); }
		public TerminalNode CharacterClassEnd(int i) {
			return getToken(PCREGrammarParser.CharacterClassEnd, i);
		}
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public List<Cc_atomContext> cc_atom() {
			return getRuleContexts(Cc_atomContext.class);
		}
		public Cc_atomContext cc_atom(int i) {
			return getRuleContext(Cc_atomContext.class,i);
		}
		public Character_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterCharacter_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitCharacter_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitCharacter_class(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Character_classContext character_class() throws RecognitionException {
		Character_classContext _localctx = new Character_classContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_character_class);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(CharacterClassStart);
				setState(154);
				match(Caret);
				setState(155);
				match(CharacterClassEnd);
				setState(156);
				match(Hyphen);
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(157);
					cc_atom();
					}
					}
					setState(160); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0) );
				setState(162);
				match(CharacterClassEnd);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(CharacterClassStart);
				setState(165);
				match(Caret);
				setState(166);
				match(CharacterClassEnd);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0)) {
					{
					{
					setState(167);
					cc_atom();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(CharacterClassEnd);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(CharacterClassStart);
				setState(175);
				match(Caret);
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					cc_atom();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0) );
				setState(181);
				match(CharacterClassEnd);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(CharacterClassStart);
				setState(184);
				match(CharacterClassEnd);
				setState(185);
				match(Hyphen);
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					cc_atom();
					}
					}
					setState(189); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0) );
				setState(191);
				match(CharacterClassEnd);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				match(CharacterClassStart);
				setState(194);
				match(CharacterClassEnd);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0)) {
					{
					{
					setState(195);
					cc_atom();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(CharacterClassEnd);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				match(CharacterClassStart);
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203);
					cc_atom();
					}
					}
					setState(206); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Quoted - 4)) | (1L << (BlockQuoted - 4)) | (1L << (BellChar - 4)) | (1L << (ControlChar - 4)) | (1L << (EscapeChar - 4)) | (1L << (FormFeed - 4)) | (1L << (NewLine - 4)) | (1L << (CarriageReturn - 4)) | (1L << (Tab - 4)) | (1L << (Backslash - 4)) | (1L << (HexChar - 4)) | (1L << (Dot - 4)) | (1L << (DecimalDigit - 4)) | (1L << (NotDecimalDigit - 4)) | (1L << (HorizontalWhiteSpace - 4)) | (1L << (NotHorizontalWhiteSpace - 4)) | (1L << (NotNewLine - 4)) | (1L << (CharWithProperty - 4)) | (1L << (CharWithoutProperty - 4)) | (1L << (NewLineSequence - 4)) | (1L << (WhiteSpace - 4)) | (1L << (NotWhiteSpace - 4)) | (1L << (VerticalWhiteSpace - 4)) | (1L << (NotVerticalWhiteSpace - 4)) | (1L << (WordChar - 4)) | (1L << (NotWordChar - 4)) | (1L << (CharacterClassStart - 4)) | (1L << (Caret - 4)) | (1L << (Hyphen - 4)) | (1L << (POSIXNamedSet - 4)) | (1L << (POSIXNegatedNamedSet - 4)) | (1L << (QuestionMark - 4)) | (1L << (Plus - 4)) | (1L << (Star - 4)) | (1L << (OpenBrace - 4)) | (1L << (CloseBrace - 4)) | (1L << (Comma - 4)) | (1L << (WordBoundary - 4)) | (1L << (EndOfSubjectOrLine - 4)) | (1L << (Pipe - 4)) | (1L << (OpenParen - 4)) | (1L << (CloseParen - 4)) | (1L << (LessThan - 4)) | (1L << (GreaterThan - 4)) | (1L << (SingleQuote - 4)) | (1L << (Underscore - 4)) | (1L << (Colon - 4)) | (1L << (Hash - 4)) | (1L << (Equals - 4)) | (1L << (Exclamation - 4)) | (1L << (Ampersand - 4)) | (1L << (ALC - 4)) | (1L << (BLC - 4)))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (CLC - 68)) | (1L << (DLC - 68)) | (1L << (ELC - 68)) | (1L << (FLC - 68)) | (1L << (GLC - 68)) | (1L << (HLC - 68)) | (1L << (ILC - 68)) | (1L << (JLC - 68)) | (1L << (KLC - 68)) | (1L << (LLC - 68)) | (1L << (MLC - 68)) | (1L << (NLC - 68)) | (1L << (OLC - 68)) | (1L << (PLC - 68)) | (1L << (QLC - 68)) | (1L << (RLC - 68)) | (1L << (SLC - 68)) | (1L << (TLC - 68)) | (1L << (ULC - 68)) | (1L << (VLC - 68)) | (1L << (WLC - 68)) | (1L << (XLC - 68)) | (1L << (YLC - 68)) | (1L << (ZLC - 68)) | (1L << (AUC - 68)) | (1L << (BUC - 68)) | (1L << (CUC - 68)) | (1L << (DUC - 68)) | (1L << (EUC - 68)) | (1L << (FUC - 68)) | (1L << (GUC - 68)) | (1L << (HUC - 68)) | (1L << (IUC - 68)) | (1L << (JUC - 68)) | (1L << (KUC - 68)) | (1L << (LUC - 68)) | (1L << (MUC - 68)) | (1L << (NUC - 68)) | (1L << (OUC - 68)) | (1L << (PUC - 68)) | (1L << (QUC - 68)) | (1L << (RUC - 68)) | (1L << (SUC - 68)) | (1L << (TUC - 68)) | (1L << (UUC - 68)) | (1L << (VUC - 68)) | (1L << (WUC - 68)) | (1L << (XUC - 68)) | (1L << (YUC - 68)) | (1L << (ZUC - 68)) | (1L << (D1 - 68)) | (1L << (D2 - 68)) | (1L << (D3 - 68)) | (1L << (D4 - 68)) | (1L << (D5 - 68)) | (1L << (D6 - 68)) | (1L << (D7 - 68)) | (1L << (D8 - 68)) | (1L << (D9 - 68)) | (1L << (D0 - 68)) | (1L << (OtherChar - 68)))) != 0) );
				setState(208);
				match(CharacterClassEnd);
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

	public static class BackreferenceContext extends ParserRuleContext {
		public Backreference_or_octalContext backreference_or_octal() {
			return getRuleContext(Backreference_or_octalContext.class,0);
		}
		public TerminalNode SubroutineOrNamedReferenceStartG() { return getToken(PCREGrammarParser.SubroutineOrNamedReferenceStartG, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode OpenBrace() { return getToken(PCREGrammarParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(PCREGrammarParser.CloseBrace, 0); }
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public TerminalNode NamedReferenceStartK() { return getToken(PCREGrammarParser.NamedReferenceStartK, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public List<TerminalNode> SingleQuote() { return getTokens(PCREGrammarParser.SingleQuote); }
		public TerminalNode SingleQuote(int i) {
			return getToken(PCREGrammarParser.SingleQuote, i);
		}
		public BackreferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backreference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterBackreference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitBackreference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitBackreference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BackreferenceContext backreference() throws RecognitionException {
		BackreferenceContext _localctx = new BackreferenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_backreference);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				backreference_or_octal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(SubroutineOrNamedReferenceStartG);
				setState(214);
				number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(SubroutineOrNamedReferenceStartG);
				setState(216);
				match(OpenBrace);
				setState(217);
				number();
				setState(218);
				match(CloseBrace);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(SubroutineOrNamedReferenceStartG);
				setState(221);
				match(OpenBrace);
				setState(222);
				match(Hyphen);
				setState(223);
				number();
				setState(224);
				match(CloseBrace);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				match(NamedReferenceStartK);
				setState(227);
				match(LessThan);
				setState(228);
				name();
				setState(229);
				match(GreaterThan);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(231);
				match(NamedReferenceStartK);
				setState(232);
				match(SingleQuote);
				setState(233);
				name();
				setState(234);
				match(SingleQuote);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				match(SubroutineOrNamedReferenceStartG);
				setState(237);
				match(OpenBrace);
				setState(238);
				name();
				setState(239);
				match(CloseBrace);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(241);
				match(NamedReferenceStartK);
				setState(242);
				match(OpenBrace);
				setState(243);
				name();
				setState(244);
				match(CloseBrace);
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

	public static class Backreference_or_octalContext extends ParserRuleContext {
		public Octal_charContext octal_char() {
			return getRuleContext(Octal_charContext.class,0);
		}
		public TerminalNode Backslash() { return getToken(PCREGrammarParser.Backslash, 0); }
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public Backreference_or_octalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backreference_or_octal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterBackreference_or_octal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitBackreference_or_octal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitBackreference_or_octal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Backreference_or_octalContext backreference_or_octal() throws RecognitionException {
		Backreference_or_octalContext _localctx = new Backreference_or_octalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_backreference_or_octal);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				octal_char();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(Backslash);
				setState(250);
				digit();
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

	public static class CaptureContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public List<TerminalNode> SingleQuote() { return getTokens(PCREGrammarParser.SingleQuote); }
		public TerminalNode SingleQuote(int i) {
			return getToken(PCREGrammarParser.SingleQuote, i);
		}
		public CaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterCapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitCapture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitCapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaptureContext capture() throws RecognitionException {
		CaptureContext _localctx = new CaptureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_capture);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(OpenParen);
				setState(254);
				match(QuestionMark);
				setState(255);
				match(LessThan);
				setState(256);
				name();
				setState(257);
				match(GreaterThan);
				setState(258);
				alternation();
				setState(259);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				match(OpenParen);
				setState(262);
				match(QuestionMark);
				setState(263);
				match(SingleQuote);
				setState(264);
				name();
				setState(265);
				match(SingleQuote);
				setState(266);
				alternation();
				setState(267);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(OpenParen);
				setState(270);
				alternation();
				setState(271);
				match(CloseParen);
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

	public static class Non_captureContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode Colon() { return getToken(PCREGrammarParser.Colon, 0); }
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public TerminalNode Pipe() { return getToken(PCREGrammarParser.Pipe, 0); }
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public Option_flagsContext option_flags() {
			return getRuleContext(Option_flagsContext.class,0);
		}
		public Non_captureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_capture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterNon_capture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitNon_capture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitNon_capture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_captureContext non_capture() throws RecognitionException {
		Non_captureContext _localctx = new Non_captureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_non_capture);
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(OpenParen);
				setState(276);
				match(QuestionMark);
				setState(277);
				match(Colon);
				setState(278);
				alternation();
				setState(279);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				match(OpenParen);
				setState(282);
				match(QuestionMark);
				setState(283);
				match(Pipe);
				setState(284);
				alternation();
				setState(285);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(OpenParen);
				setState(288);
				match(QuestionMark);
				setState(289);
				match(GreaterThan);
				setState(290);
				alternation();
				setState(291);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(293);
				match(OpenParen);
				setState(294);
				match(QuestionMark);
				setState(295);
				option_flags();
				setState(296);
				match(Colon);
				setState(297);
				alternation();
				setState(298);
				match(CloseParen);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode Hash() { return getToken(PCREGrammarParser.Hash, 0); }
		public Non_close_parensContext non_close_parens() {
			return getRuleContext(Non_close_parensContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(OpenParen);
			setState(303);
			match(QuestionMark);
			setState(304);
			match(Hash);
			setState(305);
			non_close_parens();
			setState(306);
			match(CloseParen);
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public List<Option_flagsContext> option_flags() {
			return getRuleContexts(Option_flagsContext.class);
		}
		public Option_flagsContext option_flags(int i) {
			return getRuleContext(Option_flagsContext.class,i);
		}
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public TerminalNode Star() { return getToken(PCREGrammarParser.Star, 0); }
		public TerminalNode NUC() { return getToken(PCREGrammarParser.NUC, 0); }
		public List<TerminalNode> OUC() { return getTokens(PCREGrammarParser.OUC); }
		public TerminalNode OUC(int i) {
			return getToken(PCREGrammarParser.OUC, i);
		}
		public List<TerminalNode> Underscore() { return getTokens(PCREGrammarParser.Underscore); }
		public TerminalNode Underscore(int i) {
			return getToken(PCREGrammarParser.Underscore, i);
		}
		public TerminalNode SUC() { return getToken(PCREGrammarParser.SUC, 0); }
		public List<TerminalNode> TUC() { return getTokens(PCREGrammarParser.TUC); }
		public TerminalNode TUC(int i) {
			return getToken(PCREGrammarParser.TUC, i);
		}
		public TerminalNode AUC() { return getToken(PCREGrammarParser.AUC, 0); }
		public TerminalNode RUC() { return getToken(PCREGrammarParser.RUC, 0); }
		public TerminalNode PUC() { return getToken(PCREGrammarParser.PUC, 0); }
		public TerminalNode UUC() { return getToken(PCREGrammarParser.UUC, 0); }
		public TerminalNode FUC() { return getToken(PCREGrammarParser.FUC, 0); }
		public TerminalNode D8() { return getToken(PCREGrammarParser.D8, 0); }
		public TerminalNode D1() { return getToken(PCREGrammarParser.D1, 0); }
		public TerminalNode D6() { return getToken(PCREGrammarParser.D6, 0); }
		public TerminalNode CUC() { return getToken(PCREGrammarParser.CUC, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_option);
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(OpenParen);
				setState(309);
				match(QuestionMark);
				setState(310);
				option_flags();
				setState(311);
				match(Hyphen);
				setState(312);
				option_flags();
				setState(313);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(OpenParen);
				setState(316);
				match(QuestionMark);
				setState(317);
				option_flags();
				setState(318);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(OpenParen);
				setState(321);
				match(QuestionMark);
				setState(322);
				match(Hyphen);
				setState(323);
				option_flags();
				setState(324);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				match(OpenParen);
				setState(327);
				match(Star);
				setState(328);
				match(NUC);
				setState(329);
				match(OUC);
				setState(330);
				match(Underscore);
				setState(331);
				match(SUC);
				setState(332);
				match(TUC);
				setState(333);
				match(AUC);
				setState(334);
				match(RUC);
				setState(335);
				match(TUC);
				setState(336);
				match(Underscore);
				setState(337);
				match(OUC);
				setState(338);
				match(PUC);
				setState(339);
				match(TUC);
				setState(340);
				match(CloseParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				match(OpenParen);
				setState(342);
				match(Star);
				setState(343);
				match(UUC);
				setState(344);
				match(TUC);
				setState(345);
				match(FUC);
				setState(346);
				match(D8);
				setState(347);
				match(CloseParen);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(348);
				match(OpenParen);
				setState(349);
				match(Star);
				setState(350);
				match(UUC);
				setState(351);
				match(TUC);
				setState(352);
				match(FUC);
				setState(353);
				match(D1);
				setState(354);
				match(D6);
				setState(355);
				match(CloseParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(356);
				match(OpenParen);
				setState(357);
				match(Star);
				setState(358);
				match(UUC);
				setState(359);
				match(CUC);
				setState(360);
				match(PUC);
				setState(361);
				match(CloseParen);
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

	public static class Option_flagsContext extends ParserRuleContext {
		public List<Option_flagContext> option_flag() {
			return getRuleContexts(Option_flagContext.class);
		}
		public Option_flagContext option_flag(int i) {
			return getRuleContext(Option_flagContext.class,i);
		}
		public Option_flagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_flags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterOption_flags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitOption_flags(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitOption_flags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_flagsContext option_flags() throws RecognitionException {
		Option_flagsContext _localctx = new Option_flagsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_option_flags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(364);
				option_flag();
				}
				}
				setState(367); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (ILC - 74)) | (1L << (MLC - 74)) | (1L << (SLC - 74)) | (1L << (XLC - 74)) | (1L << (JUC - 74)) | (1L << (UUC - 74)))) != 0) );
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

	public static class Option_flagContext extends ParserRuleContext {
		public TerminalNode ILC() { return getToken(PCREGrammarParser.ILC, 0); }
		public TerminalNode JUC() { return getToken(PCREGrammarParser.JUC, 0); }
		public TerminalNode MLC() { return getToken(PCREGrammarParser.MLC, 0); }
		public TerminalNode SLC() { return getToken(PCREGrammarParser.SLC, 0); }
		public TerminalNode UUC() { return getToken(PCREGrammarParser.UUC, 0); }
		public TerminalNode XLC() { return getToken(PCREGrammarParser.XLC, 0); }
		public Option_flagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterOption_flag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitOption_flag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitOption_flag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_flagContext option_flag() throws RecognitionException {
		Option_flagContext _localctx = new Option_flagContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_option_flag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (ILC - 74)) | (1L << (MLC - 74)) | (1L << (SLC - 74)) | (1L << (XLC - 74)) | (1L << (JUC - 74)) | (1L << (UUC - 74)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Look_aroundContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode Equals() { return getToken(PCREGrammarParser.Equals, 0); }
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public TerminalNode Exclamation() { return getToken(PCREGrammarParser.Exclamation, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public Look_aroundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_look_around; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterLook_around(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitLook_around(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitLook_around(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Look_aroundContext look_around() throws RecognitionException {
		Look_aroundContext _localctx = new Look_aroundContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_look_around);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				match(OpenParen);
				setState(372);
				match(QuestionMark);
				setState(373);
				match(Equals);
				setState(374);
				alternation();
				setState(375);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				match(OpenParen);
				setState(378);
				match(QuestionMark);
				setState(379);
				match(Exclamation);
				setState(380);
				alternation();
				setState(381);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				match(OpenParen);
				setState(384);
				match(QuestionMark);
				setState(385);
				match(LessThan);
				setState(386);
				match(Equals);
				setState(387);
				alternation();
				setState(388);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(OpenParen);
				setState(391);
				match(QuestionMark);
				setState(392);
				match(LessThan);
				setState(393);
				match(Exclamation);
				setState(394);
				alternation();
				setState(395);
				match(CloseParen);
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

	public static class Subroutine_referenceContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode RUC() { return getToken(PCREGrammarParser.RUC, 0); }
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Plus() { return getToken(PCREGrammarParser.Plus, 0); }
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public TerminalNode Ampersand() { return getToken(PCREGrammarParser.Ampersand, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PUC() { return getToken(PCREGrammarParser.PUC, 0); }
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public TerminalNode SubroutineOrNamedReferenceStartG() { return getToken(PCREGrammarParser.SubroutineOrNamedReferenceStartG, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public List<TerminalNode> SingleQuote() { return getTokens(PCREGrammarParser.SingleQuote); }
		public TerminalNode SingleQuote(int i) {
			return getToken(PCREGrammarParser.SingleQuote, i);
		}
		public Subroutine_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutine_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterSubroutine_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitSubroutine_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitSubroutine_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subroutine_referenceContext subroutine_reference() throws RecognitionException {
		Subroutine_referenceContext _localctx = new Subroutine_referenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subroutine_reference);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(OpenParen);
				setState(400);
				match(QuestionMark);
				setState(401);
				match(RUC);
				setState(402);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				match(OpenParen);
				setState(404);
				match(QuestionMark);
				setState(405);
				number();
				setState(406);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(408);
				match(OpenParen);
				setState(409);
				match(QuestionMark);
				setState(410);
				match(Plus);
				setState(411);
				number();
				setState(412);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(OpenParen);
				setState(415);
				match(QuestionMark);
				setState(416);
				match(Hyphen);
				setState(417);
				number();
				setState(418);
				match(CloseParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(420);
				match(OpenParen);
				setState(421);
				match(QuestionMark);
				setState(422);
				match(Ampersand);
				setState(423);
				name();
				setState(424);
				match(CloseParen);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(426);
				match(OpenParen);
				setState(427);
				match(QuestionMark);
				setState(428);
				match(PUC);
				setState(429);
				match(GreaterThan);
				setState(430);
				name();
				setState(431);
				match(CloseParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(433);
				match(SubroutineOrNamedReferenceStartG);
				setState(434);
				match(LessThan);
				setState(435);
				name();
				setState(436);
				match(GreaterThan);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(438);
				match(SubroutineOrNamedReferenceStartG);
				setState(439);
				match(SingleQuote);
				setState(440);
				name();
				setState(441);
				match(SingleQuote);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(443);
				match(SubroutineOrNamedReferenceStartG);
				setState(444);
				match(LessThan);
				setState(445);
				number();
				setState(446);
				match(GreaterThan);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(448);
				match(SubroutineOrNamedReferenceStartG);
				setState(449);
				match(SingleQuote);
				setState(450);
				number();
				setState(451);
				match(SingleQuote);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(453);
				match(SubroutineOrNamedReferenceStartG);
				setState(454);
				match(LessThan);
				setState(455);
				match(Plus);
				setState(456);
				number();
				setState(457);
				match(GreaterThan);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(459);
				match(SubroutineOrNamedReferenceStartG);
				setState(460);
				match(SingleQuote);
				setState(461);
				match(Plus);
				setState(462);
				number();
				setState(463);
				match(SingleQuote);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(465);
				match(SubroutineOrNamedReferenceStartG);
				setState(466);
				match(LessThan);
				setState(467);
				match(Hyphen);
				setState(468);
				number();
				setState(469);
				match(GreaterThan);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(471);
				match(SubroutineOrNamedReferenceStartG);
				setState(472);
				match(SingleQuote);
				setState(473);
				match(Hyphen);
				setState(474);
				number();
				setState(475);
				match(SingleQuote);
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

	public static class ConditionalContext extends ParserRuleContext {
		public List<TerminalNode> OpenParen() { return getTokens(PCREGrammarParser.OpenParen); }
		public TerminalNode OpenParen(int i) {
			return getToken(PCREGrammarParser.OpenParen, i);
		}
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<TerminalNode> CloseParen() { return getTokens(PCREGrammarParser.CloseParen); }
		public TerminalNode CloseParen(int i) {
			return getToken(PCREGrammarParser.CloseParen, i);
		}
		public List<AlternationContext> alternation() {
			return getRuleContexts(AlternationContext.class);
		}
		public AlternationContext alternation(int i) {
			return getRuleContext(AlternationContext.class,i);
		}
		public TerminalNode Pipe() { return getToken(PCREGrammarParser.Pipe, 0); }
		public TerminalNode Plus() { return getToken(PCREGrammarParser.Plus, 0); }
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public List<TerminalNode> SingleQuote() { return getTokens(PCREGrammarParser.SingleQuote); }
		public TerminalNode SingleQuote(int i) {
			return getToken(PCREGrammarParser.SingleQuote, i);
		}
		public TerminalNode RUC() { return getToken(PCREGrammarParser.RUC, 0); }
		public TerminalNode Ampersand() { return getToken(PCREGrammarParser.Ampersand, 0); }
		public TerminalNode DUC() { return getToken(PCREGrammarParser.DUC, 0); }
		public List<TerminalNode> EUC() { return getTokens(PCREGrammarParser.EUC); }
		public TerminalNode EUC(int i) {
			return getToken(PCREGrammarParser.EUC, i);
		}
		public TerminalNode FUC() { return getToken(PCREGrammarParser.FUC, 0); }
		public TerminalNode IUC() { return getToken(PCREGrammarParser.IUC, 0); }
		public TerminalNode NUC() { return getToken(PCREGrammarParser.NUC, 0); }
		public TerminalNode ALC() { return getToken(PCREGrammarParser.ALC, 0); }
		public List<TerminalNode> SLC() { return getTokens(PCREGrammarParser.SLC); }
		public TerminalNode SLC(int i) {
			return getToken(PCREGrammarParser.SLC, i);
		}
		public TerminalNode ELC() { return getToken(PCREGrammarParser.ELC, 0); }
		public TerminalNode RLC() { return getToken(PCREGrammarParser.RLC, 0); }
		public TerminalNode TLC() { return getToken(PCREGrammarParser.TLC, 0); }
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditional);
		int _la;
		try {
			setState(630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(OpenParen);
				setState(480);
				match(QuestionMark);
				setState(481);
				match(OpenParen);
				setState(482);
				number();
				setState(483);
				match(CloseParen);
				setState(484);
				alternation();
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(485);
					match(Pipe);
					setState(486);
					alternation();
					}
				}

				setState(489);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				match(OpenParen);
				setState(492);
				match(QuestionMark);
				setState(493);
				match(OpenParen);
				setState(494);
				match(Plus);
				setState(495);
				number();
				setState(496);
				match(CloseParen);
				setState(497);
				alternation();
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(498);
					match(Pipe);
					setState(499);
					alternation();
					}
				}

				setState(502);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				match(OpenParen);
				setState(505);
				match(QuestionMark);
				setState(506);
				match(OpenParen);
				setState(507);
				match(Hyphen);
				setState(508);
				number();
				setState(509);
				match(CloseParen);
				setState(510);
				alternation();
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(511);
					match(Pipe);
					setState(512);
					alternation();
					}
				}

				setState(515);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(517);
				match(OpenParen);
				setState(518);
				match(QuestionMark);
				setState(519);
				match(OpenParen);
				setState(520);
				match(LessThan);
				setState(521);
				name();
				setState(522);
				match(GreaterThan);
				setState(523);
				match(CloseParen);
				setState(524);
				alternation();
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(525);
					match(Pipe);
					setState(526);
					alternation();
					}
				}

				setState(529);
				match(CloseParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(531);
				match(OpenParen);
				setState(532);
				match(QuestionMark);
				setState(533);
				match(OpenParen);
				setState(534);
				match(SingleQuote);
				setState(535);
				name();
				setState(536);
				match(SingleQuote);
				setState(537);
				match(CloseParen);
				setState(538);
				alternation();
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(539);
					match(Pipe);
					setState(540);
					alternation();
					}
				}

				setState(543);
				match(CloseParen);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(545);
				match(OpenParen);
				setState(546);
				match(QuestionMark);
				setState(547);
				match(OpenParen);
				setState(548);
				match(RUC);
				setState(549);
				number();
				setState(550);
				match(CloseParen);
				setState(551);
				alternation();
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(552);
					match(Pipe);
					setState(553);
					alternation();
					}
				}

				setState(556);
				match(CloseParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(558);
				match(OpenParen);
				setState(559);
				match(QuestionMark);
				setState(560);
				match(OpenParen);
				setState(561);
				match(RUC);
				setState(562);
				match(CloseParen);
				setState(563);
				alternation();
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(564);
					match(Pipe);
					setState(565);
					alternation();
					}
				}

				setState(568);
				match(CloseParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(570);
				match(OpenParen);
				setState(571);
				match(QuestionMark);
				setState(572);
				match(OpenParen);
				setState(573);
				match(RUC);
				setState(574);
				match(Ampersand);
				setState(575);
				name();
				setState(576);
				match(CloseParen);
				setState(577);
				alternation();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(578);
					match(Pipe);
					setState(579);
					alternation();
					}
				}

				setState(582);
				match(CloseParen);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(584);
				match(OpenParen);
				setState(585);
				match(QuestionMark);
				setState(586);
				match(OpenParen);
				setState(587);
				match(DUC);
				setState(588);
				match(EUC);
				setState(589);
				match(FUC);
				setState(590);
				match(IUC);
				setState(591);
				match(NUC);
				setState(592);
				match(EUC);
				setState(593);
				match(CloseParen);
				setState(594);
				alternation();
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(595);
					match(Pipe);
					setState(596);
					alternation();
					}
				}

				setState(599);
				match(CloseParen);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(601);
				match(OpenParen);
				setState(602);
				match(QuestionMark);
				setState(603);
				match(OpenParen);
				setState(604);
				match(ALC);
				setState(605);
				match(SLC);
				setState(606);
				match(SLC);
				setState(607);
				match(ELC);
				setState(608);
				match(RLC);
				setState(609);
				match(TLC);
				setState(610);
				match(CloseParen);
				setState(611);
				alternation();
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(612);
					match(Pipe);
					setState(613);
					alternation();
					}
				}

				setState(616);
				match(CloseParen);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(618);
				match(OpenParen);
				setState(619);
				match(QuestionMark);
				setState(620);
				match(OpenParen);
				setState(621);
				name();
				setState(622);
				match(CloseParen);
				setState(623);
				alternation();
				setState(626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(624);
					match(Pipe);
					setState(625);
					alternation();
					}
				}

				setState(628);
				match(CloseParen);
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

	public static class Backtrack_controlContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode Star() { return getToken(PCREGrammarParser.Star, 0); }
		public List<TerminalNode> AUC() { return getTokens(PCREGrammarParser.AUC); }
		public TerminalNode AUC(int i) {
			return getToken(PCREGrammarParser.AUC, i);
		}
		public List<TerminalNode> CUC() { return getTokens(PCREGrammarParser.CUC); }
		public TerminalNode CUC(int i) {
			return getToken(PCREGrammarParser.CUC, i);
		}
		public List<TerminalNode> EUC() { return getTokens(PCREGrammarParser.EUC); }
		public TerminalNode EUC(int i) {
			return getToken(PCREGrammarParser.EUC, i);
		}
		public TerminalNode PUC() { return getToken(PCREGrammarParser.PUC, 0); }
		public TerminalNode TUC() { return getToken(PCREGrammarParser.TUC, 0); }
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public TerminalNode FUC() { return getToken(PCREGrammarParser.FUC, 0); }
		public TerminalNode IUC() { return getToken(PCREGrammarParser.IUC, 0); }
		public TerminalNode LUC() { return getToken(PCREGrammarParser.LUC, 0); }
		public TerminalNode Colon() { return getToken(PCREGrammarParser.Colon, 0); }
		public List<TerminalNode> NUC() { return getTokens(PCREGrammarParser.NUC); }
		public TerminalNode NUC(int i) {
			return getToken(PCREGrammarParser.NUC, i);
		}
		public List<TerminalNode> MUC() { return getTokens(PCREGrammarParser.MUC); }
		public TerminalNode MUC(int i) {
			return getToken(PCREGrammarParser.MUC, i);
		}
		public TerminalNode RUC() { return getToken(PCREGrammarParser.RUC, 0); }
		public TerminalNode KUC() { return getToken(PCREGrammarParser.KUC, 0); }
		public TerminalNode OUC() { return getToken(PCREGrammarParser.OUC, 0); }
		public TerminalNode UUC() { return getToken(PCREGrammarParser.UUC, 0); }
		public TerminalNode SUC() { return getToken(PCREGrammarParser.SUC, 0); }
		public TerminalNode HUC() { return getToken(PCREGrammarParser.HUC, 0); }
		public Backtrack_controlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backtrack_control; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterBacktrack_control(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitBacktrack_control(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitBacktrack_control(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Backtrack_controlContext backtrack_control() throws RecognitionException {
		Backtrack_controlContext _localctx = new Backtrack_controlContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_backtrack_control);
		int _la;
		try {
			setState(732);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(632);
				match(OpenParen);
				setState(633);
				match(Star);
				setState(634);
				match(AUC);
				setState(635);
				match(CUC);
				setState(636);
				match(CUC);
				setState(637);
				match(EUC);
				setState(638);
				match(PUC);
				setState(639);
				match(TUC);
				setState(640);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(641);
				match(OpenParen);
				setState(642);
				match(Star);
				setState(643);
				match(FUC);
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AUC) {
					{
					setState(644);
					match(AUC);
					setState(645);
					match(IUC);
					setState(646);
					match(LUC);
					}
				}

				setState(649);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				match(OpenParen);
				setState(651);
				match(Star);
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MUC) {
					{
					setState(652);
					match(MUC);
					setState(653);
					match(AUC);
					setState(654);
					match(RUC);
					setState(655);
					match(KUC);
					}
				}

				setState(658);
				match(Colon);
				setState(659);
				match(NUC);
				setState(660);
				match(AUC);
				setState(661);
				match(MUC);
				setState(662);
				match(EUC);
				setState(663);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(664);
				match(OpenParen);
				setState(665);
				match(Star);
				setState(666);
				match(CUC);
				setState(667);
				match(OUC);
				setState(668);
				match(MUC);
				setState(669);
				match(MUC);
				setState(670);
				match(IUC);
				setState(671);
				match(TUC);
				setState(672);
				match(CloseParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(673);
				match(OpenParen);
				setState(674);
				match(Star);
				setState(675);
				match(PUC);
				setState(676);
				match(RUC);
				setState(677);
				match(UUC);
				setState(678);
				match(NUC);
				setState(679);
				match(EUC);
				setState(680);
				match(CloseParen);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(681);
				match(OpenParen);
				setState(682);
				match(Star);
				setState(683);
				match(PUC);
				setState(684);
				match(RUC);
				setState(685);
				match(UUC);
				setState(686);
				match(NUC);
				setState(687);
				match(EUC);
				setState(688);
				match(Colon);
				setState(689);
				match(NUC);
				setState(690);
				match(AUC);
				setState(691);
				match(MUC);
				setState(692);
				match(EUC);
				setState(693);
				match(CloseParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(694);
				match(OpenParen);
				setState(695);
				match(Star);
				setState(696);
				match(SUC);
				setState(697);
				match(KUC);
				setState(698);
				match(IUC);
				setState(699);
				match(PUC);
				setState(700);
				match(CloseParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(701);
				match(OpenParen);
				setState(702);
				match(Star);
				setState(703);
				match(SUC);
				setState(704);
				match(KUC);
				setState(705);
				match(IUC);
				setState(706);
				match(PUC);
				setState(707);
				match(Colon);
				setState(708);
				match(NUC);
				setState(709);
				match(AUC);
				setState(710);
				match(MUC);
				setState(711);
				match(EUC);
				setState(712);
				match(CloseParen);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(713);
				match(OpenParen);
				setState(714);
				match(Star);
				setState(715);
				match(TUC);
				setState(716);
				match(HUC);
				setState(717);
				match(EUC);
				setState(718);
				match(NUC);
				setState(719);
				match(CloseParen);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(720);
				match(OpenParen);
				setState(721);
				match(Star);
				setState(722);
				match(TUC);
				setState(723);
				match(HUC);
				setState(724);
				match(EUC);
				setState(725);
				match(NUC);
				setState(726);
				match(Colon);
				setState(727);
				match(NUC);
				setState(728);
				match(AUC);
				setState(729);
				match(MUC);
				setState(730);
				match(EUC);
				setState(731);
				match(CloseParen);
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

	public static class Newline_conventionContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode Star() { return getToken(PCREGrammarParser.Star, 0); }
		public TerminalNode CUC() { return getToken(PCREGrammarParser.CUC, 0); }
		public List<TerminalNode> RUC() { return getTokens(PCREGrammarParser.RUC); }
		public TerminalNode RUC(int i) {
			return getToken(PCREGrammarParser.RUC, i);
		}
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public TerminalNode LUC() { return getToken(PCREGrammarParser.LUC, 0); }
		public TerminalNode FUC() { return getToken(PCREGrammarParser.FUC, 0); }
		public TerminalNode AUC() { return getToken(PCREGrammarParser.AUC, 0); }
		public TerminalNode NUC() { return getToken(PCREGrammarParser.NUC, 0); }
		public TerminalNode YUC() { return getToken(PCREGrammarParser.YUC, 0); }
		public TerminalNode BUC() { return getToken(PCREGrammarParser.BUC, 0); }
		public TerminalNode SUC() { return getToken(PCREGrammarParser.SUC, 0); }
		public TerminalNode Underscore() { return getToken(PCREGrammarParser.Underscore, 0); }
		public TerminalNode UUC() { return getToken(PCREGrammarParser.UUC, 0); }
		public TerminalNode IUC() { return getToken(PCREGrammarParser.IUC, 0); }
		public TerminalNode OUC() { return getToken(PCREGrammarParser.OUC, 0); }
		public TerminalNode DUC() { return getToken(PCREGrammarParser.DUC, 0); }
		public TerminalNode EUC() { return getToken(PCREGrammarParser.EUC, 0); }
		public Newline_conventionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline_convention; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterNewline_convention(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitNewline_convention(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitNewline_convention(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Newline_conventionContext newline_convention() throws RecognitionException {
		Newline_conventionContext _localctx = new Newline_conventionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_newline_convention);
		try {
			setState(795);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(734);
				match(OpenParen);
				setState(735);
				match(Star);
				setState(736);
				match(CUC);
				setState(737);
				match(RUC);
				setState(738);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(739);
				match(OpenParen);
				setState(740);
				match(Star);
				setState(741);
				match(LUC);
				setState(742);
				match(FUC);
				setState(743);
				match(CloseParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(744);
				match(OpenParen);
				setState(745);
				match(Star);
				setState(746);
				match(CUC);
				setState(747);
				match(RUC);
				setState(748);
				match(LUC);
				setState(749);
				match(FUC);
				setState(750);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(751);
				match(OpenParen);
				setState(752);
				match(Star);
				setState(753);
				match(AUC);
				setState(754);
				match(NUC);
				setState(755);
				match(YUC);
				setState(756);
				match(CUC);
				setState(757);
				match(RUC);
				setState(758);
				match(LUC);
				setState(759);
				match(FUC);
				setState(760);
				match(CloseParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(761);
				match(OpenParen);
				setState(762);
				match(Star);
				setState(763);
				match(AUC);
				setState(764);
				match(NUC);
				setState(765);
				match(YUC);
				setState(766);
				match(CloseParen);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(767);
				match(OpenParen);
				setState(768);
				match(Star);
				setState(769);
				match(BUC);
				setState(770);
				match(SUC);
				setState(771);
				match(RUC);
				setState(772);
				match(Underscore);
				setState(773);
				match(AUC);
				setState(774);
				match(NUC);
				setState(775);
				match(YUC);
				setState(776);
				match(CUC);
				setState(777);
				match(RUC);
				setState(778);
				match(LUC);
				setState(779);
				match(FUC);
				setState(780);
				match(CloseParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(781);
				match(OpenParen);
				setState(782);
				match(Star);
				setState(783);
				match(BUC);
				setState(784);
				match(SUC);
				setState(785);
				match(RUC);
				setState(786);
				match(Underscore);
				setState(787);
				match(UUC);
				setState(788);
				match(NUC);
				setState(789);
				match(IUC);
				setState(790);
				match(CUC);
				setState(791);
				match(OUC);
				setState(792);
				match(DUC);
				setState(793);
				match(EUC);
				setState(794);
				match(CloseParen);
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

	public static class CalloutContext extends ParserRuleContext {
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode CUC() { return getToken(PCREGrammarParser.CUC, 0); }
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public CalloutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterCallout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitCallout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitCallout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalloutContext callout() throws RecognitionException {
		CalloutContext _localctx = new CalloutContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_callout);
		try {
			setState(807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(797);
				match(OpenParen);
				setState(798);
				match(QuestionMark);
				setState(799);
				match(CUC);
				setState(800);
				match(CloseParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(801);
				match(OpenParen);
				setState(802);
				match(QuestionMark);
				setState(803);
				match(CUC);
				setState(804);
				number();
				setState(805);
				match(CloseParen);
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

	public static class AtomContext extends ParserRuleContext {
		public Subroutine_referenceContext subroutine_reference() {
			return getRuleContext(Subroutine_referenceContext.class,0);
		}
		public Shared_atomContext shared_atom() {
			return getRuleContext(Shared_atomContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Character_classContext character_class() {
			return getRuleContext(Character_classContext.class,0);
		}
		public CaptureContext capture() {
			return getRuleContext(CaptureContext.class,0);
		}
		public Non_captureContext non_capture() {
			return getRuleContext(Non_captureContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public OptionContext option() {
			return getRuleContext(OptionContext.class,0);
		}
		public Look_aroundContext look_around() {
			return getRuleContext(Look_aroundContext.class,0);
		}
		public BackreferenceContext backreference() {
			return getRuleContext(BackreferenceContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public Backtrack_controlContext backtrack_control() {
			return getRuleContext(Backtrack_controlContext.class,0);
		}
		public Newline_conventionContext newline_convention() {
			return getRuleContext(Newline_conventionContext.class,0);
		}
		public CalloutContext callout() {
			return getRuleContext(CalloutContext.class,0);
		}
		public TerminalNode Dot() { return getToken(PCREGrammarParser.Dot, 0); }
		public TerminalNode Caret() { return getToken(PCREGrammarParser.Caret, 0); }
		public TerminalNode StartOfSubject() { return getToken(PCREGrammarParser.StartOfSubject, 0); }
		public TerminalNode WordBoundary() { return getToken(PCREGrammarParser.WordBoundary, 0); }
		public TerminalNode NonWordBoundary() { return getToken(PCREGrammarParser.NonWordBoundary, 0); }
		public TerminalNode EndOfSubjectOrLine() { return getToken(PCREGrammarParser.EndOfSubjectOrLine, 0); }
		public TerminalNode EndOfSubjectOrLineEndOfSubject() { return getToken(PCREGrammarParser.EndOfSubjectOrLineEndOfSubject, 0); }
		public TerminalNode EndOfSubject() { return getToken(PCREGrammarParser.EndOfSubject, 0); }
		public TerminalNode PreviousMatchInSubject() { return getToken(PCREGrammarParser.PreviousMatchInSubject, 0); }
		public TerminalNode ResetStartMatch() { return getToken(PCREGrammarParser.ResetStartMatch, 0); }
		public TerminalNode OneDataUnit() { return getToken(PCREGrammarParser.OneDataUnit, 0); }
		public TerminalNode ExtendedUnicodeChar() { return getToken(PCREGrammarParser.ExtendedUnicodeChar, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_atom);
		try {
			setState(835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(809);
				subroutine_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(810);
				shared_atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(811);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(812);
				character_class();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(813);
				capture();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(814);
				non_capture();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(815);
				comment();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(816);
				option();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(817);
				look_around();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(818);
				backreference();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(819);
				conditional();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(820);
				backtrack_control();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(821);
				newline_convention();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(822);
				callout();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(823);
				match(Dot);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(824);
				match(Caret);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(825);
				match(StartOfSubject);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(826);
				match(WordBoundary);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(827);
				match(NonWordBoundary);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(828);
				match(EndOfSubjectOrLine);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(829);
				match(EndOfSubjectOrLineEndOfSubject);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(830);
				match(EndOfSubject);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(831);
				match(PreviousMatchInSubject);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(832);
				match(ResetStartMatch);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(833);
				match(OneDataUnit);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(834);
				match(ExtendedUnicodeChar);
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

	public static class Cc_atomContext extends ParserRuleContext {
		public List<Cc_literalContext> cc_literal() {
			return getRuleContexts(Cc_literalContext.class);
		}
		public Cc_literalContext cc_literal(int i) {
			return getRuleContext(Cc_literalContext.class,i);
		}
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public Shared_atomContext shared_atom() {
			return getRuleContext(Shared_atomContext.class,0);
		}
		public Backreference_or_octalContext backreference_or_octal() {
			return getRuleContext(Backreference_or_octalContext.class,0);
		}
		public Cc_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cc_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterCc_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitCc_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitCc_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cc_atomContext cc_atom() throws RecognitionException {
		Cc_atomContext _localctx = new Cc_atomContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cc_atom);
		try {
			setState(844);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(837);
				cc_literal();
				setState(838);
				match(Hyphen);
				setState(839);
				cc_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(841);
				shared_atom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(842);
				cc_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(843);
				backreference_or_octal();
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

	public static class Shared_atomContext extends ParserRuleContext {
		public TerminalNode POSIXNamedSet() { return getToken(PCREGrammarParser.POSIXNamedSet, 0); }
		public TerminalNode POSIXNegatedNamedSet() { return getToken(PCREGrammarParser.POSIXNegatedNamedSet, 0); }
		public TerminalNode ControlChar() { return getToken(PCREGrammarParser.ControlChar, 0); }
		public TerminalNode DecimalDigit() { return getToken(PCREGrammarParser.DecimalDigit, 0); }
		public TerminalNode NotDecimalDigit() { return getToken(PCREGrammarParser.NotDecimalDigit, 0); }
		public TerminalNode HorizontalWhiteSpace() { return getToken(PCREGrammarParser.HorizontalWhiteSpace, 0); }
		public TerminalNode NotHorizontalWhiteSpace() { return getToken(PCREGrammarParser.NotHorizontalWhiteSpace, 0); }
		public TerminalNode NotNewLine() { return getToken(PCREGrammarParser.NotNewLine, 0); }
		public TerminalNode CharWithProperty() { return getToken(PCREGrammarParser.CharWithProperty, 0); }
		public TerminalNode CharWithoutProperty() { return getToken(PCREGrammarParser.CharWithoutProperty, 0); }
		public TerminalNode NewLineSequence() { return getToken(PCREGrammarParser.NewLineSequence, 0); }
		public TerminalNode WhiteSpace() { return getToken(PCREGrammarParser.WhiteSpace, 0); }
		public TerminalNode NotWhiteSpace() { return getToken(PCREGrammarParser.NotWhiteSpace, 0); }
		public TerminalNode VerticalWhiteSpace() { return getToken(PCREGrammarParser.VerticalWhiteSpace, 0); }
		public TerminalNode NotVerticalWhiteSpace() { return getToken(PCREGrammarParser.NotVerticalWhiteSpace, 0); }
		public TerminalNode WordChar() { return getToken(PCREGrammarParser.WordChar, 0); }
		public TerminalNode NotWordChar() { return getToken(PCREGrammarParser.NotWordChar, 0); }
		public Shared_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shared_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterShared_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitShared_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitShared_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shared_atomContext shared_atom() throws RecognitionException {
		Shared_atomContext _localctx = new Shared_atomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shared_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ControlChar) | (1L << DecimalDigit) | (1L << NotDecimalDigit) | (1L << HorizontalWhiteSpace) | (1L << NotHorizontalWhiteSpace) | (1L << NotNewLine) | (1L << CharWithProperty) | (1L << CharWithoutProperty) | (1L << NewLineSequence) | (1L << WhiteSpace) | (1L << NotWhiteSpace) | (1L << VerticalWhiteSpace) | (1L << NotVerticalWhiteSpace) | (1L << WordChar) | (1L << NotWordChar) | (1L << POSIXNamedSet) | (1L << POSIXNegatedNamedSet))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class LiteralContext extends ParserRuleContext {
		public Shared_literalContext shared_literal() {
			return getRuleContext(Shared_literalContext.class,0);
		}
		public TerminalNode CharacterClassEnd() { return getToken(PCREGrammarParser.CharacterClassEnd, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(850);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Quoted:
			case BlockQuoted:
			case BellChar:
			case EscapeChar:
			case FormFeed:
			case NewLine:
			case CarriageReturn:
			case Tab:
			case Backslash:
			case HexChar:
			case Hyphen:
			case OpenBrace:
			case CloseBrace:
			case Comma:
			case LessThan:
			case GreaterThan:
			case SingleQuote:
			case Underscore:
			case Colon:
			case Hash:
			case Equals:
			case Exclamation:
			case Ampersand:
			case ALC:
			case BLC:
			case CLC:
			case DLC:
			case ELC:
			case FLC:
			case GLC:
			case HLC:
			case ILC:
			case JLC:
			case KLC:
			case LLC:
			case MLC:
			case NLC:
			case OLC:
			case PLC:
			case QLC:
			case RLC:
			case SLC:
			case TLC:
			case ULC:
			case VLC:
			case WLC:
			case XLC:
			case YLC:
			case ZLC:
			case AUC:
			case BUC:
			case CUC:
			case DUC:
			case EUC:
			case FUC:
			case GUC:
			case HUC:
			case IUC:
			case JUC:
			case KUC:
			case LUC:
			case MUC:
			case NUC:
			case OUC:
			case PUC:
			case QUC:
			case RUC:
			case SUC:
			case TUC:
			case UUC:
			case VUC:
			case WUC:
			case XUC:
			case YUC:
			case ZUC:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case D0:
			case OtherChar:
				enterOuterAlt(_localctx, 1);
				{
				setState(848);
				shared_literal();
				}
				break;
			case CharacterClassEnd:
				enterOuterAlt(_localctx, 2);
				{
				setState(849);
				match(CharacterClassEnd);
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

	public static class Cc_literalContext extends ParserRuleContext {
		public Shared_literalContext shared_literal() {
			return getRuleContext(Shared_literalContext.class,0);
		}
		public TerminalNode Dot() { return getToken(PCREGrammarParser.Dot, 0); }
		public TerminalNode CharacterClassStart() { return getToken(PCREGrammarParser.CharacterClassStart, 0); }
		public TerminalNode Caret() { return getToken(PCREGrammarParser.Caret, 0); }
		public TerminalNode QuestionMark() { return getToken(PCREGrammarParser.QuestionMark, 0); }
		public TerminalNode Plus() { return getToken(PCREGrammarParser.Plus, 0); }
		public TerminalNode Star() { return getToken(PCREGrammarParser.Star, 0); }
		public TerminalNode WordBoundary() { return getToken(PCREGrammarParser.WordBoundary, 0); }
		public TerminalNode EndOfSubjectOrLine() { return getToken(PCREGrammarParser.EndOfSubjectOrLine, 0); }
		public TerminalNode Pipe() { return getToken(PCREGrammarParser.Pipe, 0); }
		public TerminalNode OpenParen() { return getToken(PCREGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public Cc_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cc_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterCc_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitCc_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitCc_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cc_literalContext cc_literal() throws RecognitionException {
		Cc_literalContext _localctx = new Cc_literalContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cc_literal);
		try {
			setState(864);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Quoted:
			case BlockQuoted:
			case BellChar:
			case EscapeChar:
			case FormFeed:
			case NewLine:
			case CarriageReturn:
			case Tab:
			case Backslash:
			case HexChar:
			case Hyphen:
			case OpenBrace:
			case CloseBrace:
			case Comma:
			case LessThan:
			case GreaterThan:
			case SingleQuote:
			case Underscore:
			case Colon:
			case Hash:
			case Equals:
			case Exclamation:
			case Ampersand:
			case ALC:
			case BLC:
			case CLC:
			case DLC:
			case ELC:
			case FLC:
			case GLC:
			case HLC:
			case ILC:
			case JLC:
			case KLC:
			case LLC:
			case MLC:
			case NLC:
			case OLC:
			case PLC:
			case QLC:
			case RLC:
			case SLC:
			case TLC:
			case ULC:
			case VLC:
			case WLC:
			case XLC:
			case YLC:
			case ZLC:
			case AUC:
			case BUC:
			case CUC:
			case DUC:
			case EUC:
			case FUC:
			case GUC:
			case HUC:
			case IUC:
			case JUC:
			case KUC:
			case LUC:
			case MUC:
			case NUC:
			case OUC:
			case PUC:
			case QUC:
			case RUC:
			case SUC:
			case TUC:
			case UUC:
			case VUC:
			case WUC:
			case XUC:
			case YUC:
			case ZUC:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case D0:
			case OtherChar:
				enterOuterAlt(_localctx, 1);
				{
				setState(852);
				shared_literal();
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(853);
				match(Dot);
				}
				break;
			case CharacterClassStart:
				enterOuterAlt(_localctx, 3);
				{
				setState(854);
				match(CharacterClassStart);
				}
				break;
			case Caret:
				enterOuterAlt(_localctx, 4);
				{
				setState(855);
				match(Caret);
				}
				break;
			case QuestionMark:
				enterOuterAlt(_localctx, 5);
				{
				setState(856);
				match(QuestionMark);
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 6);
				{
				setState(857);
				match(Plus);
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 7);
				{
				setState(858);
				match(Star);
				}
				break;
			case WordBoundary:
				enterOuterAlt(_localctx, 8);
				{
				setState(859);
				match(WordBoundary);
				}
				break;
			case EndOfSubjectOrLine:
				enterOuterAlt(_localctx, 9);
				{
				setState(860);
				match(EndOfSubjectOrLine);
				}
				break;
			case Pipe:
				enterOuterAlt(_localctx, 10);
				{
				setState(861);
				match(Pipe);
				}
				break;
			case OpenParen:
				enterOuterAlt(_localctx, 11);
				{
				setState(862);
				match(OpenParen);
				}
				break;
			case CloseParen:
				enterOuterAlt(_localctx, 12);
				{
				setState(863);
				match(CloseParen);
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

	public static class Shared_literalContext extends ParserRuleContext {
		public Octal_charContext octal_char() {
			return getRuleContext(Octal_charContext.class,0);
		}
		public LetterContext letter() {
			return getRuleContext(LetterContext.class,0);
		}
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public TerminalNode BellChar() { return getToken(PCREGrammarParser.BellChar, 0); }
		public TerminalNode EscapeChar() { return getToken(PCREGrammarParser.EscapeChar, 0); }
		public TerminalNode FormFeed() { return getToken(PCREGrammarParser.FormFeed, 0); }
		public TerminalNode NewLine() { return getToken(PCREGrammarParser.NewLine, 0); }
		public TerminalNode CarriageReturn() { return getToken(PCREGrammarParser.CarriageReturn, 0); }
		public TerminalNode Tab() { return getToken(PCREGrammarParser.Tab, 0); }
		public TerminalNode HexChar() { return getToken(PCREGrammarParser.HexChar, 0); }
		public TerminalNode Quoted() { return getToken(PCREGrammarParser.Quoted, 0); }
		public TerminalNode BlockQuoted() { return getToken(PCREGrammarParser.BlockQuoted, 0); }
		public TerminalNode OpenBrace() { return getToken(PCREGrammarParser.OpenBrace, 0); }
		public TerminalNode CloseBrace() { return getToken(PCREGrammarParser.CloseBrace, 0); }
		public TerminalNode Comma() { return getToken(PCREGrammarParser.Comma, 0); }
		public TerminalNode Hyphen() { return getToken(PCREGrammarParser.Hyphen, 0); }
		public TerminalNode LessThan() { return getToken(PCREGrammarParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(PCREGrammarParser.GreaterThan, 0); }
		public TerminalNode SingleQuote() { return getToken(PCREGrammarParser.SingleQuote, 0); }
		public TerminalNode Underscore() { return getToken(PCREGrammarParser.Underscore, 0); }
		public TerminalNode Colon() { return getToken(PCREGrammarParser.Colon, 0); }
		public TerminalNode Hash() { return getToken(PCREGrammarParser.Hash, 0); }
		public TerminalNode Equals() { return getToken(PCREGrammarParser.Equals, 0); }
		public TerminalNode Exclamation() { return getToken(PCREGrammarParser.Exclamation, 0); }
		public TerminalNode Ampersand() { return getToken(PCREGrammarParser.Ampersand, 0); }
		public TerminalNode OtherChar() { return getToken(PCREGrammarParser.OtherChar, 0); }
		public Shared_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shared_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterShared_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitShared_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitShared_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shared_literalContext shared_literal() throws RecognitionException {
		Shared_literalContext _localctx = new Shared_literalContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_shared_literal);
		try {
			setState(892);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Backslash:
				enterOuterAlt(_localctx, 1);
				{
				setState(866);
				octal_char();
				}
				break;
			case ALC:
			case BLC:
			case CLC:
			case DLC:
			case ELC:
			case FLC:
			case GLC:
			case HLC:
			case ILC:
			case JLC:
			case KLC:
			case LLC:
			case MLC:
			case NLC:
			case OLC:
			case PLC:
			case QLC:
			case RLC:
			case SLC:
			case TLC:
			case ULC:
			case VLC:
			case WLC:
			case XLC:
			case YLC:
			case ZLC:
			case AUC:
			case BUC:
			case CUC:
			case DUC:
			case EUC:
			case FUC:
			case GUC:
			case HUC:
			case IUC:
			case JUC:
			case KUC:
			case LUC:
			case MUC:
			case NUC:
			case OUC:
			case PUC:
			case QUC:
			case RUC:
			case SUC:
			case TUC:
			case UUC:
			case VUC:
			case WUC:
			case XUC:
			case YUC:
			case ZUC:
				enterOuterAlt(_localctx, 2);
				{
				setState(867);
				letter();
				}
				break;
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case D0:
				enterOuterAlt(_localctx, 3);
				{
				setState(868);
				digit();
				}
				break;
			case BellChar:
				enterOuterAlt(_localctx, 4);
				{
				setState(869);
				match(BellChar);
				}
				break;
			case EscapeChar:
				enterOuterAlt(_localctx, 5);
				{
				setState(870);
				match(EscapeChar);
				}
				break;
			case FormFeed:
				enterOuterAlt(_localctx, 6);
				{
				setState(871);
				match(FormFeed);
				}
				break;
			case NewLine:
				enterOuterAlt(_localctx, 7);
				{
				setState(872);
				match(NewLine);
				}
				break;
			case CarriageReturn:
				enterOuterAlt(_localctx, 8);
				{
				setState(873);
				match(CarriageReturn);
				}
				break;
			case Tab:
				enterOuterAlt(_localctx, 9);
				{
				setState(874);
				match(Tab);
				}
				break;
			case HexChar:
				enterOuterAlt(_localctx, 10);
				{
				setState(875);
				match(HexChar);
				}
				break;
			case Quoted:
				enterOuterAlt(_localctx, 11);
				{
				setState(876);
				match(Quoted);
				}
				break;
			case BlockQuoted:
				enterOuterAlt(_localctx, 12);
				{
				setState(877);
				match(BlockQuoted);
				}
				break;
			case OpenBrace:
				enterOuterAlt(_localctx, 13);
				{
				setState(878);
				match(OpenBrace);
				}
				break;
			case CloseBrace:
				enterOuterAlt(_localctx, 14);
				{
				setState(879);
				match(CloseBrace);
				}
				break;
			case Comma:
				enterOuterAlt(_localctx, 15);
				{
				setState(880);
				match(Comma);
				}
				break;
			case Hyphen:
				enterOuterAlt(_localctx, 16);
				{
				setState(881);
				match(Hyphen);
				}
				break;
			case LessThan:
				enterOuterAlt(_localctx, 17);
				{
				setState(882);
				match(LessThan);
				}
				break;
			case GreaterThan:
				enterOuterAlt(_localctx, 18);
				{
				setState(883);
				match(GreaterThan);
				}
				break;
			case SingleQuote:
				enterOuterAlt(_localctx, 19);
				{
				setState(884);
				match(SingleQuote);
				}
				break;
			case Underscore:
				enterOuterAlt(_localctx, 20);
				{
				setState(885);
				match(Underscore);
				}
				break;
			case Colon:
				enterOuterAlt(_localctx, 21);
				{
				setState(886);
				match(Colon);
				}
				break;
			case Hash:
				enterOuterAlt(_localctx, 22);
				{
				setState(887);
				match(Hash);
				}
				break;
			case Equals:
				enterOuterAlt(_localctx, 23);
				{
				setState(888);
				match(Equals);
				}
				break;
			case Exclamation:
				enterOuterAlt(_localctx, 24);
				{
				setState(889);
				match(Exclamation);
				}
				break;
			case Ampersand:
				enterOuterAlt(_localctx, 25);
				{
				setState(890);
				match(Ampersand);
				}
				break;
			case OtherChar:
				enterOuterAlt(_localctx, 26);
				{
				setState(891);
				match(OtherChar);
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

	public static class NumberContext extends ParserRuleContext {
		public DigitsContext digits() {
			return getRuleContext(DigitsContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			digits();
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

	public static class Octal_charContext extends ParserRuleContext {
		public TerminalNode Backslash() { return getToken(PCREGrammarParser.Backslash, 0); }
		public List<Octal_digitContext> octal_digit() {
			return getRuleContexts(Octal_digitContext.class);
		}
		public Octal_digitContext octal_digit(int i) {
			return getRuleContext(Octal_digitContext.class,i);
		}
		public TerminalNode D0() { return getToken(PCREGrammarParser.D0, 0); }
		public TerminalNode D1() { return getToken(PCREGrammarParser.D1, 0); }
		public TerminalNode D2() { return getToken(PCREGrammarParser.D2, 0); }
		public TerminalNode D3() { return getToken(PCREGrammarParser.D3, 0); }
		public Octal_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octal_char; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterOctal_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitOctal_char(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitOctal_char(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Octal_charContext octal_char() throws RecognitionException {
		Octal_charContext _localctx = new Octal_charContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_octal_char);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(896);
				match(Backslash);
				setState(897);
				_la = _input.LA(1);
				if ( !(((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (D1 - 118)) | (1L << (D2 - 118)) | (1L << (D3 - 118)) | (1L << (D0 - 118)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(898);
				octal_digit();
				setState(899);
				octal_digit();
				}
				break;
			case 2:
				{
				setState(901);
				match(Backslash);
				setState(902);
				octal_digit();
				setState(903);
				octal_digit();
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

	public static class Octal_digitContext extends ParserRuleContext {
		public TerminalNode D0() { return getToken(PCREGrammarParser.D0, 0); }
		public TerminalNode D1() { return getToken(PCREGrammarParser.D1, 0); }
		public TerminalNode D2() { return getToken(PCREGrammarParser.D2, 0); }
		public TerminalNode D3() { return getToken(PCREGrammarParser.D3, 0); }
		public TerminalNode D4() { return getToken(PCREGrammarParser.D4, 0); }
		public TerminalNode D5() { return getToken(PCREGrammarParser.D5, 0); }
		public TerminalNode D6() { return getToken(PCREGrammarParser.D6, 0); }
		public TerminalNode D7() { return getToken(PCREGrammarParser.D7, 0); }
		public Octal_digitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octal_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterOctal_digit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitOctal_digit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitOctal_digit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Octal_digitContext octal_digit() throws RecognitionException {
		Octal_digitContext _localctx = new Octal_digitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_octal_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			_la = _input.LA(1);
			if ( !(((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (D1 - 118)) | (1L << (D2 - 118)) | (1L << (D3 - 118)) | (1L << (D4 - 118)) | (1L << (D5 - 118)) | (1L << (D6 - 118)) | (1L << (D7 - 118)) | (1L << (D0 - 118)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class DigitsContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public DigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterDigits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitDigits(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitDigits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitsContext digits() throws RecognitionException {
		DigitsContext _localctx = new DigitsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_digits);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(910); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(909);
					digit();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(912); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode D0() { return getToken(PCREGrammarParser.D0, 0); }
		public TerminalNode D1() { return getToken(PCREGrammarParser.D1, 0); }
		public TerminalNode D2() { return getToken(PCREGrammarParser.D2, 0); }
		public TerminalNode D3() { return getToken(PCREGrammarParser.D3, 0); }
		public TerminalNode D4() { return getToken(PCREGrammarParser.D4, 0); }
		public TerminalNode D5() { return getToken(PCREGrammarParser.D5, 0); }
		public TerminalNode D6() { return getToken(PCREGrammarParser.D6, 0); }
		public TerminalNode D7() { return getToken(PCREGrammarParser.D7, 0); }
		public TerminalNode D8() { return getToken(PCREGrammarParser.D8, 0); }
		public TerminalNode D9() { return getToken(PCREGrammarParser.D9, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_la = _input.LA(1);
			if ( !(((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (D1 - 118)) | (1L << (D2 - 118)) | (1L << (D3 - 118)) | (1L << (D4 - 118)) | (1L << (D5 - 118)) | (1L << (D6 - 118)) | (1L << (D7 - 118)) | (1L << (D8 - 118)) | (1L << (D9 - 118)) | (1L << (D0 - 118)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NameContext extends ParserRuleContext {
		public Alpha_numsContext alpha_nums() {
			return getRuleContext(Alpha_numsContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			alpha_nums();
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

	public static class Alpha_numsContext extends ParserRuleContext {
		public List<LetterContext> letter() {
			return getRuleContexts(LetterContext.class);
		}
		public LetterContext letter(int i) {
			return getRuleContext(LetterContext.class,i);
		}
		public List<TerminalNode> Underscore() { return getTokens(PCREGrammarParser.Underscore); }
		public TerminalNode Underscore(int i) {
			return getToken(PCREGrammarParser.Underscore, i);
		}
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public Alpha_numsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alpha_nums; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterAlpha_nums(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitAlpha_nums(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitAlpha_nums(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alpha_numsContext alpha_nums() throws RecognitionException {
		Alpha_numsContext _localctx = new Alpha_numsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_alpha_nums);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALC:
			case BLC:
			case CLC:
			case DLC:
			case ELC:
			case FLC:
			case GLC:
			case HLC:
			case ILC:
			case JLC:
			case KLC:
			case LLC:
			case MLC:
			case NLC:
			case OLC:
			case PLC:
			case QLC:
			case RLC:
			case SLC:
			case TLC:
			case ULC:
			case VLC:
			case WLC:
			case XLC:
			case YLC:
			case ZLC:
			case AUC:
			case BUC:
			case CUC:
			case DUC:
			case EUC:
			case FUC:
			case GUC:
			case HUC:
			case IUC:
			case JUC:
			case KUC:
			case LUC:
			case MUC:
			case NUC:
			case OUC:
			case PUC:
			case QUC:
			case RUC:
			case SUC:
			case TUC:
			case UUC:
			case VUC:
			case WUC:
			case XUC:
			case YUC:
			case ZUC:
				{
				setState(918);
				letter();
				}
				break;
			case Underscore:
				{
				setState(919);
				match(Underscore);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(927);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(925);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ALC:
					case BLC:
					case CLC:
					case DLC:
					case ELC:
					case FLC:
					case GLC:
					case HLC:
					case ILC:
					case JLC:
					case KLC:
					case LLC:
					case MLC:
					case NLC:
					case OLC:
					case PLC:
					case QLC:
					case RLC:
					case SLC:
					case TLC:
					case ULC:
					case VLC:
					case WLC:
					case XLC:
					case YLC:
					case ZLC:
					case AUC:
					case BUC:
					case CUC:
					case DUC:
					case EUC:
					case FUC:
					case GUC:
					case HUC:
					case IUC:
					case JUC:
					case KUC:
					case LUC:
					case MUC:
					case NUC:
					case OUC:
					case PUC:
					case QUC:
					case RUC:
					case SUC:
					case TUC:
					case UUC:
					case VUC:
					case WUC:
					case XUC:
					case YUC:
					case ZUC:
						{
						setState(922);
						letter();
						}
						break;
					case Underscore:
						{
						setState(923);
						match(Underscore);
						}
						break;
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
					case D0:
						{
						setState(924);
						digit();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(929);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	public static class Non_close_parensContext extends ParserRuleContext {
		public List<Non_close_parenContext> non_close_paren() {
			return getRuleContexts(Non_close_parenContext.class);
		}
		public Non_close_parenContext non_close_paren(int i) {
			return getRuleContext(Non_close_parenContext.class,i);
		}
		public Non_close_parensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_close_parens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterNon_close_parens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitNon_close_parens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitNon_close_parens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_close_parensContext non_close_parens() throws RecognitionException {
		Non_close_parensContext _localctx = new Non_close_parensContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_non_close_parens);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(930);
				non_close_paren();
				}
				}
				setState(933); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (T__1 - 1)) | (1L << (T__2 - 1)) | (1L << (Quoted - 1)) | (1L << (BlockQuoted - 1)) | (1L << (BellChar - 1)) | (1L << (ControlChar - 1)) | (1L << (EscapeChar - 1)) | (1L << (FormFeed - 1)) | (1L << (NewLine - 1)) | (1L << (CarriageReturn - 1)) | (1L << (Tab - 1)) | (1L << (Backslash - 1)) | (1L << (HexChar - 1)) | (1L << (Dot - 1)) | (1L << (OneDataUnit - 1)) | (1L << (DecimalDigit - 1)) | (1L << (NotDecimalDigit - 1)) | (1L << (HorizontalWhiteSpace - 1)) | (1L << (NotHorizontalWhiteSpace - 1)) | (1L << (NotNewLine - 1)) | (1L << (CharWithProperty - 1)) | (1L << (CharWithoutProperty - 1)) | (1L << (NewLineSequence - 1)) | (1L << (WhiteSpace - 1)) | (1L << (NotWhiteSpace - 1)) | (1L << (VerticalWhiteSpace - 1)) | (1L << (NotVerticalWhiteSpace - 1)) | (1L << (WordChar - 1)) | (1L << (NotWordChar - 1)) | (1L << (ExtendedUnicodeChar - 1)) | (1L << (CharacterClassStart - 1)) | (1L << (CharacterClassEnd - 1)) | (1L << (Caret - 1)) | (1L << (Hyphen - 1)) | (1L << (POSIXNamedSet - 1)) | (1L << (POSIXNegatedNamedSet - 1)) | (1L << (QuestionMark - 1)) | (1L << (Plus - 1)) | (1L << (Star - 1)) | (1L << (OpenBrace - 1)) | (1L << (CloseBrace - 1)) | (1L << (Comma - 1)) | (1L << (WordBoundary - 1)) | (1L << (NonWordBoundary - 1)) | (1L << (StartOfSubject - 1)) | (1L << (EndOfSubjectOrLine - 1)) | (1L << (EndOfSubjectOrLineEndOfSubject - 1)) | (1L << (EndOfSubject - 1)) | (1L << (PreviousMatchInSubject - 1)) | (1L << (ResetStartMatch - 1)) | (1L << (SubroutineOrNamedReferenceStartG - 1)) | (1L << (NamedReferenceStartK - 1)) | (1L << (Pipe - 1)) | (1L << (OpenParen - 1)) | (1L << (LessThan - 1)) | (1L << (GreaterThan - 1)) | (1L << (SingleQuote - 1)) | (1L << (Underscore - 1)) | (1L << (Colon - 1)) | (1L << (Hash - 1)) | (1L << (Equals - 1)) | (1L << (Exclamation - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Ampersand - 65)) | (1L << (ALC - 65)) | (1L << (BLC - 65)) | (1L << (CLC - 65)) | (1L << (DLC - 65)) | (1L << (ELC - 65)) | (1L << (FLC - 65)) | (1L << (GLC - 65)) | (1L << (HLC - 65)) | (1L << (ILC - 65)) | (1L << (JLC - 65)) | (1L << (KLC - 65)) | (1L << (LLC - 65)) | (1L << (MLC - 65)) | (1L << (NLC - 65)) | (1L << (OLC - 65)) | (1L << (PLC - 65)) | (1L << (QLC - 65)) | (1L << (RLC - 65)) | (1L << (SLC - 65)) | (1L << (TLC - 65)) | (1L << (ULC - 65)) | (1L << (VLC - 65)) | (1L << (WLC - 65)) | (1L << (XLC - 65)) | (1L << (YLC - 65)) | (1L << (ZLC - 65)) | (1L << (AUC - 65)) | (1L << (BUC - 65)) | (1L << (CUC - 65)) | (1L << (DUC - 65)) | (1L << (EUC - 65)) | (1L << (FUC - 65)) | (1L << (GUC - 65)) | (1L << (HUC - 65)) | (1L << (IUC - 65)) | (1L << (JUC - 65)) | (1L << (KUC - 65)) | (1L << (LUC - 65)) | (1L << (MUC - 65)) | (1L << (NUC - 65)) | (1L << (OUC - 65)) | (1L << (PUC - 65)) | (1L << (QUC - 65)) | (1L << (RUC - 65)) | (1L << (SUC - 65)) | (1L << (TUC - 65)) | (1L << (UUC - 65)) | (1L << (VUC - 65)) | (1L << (WUC - 65)) | (1L << (XUC - 65)) | (1L << (YUC - 65)) | (1L << (ZUC - 65)) | (1L << (D1 - 65)) | (1L << (D2 - 65)) | (1L << (D3 - 65)) | (1L << (D4 - 65)) | (1L << (D5 - 65)) | (1L << (D6 - 65)) | (1L << (D7 - 65)) | (1L << (D8 - 65)) | (1L << (D9 - 65)) | (1L << (D0 - 65)) | (1L << (OtherChar - 65)))) != 0) );
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

	public static class Non_close_parenContext extends ParserRuleContext {
		public TerminalNode CloseParen() { return getToken(PCREGrammarParser.CloseParen, 0); }
		public Non_close_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_close_paren; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterNon_close_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitNon_close_paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitNon_close_paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_close_parenContext non_close_paren() throws RecognitionException {
		Non_close_parenContext _localctx = new Non_close_parenContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_non_close_paren);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==CloseParen) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class LetterContext extends ParserRuleContext {
		public TerminalNode ALC() { return getToken(PCREGrammarParser.ALC, 0); }
		public TerminalNode BLC() { return getToken(PCREGrammarParser.BLC, 0); }
		public TerminalNode CLC() { return getToken(PCREGrammarParser.CLC, 0); }
		public TerminalNode DLC() { return getToken(PCREGrammarParser.DLC, 0); }
		public TerminalNode ELC() { return getToken(PCREGrammarParser.ELC, 0); }
		public TerminalNode FLC() { return getToken(PCREGrammarParser.FLC, 0); }
		public TerminalNode GLC() { return getToken(PCREGrammarParser.GLC, 0); }
		public TerminalNode HLC() { return getToken(PCREGrammarParser.HLC, 0); }
		public TerminalNode ILC() { return getToken(PCREGrammarParser.ILC, 0); }
		public TerminalNode JLC() { return getToken(PCREGrammarParser.JLC, 0); }
		public TerminalNode KLC() { return getToken(PCREGrammarParser.KLC, 0); }
		public TerminalNode LLC() { return getToken(PCREGrammarParser.LLC, 0); }
		public TerminalNode MLC() { return getToken(PCREGrammarParser.MLC, 0); }
		public TerminalNode NLC() { return getToken(PCREGrammarParser.NLC, 0); }
		public TerminalNode OLC() { return getToken(PCREGrammarParser.OLC, 0); }
		public TerminalNode PLC() { return getToken(PCREGrammarParser.PLC, 0); }
		public TerminalNode QLC() { return getToken(PCREGrammarParser.QLC, 0); }
		public TerminalNode RLC() { return getToken(PCREGrammarParser.RLC, 0); }
		public TerminalNode SLC() { return getToken(PCREGrammarParser.SLC, 0); }
		public TerminalNode TLC() { return getToken(PCREGrammarParser.TLC, 0); }
		public TerminalNode ULC() { return getToken(PCREGrammarParser.ULC, 0); }
		public TerminalNode VLC() { return getToken(PCREGrammarParser.VLC, 0); }
		public TerminalNode WLC() { return getToken(PCREGrammarParser.WLC, 0); }
		public TerminalNode XLC() { return getToken(PCREGrammarParser.XLC, 0); }
		public TerminalNode YLC() { return getToken(PCREGrammarParser.YLC, 0); }
		public TerminalNode ZLC() { return getToken(PCREGrammarParser.ZLC, 0); }
		public TerminalNode AUC() { return getToken(PCREGrammarParser.AUC, 0); }
		public TerminalNode BUC() { return getToken(PCREGrammarParser.BUC, 0); }
		public TerminalNode CUC() { return getToken(PCREGrammarParser.CUC, 0); }
		public TerminalNode DUC() { return getToken(PCREGrammarParser.DUC, 0); }
		public TerminalNode EUC() { return getToken(PCREGrammarParser.EUC, 0); }
		public TerminalNode FUC() { return getToken(PCREGrammarParser.FUC, 0); }
		public TerminalNode GUC() { return getToken(PCREGrammarParser.GUC, 0); }
		public TerminalNode HUC() { return getToken(PCREGrammarParser.HUC, 0); }
		public TerminalNode IUC() { return getToken(PCREGrammarParser.IUC, 0); }
		public TerminalNode JUC() { return getToken(PCREGrammarParser.JUC, 0); }
		public TerminalNode KUC() { return getToken(PCREGrammarParser.KUC, 0); }
		public TerminalNode LUC() { return getToken(PCREGrammarParser.LUC, 0); }
		public TerminalNode MUC() { return getToken(PCREGrammarParser.MUC, 0); }
		public TerminalNode NUC() { return getToken(PCREGrammarParser.NUC, 0); }
		public TerminalNode OUC() { return getToken(PCREGrammarParser.OUC, 0); }
		public TerminalNode PUC() { return getToken(PCREGrammarParser.PUC, 0); }
		public TerminalNode QUC() { return getToken(PCREGrammarParser.QUC, 0); }
		public TerminalNode RUC() { return getToken(PCREGrammarParser.RUC, 0); }
		public TerminalNode SUC() { return getToken(PCREGrammarParser.SUC, 0); }
		public TerminalNode TUC() { return getToken(PCREGrammarParser.TUC, 0); }
		public TerminalNode UUC() { return getToken(PCREGrammarParser.UUC, 0); }
		public TerminalNode VUC() { return getToken(PCREGrammarParser.VUC, 0); }
		public TerminalNode WUC() { return getToken(PCREGrammarParser.WUC, 0); }
		public TerminalNode XUC() { return getToken(PCREGrammarParser.XUC, 0); }
		public TerminalNode YUC() { return getToken(PCREGrammarParser.YUC, 0); }
		public TerminalNode ZUC() { return getToken(PCREGrammarParser.ZUC, 0); }
		public LetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).enterLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCREGrammarListener ) ((PCREGrammarListener)listener).exitLetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCREGrammarVisitor ) return ((PCREGrammarVisitor<? extends T>)visitor).visitLetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetterContext letter() throws RecognitionException {
		LetterContext _localctx = new LetterContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_letter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ALC - 66)) | (1L << (BLC - 66)) | (1L << (CLC - 66)) | (1L << (DLC - 66)) | (1L << (ELC - 66)) | (1L << (FLC - 66)) | (1L << (GLC - 66)) | (1L << (HLC - 66)) | (1L << (ILC - 66)) | (1L << (JLC - 66)) | (1L << (KLC - 66)) | (1L << (LLC - 66)) | (1L << (MLC - 66)) | (1L << (NLC - 66)) | (1L << (OLC - 66)) | (1L << (PLC - 66)) | (1L << (QLC - 66)) | (1L << (RLC - 66)) | (1L << (SLC - 66)) | (1L << (TLC - 66)) | (1L << (ULC - 66)) | (1L << (VLC - 66)) | (1L << (WLC - 66)) | (1L << (XLC - 66)) | (1L << (YLC - 66)) | (1L << (ZLC - 66)) | (1L << (AUC - 66)) | (1L << (BUC - 66)) | (1L << (CUC - 66)) | (1L << (DUC - 66)) | (1L << (EUC - 66)) | (1L << (FUC - 66)) | (1L << (GUC - 66)) | (1L << (HUC - 66)) | (1L << (IUC - 66)) | (1L << (JUC - 66)) | (1L << (KUC - 66)) | (1L << (LUC - 66)) | (1L << (MUC - 66)) | (1L << (NUC - 66)) | (1L << (OUC - 66)) | (1L << (PUC - 66)) | (1L << (QUC - 66)) | (1L << (RUC - 66)) | (1L << (SUC - 66)) | (1L << (TUC - 66)) | (1L << (UUC - 66)) | (1L << (VUC - 66)) | (1L << (WUC - 66)) | (1L << (XUC - 66)) | (1L << (YUC - 66)) | (1L << (ZUC - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0082\u03ae\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\6\2R\n\2\r\2\16"+
		"\2S\3\2\3\2\3\3\3\3\5\3Z\n\3\3\3\3\3\3\3\5\3_\n\3\3\3\5\3b\n\3\3\3\3\3"+
		"\3\4\6\4g\n\4\r\4\16\4h\3\5\3\5\3\5\7\5n\n\5\f\5\16\5q\13\5\3\6\7\6t\n"+
		"\6\f\6\16\6w\13\6\3\7\3\7\5\7{\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0095"+
		"\n\b\3\t\3\t\3\t\5\t\u009a\n\t\3\n\3\n\3\n\3\n\3\n\6\n\u00a1\n\n\r\n\16"+
		"\n\u00a2\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ab\n\n\f\n\16\n\u00ae\13\n\3\n"+
		"\3\n\3\n\3\n\6\n\u00b4\n\n\r\n\16\n\u00b5\3\n\3\n\3\n\3\n\3\n\3\n\6\n"+
		"\u00be\n\n\r\n\16\n\u00bf\3\n\3\n\3\n\3\n\3\n\7\n\u00c7\n\n\f\n\16\n\u00ca"+
		"\13\n\3\n\3\n\3\n\6\n\u00cf\n\n\r\n\16\n\u00d0\3\n\3\n\5\n\u00d5\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f9\n\13\3\f\3\f\3\f\5\f\u00fe\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0114\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u012f\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u016d\n\20\3\21\6\21"+
		"\u0170\n\21\r\21\16\21\u0171\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u0190\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u01e0\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u01ea\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u01f7\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0204\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0212\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0220\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u022d\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0239\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0247\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0258\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0269\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0275\n\25\3\25\3\25"+
		"\5\25\u0279\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u028a\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0293\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u02df\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u031e\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u032a\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0346\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u034f\n"+
		"\32\3\33\3\33\3\34\3\34\5\34\u0355\n\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0363\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u037f\n\36\3\37\3\37\3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \5 \u038c\n \3!\3!\3\"\6\"\u0391\n\"\r\"\16\"\u0392"+
		"\3#\3#\3$\3$\3%\3%\5%\u039b\n%\3%\3%\3%\7%\u03a0\n%\f%\16%\u03a3\13%\3"+
		"&\6&\u03a6\n&\r&\16&\u03a7\3\'\3\'\3(\3(\3(\2\2)\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\t\b\2LLPPVV[[gg"+
		"rr\5\2\t\t\23 &\'\4\2xz\u0081\u0081\4\2x~\u0081\u0081\3\2x\u0081\3\2:"+
		":\3\2Dw\2\u0433\2Q\3\2\2\2\4W\3\2\2\2\6f\3\2\2\2\bj\3\2\2\2\nu\3\2\2\2"+
		"\fx\3\2\2\2\16\u0094\3\2\2\2\20\u0099\3\2\2\2\22\u00d4\3\2\2\2\24\u00f8"+
		"\3\2\2\2\26\u00fd\3\2\2\2\30\u0113\3\2\2\2\32\u012e\3\2\2\2\34\u0130\3"+
		"\2\2\2\36\u016c\3\2\2\2 \u016f\3\2\2\2\"\u0173\3\2\2\2$\u018f\3\2\2\2"+
		"&\u01df\3\2\2\2(\u0278\3\2\2\2*\u02de\3\2\2\2,\u031d\3\2\2\2.\u0329\3"+
		"\2\2\2\60\u0345\3\2\2\2\62\u034e\3\2\2\2\64\u0350\3\2\2\2\66\u0354\3\2"+
		"\2\28\u0362\3\2\2\2:\u037e\3\2\2\2<\u0380\3\2\2\2>\u038b\3\2\2\2@\u038d"+
		"\3\2\2\2B\u0390\3\2\2\2D\u0394\3\2\2\2F\u0396\3\2\2\2H\u039a\3\2\2\2J"+
		"\u03a5\3\2\2\2L\u03a9\3\2\2\2N\u03ab\3\2\2\2PR\5\4\3\2QP\3\2\2\2RS\3\2"+
		"\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\2\2\3V\3\3\2\2\2WY\7\3\2\2XZ\7"+
		"$\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\5\b\5\2\\^\7\3\2\2]_\5\6\4\2^]"+
		"\3\2\2\2^_\3\2\2\2_a\3\2\2\2`b\7\4\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2c"+
		"d\7\5\2\2d\5\3\2\2\2eg\5H%\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i"+
		"\7\3\2\2\2jo\5\n\6\2kl\78\2\2ln\5\n\6\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2"+
		"op\3\2\2\2p\t\3\2\2\2qo\3\2\2\2rt\5\f\7\2sr\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2uv\3\2\2\2v\13\3\2\2\2wu\3\2\2\2xz\5\60\31\2y{\5\16\b\2zy\3\2\2\2z{"+
		"\3\2\2\2{\r\3\2\2\2|}\7(\2\2}\u0095\5\20\t\2~\177\7)\2\2\177\u0095\5\20"+
		"\t\2\u0080\u0081\7*\2\2\u0081\u0095\5\20\t\2\u0082\u0083\7+\2\2\u0083"+
		"\u0084\5<\37\2\u0084\u0085\7,\2\2\u0085\u0086\5\20\t\2\u0086\u0095\3\2"+
		"\2\2\u0087\u0088\7+\2\2\u0088\u0089\5<\37\2\u0089\u008a\7-\2\2\u008a\u008b"+
		"\7,\2\2\u008b\u008c\5\20\t\2\u008c\u0095\3\2\2\2\u008d\u008e\7+\2\2\u008e"+
		"\u008f\5<\37\2\u008f\u0090\7-\2\2\u0090\u0091\5<\37\2\u0091\u0092\7,\2"+
		"\2\u0092\u0093\5\20\t\2\u0093\u0095\3\2\2\2\u0094|\3\2\2\2\u0094~\3\2"+
		"\2\2\u0094\u0080\3\2\2\2\u0094\u0082\3\2\2\2\u0094\u0087\3\2\2\2\u0094"+
		"\u008d\3\2\2\2\u0095\17\3\2\2\2\u0096\u009a\7)\2\2\u0097\u009a\7(\2\2"+
		"\u0098\u009a\3\2\2\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098"+
		"\3\2\2\2\u009a\21\3\2\2\2\u009b\u009c\7\"\2\2\u009c\u009d\7$\2\2\u009d"+
		"\u009e\7#\2\2\u009e\u00a0\7%\2\2\u009f\u00a1\5\62\32\2\u00a0\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\7#\2\2\u00a5\u00d5\3\2\2\2\u00a6\u00a7\7\""+
		"\2\2\u00a7\u00a8\7$\2\2\u00a8\u00ac\7#\2\2\u00a9\u00ab\5\62\32\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00d5\7#\2\2\u00b0"+
		"\u00b1\7\"\2\2\u00b1\u00b3\7$\2\2\u00b2\u00b4\5\62\32\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00d5\3\2\2\2\u00b9\u00ba\7\""+
		"\2\2\u00ba\u00bb\7#\2\2\u00bb\u00bd\7%\2\2\u00bc\u00be\5\62\32\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2\u00d5\3\2\2\2\u00c3"+
		"\u00c4\7\"\2\2\u00c4\u00c8\7#\2\2\u00c5\u00c7\5\62\32\2\u00c6\u00c5\3"+
		"\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00d5\7#\2\2\u00cc\u00ce\7\""+
		"\2\2\u00cd\u00cf\5\62\32\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7#"+
		"\2\2\u00d3\u00d5\3\2\2\2\u00d4\u009b\3\2\2\2\u00d4\u00a6\3\2\2\2\u00d4"+
		"\u00b0\3\2\2\2\u00d4\u00b9\3\2\2\2\u00d4\u00c3\3\2\2\2\u00d4\u00cc\3\2"+
		"\2\2\u00d5\23\3\2\2\2\u00d6\u00f9\5\26\f\2\u00d7\u00d8\7\66\2\2\u00d8"+
		"\u00f9\5<\37\2\u00d9\u00da\7\66\2\2\u00da\u00db\7+\2\2\u00db\u00dc\5<"+
		"\37\2\u00dc\u00dd\7,\2\2\u00dd\u00f9\3\2\2\2\u00de\u00df\7\66\2\2\u00df"+
		"\u00e0\7+\2\2\u00e0\u00e1\7%\2\2\u00e1\u00e2\5<\37\2\u00e2\u00e3\7,\2"+
		"\2\u00e3\u00f9\3\2\2\2\u00e4\u00e5\7\67\2\2\u00e5\u00e6\7;\2\2\u00e6\u00e7"+
		"\5F$\2\u00e7\u00e8\7<\2\2\u00e8\u00f9\3\2\2\2\u00e9\u00ea\7\67\2\2\u00ea"+
		"\u00eb\7=\2\2\u00eb\u00ec\5F$\2\u00ec\u00ed\7=\2\2\u00ed\u00f9\3\2\2\2"+
		"\u00ee\u00ef\7\66\2\2\u00ef\u00f0\7+\2\2\u00f0\u00f1\5F$\2\u00f1\u00f2"+
		"\7,\2\2\u00f2\u00f9\3\2\2\2\u00f3\u00f4\7\67\2\2\u00f4\u00f5\7+\2\2\u00f5"+
		"\u00f6\5F$\2\u00f6\u00f7\7,\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00d6\3\2\2"+
		"\2\u00f8\u00d7\3\2\2\2\u00f8\u00d9\3\2\2\2\u00f8\u00de\3\2\2\2\u00f8\u00e4"+
		"\3\2\2\2\u00f8\u00e9\3\2\2\2\u00f8\u00ee\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f9"+
		"\25\3\2\2\2\u00fa\u00fe\5> \2\u00fb\u00fc\7\17\2\2\u00fc\u00fe\5D#\2\u00fd"+
		"\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\27\3\2\2\2\u00ff\u0100\79\2\2"+
		"\u0100\u0101\7(\2\2\u0101\u0102\7;\2\2\u0102\u0103\5F$\2\u0103\u0104\7"+
		"<\2\2\u0104\u0105\5\b\5\2\u0105\u0106\7:\2\2\u0106\u0114\3\2\2\2\u0107"+
		"\u0108\79\2\2\u0108\u0109\7(\2\2\u0109\u010a\7=\2\2\u010a\u010b\5F$\2"+
		"\u010b\u010c\7=\2\2\u010c\u010d\5\b\5\2\u010d\u010e\7:\2\2\u010e\u0114"+
		"\3\2\2\2\u010f\u0110\79\2\2\u0110\u0111\5\b\5\2\u0111\u0112\7:\2\2\u0112"+
		"\u0114\3\2\2\2\u0113\u00ff\3\2\2\2\u0113\u0107\3\2\2\2\u0113\u010f\3\2"+
		"\2\2\u0114\31\3\2\2\2\u0115\u0116\79\2\2\u0116\u0117\7(\2\2\u0117\u0118"+
		"\7?\2\2\u0118\u0119\5\b\5\2\u0119\u011a\7:\2\2\u011a\u012f\3\2\2\2\u011b"+
		"\u011c\79\2\2\u011c\u011d\7(\2\2\u011d\u011e\78\2\2\u011e\u011f\5\b\5"+
		"\2\u011f\u0120\7:\2\2\u0120\u012f\3\2\2\2\u0121\u0122\79\2\2\u0122\u0123"+
		"\7(\2\2\u0123\u0124\7<\2\2\u0124\u0125\5\b\5\2\u0125\u0126\7:\2\2\u0126"+
		"\u012f\3\2\2\2\u0127\u0128\79\2\2\u0128\u0129\7(\2\2\u0129\u012a\5 \21"+
		"\2\u012a\u012b\7?\2\2\u012b\u012c\5\b\5\2\u012c\u012d\7:\2\2\u012d\u012f"+
		"\3\2\2\2\u012e\u0115\3\2\2\2\u012e\u011b\3\2\2\2\u012e\u0121\3\2\2\2\u012e"+
		"\u0127\3\2\2\2\u012f\33\3\2\2\2\u0130\u0131\79\2\2\u0131\u0132\7(\2\2"+
		"\u0132\u0133\7@\2\2\u0133\u0134\5J&\2\u0134\u0135\7:\2\2\u0135\35\3\2"+
		"\2\2\u0136\u0137\79\2\2\u0137\u0138\7(\2\2\u0138\u0139\5 \21\2\u0139\u013a"+
		"\7%\2\2\u013a\u013b\5 \21\2\u013b\u013c\7:\2\2\u013c\u016d\3\2\2\2\u013d"+
		"\u013e\79\2\2\u013e\u013f\7(\2\2\u013f\u0140\5 \21\2\u0140\u0141\7:\2"+
		"\2\u0141\u016d\3\2\2\2\u0142\u0143\79\2\2\u0143\u0144\7(\2\2\u0144\u0145"+
		"\7%\2\2\u0145\u0146\5 \21\2\u0146\u0147\7:\2\2\u0147\u016d\3\2\2\2\u0148"+
		"\u0149\79\2\2\u0149\u014a\7*\2\2\u014a\u014b\7k\2\2\u014b\u014c\7l\2\2"+
		"\u014c\u014d\7>\2\2\u014d\u014e\7p\2\2\u014e\u014f\7q\2\2\u014f\u0150"+
		"\7^\2\2\u0150\u0151\7o\2\2\u0151\u0152\7q\2\2\u0152\u0153\7>\2\2\u0153"+
		"\u0154\7l\2\2\u0154\u0155\7m\2\2\u0155\u0156\7q\2\2\u0156\u016d\7:\2\2"+
		"\u0157\u0158\79\2\2\u0158\u0159\7*\2\2\u0159\u015a\7r\2\2\u015a\u015b"+
		"\7q\2\2\u015b\u015c\7c\2\2\u015c\u015d\7\177\2\2\u015d\u016d\7:\2\2\u015e"+
		"\u015f\79\2\2\u015f\u0160\7*\2\2\u0160\u0161\7r\2\2\u0161\u0162\7q\2\2"+
		"\u0162\u0163\7c\2\2\u0163\u0164\7x\2\2\u0164\u0165\7}\2\2\u0165\u016d"+
		"\7:\2\2\u0166\u0167\79\2\2\u0167\u0168\7*\2\2\u0168\u0169\7r\2\2\u0169"+
		"\u016a\7`\2\2\u016a\u016b\7m\2\2\u016b\u016d\7:\2\2\u016c\u0136\3\2\2"+
		"\2\u016c\u013d\3\2\2\2\u016c\u0142\3\2\2\2\u016c\u0148\3\2\2\2\u016c\u0157"+
		"\3\2\2\2\u016c\u015e\3\2\2\2\u016c\u0166\3\2\2\2\u016d\37\3\2\2\2\u016e"+
		"\u0170\5\"\22\2\u016f\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3"+
		"\2\2\2\u0171\u0172\3\2\2\2\u0172!\3\2\2\2\u0173\u0174\t\2\2\2\u0174#\3"+
		"\2\2\2\u0175\u0176\79\2\2\u0176\u0177\7(\2\2\u0177\u0178\7A\2\2\u0178"+
		"\u0179\5\b\5\2\u0179\u017a\7:\2\2\u017a\u0190\3\2\2\2\u017b\u017c\79\2"+
		"\2\u017c\u017d\7(\2\2\u017d\u017e\7B\2\2\u017e\u017f\5\b\5\2\u017f\u0180"+
		"\7:\2\2\u0180\u0190\3\2\2\2\u0181\u0182\79\2\2\u0182\u0183\7(\2\2\u0183"+
		"\u0184\7;\2\2\u0184\u0185\7A\2\2\u0185\u0186\5\b\5\2\u0186\u0187\7:\2"+
		"\2\u0187\u0190\3\2\2\2\u0188\u0189\79\2\2\u0189\u018a\7(\2\2\u018a\u018b"+
		"\7;\2\2\u018b\u018c\7B\2\2\u018c\u018d\5\b\5\2\u018d\u018e\7:\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u0175\3\2\2\2\u018f\u017b\3\2\2\2\u018f\u0181\3\2"+
		"\2\2\u018f\u0188\3\2\2\2\u0190%\3\2\2\2\u0191\u0192\79\2\2\u0192\u0193"+
		"\7(\2\2\u0193\u0194\7o\2\2\u0194\u01e0\7:\2\2\u0195\u0196\79\2\2\u0196"+
		"\u0197\7(\2\2\u0197\u0198\5<\37\2\u0198\u0199\7:\2\2\u0199\u01e0\3\2\2"+
		"\2\u019a\u019b\79\2\2\u019b\u019c\7(\2\2\u019c\u019d\7)\2\2\u019d\u019e"+
		"\5<\37\2\u019e\u019f\7:\2\2\u019f\u01e0\3\2\2\2\u01a0\u01a1\79\2\2\u01a1"+
		"\u01a2\7(\2\2\u01a2\u01a3\7%\2\2\u01a3\u01a4\5<\37\2\u01a4\u01a5\7:\2"+
		"\2\u01a5\u01e0\3\2\2\2\u01a6\u01a7\79\2\2\u01a7\u01a8\7(\2\2\u01a8\u01a9"+
		"\7C\2\2\u01a9\u01aa\5F$\2\u01aa\u01ab\7:\2\2\u01ab\u01e0\3\2\2\2\u01ac"+
		"\u01ad\79\2\2\u01ad\u01ae\7(\2\2\u01ae\u01af\7m\2\2\u01af\u01b0\7<\2\2"+
		"\u01b0\u01b1\5F$\2\u01b1\u01b2\7:\2\2\u01b2\u01e0\3\2\2\2\u01b3\u01b4"+
		"\7\66\2\2\u01b4\u01b5\7;\2\2\u01b5\u01b6\5F$\2\u01b6\u01b7\7<\2\2\u01b7"+
		"\u01e0\3\2\2\2\u01b8\u01b9\7\66\2\2\u01b9\u01ba\7=\2\2\u01ba\u01bb\5F"+
		"$\2\u01bb\u01bc\7=\2\2\u01bc\u01e0\3\2\2\2\u01bd\u01be\7\66\2\2\u01be"+
		"\u01bf\7;\2\2\u01bf\u01c0\5<\37\2\u01c0\u01c1\7<\2\2\u01c1\u01e0\3\2\2"+
		"\2\u01c2\u01c3\7\66\2\2\u01c3\u01c4\7=\2\2\u01c4\u01c5\5<\37\2\u01c5\u01c6"+
		"\7=\2\2\u01c6\u01e0\3\2\2\2\u01c7\u01c8\7\66\2\2\u01c8\u01c9\7;\2\2\u01c9"+
		"\u01ca\7)\2\2\u01ca\u01cb\5<\37\2\u01cb\u01cc\7<\2\2\u01cc\u01e0\3\2\2"+
		"\2\u01cd\u01ce\7\66\2\2\u01ce\u01cf\7=\2\2\u01cf\u01d0\7)\2\2\u01d0\u01d1"+
		"\5<\37\2\u01d1\u01d2\7=\2\2\u01d2\u01e0\3\2\2\2\u01d3\u01d4\7\66\2\2\u01d4"+
		"\u01d5\7;\2\2\u01d5\u01d6\7%\2\2\u01d6\u01d7\5<\37\2\u01d7\u01d8\7<\2"+
		"\2\u01d8\u01e0\3\2\2\2\u01d9\u01da\7\66\2\2\u01da\u01db\7=\2\2\u01db\u01dc"+
		"\7%\2\2\u01dc\u01dd\5<\37\2\u01dd\u01de\7=\2\2\u01de\u01e0\3\2\2\2\u01df"+
		"\u0191\3\2\2\2\u01df\u0195\3\2\2\2\u01df\u019a\3\2\2\2\u01df\u01a0\3\2"+
		"\2\2\u01df\u01a6\3\2\2\2\u01df\u01ac\3\2\2\2\u01df\u01b3\3\2\2\2\u01df"+
		"\u01b8\3\2\2\2\u01df\u01bd\3\2\2\2\u01df\u01c2\3\2\2\2\u01df\u01c7\3\2"+
		"\2\2\u01df\u01cd\3\2\2\2\u01df\u01d3\3\2\2\2\u01df\u01d9\3\2\2\2\u01e0"+
		"\'\3\2\2\2\u01e1\u01e2\79\2\2\u01e2\u01e3\7(\2\2\u01e3\u01e4\79\2\2\u01e4"+
		"\u01e5\5<\37\2\u01e5\u01e6\7:\2\2\u01e6\u01e9\5\b\5\2\u01e7\u01e8\78\2"+
		"\2\u01e8\u01ea\5\b\5\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb"+
		"\3\2\2\2\u01eb\u01ec\7:\2\2\u01ec\u0279\3\2\2\2\u01ed\u01ee\79\2\2\u01ee"+
		"\u01ef\7(\2\2\u01ef\u01f0\79\2\2\u01f0\u01f1\7)\2\2\u01f1\u01f2\5<\37"+
		"\2\u01f2\u01f3\7:\2\2\u01f3\u01f6\5\b\5\2\u01f4\u01f5\78\2\2\u01f5\u01f7"+
		"\5\b\5\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01f9\7:\2\2\u01f9\u0279\3\2\2\2\u01fa\u01fb\79\2\2\u01fb\u01fc\7(\2"+
		"\2\u01fc\u01fd\79\2\2\u01fd\u01fe\7%\2\2\u01fe\u01ff\5<\37\2\u01ff\u0200"+
		"\7:\2\2\u0200\u0203\5\b\5\2\u0201\u0202\78\2\2\u0202\u0204\5\b\5\2\u0203"+
		"\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206\7:"+
		"\2\2\u0206\u0279\3\2\2\2\u0207\u0208\79\2\2\u0208\u0209\7(\2\2\u0209\u020a"+
		"\79\2\2\u020a\u020b\7;\2\2\u020b\u020c\5F$\2\u020c\u020d\7<\2\2\u020d"+
		"\u020e\7:\2\2\u020e\u0211\5\b\5\2\u020f\u0210\78\2\2\u0210\u0212\5\b\5"+
		"\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214"+
		"\7:\2\2\u0214\u0279\3\2\2\2\u0215\u0216\79\2\2\u0216\u0217\7(\2\2\u0217"+
		"\u0218\79\2\2\u0218\u0219\7=\2\2\u0219\u021a\5F$\2\u021a\u021b\7=\2\2"+
		"\u021b\u021c\7:\2\2\u021c\u021f\5\b\5\2\u021d\u021e\78\2\2\u021e\u0220"+
		"\5\b\5\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\3\2\2\2\u0221"+
		"\u0222\7:\2\2\u0222\u0279\3\2\2\2\u0223\u0224\79\2\2\u0224\u0225\7(\2"+
		"\2\u0225\u0226\79\2\2\u0226\u0227\7o\2\2\u0227\u0228\5<\37\2\u0228\u0229"+
		"\7:\2\2\u0229\u022c\5\b\5\2\u022a\u022b\78\2\2\u022b\u022d\5\b\5\2\u022c"+
		"\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\7:"+
		"\2\2\u022f\u0279\3\2\2\2\u0230\u0231\79\2\2\u0231\u0232\7(\2\2\u0232\u0233"+
		"\79\2\2\u0233\u0234\7o\2\2\u0234\u0235\7:\2\2\u0235\u0238\5\b\5\2\u0236"+
		"\u0237\78\2\2\u0237\u0239\5\b\5\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2"+
		"\2\2\u0239\u023a\3\2\2\2\u023a\u023b\7:\2\2\u023b\u0279\3\2\2\2\u023c"+
		"\u023d\79\2\2\u023d\u023e\7(\2\2\u023e\u023f\79\2\2\u023f\u0240\7o\2\2"+
		"\u0240\u0241\7C\2\2\u0241\u0242\5F$\2\u0242\u0243\7:\2\2\u0243\u0246\5"+
		"\b\5\2\u0244\u0245\78\2\2\u0245\u0247\5\b\5\2\u0246\u0244\3\2\2\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\7:\2\2\u0249\u0279\3\2"+
		"\2\2\u024a\u024b\79\2\2\u024b\u024c\7(\2\2\u024c\u024d\79\2\2\u024d\u024e"+
		"\7a\2\2\u024e\u024f\7b\2\2\u024f\u0250\7c\2\2\u0250\u0251\7f\2\2\u0251"+
		"\u0252\7k\2\2\u0252\u0253\7b\2\2\u0253\u0254\7:\2\2\u0254\u0257\5\b\5"+
		"\2\u0255\u0256\78\2\2\u0256\u0258\5\b\5\2\u0257\u0255\3\2\2\2\u0257\u0258"+
		"\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\7:\2\2\u025a\u0279\3\2\2\2\u025b"+
		"\u025c\79\2\2\u025c\u025d\7(\2\2\u025d\u025e\79\2\2\u025e\u025f\7D\2\2"+
		"\u025f\u0260\7V\2\2\u0260\u0261\7V\2\2\u0261\u0262\7H\2\2\u0262\u0263"+
		"\7U\2\2\u0263\u0264\7W\2\2\u0264\u0265\7:\2\2\u0265\u0268\5\b\5\2\u0266"+
		"\u0267\78\2\2\u0267\u0269\5\b\5\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2"+
		"\2\2\u0269\u026a\3\2\2\2\u026a\u026b\7:\2\2\u026b\u0279\3\2\2\2\u026c"+
		"\u026d\79\2\2\u026d\u026e\7(\2\2\u026e\u026f\79\2\2\u026f\u0270\5F$\2"+
		"\u0270\u0271\7:\2\2\u0271\u0274\5\b\5\2\u0272\u0273\78\2\2\u0273\u0275"+
		"\5\b\5\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0276\3\2\2\2\u0276"+
		"\u0277\7:\2\2\u0277\u0279\3\2\2\2\u0278\u01e1\3\2\2\2\u0278\u01ed\3\2"+
		"\2\2\u0278\u01fa\3\2\2\2\u0278\u0207\3\2\2\2\u0278\u0215\3\2\2\2\u0278"+
		"\u0223\3\2\2\2\u0278\u0230\3\2\2\2\u0278\u023c\3\2\2\2\u0278\u024a\3\2"+
		"\2\2\u0278\u025b\3\2\2\2\u0278\u026c\3\2\2\2\u0279)\3\2\2\2\u027a\u027b"+
		"\79\2\2\u027b\u027c\7*\2\2\u027c\u027d\7^\2\2\u027d\u027e\7`\2\2\u027e"+
		"\u027f\7`\2\2\u027f\u0280\7b\2\2\u0280\u0281\7m\2\2\u0281\u0282\7q\2\2"+
		"\u0282\u02df\7:\2\2\u0283\u0284\79\2\2\u0284\u0285\7*\2\2\u0285\u0289"+
		"\7c\2\2\u0286\u0287\7^\2\2\u0287\u0288\7f\2\2\u0288\u028a\7i\2\2\u0289"+
		"\u0286\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u02df\7:"+
		"\2\2\u028c\u028d\79\2\2\u028d\u0292\7*\2\2\u028e\u028f\7j\2\2\u028f\u0290"+
		"\7^\2\2\u0290\u0291\7o\2\2\u0291\u0293\7h\2\2\u0292\u028e\3\2\2\2\u0292"+
		"\u0293\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0295\7?\2\2\u0295\u0296\7k\2"+
		"\2\u0296\u0297\7^\2\2\u0297\u0298\7j\2\2\u0298\u0299\7b\2\2\u0299\u02df"+
		"\7:\2\2\u029a\u029b\79\2\2\u029b\u029c\7*\2\2\u029c\u029d\7`\2\2\u029d"+
		"\u029e\7l\2\2\u029e\u029f\7j\2\2\u029f\u02a0\7j\2\2\u02a0\u02a1\7f\2\2"+
		"\u02a1\u02a2\7q\2\2\u02a2\u02df\7:\2\2\u02a3\u02a4\79\2\2\u02a4\u02a5"+
		"\7*\2\2\u02a5\u02a6\7m\2\2\u02a6\u02a7\7o\2\2\u02a7\u02a8\7r\2\2\u02a8"+
		"\u02a9\7k\2\2\u02a9\u02aa\7b\2\2\u02aa\u02df\7:\2\2\u02ab\u02ac\79\2\2"+
		"\u02ac\u02ad\7*\2\2\u02ad\u02ae\7m\2\2\u02ae\u02af\7o\2\2\u02af\u02b0"+
		"\7r\2\2\u02b0\u02b1\7k\2\2\u02b1\u02b2\7b\2\2\u02b2\u02b3\7?\2\2\u02b3"+
		"\u02b4\7k\2\2\u02b4\u02b5\7^\2\2\u02b5\u02b6\7j\2\2\u02b6\u02b7\7b\2\2"+
		"\u02b7\u02df\7:\2\2\u02b8\u02b9\79\2\2\u02b9\u02ba\7*\2\2\u02ba\u02bb"+
		"\7p\2\2\u02bb\u02bc\7h\2\2\u02bc\u02bd\7f\2\2\u02bd\u02be\7m\2\2\u02be"+
		"\u02df\7:\2\2\u02bf\u02c0\79\2\2\u02c0\u02c1\7*\2\2\u02c1\u02c2\7p\2\2"+
		"\u02c2\u02c3\7h\2\2\u02c3\u02c4\7f\2\2\u02c4\u02c5\7m\2\2\u02c5\u02c6"+
		"\7?\2\2\u02c6\u02c7\7k\2\2\u02c7\u02c8\7^\2\2\u02c8\u02c9\7j\2\2\u02c9"+
		"\u02ca\7b\2\2\u02ca\u02df\7:\2\2\u02cb\u02cc\79\2\2\u02cc\u02cd\7*\2\2"+
		"\u02cd\u02ce\7q\2\2\u02ce\u02cf\7e\2\2\u02cf\u02d0\7b\2\2\u02d0\u02d1"+
		"\7k\2\2\u02d1\u02df\7:\2\2\u02d2\u02d3\79\2\2\u02d3\u02d4\7*\2\2\u02d4"+
		"\u02d5\7q\2\2\u02d5\u02d6\7e\2\2\u02d6\u02d7\7b\2\2\u02d7\u02d8\7k\2\2"+
		"\u02d8\u02d9\7?\2\2\u02d9\u02da\7k\2\2\u02da\u02db\7^\2\2\u02db\u02dc"+
		"\7j\2\2\u02dc\u02dd\7b\2\2\u02dd\u02df\7:\2\2\u02de\u027a\3\2\2\2\u02de"+
		"\u0283\3\2\2\2\u02de\u028c\3\2\2\2\u02de\u029a\3\2\2\2\u02de\u02a3\3\2"+
		"\2\2\u02de\u02ab\3\2\2\2\u02de\u02b8\3\2\2\2\u02de\u02bf\3\2\2\2\u02de"+
		"\u02cb\3\2\2\2\u02de\u02d2\3\2\2\2\u02df+\3\2\2\2\u02e0\u02e1\79\2\2\u02e1"+
		"\u02e2\7*\2\2\u02e2\u02e3\7`\2\2\u02e3\u02e4\7o\2\2\u02e4\u031e\7:\2\2"+
		"\u02e5\u02e6\79\2\2\u02e6\u02e7\7*\2\2\u02e7\u02e8\7i\2\2\u02e8\u02e9"+
		"\7c\2\2\u02e9\u031e\7:\2\2\u02ea\u02eb\79\2\2\u02eb\u02ec\7*\2\2\u02ec"+
		"\u02ed\7`\2\2\u02ed\u02ee\7o\2\2\u02ee\u02ef\7i\2\2\u02ef\u02f0\7c\2\2"+
		"\u02f0\u031e\7:\2\2\u02f1\u02f2\79\2\2\u02f2\u02f3\7*\2\2\u02f3\u02f4"+
		"\7^\2\2\u02f4\u02f5\7k\2\2\u02f5\u02f6\7v\2\2\u02f6\u02f7\7`\2\2\u02f7"+
		"\u02f8\7o\2\2\u02f8\u02f9\7i\2\2\u02f9\u02fa\7c\2\2\u02fa\u031e\7:\2\2"+
		"\u02fb\u02fc\79\2\2\u02fc\u02fd\7*\2\2\u02fd\u02fe\7^\2\2\u02fe\u02ff"+
		"\7k\2\2\u02ff\u0300\7v\2\2\u0300\u031e\7:\2\2\u0301\u0302\79\2\2\u0302"+
		"\u0303\7*\2\2\u0303\u0304\7_\2\2\u0304\u0305\7p\2\2\u0305\u0306\7o\2\2"+
		"\u0306\u0307\7>\2\2\u0307\u0308\7^\2\2\u0308\u0309\7k\2\2\u0309\u030a"+
		"\7v\2\2\u030a\u030b\7`\2\2\u030b\u030c\7o\2\2\u030c\u030d\7i\2\2\u030d"+
		"\u030e\7c\2\2\u030e\u031e\7:\2\2\u030f\u0310\79\2\2\u0310\u0311\7*\2\2"+
		"\u0311\u0312\7_\2\2\u0312\u0313\7p\2\2\u0313\u0314\7o\2\2\u0314\u0315"+
		"\7>\2\2\u0315\u0316\7r\2\2\u0316\u0317\7k\2\2\u0317\u0318\7f\2\2\u0318"+
		"\u0319\7`\2\2\u0319\u031a\7l\2\2\u031a\u031b\7a\2\2\u031b\u031c\7b\2\2"+
		"\u031c\u031e\7:\2\2\u031d\u02e0\3\2\2\2\u031d\u02e5\3\2\2\2\u031d\u02ea"+
		"\3\2\2\2\u031d\u02f1\3\2\2\2\u031d\u02fb\3\2\2\2\u031d\u0301\3\2\2\2\u031d"+
		"\u030f\3\2\2\2\u031e-\3\2\2\2\u031f\u0320\79\2\2\u0320\u0321\7(\2\2\u0321"+
		"\u0322\7`\2\2\u0322\u032a\7:\2\2\u0323\u0324\79\2\2\u0324\u0325\7(\2\2"+
		"\u0325\u0326\7`\2\2\u0326\u0327\5<\37\2\u0327\u0328\7:\2\2\u0328\u032a"+
		"\3\2\2\2\u0329\u031f\3\2\2\2\u0329\u0323\3\2\2\2\u032a/\3\2\2\2\u032b"+
		"\u0346\5&\24\2\u032c\u0346\5\64\33\2\u032d\u0346\5\66\34\2\u032e\u0346"+
		"\5\22\n\2\u032f\u0346\5\30\r\2\u0330\u0346\5\32\16\2\u0331\u0346\5\34"+
		"\17\2\u0332\u0346\5\36\20\2\u0333\u0346\5$\23\2\u0334\u0346\5\24\13\2"+
		"\u0335\u0346\5(\25\2\u0336\u0346\5*\26\2\u0337\u0346\5,\27\2\u0338\u0346"+
		"\5.\30\2\u0339\u0346\7\21\2\2\u033a\u0346\7$\2\2\u033b\u0346\7\60\2\2"+
		"\u033c\u0346\7.\2\2\u033d\u0346\7/\2\2\u033e\u0346\7\61\2\2\u033f\u0346"+
		"\7\62\2\2\u0340\u0346\7\63\2\2\u0341\u0346\7\64\2\2\u0342\u0346\7\65\2"+
		"\2\u0343\u0346\7\22\2\2\u0344\u0346\7!\2\2\u0345\u032b\3\2\2\2\u0345\u032c"+
		"\3\2\2\2\u0345\u032d\3\2\2\2\u0345\u032e\3\2\2\2\u0345\u032f\3\2\2\2\u0345"+
		"\u0330\3\2\2\2\u0345\u0331\3\2\2\2\u0345\u0332\3\2\2\2\u0345\u0333\3\2"+
		"\2\2\u0345\u0334\3\2\2\2\u0345\u0335\3\2\2\2\u0345\u0336\3\2\2\2\u0345"+
		"\u0337\3\2\2\2\u0345\u0338\3\2\2\2\u0345\u0339\3\2\2\2\u0345\u033a\3\2"+
		"\2\2\u0345\u033b\3\2\2\2\u0345\u033c\3\2\2\2\u0345\u033d\3\2\2\2\u0345"+
		"\u033e\3\2\2\2\u0345\u033f\3\2\2\2\u0345\u0340\3\2\2\2\u0345\u0341\3\2"+
		"\2\2\u0345\u0342\3\2\2\2\u0345\u0343\3\2\2\2\u0345\u0344\3\2\2\2\u0346"+
		"\61\3\2\2\2\u0347\u0348\58\35\2\u0348\u0349\7%\2\2\u0349\u034a\58\35\2"+
		"\u034a\u034f\3\2\2\2\u034b\u034f\5\64\33\2\u034c\u034f\58\35\2\u034d\u034f"+
		"\5\26\f\2\u034e\u0347\3\2\2\2\u034e\u034b\3\2\2\2\u034e\u034c\3\2\2\2"+
		"\u034e\u034d\3\2\2\2\u034f\63\3\2\2\2\u0350\u0351\t\3\2\2\u0351\65\3\2"+
		"\2\2\u0352\u0355\5:\36\2\u0353\u0355\7#\2\2\u0354\u0352\3\2\2\2\u0354"+
		"\u0353\3\2\2\2\u0355\67\3\2\2\2\u0356\u0363\5:\36\2\u0357\u0363\7\21\2"+
		"\2\u0358\u0363\7\"\2\2\u0359\u0363\7$\2\2\u035a\u0363\7(\2\2\u035b\u0363"+
		"\7)\2\2\u035c\u0363\7*\2\2\u035d\u0363\7.\2\2\u035e\u0363\7\61\2\2\u035f"+
		"\u0363\78\2\2\u0360\u0363\79\2\2\u0361\u0363\7:\2\2\u0362\u0356\3\2\2"+
		"\2\u0362\u0357\3\2\2\2\u0362\u0358\3\2\2\2\u0362\u0359\3\2\2\2\u0362\u035a"+
		"\3\2\2\2\u0362\u035b\3\2\2\2\u0362\u035c\3\2\2\2\u0362\u035d\3\2\2\2\u0362"+
		"\u035e\3\2\2\2\u0362\u035f\3\2\2\2\u0362\u0360\3\2\2\2\u0362\u0361\3\2"+
		"\2\2\u03639\3\2\2\2\u0364\u037f\5> \2\u0365\u037f\5N(\2\u0366\u037f\5"+
		"D#\2\u0367\u037f\7\b\2\2\u0368\u037f\7\n\2\2\u0369\u037f\7\13\2\2\u036a"+
		"\u037f\7\f\2\2\u036b\u037f\7\r\2\2\u036c\u037f\7\16\2\2\u036d\u037f\7"+
		"\20\2\2\u036e\u037f\7\6\2\2\u036f\u037f\7\7\2\2\u0370\u037f\7+\2\2\u0371"+
		"\u037f\7,\2\2\u0372\u037f\7-\2\2\u0373\u037f\7%\2\2\u0374\u037f\7;\2\2"+
		"\u0375\u037f\7<\2\2\u0376\u037f\7=\2\2\u0377\u037f\7>\2\2\u0378\u037f"+
		"\7?\2\2\u0379\u037f\7@\2\2\u037a\u037f\7A\2\2\u037b\u037f\7B\2\2\u037c"+
		"\u037f\7C\2\2\u037d\u037f\7\u0082\2\2\u037e\u0364\3\2\2\2\u037e\u0365"+
		"\3\2\2\2\u037e\u0366\3\2\2\2\u037e\u0367\3\2\2\2\u037e\u0368\3\2\2\2\u037e"+
		"\u0369\3\2\2\2\u037e\u036a\3\2\2\2\u037e\u036b\3\2\2\2\u037e\u036c\3\2"+
		"\2\2\u037e\u036d\3\2\2\2\u037e\u036e\3\2\2\2\u037e\u036f\3\2\2\2\u037e"+
		"\u0370\3\2\2\2\u037e\u0371\3\2\2\2\u037e\u0372\3\2\2\2\u037e\u0373\3\2"+
		"\2\2\u037e\u0374\3\2\2\2\u037e\u0375\3\2\2\2\u037e\u0376\3\2\2\2\u037e"+
		"\u0377\3\2\2\2\u037e\u0378\3\2\2\2\u037e\u0379\3\2\2\2\u037e\u037a\3\2"+
		"\2\2\u037e\u037b\3\2\2\2\u037e\u037c\3\2\2\2\u037e\u037d\3\2\2\2\u037f"+
		";\3\2\2\2\u0380\u0381\5B\"\2\u0381=\3\2\2\2\u0382\u0383\7\17\2\2\u0383"+
		"\u0384\t\4\2\2\u0384\u0385\5@!\2\u0385\u0386\5@!\2\u0386\u038c\3\2\2\2"+
		"\u0387\u0388\7\17\2\2\u0388\u0389\5@!\2\u0389\u038a\5@!\2\u038a\u038c"+
		"\3\2\2\2\u038b\u0382\3\2\2\2\u038b\u0387\3\2\2\2\u038c?\3\2\2\2\u038d"+
		"\u038e\t\5\2\2\u038eA\3\2\2\2\u038f\u0391\5D#\2\u0390\u038f\3\2\2\2\u0391"+
		"\u0392\3\2\2\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2\2\2\u0393C\3\2\2\2"+
		"\u0394\u0395\t\6\2\2\u0395E\3\2\2\2\u0396\u0397\5H%\2\u0397G\3\2\2\2\u0398"+
		"\u039b\5N(\2\u0399\u039b\7>\2\2\u039a\u0398\3\2\2\2\u039a\u0399\3\2\2"+
		"\2\u039b\u03a1\3\2\2\2\u039c\u03a0\5N(\2\u039d\u03a0\7>\2\2\u039e\u03a0"+
		"\5D#\2\u039f\u039c\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u039e\3\2\2\2\u03a0"+
		"\u03a3\3\2\2\2\u03a1\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2I\3\2\2\2"+
		"\u03a3\u03a1\3\2\2\2\u03a4\u03a6\5L\'\2\u03a5\u03a4\3\2\2\2\u03a6\u03a7"+
		"\3\2\2\2\u03a7\u03a5\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8K\3\2\2\2\u03a9"+
		"\u03aa\n\7\2\2\u03aaM\3\2\2\2\u03ab\u03ac\t\b\2\2\u03acO\3\2\2\2\67SY"+
		"^ahouz\u0094\u0099\u00a2\u00ac\u00b5\u00bf\u00c8\u00d0\u00d4\u00f8\u00fd"+
		"\u0113\u012e\u016c\u0171\u018f\u01df\u01e9\u01f6\u0203\u0211\u021f\u022c"+
		"\u0238\u0246\u0257\u0268\u0274\u0278\u0289\u0292\u02de\u031d\u0329\u0345"+
		"\u034e\u0354\u0362\u037e\u038b\u0392\u039a\u039f\u03a1\u03a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}