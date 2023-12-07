package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.RPGGrammarBaseListener;
import lang.IntVar;
import lang.Methods;
import lang.StringVar;
import lang.Variable;
import org.antlr.v4.runtime.ParserRuleContext;

public class RPGListener extends RPGGrammarBaseListener {
    
    private FileWriter writer;
    private final List<Variable> variableList;

    private final String[] methodList = {"lutar", "curar", "fugir", "especial"};

    public RPGListener() {
        try {
            writer = new FileWriter(new File("RPG.txt"));
            Methods.writer = writer;
        } catch (IOException ex) {
            Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        variableList = new ArrayList<>();
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String firstNode = ctx.getChild(0).getText();
        if(firstNode.equals("slot")) {
            setVariableList(ctx);
        } else {
            int indexOfMethodCall = firstNode.indexOf("(");

            if(indexOfMethodCall != -1) {
                String methodName = getMethodName(firstNode, indexOfMethodCall);
                boolean isOnMethodList = Arrays.asList(methodList).contains(methodName);

                if(isOnMethodList) {
                    execMethod(ctx,methodName);
                }
            }
        }
    }

    private void setVariableList(ParserRuleContext ctx) {
        String value = ctx.getChild(3).getText();
        String name = ctx.getChild(1).getText();

        if(Methods.getTypeOfVar(value).equals("string")) {
            Methods.writeOnOutputFile("Declarou String. Valor: " + value + "\n");
            variableList.add(new StringVar(name, value));
        } else if(Methods.getTypeOfVar(value).equals("int")) {
            int intValue = Integer.parseInt(value);
            Methods.writeOnOutputFile("Declarou Inteiro. Valor: " + value + "\n");
            variableList.add(new IntVar(name, intValue));
        }
    }

    private String getMethodName(String node, int index) {
        return node.substring(0, index).trim();
    }

    private void execMethod(ParserRuleContext ctx, String methodName) {
        switch (methodName){
            case "lutar":
                Methods.lutar();
                break;
            case "curar":
                Methods.curar();
                break;
            case "fugir":
                Methods.fugir();
                break;
            case "especial":
                Methods.especial();
                break;
        }
    }
}
