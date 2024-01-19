package jakthespire.powers.morphgun.blue;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class ArcWielder extends MorphGun {
    public ArcWielder(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public ArcWielder(AbstractCreature owner, int amount) {
        super(getID, "ArcWielder", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("ArcWielder");

}
