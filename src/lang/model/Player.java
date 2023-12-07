package lang.model;

import lang.types.IntVar;
import lang.types.StringVar;
import util.ParametersUtils;

import java.util.List;

public class Player {
    private String name;
    private int hp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public void setPlayerName(List<Variable> variableList, String arg) {
        String playerName = "";

        if(ParametersUtils.isVariable(arg)) {
            playerName = StringVar.getStringVarValue(variableList, arg);
        } else {
            playerName = ParametersUtils.removeStringMarks(arg);
        }
        this.setName(playerName);
    }

    public void setPlayerHP(List<Variable> variableList, String arg) {
        int playerHp = 0;
        if(ParametersUtils.isVariable(arg)) {
            playerHp = IntVar.getIntVarValue(variableList, arg);
        } else {
            playerHp = Integer.parseInt(arg);
        }
        this.setHp(playerHp);
    }
}
