package jakthespire.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.BetterOnLoseHpRelic;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import jakthespire.TheSidekick;
import org.apache.commons.lang3.math.NumberUtils;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.thornDmg;

public class ReflectiveLens extends AbstractEasyRelic implements BetterOnLoseHpRelic {
    public static final String ID = makeID("ReflectiveLens");

    public ReflectiveLens() {
        super(ID, RelicTier.RARE, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

    public int betterOnLoseHp(DamageInfo info, int Amount) {
        if (info.owner != AbstractDungeon.player && info.owner != null && AbstractDungeon.actionManager.turnHasEnded && info.type == DamageInfo.DamageType.NORMAL && Amount > 0 && this.counter < 1) {
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            this.counter++;
            thornDmg(info.owner, Amount);
            return 0;
        } else {
            return Amount;
        }
    }

    public void onVictory() {
        this.counter = 0;
    }
}
