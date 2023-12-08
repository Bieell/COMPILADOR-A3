package lang.methods;

import lang.model.Method;
import lang.model.Variable;
import lang.parameters.FugirParams;
import util.Response;

import java.util.List;

public class Fugir implements Method {

    private final Response output;
    private final FugirParams params;

    public Fugir(Response output, FugirParams params) {

        this.output = output;
        this.params = params;
    }

    @Override
    public void execute() {
        String msg = String.format("\n%s tentou fugir.",params.getPlayer().getName());
        output.writeOnOutputFile(msg);
        output.writeOnOutputFile(getFugirMessage());
    }

    private String getFugirMessage() {
        double random = Math.random();
        if(random > 0.5) {
            return String.format("%s conseguiu fugir!!\n", params.getPlayer().getName());
        }
        return String.format("%s não conseguiu fugir...\n", params.getPlayer().getName());
    }
}
