package jakthespire.relics;

import jakthespire.TheSidekick;

import static jakthespire.ModFile.makeID;

public class MarSealPiece extends AbstractEasyRelic {
    public static final String ID = makeID("MarSealPiece");

    public MarSealPiece() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheSidekick.Enums.MAR_COLOR);
        this.counter = 0;
    }

}
