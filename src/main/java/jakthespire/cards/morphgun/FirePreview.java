package jakthespire.cards.morphgun;

import basemod.AutoAdd;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

@AutoAdd.Ignore
public class FirePreview extends AbstractEasyCard {
    public final static String ID = makeID("FirePreview");
    // intellij stuff ATTACK, ENEMY, SPECIAL, , , , , , 


    public FirePreview() {
        super(ID, -2, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL_ENEMY); //Pass the required information to the BaseCard constructor.
        baseDamage = 3;
        baseMagicNumber = 1;
    }

    public FirePreview(int a) {
        super(ID, -2, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL_ENEMY); //Pass the required information to the BaseCard constructor.
        baseDamage = 3;
        baseMagicNumber = 1;
        switch (a) {
            case 0:
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                break;
            case 1:
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[1];
                break;
            case 2:
                damage = baseDamage + 2;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                break;
            case 3:
                damage = baseDamage + 2;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[3];
                break;
            case 4:
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[4];
                break;
            case 5:
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[5];
                break;
            case 6:
                damage = baseDamage * 3;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[6];
                break;
            case 7:
                damage = baseDamage * 5;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[7];
                break;
        }
        initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
    }
}