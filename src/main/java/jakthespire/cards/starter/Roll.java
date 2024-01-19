package jakthespire.cards.starter;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.AbstractEasyCard;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.Wiz.*;

public class Roll extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("Roll");
    // intellij stuff SKILL, SELF, BASIC, , , 5, 3, , 

    public Roll() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return cardCount(Jump.ID) < 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    public void upp() {
        upgradeBlock(3);
    }
}