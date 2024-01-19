package jakthespire.cards.created;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;

@AutoAdd.Ignore
public class WastelanderSpin extends AbstractEasyCard {
    public final static String ID = makeID("WastelanderSpin");
    // intellij stuff POWER, ALL_ENEMY, SPECIAL, 3, , , , 1, 1

    public WastelanderSpin() {
        super(ID, -2, CardType.POWER, CardRarity.SPECIAL, CardTarget.ENEMY);
        baseDamage = 2;
        baseMagicNumber = magicNumber = 1;
        exhaust = true;
    }

    public WastelanderSpin(int dmg) {
        super(ID, -2, CardType.POWER, CardRarity.SPECIAL, CardTarget.ENEMY);
        baseDamage = dmg/2;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            dmgRan(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        }
    }

    @Override
    public boolean canUpgrade() {
        if (this.type == AbstractCard.CardType.CURSE) {
            return false;
        } else if (this.type == AbstractCard.CardType.STATUS) {
            return false;
        } else {
            return timesUpgraded < 2;
        }
    }

    public void upp() {
        upgradeMagicNumber(1);
        timesUpgraded += 1;
    }
}