package jakthespire.powers.morphgun.yellow;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class Blaster extends MorphGun {
    public Blaster(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public Blaster(AbstractCreature owner, int amount) {
        super(getID, "Blaster", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("Blaster");

}
