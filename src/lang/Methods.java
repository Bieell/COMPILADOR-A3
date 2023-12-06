package lang;

public class Methods {
    public static String getTypeOfVar(String value) {
        return value.matches("\\d+") ? "int" : "string";
    }
}
