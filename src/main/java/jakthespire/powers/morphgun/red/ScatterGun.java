package jakthespire.powers.morphgun.red;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class ScatterGun extends MorphGun {
    public ScatterGun(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public ScatterGun(AbstractCreature owner, int amount) {
        super(getID, "ScatterGun", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("ScatterGun");

}
