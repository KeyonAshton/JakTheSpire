package jakthespire.relics;

import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class MarSeal extends AbstractEasyRelic {
    public static final String ID = makeID("MarSeal");

    public MarSeal() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

}
