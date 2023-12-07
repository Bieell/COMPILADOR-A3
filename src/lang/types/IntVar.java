package lang.types;

import lang.model.Variable;

import java.util.List;

public class IntVar extends Variable {
    private int value;

    public IntVar(String nome, int value) {
        super(nome, "int");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static int getIntVarValue(List<Variable> variableList, String arg) {
        int num = 0;
        for(Variable var : variableList) {
            if(var instanceof IntVar intVar) {
                if(intVar.getName().equals(arg)) {
                    num = intVar.getValue();
                }
            }
        }
        return num;
    }
}
