package jakthespire.powers.morphgun;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.AbstractEasyPower;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.removeFromSelf;

public abstract class Ammo extends AbstractEasyPower {
    public Ammo(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public Ammo(AbstractCreature owner, int amount) {
        super(getID, "Ammo", PowerType.BUFF, false, owner, amount);
    }

    public static final int ammoMax = 5;
    public static final String getID = makeID("Ammo");

    @Override
    public void atEndOfRound() {
        if (this.amount <= 0) {
            removeFromSelf(getID);
        }
        while (this.amount > ammoMax) {
            reducePower(1);
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

}
