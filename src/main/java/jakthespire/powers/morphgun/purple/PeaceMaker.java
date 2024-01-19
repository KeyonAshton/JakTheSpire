package jakthespire.powers.morphgun.purple;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class PeaceMaker extends MorphGun {
    public PeaceMaker(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public PeaceMaker(AbstractCreature owner, int amount) {
        super(getID, "PeaceMaker", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("PeaceMaker");

}
