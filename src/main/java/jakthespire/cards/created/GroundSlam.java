package jakthespire.cards.created;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

@AutoAdd.Ignore
public class GroundSlam extends AbstractEasyCard {
    public final static String ID = makeID("GroundSlam");
    // intellij stuff POWER, ENEMY, SPECIAL, 4, 2, , , , 

    public GroundSlam() {
        super(ID, -2, CardType.POWER, CardRarity.SPECIAL, CardTarget.ENEMY);
        baseDamage = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }

    @Override
    public boolean canUpgrade() {
        if (this.type == AbstractCard.CardType.CURSE) {
            return false;
        } else if (this.type == AbstractCard.CardType.STATUS) {
            return false;
        } else {
            return timesUpgraded < 3;
        }
    }

    public void upp() {
        upgradeDamage(2);
    }
}