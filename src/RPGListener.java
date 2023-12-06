import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;

public class RPGListener extends RPGGrammarBaseListener{
    
    private FileWriter writer;
    
    public RPGListener() {
        try {
            writer = new FileWriter(new File("Retorno Compilador.txt"));
        } catch (IOException ex) {
            Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx.getChild(0).getText().equals("slot")) {
            try {
                writer.write("Declarou variável. Valor: " + ctx.getChild(3));
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void enterProgram(RPGGrammarParser.ProgramContext ctx) {
    }

    @Override
    public void exitProgram(RPGGrammarParser.ProgramContext ctx) {
        System.out.println("Sai do compilador RPG");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("Entrei num nó do código");
    }
        
}
