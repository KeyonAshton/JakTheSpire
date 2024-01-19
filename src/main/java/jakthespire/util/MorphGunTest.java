package jakthespire.util;

import jakthespire.powers.morphgun.red.*;
import jakthespire.powers.morphgun.blue.*;
import jakthespire.powers.morphgun.purple.*;
import jakthespire.powers.morphgun.yellow.*;

import static jakthespire.util.Wiz.adp;
import static jakthespire.util.Wiz.pwrAmt;

public class MorphGunTest {

    public int getMorphGunAmmo(String color) {
        switch (color) {
            case "Red":
                return pwrAmt(adp(), RedAmmo.getID);
            case "Yellow":
                return pwrAmt(adp(), YellowAmmo.getID);
            case "Blue":
                return pwrAmt(adp(), BlueAmmo.getID);
            case "Purple":
                return pwrAmt(adp(), PurpleAmmo.getID);
            default:
                return 0;
        }
    }

    public String getMorphGunMode() {
        if (pwrAmt(adp(), ScatterGun.getID) > 0) {
            return "R1";
        } else if (pwrAmt(adp(), Blaster.getID) > 0) {
            return "Y1";
        } else if (pwrAmt(adp(), VulcanFury.getID) > 0) {
            return "B1";
        } else if (pwrAmt(adp(), PeaceMaker.getID) > 0) {
            return "P1";
        } else if (pwrAmt(adp(), WaveConcussor.getID) > 0) {
            return "R2";
        } else if (pwrAmt(adp(), BeamReflexor.getID) > 0) {
            return "Y2";
        } else if (pwrAmt(adp(), ArcWielder.getID) > 0) {
            return "B2";
        } else if (pwrAmt(adp(), SuperNova.getID) > 0) {
            return "P2";
        }
        return "null";
    }

    public boolean canMorphGunFire() {
        String d = getMorphGunMode();
        switch (d) {
            case "R1": case "R2":
                return getMorphGunAmmo("Red") > 0;
            case "Y1": case "Y2":
                return getMorphGunAmmo("Yellow") > 0;
            case "B1": case "B2":
                return getMorphGunAmmo("Blue") > 0;
            case "P1": case "P2":
                return getMorphGunAmmo("Purple") > 0;
            default:
                return false;
        }
    }

}
