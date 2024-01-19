package jakthespire.powers.eco;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.AbstractEasyPower;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.removeFromSelf;

public abstract class Eco extends AbstractEasyPower {
    public Eco(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public Eco(AbstractCreature owner, int amount) {
        super(getID, "Ammo", PowerType.BUFF, false, owner, amount);
    }

    public static final int ecoMax = 5;
    public static final String getID = makeID("Eco");

    @Override
    public void atEndOfRound() {
        if (this.amount <= 0) {
            removeFromSelf(getID);
        }
        while (this.amount > ecoMax) {
            reducePower(1);
        }
        reducePower(1);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

}
