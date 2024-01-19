package jakthespire.powers.morphgun.blue;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.Ammo;

import static jakthespire.ModFile.makeID;

public class BlueAmmo extends Ammo {
    public BlueAmmo(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public BlueAmmo(AbstractCreature owner, int amount) {
        super(getID, "BlueAmmo", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("BlueAmmo");

}
