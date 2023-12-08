package lang.parameters;

import lang.model.Player;
import lang.model.Variable;
import lang.types.IntVar;
import util.ParametersUtils;

import java.util.List;

public class CurarParams {

    private final String[] args;
    private final List<Variable> variableList;
    private final Player player;
    private int startHp;
    private int numberOfHeals;

    public CurarParams(String method, List<Variable> variableList) {
        player = new Player();
        args = ParametersUtils.getMethodParams(method);
        this.variableList = variableList;
        setCurarParams();
    }

    private void setCurarParams() {
        setPlayer();
        setStartHp();
        setNumberOfHeals();
    }

    public void setPlayer() {
        if(ParametersUtils.isVariable(args[0])) {
            player.setVariablePlayerName(variableList, args[0]);
        } else if(ParametersUtils.getTypeOfVar(args[0]).equals("string")) {
            player.setName(ParametersUtils.removeStringMarks(args[0]));
        }

        if(ParametersUtils.isVariable(args[1])) {
            player.setVariablePlayerHP(variableList, args[1]);
        } else if (ParametersUtils.getTypeOfVar(args[1]).equals("int")){
            player.setHp(Integer.parseInt(args[1]));
        }
    }

    public void setStartHp() {
        if(ParametersUtils.isVariable(args[2])) {
            startHp = IntVar.getIntVarValue(variableList, args[2]);
        } else if(ParametersUtils.getTypeOfVar(args[2]).equals("int")){
            startHp = Integer.parseInt(args[2]);
        }
    }

    public void setNumberOfHeals() {
        if(ParametersUtils.isVariable(args[3])) {
            numberOfHeals = IntVar.getIntVarValue(variableList, args[3]);
        } else if(ParametersUtils.getTypeOfVar(args[3]).equals("int")){
            numberOfHeals = Integer.parseInt(args[3]);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberOfHeals() {
        return numberOfHeals;
    }

    public int getStartHp() {
        return startHp;
    }
}
