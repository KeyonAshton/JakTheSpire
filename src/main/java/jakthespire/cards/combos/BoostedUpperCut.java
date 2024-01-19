package jakthespire.cards.combos;

import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class BoostedUpperCut extends AbstractEasyCard {
    public final static String ID = makeID("BoostedUpperCut");
    // intellij stuff attack, all, common, 6, 1, , , 2, 1

    public BoostedUpperCut() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = 6;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
        upgradeDamage(1);
        upgradeMagicNumber(1);
    }
}