package jakthespire.cards.combos;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.TheBomb;
import com.megacrit.cardcrawl.cards.red.Uppercut;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.cards.created.GroundSlam;
import jakthespire.cards.created.UpperCut;
import jakthespire.cards.starter.Jump;
import jakthespire.cards.starter.Roll;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class PlasmiteBomb extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("PlasmiteBomb");
    // intellij stuff ATTACK, ENEMY, BASIC, 6, 3, , , ,

    public PlasmiteBomb() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 3;
        baseMagicNumber = magicNumber = 1;
        baseSecondMagic = secondMagic = 0;
        rawDescription = cardStrings.DESCRIPTION;
    }

    public void triggerWhenDrawn() {
        damage = baseDamage;
        secondMagic = 0;
        for(int i = 1; cardPlayed(i).equals(PlasmiteBomb.ID) || cardPlayed(i).equals(TheBomb.ID) || cardPlayed(i).equals(DarkEcoBox.ID) || cardPlayed(i).equals(DarkEcoCrate.ID); i++) {
            if (cardPlayed(i).equals(PlasmiteBomb.ID)) {
                damage += magicNumber;
                secondMagic++;
            }
        }
        rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0] + secondMagic + cardStrings.EXTENDED_DESCRIPTION[1];
        initializeDescription();
    }

    public void triggerOnOtherCardPlayed(AbstractCard c) {
        damage = baseDamage;
        secondMagic = 0;
        if(cardPlayed(1).equals(PlasmiteBomb.ID)) {
            damage += magicNumber;
            secondMagic++;
        } else if (!cardPlayed(1).equals(TheBomb.ID) || !cardPlayed(1).equals(DarkEcoBox.ID) || !cardPlayed(1).equals(DarkEcoCrate.ID)) {
            damage = baseDamage;
        }
        rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0] + secondMagic + cardStrings.EXTENDED_DESCRIPTION[1];
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        damage = baseDamage;
        secondMagic = 0;
        for(int i = 2; cardPlayed(i).equals(PlasmiteBomb.ID) || cardPlayed(i).equals(TheBomb.ID) || cardPlayed(i).equals(DarkEcoBox.ID) || cardPlayed(i).equals(DarkEcoCrate.ID); i++) {
            if (cardPlayed(i).equals(PlasmiteBomb.ID)) {
                damage += magicNumber;
                secondMagic++;
            }
        }
        rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0] + secondMagic + cardStrings.EXTENDED_DESCRIPTION[1];
        initializeDescription();
        allDmg(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }

    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(1);
    }
}