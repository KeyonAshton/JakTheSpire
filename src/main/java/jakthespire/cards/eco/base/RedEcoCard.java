package jakthespire.cards.eco.base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.powers.eco.RedEco;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.adp;
import static jakthespire.util.Wiz.pwrAmt;

public class RedEcoCard extends AbstractEasyCard {
    public final static String ID = makeID("YellowEco");
    // intellij stuff skill, self, uncommon, , , , , 1, 1

    public RedEcoCard() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(pwrAmt(p, RedEco.getID) < 4) {
            this.addToBot(new ApplyPowerAction(p, p, new RedEco(p, magicNumber), magicNumber));
        } else if(pwrAmt(p, RedEco.getID) == 4) {
            this.addToBot(new ApplyPowerAction(p, p, new RedEco(p, 1), 1));
        }
    }

    public boolean cardPlayable(AbstractMonster m) {
        return pwrAmt(adp(), RedEco.getID) < 5;
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}