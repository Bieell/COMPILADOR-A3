// Generated from RPGGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RPGGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCAO=1, INICIO=2, DECLARAR=3, PONTO_E_VIRGULA=4, ATRIBUIR=5, METODOS=6, 
		METODO_COMBATE=7, METODO_CURAR=8, METODO_FUGIR=9, METODO_ESPECIAL=10, 
		PARAMETROS_COMBATE=11, PARAMETROS_CURAR=12, PARAMETROS_FUGIR=13, PARAMETROS_ESPECIAL=14, 
		FIM=15, ESPACO=16, INT=17, ID=18, STRING=19, WS=20;
	public static final int
		RULE_program = 0, RULE_rpg = 1, RULE_criarrpg = 2, RULE_declaracao = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "rpg", "criarrpg", "declaracao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'quest'", null, "'slot'", "';'", "'='", null, null, null, null, 
			null, null, null, null, null, "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNCAO", "INICIO", "DECLARAR", "PONTO_E_VIRGULA", "ATRIBUIR", 
			"METODOS", "METODO_COMBATE", "METODO_CURAR", "METODO_FUGIR", "METODO_ESPECIAL", 
			"PARAMETROS_COMBATE", "PARAMETROS_CURAR", "PARAMETROS_FUGIR", "PARAMETROS_ESPECIAL", 
			"FIM", "ESPACO", "INT", "ID", "STRING", "WS"
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
	public String getGrammarFileName() { return "RPGGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RPGGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public RpgContext rpg() {
			return getRuleContext(RpgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RPGGrammarParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			rpg();
			setState(9);
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
	public static class RpgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RPGGrammarParser.EOF, 0); }
		public CriarrpgContext criarrpg() {
			return getRuleContext(CriarrpgContext.class,0);
		}
		public RpgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).enterRpg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).exitRpg(this);
		}
	}

	public final RpgContext rpg() throws RecognitionException {
		RpgContext _localctx = new RpgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rpg);
		try {
			setState(13);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				match(EOF);
				}
				break;
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				criarrpg();
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
	public static class CriarrpgContext extends ParserRuleContext {
		public TerminalNode FUNCAO() { return getToken(RPGGrammarParser.FUNCAO, 0); }
		public TerminalNode INICIO() { return getToken(RPGGrammarParser.INICIO, 0); }
		public TerminalNode FIM() { return getToken(RPGGrammarParser.FIM, 0); }
		public List<TerminalNode> PONTO_E_VIRGULA() { return getTokens(RPGGrammarParser.PONTO_E_VIRGULA); }
		public TerminalNode PONTO_E_VIRGULA(int i) {
			return getToken(RPGGrammarParser.PONTO_E_VIRGULA, i);
		}
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public List<TerminalNode> METODOS() { return getTokens(RPGGrammarParser.METODOS); }
		public TerminalNode METODOS(int i) {
			return getToken(RPGGrammarParser.METODOS, i);
		}
		public CriarrpgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criarrpg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).enterCriarrpg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).exitCriarrpg(this);
		}
	}

	public final CriarrpgContext criarrpg() throws RecognitionException {
		CriarrpgContext _localctx = new CriarrpgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_criarrpg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(FUNCAO);
			setState(16);
			match(INICIO);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262216L) != 0)) {
				{
				{
				setState(19);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DECLARAR:
				case ID:
					{
					setState(17);
					declaracao();
					}
					break;
				case METODOS:
					{
					setState(18);
					match(METODOS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(21);
				match(PONTO_E_VIRGULA);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(FIM);
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
	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode ATRIBUIR() { return getToken(RPGGrammarParser.ATRIBUIR, 0); }
		public TerminalNode STRING() { return getToken(RPGGrammarParser.STRING, 0); }
		public TerminalNode METODOS() { return getToken(RPGGrammarParser.METODOS, 0); }
		public TerminalNode INT() { return getToken(RPGGrammarParser.INT, 0); }
		public TerminalNode ID() { return getToken(RPGGrammarParser.ID, 0); }
		public TerminalNode DECLARAR() { return getToken(RPGGrammarParser.DECLARAR, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPGGrammarListener ) ((RPGGrammarListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARAR:
				{
				{
				setState(29);
				match(DECLARAR);
				setState(30);
				match(ID);
				}
				}
				break;
			case ID:
				{
				setState(31);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(34);
			match(ATRIBUIR);
			setState(35);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 655424L) != 0)) ) {
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
		"\u0004\u0001\u0014&\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u000e\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0014\b\u0002\u0001\u0002\u0005"+
		"\u0002\u0017\b\u0002\n\u0002\f\u0002\u001a\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003!\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004"+
		"\u0006\u0000\u0001\u0003\u0000\u0006\u0006\u0011\u0011\u0013\u0013%\u0000"+
		"\b\u0001\u0000\u0000\u0000\u0002\r\u0001\u0000\u0000\u0000\u0004\u000f"+
		"\u0001\u0000\u0000\u0000\u0006 \u0001\u0000\u0000\u0000\b\t\u0003\u0002"+
		"\u0001\u0000\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000"+
		"\u000b\u000e\u0005\u0000\u0000\u0001\f\u000e\u0003\u0004\u0002\u0000\r"+
		"\u000b\u0001\u0000\u0000\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u0003"+
		"\u0001\u0000\u0000\u0000\u000f\u0010\u0005\u0001\u0000\u0000\u0010\u0018"+
		"\u0005\u0002\u0000\u0000\u0011\u0014\u0003\u0006\u0003\u0000\u0012\u0014"+
		"\u0005\u0006\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0012"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0017"+
		"\u0005\u0004\u0000\u0000\u0016\u0013\u0001\u0000\u0000\u0000\u0017\u001a"+
		"\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u0018"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u000f\u0000\u0000\u001c\u0005"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0003\u0000\u0000\u001e!\u0005"+
		"\u0012\u0000\u0000\u001f!\u0005\u0012\u0000\u0000 \u001d\u0001\u0000\u0000"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005"+
		"\u0005\u0000\u0000#$\u0007\u0000\u0000\u0000$\u0007\u0001\u0000\u0000"+
		"\u0000\u0004\r\u0013\u0018 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}