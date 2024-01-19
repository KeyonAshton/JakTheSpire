package jakthespire.powers.morphgun.yellow;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.Ammo;

import static jakthespire.ModFile.makeID;

public class YellowAmmo extends Ammo {
    public YellowAmmo(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public YellowAmmo(AbstractCreature owner, int amount) {
        super(getID, "YellowAmmo", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("YellowAmmo");

}
