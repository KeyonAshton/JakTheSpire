package jakthespire.cards.starter;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class SpinKick extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("SpinKick");
    // intellij stuff ATTACK, ALL_ENEMY, BASIC, 3, 1, , , 2, 1

    public SpinKick() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = 3;
        baseMagicNumber = magicNumber = 2;
        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return cardCount(Jump.ID) < 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmgRan(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        dmgRan(AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        if (upgraded) {
            dmgRan(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        }
    }

    public void upp() {
        upgradeDamage(1);
        upgradeMagicNumber(1);
    }
}