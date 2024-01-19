package jakthespire.powers.morphgun;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.AbstractEasyPower;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.removeFromSelf;

public abstract class MorphGun extends AbstractEasyPower {
    public MorphGun(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public MorphGun(AbstractCreature owner, int amount) {
        super(getID, "MorphGun", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("MorphGun");

    @Override
    public void atEndOfRound() {
        if (this.amount <= 0) {
            removeFromSelf(getID);
        }
        while (this.amount > 1) {
            reducePower(1);
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

}
