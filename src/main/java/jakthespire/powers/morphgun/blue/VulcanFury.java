package jakthespire.powers.morphgun.blue;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class VulcanFury extends MorphGun {
    public VulcanFury(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public VulcanFury(AbstractCreature owner, int amount) {
        super(getID, "VulcanFury", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("VulcanFury");

}
