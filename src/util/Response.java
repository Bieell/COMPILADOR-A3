package util;

import compiler.RPGListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Response {

    private FileWriter writer;

    public Response() {
        try {
            writer = new FileWriter(new File("RPG.txt"));
        } catch (IOException ex) {
            Logger.getLogger(RPGListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writeOnOutputFile(String msg) {
        try {
            writer.write(msg);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
