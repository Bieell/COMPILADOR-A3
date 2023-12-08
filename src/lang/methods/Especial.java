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
        String msg1 = String.format("\n%s tentou usar o especial: %s em %s no local: %s.\n", params.getPlayerOne().getName(), params.getSpecialName(), params.getPlayerTwo().getName(), params.getLocal());
        String msg2 = String.format("Vida do %s: %d de vida.\n", params.getPlayerOne().getName(), params.getPlayerOne().getHp());
        String msg3 = String.format("Vida do %s: %d de vida.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());

        output.writeOnOutputFile(msg1+msg2+msg3);
        output.writeOnOutputFile(getSpecialMessage());
    }

    private String getSpecialMessage() {
        String msgEspecial = String.format("%s não acertou o especial em %s...\n", params.getPlayerOne().getName(), params.getPlayerTwo().getName());;

        if(special()) {
            int specialDamage = getSpecialDamage();
            int newHp = params.getPlayerTwo().getHp() - specialDamage;
            params.getPlayerTwo().setHp(newHp);
            msgEspecial = String.format("%s acertou o especial em %s!\n", params.getPlayerOne().getName(), params.getPlayerTwo().getName());
            String msgDamage = String.format("Dano causado: %d\n",specialDamage);
            String msgLife =String.format("Vida do %s: %d.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());
            return msgEspecial + msgDamage + msgLife;
        }

        return msgEspecial;
    }
    private boolean special() {

        double specialChance = 0.60;

        if(params.getPlayerOne().getHp() < params.getPlayerTwo().getHp()) {
            specialChance = 0.3;
        }

        double random = Math.random();

        return random > specialChance;
    }

    private int getSpecialDamage() {
        if(params.getPlayerTwo().getHp() < 60) return params.getPlayerTwo().getHp();
        return (int) (params.getPlayerTwo().getHp() * 0.75);
    }

}
