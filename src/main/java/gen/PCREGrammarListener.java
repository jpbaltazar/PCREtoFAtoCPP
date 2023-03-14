package gen;// Generated from C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/main/resources\PCREGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PCREGrammarParser}.
 */
public interface PCREGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(PCREGrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(PCREGrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#singleRule}.
	 * @param ctx the parse tree
	 */
	void enterSingleRule(PCREGrammarParser.SingleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#singleRule}.
	 * @param ctx the parse tree
	 */
	void exitSingleRule(PCREGrammarParser.SingleRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#directives}.
	 * @param ctx the parse tree
	 */
	void enterDirectives(PCREGrammarParser.DirectivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#directives}.
	 * @param ctx the parse tree
	 */
	void exitDirectives(PCREGrammarParser.DirectivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#alternation}.
	 * @param ctx the parse tree
	 */
	void enterAlternation(PCREGrammarParser.AlternationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#alternation}.
	 * @param ctx the parse tree
	 */
	void exitAlternation(PCREGrammarParser.AlternationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PCREGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PCREGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(PCREGrammarParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(PCREGrammarParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(PCREGrammarParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(PCREGrammarParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#quantifier_type}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier_type(PCREGrammarParser.Quantifier_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#quantifier_type}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier_type(PCREGrammarParser.Quantifier_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#character_class}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_class(PCREGrammarParser.Character_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#character_class}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_class(PCREGrammarParser.Character_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#backreference}.
	 * @param ctx the parse tree
	 */
	void enterBackreference(PCREGrammarParser.BackreferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#backreference}.
	 * @param ctx the parse tree
	 */
	void exitBackreference(PCREGrammarParser.BackreferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#backreference_or_octal}.
	 * @param ctx the parse tree
	 */
	void enterBackreference_or_octal(PCREGrammarParser.Backreference_or_octalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#backreference_or_octal}.
	 * @param ctx the parse tree
	 */
	void exitBackreference_or_octal(PCREGrammarParser.Backreference_or_octalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#capture}.
	 * @param ctx the parse tree
	 */
	void enterCapture(PCREGrammarParser.CaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#capture}.
	 * @param ctx the parse tree
	 */
	void exitCapture(PCREGrammarParser.CaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#non_capture}.
	 * @param ctx the parse tree
	 */
	void enterNon_capture(PCREGrammarParser.Non_captureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#non_capture}.
	 * @param ctx the parse tree
	 */
	void exitNon_capture(PCREGrammarParser.Non_captureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(PCREGrammarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(PCREGrammarParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(PCREGrammarParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(PCREGrammarParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#option_flags}.
	 * @param ctx the parse tree
	 */
	void enterOption_flags(PCREGrammarParser.Option_flagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#option_flags}.
	 * @param ctx the parse tree
	 */
	void exitOption_flags(PCREGrammarParser.Option_flagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#option_flag}.
	 * @param ctx the parse tree
	 */
	void enterOption_flag(PCREGrammarParser.Option_flagContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#option_flag}.
	 * @param ctx the parse tree
	 */
	void exitOption_flag(PCREGrammarParser.Option_flagContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#look_around}.
	 * @param ctx the parse tree
	 */
	void enterLook_around(PCREGrammarParser.Look_aroundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#look_around}.
	 * @param ctx the parse tree
	 */
	void exitLook_around(PCREGrammarParser.Look_aroundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#subroutine_reference}.
	 * @param ctx the parse tree
	 */
	void enterSubroutine_reference(PCREGrammarParser.Subroutine_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#subroutine_reference}.
	 * @param ctx the parse tree
	 */
	void exitSubroutine_reference(PCREGrammarParser.Subroutine_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(PCREGrammarParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(PCREGrammarParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#backtrack_control}.
	 * @param ctx the parse tree
	 */
	void enterBacktrack_control(PCREGrammarParser.Backtrack_controlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#backtrack_control}.
	 * @param ctx the parse tree
	 */
	void exitBacktrack_control(PCREGrammarParser.Backtrack_controlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#newline_convention}.
	 * @param ctx the parse tree
	 */
	void enterNewline_convention(PCREGrammarParser.Newline_conventionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#newline_convention}.
	 * @param ctx the parse tree
	 */
	void exitNewline_convention(PCREGrammarParser.Newline_conventionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#callout}.
	 * @param ctx the parse tree
	 */
	void enterCallout(PCREGrammarParser.CalloutContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#callout}.
	 * @param ctx the parse tree
	 */
	void exitCallout(PCREGrammarParser.CalloutContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PCREGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PCREGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#cc_atom}.
	 * @param ctx the parse tree
	 */
	void enterCc_atom(PCREGrammarParser.Cc_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#cc_atom}.
	 * @param ctx the parse tree
	 */
	void exitCc_atom(PCREGrammarParser.Cc_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#shared_atom}.
	 * @param ctx the parse tree
	 */
	void enterShared_atom(PCREGrammarParser.Shared_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#shared_atom}.
	 * @param ctx the parse tree
	 */
	void exitShared_atom(PCREGrammarParser.Shared_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PCREGrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PCREGrammarParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#cc_literal}.
	 * @param ctx the parse tree
	 */
	void enterCc_literal(PCREGrammarParser.Cc_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#cc_literal}.
	 * @param ctx the parse tree
	 */
	void exitCc_literal(PCREGrammarParser.Cc_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#shared_literal}.
	 * @param ctx the parse tree
	 */
	void enterShared_literal(PCREGrammarParser.Shared_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#shared_literal}.
	 * @param ctx the parse tree
	 */
	void exitShared_literal(PCREGrammarParser.Shared_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PCREGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PCREGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#octal_char}.
	 * @param ctx the parse tree
	 */
	void enterOctal_char(PCREGrammarParser.Octal_charContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#octal_char}.
	 * @param ctx the parse tree
	 */
	void exitOctal_char(PCREGrammarParser.Octal_charContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#octal_digit}.
	 * @param ctx the parse tree
	 */
	void enterOctal_digit(PCREGrammarParser.Octal_digitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#octal_digit}.
	 * @param ctx the parse tree
	 */
	void exitOctal_digit(PCREGrammarParser.Octal_digitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#digits}.
	 * @param ctx the parse tree
	 */
	void enterDigits(PCREGrammarParser.DigitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#digits}.
	 * @param ctx the parse tree
	 */
	void exitDigits(PCREGrammarParser.DigitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(PCREGrammarParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(PCREGrammarParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PCREGrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PCREGrammarParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#alpha_nums}.
	 * @param ctx the parse tree
	 */
	void enterAlpha_nums(PCREGrammarParser.Alpha_numsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#alpha_nums}.
	 * @param ctx the parse tree
	 */
	void exitAlpha_nums(PCREGrammarParser.Alpha_numsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#non_close_parens}.
	 * @param ctx the parse tree
	 */
	void enterNon_close_parens(PCREGrammarParser.Non_close_parensContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#non_close_parens}.
	 * @param ctx the parse tree
	 */
	void exitNon_close_parens(PCREGrammarParser.Non_close_parensContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#non_close_paren}.
	 * @param ctx the parse tree
	 */
	void enterNon_close_paren(PCREGrammarParser.Non_close_parenContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#non_close_paren}.
	 * @param ctx the parse tree
	 */
	void exitNon_close_paren(PCREGrammarParser.Non_close_parenContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCREGrammarParser#letter}.
	 * @param ctx the parse tree
	 */
	void enterLetter(PCREGrammarParser.LetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCREGrammarParser#letter}.
	 * @param ctx the parse tree
	 */
	void exitLetter(PCREGrammarParser.LetterContext ctx);
}