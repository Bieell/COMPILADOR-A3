package lang.types;

import lang.model.Variable;

import java.util.List;

public class StringVar extends Variable {

    private String value;

    public StringVar(String nome, String value) {
        super(nome, "string");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getStringVarValue(List<Variable> variableList, String arg) {
        String str = "";
        for(Variable var : variableList) {
            if(var instanceof StringVar stringVar) {
                if(stringVar.getName().equals(arg)) {
                    str = stringVar.getValue();
                }
            }
        }
        return str;
    }

}
