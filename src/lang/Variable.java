package lang;

public abstract class Variable {

    private String nome;
    private String type;

    public Variable(String nome, String type) {
        this.nome = nome;
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public String getType() {
        return type;
    }
}
