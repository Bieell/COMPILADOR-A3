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
        String msg = String.format("\n%s tentou se curar %d vezes.\n%s está com %d de vida. Vida inicial: %d\n", params.getPlayer().getName(), params.getNumberOfHeals(), params.getPlayer().getName(), params.getPlayer().getHp(), params.getStartHp());
        output.writeOnOutputFile(msg);
        for (int i = 0; i < params.getNumberOfHeals() && !playerIsFullHp(); i++) {
            output.writeOnOutputFile(getHealMsg(i));
        }
        if(playerIsFullHp()) {
            String msgFullHP = String.format("%s está com a vida cheia!", params.getPlayer().getName());
            output.writeOnOutputFile(msgFullHP);
        }
    }

    private String getHealMsg(int numberOfHeal) {
        numberOfHeal+=1;
        String msg1 =  String.format("Tentativa de Cura %d:\n",numberOfHeal);
        String msg2 = String.format("%s não conseguiu se curar...\n", params.getPlayer().getName());

        if(heal()) {
            int hpHealed = getHpHeal();
            int newHp = params.getPlayer().getHp() + hpHealed;
            params.getPlayer().setHp(newHp);
            String msgLife = String.format("Vida do %s: %d.\n", params.getPlayer().getName(), params.getPlayer().getHp());
            msg2 = String.format("%s curou %d de vida\n", params.getPlayer().getName(), hpHealed) + msgLife;
        }

        return msg1 + msg2;
    }

    private boolean heal() {
        double minHealChance = 0.10;
        double maxHealChance = 0.90;

        double chanceOfHeal = (double) params.getPlayer().getHp()/params.getStartHp();

        chanceOfHeal = 1.0 - chanceOfHeal;

        double random = getRandomMinMax(minHealChance, maxHealChance);

        if(chanceOfHeal >= maxHealChance) chanceOfHeal = maxHealChance;
        if(chanceOfHeal <= minHealChance) chanceOfHeal = minHealChance;

        return chanceOfHeal > random;
    }

    private int getHpHeal() {
        double min = 0.15;
        double max = 0.25;
        double random = getRandomMinMax(min, max);
        return (int) Math.round((params.getStartHp() * random));
    }

    private double getRandomMinMax(double min, double max) {
        double random = Math.random();
        return random * (max - min) + min;
    }

    private boolean playerIsFullHp() {
        return params.getPlayer().getHp() == params.getStartHp();
    }
}
