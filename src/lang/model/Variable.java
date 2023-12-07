package lang.model;

public abstract class Variable {

    private String name;
    private String type;

    public Variable(String nome, String type) {
        this.name = nome;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
