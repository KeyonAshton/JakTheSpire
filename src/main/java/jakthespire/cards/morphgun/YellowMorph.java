package jakthespire.cards.morphgun;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;
import jakthespire.powers.morphgun.blue.ArcWielder;
import jakthespire.powers.morphgun.blue.VulcanFury;
import jakthespire.powers.morphgun.purple.PeaceMaker;
import jakthespire.powers.morphgun.purple.SuperNova;
import jakthespire.powers.morphgun.red.ScatterGun;
import jakthespire.powers.morphgun.red.WaveConcussor;
import jakthespire.powers.morphgun.yellow.BeamReflexor;
import jakthespire.powers.morphgun.yellow.Blaster;
import jakthespire.powers.morphgun.yellow.YellowAmmo;
import jakthespire.util.MorphGunTest;

import static jakthespire.ModFile.makeID;
import static jakthespire.powers.morphgun.Ammo.ammoMax;
import static jakthespire.util.Wiz.*;

public class YellowMorph extends AbstractEasyCard {
    public final static String ID = makeID("YellowMorph");
    // intellij stuff SKILL, SELF, UNCOMMON, , , , , 1, 1

    public YellowMorph() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 1;
        rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0] + 3 + cardStrings.EXTENDED_DESCRIPTION[3];
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        switch (new MorphGunTest().getMorphGunMode()) {
            case "R1":
                removeFromSelf(ScatterGun.getID);
                break;
            case "Y1":
                if (timesUpgraded == 0) {
                    removeFromSelf(Blaster.getID);
                }
                break;
            case "B1":
                removeFromSelf(VulcanFury.getID);
                break;
            case "P1":
                removeFromSelf(PeaceMaker.getID);
                break;
            case "R2":
                removeFromSelf(WaveConcussor.getID);
                break;
            case "Y2":
                if (timesUpgraded > 0) {
                    removeFromSelf(BeamReflexor.getID);
                }
                break;
            case "B2":
                removeFromSelf(ArcWielder.getID);
                break;
            case "P2":
                removeFromSelf(SuperNova.getID);
                break;
        }
        if (pwrAmt(p, YellowAmmo.getID) < ammoMax) {
            applyToSelf(new YellowAmmo(p, magicNumber));
            while (pwrAmt(p, YellowAmmo.getID) < ammoMax) {
                applyToSelf(new YellowAmmo(p, -1));
            }
        }
        if (timesUpgraded > 0) {
            applyToSelf(new BeamReflexor(p, 1));
        } else {
            applyToSelf(new Blaster(p, 1));
        }
    }

    @Override
    public void upgrade() {
        switch (timesUpgraded) {
            case 0:
                name = cardStrings.EXTENDED_DESCRIPTION[1];
                rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[2] + 2 + cardStrings.EXTENDED_DESCRIPTION[3];
                break;
            case 1:
                rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[2] + 1 + cardStrings.EXTENDED_DESCRIPTION[3];
                upgradeMagicNumber(1);
                break;
            case 2:
                name = cardStrings.EXTENDED_DESCRIPTION[1];
                rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[4];
                upgraded = true;
                isInnate = true;
                break;
            default:
                name = "Broken";
                rawDescription = "How";
        }
        initializeDescription();
    }

    @Override
    public void upp() {
    }
}