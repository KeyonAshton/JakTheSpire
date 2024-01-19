package jakthespire.relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class PowerCell extends AbstractEasyRelic {
    public static final String ID = makeID("PowerCell");

    public PowerCell() {
        super(ID, RelicTier.BOSS, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

    public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
    }
}
