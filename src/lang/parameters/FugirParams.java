package lang.parameters;

import lang.model.Player;
import lang.model.Variable;
import util.ParametersUtils;

import java.util.List;

public class FugirParams {

    private final List<Variable> variableList;
    private final Player player;
    public FugirParams(String method, List<Variable> variableList) {
        player = new Player();
        String[] args = ParametersUtils.getMethodParams(method);
        this.variableList = variableList;
        setFugirParams(args);
    }

    private void setFugirParams(String[] args) {
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

    public Player getPlayer() {
        return player;
    }
}
