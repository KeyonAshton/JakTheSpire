package jakthespire.cards.eco;

import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.powers.eco.BlueEco;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class EcoDraw extends AbstractEasyCard {
    public final static String ID = makeID("EcoDraw");
    // intellij stuff skill, self, uncommon, , , , , 0, 1

    public EcoDraw() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 0;
        rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        keywords.add("${ModID}:Blue_Eco");
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDrawPileToHandAction(pwrAmt(p, BlueEco.getID) / 2 + this.magicNumber));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return pwrAmt(p, BlueEco.getID) >= 2;
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1] + cardStrings.EXTENDED_DESCRIPTION[0];
            upgradeMagicNumber(1);
            upgraded = true;
            initializeDescription();
        }
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}