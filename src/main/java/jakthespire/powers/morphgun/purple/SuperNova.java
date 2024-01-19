package jakthespire.powers.morphgun.purple;

import com.megacrit.cardcrawl.core.AbstractCreature;
import jakthespire.powers.morphgun.MorphGun;

import static jakthespire.ModFile.makeID;

public class SuperNova extends MorphGun {
    public SuperNova(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public SuperNova(AbstractCreature owner, int amount) {
        super(getID, "SuperNova", PowerType.BUFF, false, owner, amount);
    }

    public static final String getID = makeID("SuperNova");

}
