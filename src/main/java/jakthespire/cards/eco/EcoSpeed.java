package jakthespire.cards.eco;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.powers.eco.BlueEco;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.pwrAmt;

public class EcoSpeed extends AbstractEasyCard {
    public final static String ID = makeID("EcoSpeed");
    // intellij stuff skill, self, uncommon, , , , , 0, 1

    public EcoSpeed() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 0;
        rawDescription = cardStrings.DESCRIPTION;
        keywords.add("${ModID}:Blue_Eco");
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(p, pwrAmt(p, BlueEco.getID)));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return pwrAmt(p, BlueEco.getID) >= 1;
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(0);
            upgraded = true;
        }
    }

    public void upp() {
    }
}