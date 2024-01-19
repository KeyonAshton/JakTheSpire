package jakthespire.cards.eco.base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.powers.eco.BlueEco;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.adp;
import static jakthespire.util.Wiz.pwrAmt;

public class BlueEcoCard extends AbstractEasyCard {
    public final static String ID = makeID("YellowEco");
    // intellij stuff skill, self, uncommon, , , , , 1, 1

    public BlueEcoCard() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(pwrAmt(p, BlueEco.getID) < 4) {
            this.addToBot(new ApplyPowerAction(p, p, new BlueEco(p, magicNumber), magicNumber));
        } else if(pwrAmt(p, BlueEco.getID) == 4) {
            this.addToBot(new ApplyPowerAction(p, p, new BlueEco(p, 1), 1));
        }
    }

    public boolean cardPlayable(AbstractMonster m) {
        return pwrAmt(adp(), BlueEco.getID) < 5;
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}