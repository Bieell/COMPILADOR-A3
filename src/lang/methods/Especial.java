package lang.methods;

import lang.model.Method;
import lang.parameters.EspecialParams;
import util.Response;

public class Especial implements Method {

    private final Response output;
    private final EspecialParams params;

    public Especial(Response output, EspecialParams params) {
        this.output = output;
        this.params = params;
    }

    @Override
    public void execute() {
        String msg1 = String.format("%s tentou usar o especial: %s em %s no local: %s.\n", params.getPlayerOne().getName(), params.getSpecialName(), params.getPlayerTwo().getName(), params.getLocal());
        String msg2 = String.format("Vida do %s: %d de vida.\n", params.getPlayerOne().getName(), params.getPlayerOne().getHp());
        String msg3 = String.format("Vida do %s: %d de vida.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());

        output.writeOnOutputFile(msg1+msg2+msg3);
    }
}
