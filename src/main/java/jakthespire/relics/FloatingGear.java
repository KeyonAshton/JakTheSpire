package jakthespire.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class FloatingGear extends AbstractEasyRelic {
    public static final String ID = makeID("FloatingGear");

    public FloatingGear() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

}
