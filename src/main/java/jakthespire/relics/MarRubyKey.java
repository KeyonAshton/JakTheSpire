package jakthespire.relics;

import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class MarRubyKey extends AbstractEasyRelic {
    public static final String ID = makeID("MarRubyKey");

    public MarRubyKey() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

}
