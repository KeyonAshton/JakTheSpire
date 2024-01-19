package jakthespire.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.RegenPower;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class MarHeart extends AbstractEasyRelic {
    public static final String ID = makeID("PrecursorEgg");

    public MarHeart() {
        super(ID, RelicTier.RARE, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

    public void atBattleStart() {
        this.flash();
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RegenPower(AbstractDungeon.player, 3), 3));
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }

}
