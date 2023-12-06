package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.RPGGrammarBaseListener;
import antlr.RPGGrammarParser;
import lang.IntVar;
import lang.Methods;
import lang.StringVar;
import lang.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class RPGListener extends RPGGrammarBaseListener {
    
    private FileWriter writer;
    private final List<Variable> variableList;

    public RPGListener() {
        try {
            writer = new FileWriter(new File("Retorno Compilador.txt"));
        } catch (IOException ex) {
            Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        variableList = new ArrayList<>();
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("Entrei numa regra: " + ctx.getText());
        String firstNode = ctx.getChild(0).getText();
        if(firstNode.equals("slot")) {
            setVariableList(ctx);
            try {
                writer.write("Declarou variável. Valor: " + ctx.getChild(3)+ "\n");
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(ctx.getChild(0).getText().contains("slot"));
    }

    @Override
    public void exitProgram(RPGGrammarParser.ProgramContext ctx) {
        System.out.println("Sai do compilador RPG");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("Entrei num nó do código: " + node.getText());
    }

    private void setVariableList(ParserRuleContext ctx) {
        String value = ctx.getChild(3).getText();
        String name = ctx.getChild(1).getText();

        if(Methods.getTypeOfVar(value).equals("string")) {
            variableList.add(new StringVar(name, value));
        } else if(Methods.getTypeOfVar(value).equals("int")) {
            int intValue = Integer.parseInt(value);
            variableList.add(new IntVar(name, intValue));
        }
    }

}
