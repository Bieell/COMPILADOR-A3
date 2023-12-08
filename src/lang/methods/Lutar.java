package lang.methods;

import lang.model.Method;
import lang.parameters.LutarParams;
import util.Response;

public class Lutar implements Method {

    private final Response output;
    private final LutarParams params;
    private final int playerTwoStartHp;
    private boolean isPlayerTwoDead;

    public Lutar(Response output, LutarParams params) {
        this.output = output;
        this.params = params;
        playerTwoStartHp = params.getPlayerTwo().getHp();
        isPlayerTwoDead = false;
    }

    @Override
    public void execute() {
        String msg1 = String.format("\n%s atacou %s usando %s %d vezes no local: %s.\n", params.getPlayerOne().getName(), params.getPlayerTwo().getName(), params.getAttack(), params.getNumberOfAttacks(), params.getLocal());
        String msg2 = String.format("Vida total de %s: %d.\n", params.getPlayerOne().getName(), params.getPlayerOne().getHp());
        String msg3 = String.format("Vida total de %s: %d.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());
        output.writeOnOutputFile(msg1+msg2+msg3);
        for(int i = 0; i < params.getNumberOfAttacks() && !isPlayerTwoDead; i++) {
            output.writeOnOutputFile(getAttackMsg(i));
        }
        if(!isPlayerTwoDead) {
            String msgSurvive = String.format("%s ta vivo!! \uD83D\uDE04\uD83D\uDE04\nLuta Encerrada.\n",params.getPlayerTwo().getName());
            output.writeOnOutputFile(msgSurvive);
        }
    }

    private String getAttackMsg(int attackNumber) {
        String msgAttack = "";
        attackNumber+=1;
        boolean isDefended = defend();

        if(isDefended) {
            msgAttack = String.format("Ataque %d: %s Defendeu o Ataque!\n", attackNumber, params.getPlayerTwo().getName());
        } else if(params.getPlayerTwo().getHp() > 0){
            int playerTwoHp = params.getPlayerTwo().getHp();
            int atackDamage = getAttackDamage();
            int newHp = playerTwoHp - atackDamage;
            params.getPlayerTwo().setHp(newHp);
            msgAttack = String.format("Ataque %d: %s Acertou o Ataque! Dano: %d\n", attackNumber, params.getPlayerOne().getName(), atackDamage);;
        } else {
            msgAttack = String.format("%s Morreu \uD83D\uDE2D\uD83D\uDE2D\nLuta Encerrada...\n",params.getPlayerTwo().getName());
            isPlayerTwoDead = true;
            return msgAttack;
        }

        String msgLife = String.format("Vida do %s: %d.\n", params.getPlayerTwo().getName(), params.getPlayerTwo().getHp());

        return msgAttack+msgLife;
    }

    private boolean defend() {
        double maxChanceToDefend = 0.60;
        double random = getRandomMinMax(0.20, 0.99);
        double chanceToDefend = (double) params.getPlayerTwo().getHp()/params.getPlayerOne().getHp();
        if(chanceToDefend >= maxChanceToDefend) {
            return random < maxChanceToDefend;
        }
        return random < chanceToDefend;
    }

    private int getAttackDamage() {
        double min = 0.20;
        double max = 0.30;
        double hitKillPct = 0.25;
        double random = getRandomMinMax(min, max);
        int attackDamage = (int) Math.round((params.getPlayerTwo().getHp() * random));

        if(params.getPlayerTwo().getHp() <= playerTwoStartHp *hitKillPct) {
            attackDamage = params.getPlayerTwo().getHp();
        }
        return attackDamage;
    }

    private double getRandomMinMax(double min, double max) {
        double random = Math.random();
        return random * (max - min) + min;
    }
}
