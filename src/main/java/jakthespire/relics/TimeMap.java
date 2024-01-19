package jakthespire.relics;

import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class TimeMap extends AbstractEasyRelic {
    public static final String ID = makeID("TimeMap");

    public TimeMap() {
        super(ID, RelicTier.RARE, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 2;
    }

    public void setCounter(int setCounter) {
        this.counter = setCounter;
        if (this.counter == -3) {
            this.usedUp();
            this.counter = -3;
        }

    }

    public boolean canSpawn() {
        return Settings.isEndless || AbstractDungeon.floorNum <= 40;
    }

    public void onVictory() {
        if (AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss) {
            this.counter = 2;
        }
    }

}
