package jakthespire.powers.eco;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static jakthespire.ModFile.makeID;

public class BlueEco extends Eco {
    public BlueEco(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, PowerType.BUFF, false, owner, amount);
    }

    public BlueEco(AbstractCreature owner, int amount) {
        super(getID, "BlueEco", PowerType.BUFF, false, owner, amount);
    }

    public void atStartOfTurnPostDraw() {
        if (this.owner.isPlayer) {
            AbstractDungeon.player.energy.energy = AbstractDungeon.player.energy.energy + this.amount;
        }
    }
    public void onInitialApplication() {
        if (this.owner.isPlayer) {
            AbstractDungeon.player.energy.energy = AbstractDungeon.player.energy.energy + this.amount;
        }
    }

    public static final String getID = makeID("BlueEco");

}
