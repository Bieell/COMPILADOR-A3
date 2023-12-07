package lang;

import java.io.FileWriter;
import java.io.IOException;

public class Methods {

    public static FileWriter writer;

    public static String getTypeOfVar(String value) {
        return value.matches("\\d+") ? "int" : "string";
    }

    public static void lutar() {
        writeOnOutputFile("Lutou\n");
    }

    public static void curar() {
        writeOnOutputFile("Curou\n");
    }

    public static void fugir() {
        writeOnOutputFile("Fugiu\n");
    }

    public static void especial() {
        writeOnOutputFile("Especial\n");
    }

    public static void writeOnOutputFile(String msg) {
        try {
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
