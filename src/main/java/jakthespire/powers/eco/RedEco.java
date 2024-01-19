package jakthespire.powers.eco;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.adp;

public class RedEco extends Eco {
    public RedEco(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public RedEco(AbstractCreature owner, int amount) {
        super(getID, "RedEco", PowerType.BUFF, false, owner, amount);
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type) {
        if(adp().hasPower(YellowEco.getID) && !AbstractDungeon.actionManager.turnHasEnded) {
            return type == DamageInfo.DamageType.THORNS ? damage + this.amount : damage;
        }
        return type == DamageInfo.DamageType.NORMAL ? damage + this.amount : damage;
    }

    public static final String getID = makeID("RedEco");

}
