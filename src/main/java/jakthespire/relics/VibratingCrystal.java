package jakthespire.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class VibratingCrystal extends AbstractEasyRelic {
    public static final String ID = makeID("VibratingCrystal");

    private int a;

    public VibratingCrystal() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
        a = 0;
    }

    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        if (a == 0 && targetCard.type == AbstractCard.CardType.ATTACK && this.counter <= AbstractDungeon.floorNum/2) {
            this.counter++;
        }
    }
    public void atTurnStart() {
        a = 1;
    }

    public void onPlayerEndTurn() {
        a = 0;
    }

    public int onAttackToChangeDamage(DamageInfo info, int damageAmount) {
        if (a == 1) {
            this.flash();
            this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            return damageAmount + a;
        } else {
            return damageAmount;
        }
    }

}
