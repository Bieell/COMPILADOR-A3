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
        String msg = String.format("%s tentou fugir.\n",params.getPlayer().getName());
        output.writeOnOutputFile(msg);
    }
}
