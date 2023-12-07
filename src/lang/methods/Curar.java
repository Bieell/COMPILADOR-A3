package lang.methods;

import lang.model.Method;
import lang.model.Variable;
import lang.parameters.CurarParams;
import util.Response;

import java.util.List;

public class Curar implements Method {

    private final Response output;
    private final CurarParams params;

    public Curar(Response output, CurarParams params) {
        this.output = output;
        this.params = params;
    }
    @Override
    public void execute() {
        String msg = String.format("%s está com %d de vida. %s curou %d vezes.\n", params.getPlayer().getName(), params.getPlayer().getHp(), params.getPlayer().getName(), params.getNumberOfHeals());
        output.writeOnOutputFile(msg);
    }
}
