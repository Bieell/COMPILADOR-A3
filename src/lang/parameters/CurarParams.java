package lang.parameters;

import lang.model.Player;
import lang.model.Variable;
import lang.types.IntVar;
import util.ParametersUtils;

import java.util.List;

public class CurarParams {

    private final String[] args;
    private final List<Variable> variableList;
    private Player player;
    private int numberOfHeals;

    public CurarParams(String method, List<Variable> variableList) {
        player = new Player();
        args = ParametersUtils.getMethodParams(method);
        this.variableList = variableList;
        setCurarParams();
    }

    private void setCurarParams() {
        setPlayer();
        setNumberOfHeals();
    }

    public void setPlayer() {
        player.setPlayerName(variableList, args[0]);
        player.setPlayerHP(variableList, args[1]);
    }

    public void setNumberOfHeals() {
        if(ParametersUtils.isVariable(args[2])) {
            numberOfHeals = IntVar.getIntVarValue(variableList, args[2]);
        } else {
            numberOfHeals = Integer.parseInt(args[2]);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberOfHeals() {
        return numberOfHeals;
    }
}
