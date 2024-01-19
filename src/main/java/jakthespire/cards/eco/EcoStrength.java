package jakthespire.cards.eco;

import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.powers.eco.RedEco;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class EcoStrength extends AbstractEasyCard {
    public final static String ID = makeID("EcoStrength");
    // intellij stuff SKILL, SELF, RARE, , , , , , 

    public EcoStrength() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        keywords.add("${ModID}:Red_Eco");
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        applyToSelf(new StrengthPower(p, p.getPower(RedEco.getID).amount));
        applyToSelf(new LoseStrengthPower(p, p.getPower(RedEco.getID).amount));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return pwrAmt(p, RedEco.getID) >= 1;
    }

    public void upp() {
        upgradeBaseCost(2);
    }
}