package antlr;// Generated from RPGGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RPGGrammarParser}.
 */
public interface RPGGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RPGGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(RPGGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPGGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(RPGGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPGGrammarParser#rpg}.
	 * @param ctx the parse tree
	 */
	void enterRpg(RPGGrammarParser.RpgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPGGrammarParser#rpg}.
	 * @param ctx the parse tree
	 */
	void exitRpg(RPGGrammarParser.RpgContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPGGrammarParser#criarrpg}.
	 * @param ctx the parse tree
	 */
	void enterCriarrpg(RPGGrammarParser.CriarrpgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPGGrammarParser#criarrpg}.
	 * @param ctx the parse tree
	 */
	void exitCriarrpg(RPGGrammarParser.CriarrpgContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPGGrammarParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(RPGGrammarParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPGGrammarParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(RPGGrammarParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPGGrammarParser#metodo}.
	 * @param ctx the parse tree
	 */
	void enterMetodo(RPGGrammarParser.MetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPGGrammarParser#metodo}.
	 * @param ctx the parse tree
	 */
	void exitMetodo(RPGGrammarParser.MetodoContext ctx);
}