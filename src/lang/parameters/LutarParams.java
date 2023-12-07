package lang.parameters;

import lang.model.Player;
import lang.model.Variable;
import lang.types.IntVar;
import lang.types.StringVar;
import util.ParametersUtils;

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
        playerOne.setPlayerName(variableList, args[0]);
        playerOne.setPlayerHP(variableList, args[1]);
    }

    private void setPlayerTwo() {
        playerTwo.setPlayerName(variableList, args[2]);
        playerTwo.setPlayerHP(variableList, args[3]);
    }

    private void setLocal() {
        if(ParametersUtils.isVariable(args[4])) {
            local = StringVar.getStringVarValue(variableList, args[4]);
        } else {
            local = ParametersUtils.removeStringMarks(args[4]);
        }
    }

    private void setAttack() {
        if(ParametersUtils.isVariable(args[5])) {
            attack = StringVar.getStringVarValue(variableList, args[5]);
        } else {
            attack = ParametersUtils.removeStringMarks(args[5]);
        }
    }

    private void setNumberOfAttacks() {
        if(ParametersUtils.isVariable(args[6])) {
            numberOfAttacks = IntVar.getIntVarValue(variableList, args[6]);
        } else {
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
