package compiler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.RPGGrammarLexer;
import antlr.RPGGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class RPGCompilador {
    private static CharStream entrada;
    
    public static void main(String[] args) {
        try {
            entrada = CharStreams.fromPath(Path.of("codigo_fonte.txt"), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(RPGCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RPGGrammarLexer lexer = new RPGGrammarLexer(entrada);
        CommonTokenStream  tokens = new CommonTokenStream(lexer);
        RPGGrammarParser parser = new RPGGrammarParser(tokens);
        RPGGrammarParser.ProgramContext arvore = parser.program();
        System.out.println("ARVORE: " + arvore.toStringTree(parser));
        RPGListener listener = new RPGListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, arvore);
    }
}
