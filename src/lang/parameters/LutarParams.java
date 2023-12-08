package lang.parameters;

import com.sun.source.tree.TypeParameterTree;
import lang.model.Player;
import lang.model.Variable;
import lang.types.IntVar;
import lang.types.StringVar;
import org.antlr.v4.parse.v4ParserException;
import util.ParametersUtils;

import java.text.ParseException;
import java.util.List;

public class LutarParams {

    private final String[] args;
    private final List<Variable> variableList;
    private final Player playerOne;
    private final Player playerTwo;
    private String local;
    private String attack;
    private int numberOfAttacks;


    public LutarParams(String method, List<Variable> variableList) {
        args = ParametersUtils.getMethodParams(method);
        playerOne = new Player();
        playerTwo = new Player();
        this.variableList = variableList;
        setLutarParams();
    }

    private void setLutarParams() {
        setPlayerOne();
        setPlayerTwo();
        setLocal();
        setAttack();
        setNumberOfAttacks();
    }

    private void setPlayerOne() {
        if(ParametersUtils.isVariable(args[0])) {
            playerOne.setVariablePlayerName(variableList, args[0]);
        } else if(ParametersUtils.getTypeOfVar(args[0]).equals("string")) {
            playerOne.setName(ParametersUtils.removeStringMarks(args[0]));
        }

        if(ParametersUtils.isVariable(args[1])) {
            playerOne.setVariablePlayerHP(variableList, args[1]);
        } else if (ParametersUtils.getTypeOfVar(args[1]).equals("int")){
            playerOne.setHp(Integer.parseInt(args[1]));
        }
    }

    private void setPlayerTwo() {
        if(ParametersUtils.isVariable(args[2])) {
            playerTwo.setVariablePlayerName(variableList, args[2]);
        } else if(ParametersUtils.getTypeOfVar(args[2]).equals("string")){
            playerTwo.setName(ParametersUtils.removeStringMarks(args[2]));
        }

        if(ParametersUtils.isVariable(args[3])) {
            playerTwo.setVariablePlayerHP(variableList, args[3]);
        } else if (ParametersUtils.getTypeOfVar(args[3]).equals("int")){
            playerTwo.setHp(Integer.parseInt(args[3]));
        }
    }

    private void setLocal() {
        if(ParametersUtils.isVariable(args[4])) {
            local = StringVar.getStringVarValue(variableList, args[4]);
        } else if(ParametersUtils.getTypeOfVar(args[4]).equals("string")){
            local = ParametersUtils.removeStringMarks(args[4]);
        }
    }

    private void setAttack() {
        if(ParametersUtils.isVariable(args[5])) {
            attack = StringVar.getStringVarValue(variableList, args[5]);
        } else if(ParametersUtils.getTypeOfVar(args[5]).equals("string")){
            attack = ParametersUtils.removeStringMarks(args[5]);
        }
    }

    private void setNumberOfAttacks() {
        if(ParametersUtils.isVariable(args[6])) {
            numberOfAttacks = IntVar.getIntVarValue(variableList, args[6]);
        } else if(ParametersUtils.getTypeOfVar(args[6]).equals("int")){
            numberOfAttacks = Integer.parseInt(args[6]);
        }
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public String getLocal() {
        return local;
    }

    public String getAttack() {
        return attack;
    }

    public int getNumberOfAttacks() {
        return numberOfAttacks;
    }
}
