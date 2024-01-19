package jakthespire.cards.combos;

import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class DarkEcoCrate extends AbstractEasyCard {
    public final static String ID = makeID("DarkEcoCrate");
    // intellij stuff attack, enemy, common, 5, 2, , , , 

    public DarkEcoCrate() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
        upgradeDamage(2);
    }
}