package jakthespire.powers.morphgun.red;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class WaveConcussor extends MorphGun {
    public WaveConcussor(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public WaveConcussor(AbstractCreature owner, int amount) {
        super(getID, "WaveConcussor", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("WaveConcussor");

}
