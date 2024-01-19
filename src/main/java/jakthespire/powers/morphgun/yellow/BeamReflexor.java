package jakthespire.powers.morphgun.yellow;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class BeamReflexor extends MorphGun {
    public BeamReflexor(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public BeamReflexor(AbstractCreature owner, int amount) {
        super(getID, "BeamReflexor", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("BeamReflexor");

}
