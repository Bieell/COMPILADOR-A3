package lang.parameters;

import lang.model.Player;
import lang.model.Variable;
import lang.types.StringVar;
import util.ParametersUtils;

import java.util.List;

public class EspecialParams {

    private final List<Variable> variableList;
    private final String[] args;
    private final Player playerOne;
    private final Player playerTwo;
    private String local;
    private String specialName;

    public EspecialParams(String method, List<Variable> variableList) {
        playerOne = new Player();
        playerTwo = new Player();
        this.variableList = variableList;
        args = ParametersUtils.getMethodParams(method);
        setEspecialParams();
    }

    private void setEspecialParams() {
        setPlayerOne();
        setPlayerTwo();
        setLocal();
        setSpecialName();
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

    private void setSpecialName() {
        if(ParametersUtils.isVariable(args[5])) {
            specialName = StringVar.getStringVarValue(variableList, args[5]);
        } else {
            specialName = ParametersUtils.removeStringMarks(args[5]);
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

    public String getSpecialName() {
        return specialName;
    }
}
