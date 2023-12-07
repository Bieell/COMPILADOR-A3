package lang.methods;

import lang.model.Method;
import lang.parameters.LutarParams;
import util.Response;

public class Lutar implements Method {

    private final Response output;
    private final LutarParams params;

    public Lutar(Response output, LutarParams params) {
        this.output = output;
        this.params = params;
    }

    @Override
    public void execute() {
        String msg1 = String.format("%s atacou %s usando %s %d vezes no local %s.\n", params.getPlayerOne().getName(), params.getPlayerTwo().getName(), params.getAttack(), params.getNumberOfAttacks(), params.getLocal());
        String msg2 = String.format("Vida do %s: %d.\n", params.getPlayerOne().getName(), params.getPlayerOne().getHp());
        String msg3 = String.format("Vida do %s: %d.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());
        output.writeOnOutputFile(msg1+msg2+msg3);
    }
}
