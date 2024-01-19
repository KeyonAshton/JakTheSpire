package jakthespire.powers.morphgun.red;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.Ammo;

import static jakthespire.ModFile.makeID;

public class RedAmmo extends Ammo {
    public RedAmmo(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public RedAmmo(AbstractCreature owner, int amount) {
        super(getID, "RedAmmo", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("RedAmmo");

}
