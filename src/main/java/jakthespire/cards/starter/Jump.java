package jakthespire.cards.starter;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.created.UpperCut;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class Jump extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("Jump");
    // intellij stuff SKILL, SELF, BASIC, 1, , 4, 3, 3, 1

    public Jump() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ALL);
        baseDamage = 1;
        baseBlock = 4;
        baseMagicNumber = magicNumber = 3;
        tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return cardCount(Jump.ID) < 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        name = cardStrings.NAME;
        rawDescription = cardStrings.DESCRIPTION;
        cardsToPreview = null;
        if (cardPlayed(2).equals(Jump.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[0];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
            block = baseBlock + magicNumber;
        } else if (cardPlayed(2).equals(Roll.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[2];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[3];
            this.cardsToPreview = null;
            dmgRan(AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        } else if (cardPlayed(2).equals(Punch.ID)) {
            name = cardStrings.NAME;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[4];
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            }
            if (cardPlayedUpped(2)) {
                uppercut.upgrade();
            }
            AbstractMonster ran = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            queueCardTop(uppercut, ran);
            cardsToPreview = uppercut;
        }
        initializeDescription();
        blck();
    }

    public void triggerWhenDrawn() {
        name = cardStrings.NAME;
        rawDescription = cardStrings.DESCRIPTION;
        cardsToPreview = null;
        if (cardPlayed(1).equals(Jump.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[0];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
        } else if (cardPlayed(1).equals(Roll.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[2];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[3];
            this.cardsToPreview = null;
        } else if (cardPlayed(1).equals(Punch.ID)) {
            name = cardStrings.NAME;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[4];
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            } if (cardPlayedUpped(1)) {
                uppercut.upgrade();
            }
            cardsToPreview = uppercut;
        }
        initializeDescription();
    }

    public void triggerOnOtherCardPlayed(AbstractCard c) {
        name = cardStrings.NAME;
        rawDescription = cardStrings.DESCRIPTION;
        cardsToPreview = null;
        if (cardPlayed(1).equals(Jump.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[0];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
        } else if (cardPlayed(1).equals(Roll.ID)) {
            name = cardStrings.EXTENDED_DESCRIPTION[2];
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[3];
            this.cardsToPreview = null;
        } else if (cardPlayed(1).equals(Punch.ID)) {
            name = cardStrings.NAME;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[4];
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            } if (cardPlayedUpped(1)) {
                uppercut.upgrade();
            }
            cardsToPreview = uppercut;
        }
        initializeDescription();
    }

    public void upp() {
        upgradeBlock(3);
        upgradeMagicNumber(1);
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        this.damage = this.baseDamage;
    }
}