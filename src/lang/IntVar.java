package lang;

public class IntVar extends Variable{
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
}
