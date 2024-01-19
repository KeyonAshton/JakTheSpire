package jakthespire.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.ShopRoom;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class PrecursorEgg extends AbstractEasyRelic implements ClickableRelic {
    public static final String ID = makeID("PrecursorEgg");

    public PrecursorEgg() {
        super(ID, RelicTier.COMMON, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

    public void onVictory() {
        this.counter++;
    }

    public void justEnteredRoom(AbstractRoom room) {
        if (room instanceof ShopRoom) {
            this.flash();
        }
    }

    public void onRightClick() {
        if (AbstractDungeon.getCurrRoom() instanceof ShopRoom) {
            int a = 3;
            for(int i = this.counter; i < 10; i =- 10) {
                a = a + 1;
            }
            AbstractDungeon.player.gainGold(this.counter * a);
            this.counter = 0;
            this.flash();
        }
    }
}
