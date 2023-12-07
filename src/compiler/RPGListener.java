package compiler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import antlr.RPGGrammarBaseListener;
import lang.methods.Curar;
import lang.methods.Especial;
import lang.methods.Fugir;
import lang.methods.Lutar;
import lang.parameters.CurarParams;
import lang.parameters.EspecialParams;
import lang.parameters.FugirParams;
import lang.parameters.LutarParams;
import lang.types.IntVar;
import lang.types.StringVar;
import lang.model.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import util.ParametersUtils;
import util.Response;

public class RPGListener extends RPGGrammarBaseListener {

    private final Response output;
    private final List<Variable> variableList;

    private final String[] methodList = {"lutar", "curar", "fugir", "especial"};

    public RPGListener() {
        variableList = new ArrayList<>();
        output = new Response();
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String firstNode = ctx.getChild(0).getText();
        int indexOfMethodCall = firstNode.indexOf("(");
        if(firstNode.equals("slot")) {
            setVariableList(ctx);
        }
        if(indexOfMethodCall != -1) {
            String methodName = getMethodName(firstNode, indexOfMethodCall);
            boolean isOnMethodList = Arrays.asList(methodList).contains(methodName);

            if(isOnMethodList) {
                execMethod(ctx,methodName);
            }
        }
    }

    private void setVariableList(ParserRuleContext ctx) {
        String value = ctx.getChild(3).getText();
        String name = ctx.getChild(1).getText();

        if(ParametersUtils.getTypeOfVar(value).equals("string")) {
//            output.writeOnOutputFile("Declarou String. Valor: " + value + "\n");
            variableList.add(new StringVar(name, ParametersUtils.removeStringMarks(value)));
        } else if(ParametersUtils.getTypeOfVar(value).equals("int")) {
            int intValue = Integer.parseInt(value);
//            output.writeOnOutputFile("Declarou Inteiro. Valor: " + value + "\n");
            variableList.add(new IntVar(name, intValue));
        }
    }

    private String getMethodName(String node, int index) {
        return node.substring(0, index).trim();
    }

    private void execMethod(ParserRuleContext ctx, String methodName) {
        String method = ctx.getChild(0).getText();

        switch (methodName){
            case "lutar":

                Lutar lutar = new Lutar(output, new LutarParams(method, variableList));
                lutar.execute();
                break;
            case "curar":
                Curar curar = new Curar(output, new CurarParams(method, variableList));
                curar.execute();
                break;
            case "fugir":
                Fugir fugir = new Fugir(output, new FugirParams(method, variableList));
                fugir.execute();
                break;
            case "especial":
                Especial especial = new Especial(output, new EspecialParams(method, variableList));
                especial.execute();
                break;
        }
    }



}
