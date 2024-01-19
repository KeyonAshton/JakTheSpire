package jakthespire.powers.morphgun.purple;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.Ammo;

import static jakthespire.ModFile.makeID;

public class PurpleAmmo extends Ammo {
    public PurpleAmmo(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public PurpleAmmo(AbstractCreature owner, int amount) {
        super(getID, "PurpleAmmo", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("PurpleAmmo");

}
