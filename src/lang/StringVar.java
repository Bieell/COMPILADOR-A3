package lang;

public class StringVar extends Variable{

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

}
