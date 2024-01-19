package jakthespire.cards.starter;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.red.Uppercut;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.cards.created.GroundSlam;
import jakthespire.cards.created.UpperCut;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class Punch extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("Punch");
    // intellij stuff ATTACK, ENEMY, BASIC, 6, 3, , , , 

    public Punch() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 6;
        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return cardCount(Jump.ID) < 4;
    }

    public void triggerWhenDrawn() {
        cardsToPreview = null;
        rawDescription = cardStrings.DESCRIPTION;
        if (cardPlayed(1).equals(Jump.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(1)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(UpperCut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(2)) {
                groundslam.upgrade();
            } if (cardPlayedUpped(3)) {
                groundslam.upgrade();
            }
            groundslam.upgrade();
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(Uppercut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(1)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(Roll.ID)) {
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            } if (cardPlayedUpped(1)) {
                uppercut.upgrade();
            }
            cardsToPreview = uppercut;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
        }
        initializeDescription();
    }

    public void triggerOnOtherCardPlayed(AbstractCard c) {
        cardsToPreview = null;
        rawDescription = cardStrings.DESCRIPTION;
        if (cardPlayed(1).equals(Jump.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(1)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(UpperCut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(2)) {
                groundslam.upgrade();
            } if (cardPlayedUpped(3)) {
                groundslam.upgrade();
            }
            groundslam.upgrade();
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(Uppercut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(1)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        } else if (cardPlayed(1).equals(Roll.ID)) {
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            } if (cardPlayedUpped(1)) {
                uppercut.upgrade();
            }
            cardsToPreview = uppercut;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
        }
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        cardsToPreview = null;
        rawDescription = cardStrings.DESCRIPTION;
        if (cardPlayed(2).equals(Jump.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(2)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
            if (!m.isDying && !m.isDead) {
                queueCardTop(groundslam, m);
            } else {
                AbstractMonster ran = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                queueCardTop(groundslam, ran);
            }
        } else if (cardPlayed(2).equals(UpperCut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(3)) {
                groundslam.upgrade();
            } if (cardPlayedUpped(4)) {
                groundslam.upgrade();
            }
            groundslam.upgrade();
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
            if (!m.isDying && !m.isDead) {
                queueCardTop(groundslam, m);
            } else {
                AbstractMonster ran = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                queueCardTop(groundslam, ran);
            }
        } else if (cardPlayed(2).equals(Uppercut.ID)) {
            GroundSlam groundslam = new GroundSlam();
            if (upgraded) {
                groundslam.upgrade();
            } if (cardPlayedUpped(2)) {
                groundslam.upgrade();
            }
            cardsToPreview = groundslam;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
            if (!m.isDying && !m.isDead) {
                queueCardTop(groundslam, m);
            } else {
                AbstractMonster ran = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                queueCardTop(groundslam, ran);
            }
        } else if (cardPlayed(2).equals(Roll.ID)) {
            UpperCut uppercut = new UpperCut();
            if (upgraded) {
                uppercut.upgrade();
            } if (cardPlayedUpped(2)) {
                uppercut.upgrade();
            }
            cardsToPreview = uppercut;
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[1];
            if (!m.isDying && !m.isDead) {
                queueCardTop(uppercut, m);
            } else {
                AbstractMonster ran = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                queueCardTop(uppercut, ran);
            }
        }
        initializeDescription();
        dmg(m,AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }

    public void upp() {
        upgradeDamage(3);
    }
}