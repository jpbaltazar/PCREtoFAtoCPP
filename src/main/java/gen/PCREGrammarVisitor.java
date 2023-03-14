package gen;// Generated from C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/main/resources\PCREGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PCREGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PCREGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PCREGrammarParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#singleRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleRule(PCREGrammarParser.SingleRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#directives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectives(PCREGrammarParser.DirectivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#alternation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternation(PCREGrammarParser.AlternationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PCREGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(PCREGrammarParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(PCREGrammarParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#quantifier_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier_type(PCREGrammarParser.Quantifier_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#character_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_class(PCREGrammarParser.Character_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#backreference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackreference(PCREGrammarParser.BackreferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#backreference_or_octal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackreference_or_octal(PCREGrammarParser.Backreference_or_octalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#capture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapture(PCREGrammarParser.CaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#non_capture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_capture(PCREGrammarParser.Non_captureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(PCREGrammarParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(PCREGrammarParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#option_flags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_flags(PCREGrammarParser.Option_flagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#option_flag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_flag(PCREGrammarParser.Option_flagContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#look_around}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLook_around(PCREGrammarParser.Look_aroundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#subroutine_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutine_reference(PCREGrammarParser.Subroutine_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(PCREGrammarParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#backtrack_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBacktrack_control(PCREGrammarParser.Backtrack_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#newline_convention}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewline_convention(PCREGrammarParser.Newline_conventionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#callout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallout(PCREGrammarParser.CalloutContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PCREGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#cc_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCc_atom(PCREGrammarParser.Cc_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#shared_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShared_atom(PCREGrammarParser.Shared_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PCREGrammarParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#cc_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCc_literal(PCREGrammarParser.Cc_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#shared_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShared_literal(PCREGrammarParser.Shared_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PCREGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#octal_char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctal_char(PCREGrammarParser.Octal_charContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#octal_digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOctal_digit(PCREGrammarParser.Octal_digitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#digits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigits(PCREGrammarParser.DigitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(PCREGrammarParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(PCREGrammarParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#alpha_nums}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlpha_nums(PCREGrammarParser.Alpha_numsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#non_close_parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_close_parens(PCREGrammarParser.Non_close_parensContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#non_close_paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_close_paren(PCREGrammarParser.Non_close_parenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCREGrammarParser#letter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetter(PCREGrammarParser.LetterContext ctx);
}