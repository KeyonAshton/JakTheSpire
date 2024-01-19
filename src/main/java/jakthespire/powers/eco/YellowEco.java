package jakthespire.powers.eco;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class YellowEco extends Eco {
    public YellowEco(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public YellowEco(AbstractCreature owner, int amount) {
        super(getID, "YellowEco", PowerType.BUFF, false, owner, amount);
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if (target.hasPower(MetallicizePower.POWER_ID)) {
            att(new ReducePowerAction(target, this.owner, MetallicizePower.POWER_ID, 1));
        }
        att(new ApplyPowerAction(target, this.owner, new PoisonPower(target, this.owner, damageAmount / (this.amount / 5)), damageAmount / this.amount, true));
        thornDmg(target, damageAmount - (damageAmount / (this.amount / 5)));
    }

    public static final String getID = makeID("YellowEco");

}
