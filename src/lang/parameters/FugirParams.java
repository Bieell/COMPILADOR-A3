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
        player.setPlayerName(variableList, args[0]);
        player.setPlayerHP(variableList, args[1]);
    }

    public Player getPlayer() {
        return player;
    }
}
