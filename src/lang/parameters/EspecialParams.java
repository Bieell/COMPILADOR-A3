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

    private void setSpecialName() {
        if(ParametersUtils.isVariable(args[5])) {
            specialName = StringVar.getStringVarValue(variableList, args[5]);
        } else if(ParametersUtils.getTypeOfVar(args[5]).equals("string")){
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
