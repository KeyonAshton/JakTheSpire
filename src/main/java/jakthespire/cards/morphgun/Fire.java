package jakthespire.cards.morphgun;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.WeakPower;
import jakthespire.cards.AbstractEasyCard;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import jakthespire.cards.created.WastelanderPunch;
import jakthespire.cards.created.WastelanderSpin;
import jakthespire.cards.starter.Jump;
import jakthespire.cards.starter.Punch;
import jakthespire.cards.starter.SpinKick;
import jakthespire.powers.morphgun.blue.BlueAmmo;
import jakthespire.powers.morphgun.purple.PurpleAmmo;
import jakthespire.powers.morphgun.red.RedAmmo;
import jakthespire.powers.morphgun.yellow.YellowAmmo;
import jakthespire.util.MorphGunTest;

import java.util.ArrayList;

import static jakthespire.ModFile.makeID;
import static jakthespire.util.CustomTags.TAG_AMMO;
import static jakthespire.util.Wiz.*;

public class Fire extends AbstractEasyCard implements SpawnModificationCard {
    public final static String ID = makeID("Fire");
    // intellij stuff ATTACK, ENEMY, UNCOMMON, 3, , , , 1,
    private float rotationTimer = 0;
    private int previewIndex;
    protected ArrayList<AbstractCard> cyclePreviewCards = new ArrayList<>();

    public Fire() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 3;
        baseMagicNumber = magicNumber = 1;
        rawDescription = cardStrings.DESCRIPTION;
        firePreviews();
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        for(AbstractCard c : AbstractDungeon.player.masterDeck.group) {
            if (c.cardID.equals(BlueMorph.ID) || c.cardID.equals(RedMorph.ID) || c.cardID.equals(PurpleMorph.ID) || c.cardID.equals(YellowMorph.ID)) {
                return true;
            }
        }
        return false;
    }

    public void upp() {
        upgradeDamage(3);
    }

    //Update override handles swapping
    @Override
    public void update() {
        super.update();
        if (!cyclePreviewCards.isEmpty()) {
            if (hb.hovered) {
                if (rotationTimer <= 0F) {
                    rotationTimer = 2.5f;
                    cardsToPreview = cyclePreviewCards.get(previewIndex);
                    if (previewIndex == cyclePreviewCards.size() - 1) {
                        previewIndex = 0;
                    } else {
                        previewIndex++;
                    }
                } else {
                    rotationTimer -= Gdx.graphics.getDeltaTime();
                }
            }
        }
    }

    private void firePreviews() {
        FirePreview a = new FirePreview(0);
        FirePreview b = new FirePreview(1);
        FirePreview c = new FirePreview(2);
        FirePreview d = new FirePreview(3);
        FirePreview e = new FirePreview(4);
        FirePreview f = new FirePreview(5);
        FirePreview g = new FirePreview(6);
        FirePreview h = new FirePreview(7);
        if (this.upgraded) {
            a.upgrade();
            b.upgrade();
            c.upgrade();
            d.upgrade();
            e.upgrade();
            f.upgrade();
            g.upgrade();
            h.upgrade();
        }
        cyclePreviewCards.add(a);
        cyclePreviewCards.add(b);
        cyclePreviewCards.add(c);
        cyclePreviewCards.add(d);
        cyclePreviewCards.add(e);
        cyclePreviewCards.add(f);
        cyclePreviewCards.add(g);
        cyclePreviewCards.add(h);
    }

    public void triggerWhenDrawn() {
        String test = new MorphGunTest().getMorphGunMode();
        switch (test) {
            case "R1":
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                break;
            case "Y1":
                damage = baseDamage + 2;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                    WastelanderSpin spin = new WastelanderSpin(damage);
                    if (cardPlayedUpped(1)) {
                        spin.upgrade();
                    }
                    if (cardPlayedUpped(2)) {
                        spin.upgrade();
                    }
                    if (upgraded) {
                        spin.upgrade();
                    }
                    cardsToPreview = spin;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                }else if (cardPlayed(1).equals(Punch.ID)) {
                    WastelanderPunch punch = new WastelanderPunch(damage);
                    if (cardPlayedUpped(1)) {
                        punch.upgrade();
                    }
                    if (upgraded) {
                        punch.upgrade();
                    }
                    cardsToPreview = punch;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                }
                target = CardTarget.ENEMY;
                cyclePreviewCards.clear();
                break;
            case "B1":
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[3];
                cyclePreviewCards.clear();
                break;
            case "P1":
                damage = baseDamage * 3;
                target = CardTarget.ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[5];
                cyclePreviewCards.clear();
                break;
            case "R2":
                damage = baseDamage + 3;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                break;
            case "Y2":
                damage = baseDamage + 6;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                    WastelanderSpin spin = new WastelanderSpin(damage);
                    if (cardPlayedUpped(1)) {
                        spin.upgrade();
                    }
                    if (cardPlayedUpped(2)) {
                        spin.upgrade();
                    }
                    if (upgraded) {
                        spin.upgrade();
                    }
                    cardsToPreview = spin;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                }else if (cardPlayed(1).equals(Punch.ID)) {
                    WastelanderPunch punch = new WastelanderPunch(damage);
                    if (cardPlayedUpped(1)) {
                        punch.upgrade();
                    }
                    if (upgraded) {
                        punch.upgrade();
                    }
                    cardsToPreview = punch;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                }
                target = CardTarget.ENEMY;
                cyclePreviewCards.clear();
                break;
            case "B2":
                damage = baseDamage + 2;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[4];
                cyclePreviewCards.clear();
                break;
            case "P2":
                damage = baseDamage * 5;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                break;
            default:
                firePreviews();
                break;
        }
        initializeDescription();
    }

    public void triggerOnOtherCardPlayed(AbstractCard c) {
        if (c.hasTag(TAG_AMMO)) {
            String test = new MorphGunTest().getMorphGunMode();
            switch (test) {
                case "R1":
                    target = CardTarget.ALL_ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                    cyclePreviewCards.clear();
                    break;
                case "Y1":
                    damage = baseDamage + 2;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                    if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                        WastelanderSpin spin = new WastelanderSpin(damage);
                        if (cardPlayedUpped(1)) {
                            spin.upgrade();
                        }
                        if (cardPlayedUpped(2)) {
                            spin.upgrade();
                        }
                        if (upgraded) {
                            spin.upgrade();
                        }
                        cardsToPreview = spin;
                        rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                    } else if (cardPlayed(1).equals(Punch.ID)) {
                        WastelanderPunch punch = new WastelanderPunch(damage);
                        if (cardPlayedUpped(1)) {
                            punch.upgrade();
                        }
                        if (upgraded) {
                            punch.upgrade();
                        }
                        cardsToPreview = punch;
                        rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                    }
                    target = CardTarget.ENEMY;
                    cyclePreviewCards.clear();
                    break;
                case "B1":
                    target = CardTarget.ALL_ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[3];
                    cyclePreviewCards.clear();
                    break;
                case "P1":
                    damage = baseDamage * 3;
                    target = CardTarget.ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[5];
                    cyclePreviewCards.clear();
                    break;
                case "R2":
                    damage = baseDamage + 3;
                    target = CardTarget.ALL_ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                    cyclePreviewCards.clear();
                    break;
                case "Y2":
                    damage = baseDamage + 6;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                    if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                        WastelanderSpin spin = new WastelanderSpin(damage);
                        if (cardPlayedUpped(1)) {
                            spin.upgrade();
                        }
                        if (cardPlayedUpped(2)) {
                            spin.upgrade();
                        }
                        if (upgraded) {
                            spin.upgrade();
                        }
                        cardsToPreview = spin;
                        rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                    } else if (cardPlayed(1).equals(Punch.ID)) {
                        WastelanderPunch punch = new WastelanderPunch(damage);
                        if (cardPlayedUpped(1)) {
                            punch.upgrade();
                        }
                        if (upgraded) {
                            punch.upgrade();
                        }
                        cardsToPreview = punch;
                        rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                    }
                    target = CardTarget.ENEMY;
                    cyclePreviewCards.clear();
                    break;
                case "B2":
                    damage = baseDamage + 2;
                    target = CardTarget.ALL_ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[4];
                    cyclePreviewCards.clear();
                    break;
                case "P2":
                    damage = baseDamage * 5;
                    target = CardTarget.ALL_ENEMY;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                    cyclePreviewCards.clear();
                    break;
                default:
                    firePreviews();
                    break;
            }
            initializeDescription();
        }
    }

    public boolean cardPlayable(AbstractMonster m) {
        if ((this.target != AbstractCard.CardTarget.ENEMY && this.target != AbstractCard.CardTarget.SELF_AND_ENEMY || m == null || !m.isDying) && !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            return new MorphGunTest().canMorphGunFire();
        } else {
            this.cantUseMessage = null;
            return false;
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        String test = new MorphGunTest().getMorphGunMode();
        switch (test) {
            case "R1":
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, RedAmmo.getID, 1));
                if (pwrAmt(p, RedAmmo.getID) == 0) {
                    removeFromSelf(RedAmmo.getID);
                }
                break;
            case "Y1":
                damage = baseDamage + 2;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                magicNumber = baseMagicNumber;
                if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                    WastelanderSpin spin = new WastelanderSpin(damage);
                    if (cardPlayedUpped(1)) {
                        magicNumber++;
                        spin.upgrade();
                    }
                    if (cardPlayedUpped(2)) {
                        magicNumber++;
                        spin.upgrade();
                    }
                    if (upgraded) {
                        magicNumber++;
                        spin.upgrade();
                    }
                    spin.magicNumber = magicNumber;
                    att(new NewQueueCardAction(spin, m, true, true));
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                }else if (cardPlayed(1).equals(Punch.ID)) {
                    WastelanderPunch punch = new WastelanderPunch(damage);
                    if (cardPlayedUpped(1)) {
                        punch.upgrade();
                    }
                    if (upgraded) {
                        punch.upgrade();
                    }
                    att(new NewQueueCardAction(punch, m, true, true));
                    cardsToPreview = punch;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                }
                target = CardTarget.ENEMY;
                cyclePreviewCards.clear();
                dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, YellowAmmo.getID, 1));
                if (pwrAmt(p, YellowAmmo.getID) == 0) {
                    removeFromSelf(YellowAmmo.getID);
                }
                break;
            case "B1":
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[3];
                cyclePreviewCards.clear();
                dmgRan(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                dmgRan(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                dmgRan(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, BlueAmmo.getID, 1));
                if (pwrAmt(p, BlueAmmo.getID) == 0) {
                    removeFromSelf(BlueAmmo.getID);
                }
                break;
            case "P1":
                damage = baseDamage * 3;
                target = CardTarget.ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[5];
                cyclePreviewCards.clear();
                dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, PurpleAmmo.getID, 1));
                if (pwrAmt(p, PurpleAmmo.getID) == 0) {
                    removeFromSelf(PurpleAmmo.getID);
                }
                break;
            case "R2":
                damage = baseDamage + 3;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, RedAmmo.getID, 1));
                if (pwrAmt(p, RedAmmo.getID) == 0) {
                    removeFromSelf(RedAmmo.getID);
                }
                break;
            case "Y2":
                damage = baseDamage + 3;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[2];
                if (cardPlayed(1).equals(SpinKick.ID) && cardPlayed(2).equals(Jump.ID)) {
                    WastelanderSpin spin = new WastelanderSpin(damage);
                    if (cardPlayedUpped(1)) {
                        spin.upgrade();
                    }
                    if (cardPlayedUpped(2)) {
                        spin.upgrade();
                    }
                    if (upgraded) {
                        spin.upgrade();
                    }
                    att(new NewQueueCardAction(spin, m, true, true));
                    cardsToPreview = spin;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[7];
                }else if (cardPlayed(1).equals(Punch.ID)) {
                    WastelanderPunch punch = new WastelanderPunch(damage);
                    if (cardPlayedUpped(1)) {
                        punch.upgrade();
                    }
                    if (upgraded) {
                        punch.upgrade();
                    }
                    att(new NewQueueCardAction(punch, m, true, true));
                    cardsToPreview = punch;
                    rawDescription = cardStrings.EXTENDED_DESCRIPTION[2] + cardStrings.EXTENDED_DESCRIPTION[6];
                }
                target = CardTarget.ENEMY;
                cyclePreviewCards.clear();
                dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                dmgRan(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, YellowAmmo.getID, 1));
                if (pwrAmt(p, YellowAmmo.getID) == 0) {
                    removeFromSelf(YellowAmmo.getID);
                }
                break;
            case "B2":
                damage = baseDamage + 2;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[4];
                cyclePreviewCards.clear();
                atb(new ReducePowerAction(p, p, BlueAmmo.getID, 1));
                if (pwrAmt(p, BlueAmmo.getID) == 0) {
                    removeFromSelf(BlueAmmo.getID);
                }
                AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                AbstractMonster randomMonster1 = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                AbstractMonster randomMonster2 = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                dmg(randomMonster, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                applyToEnemy(randomMonster, new WeakPower(randomMonster, 1, true));
                dmg(randomMonster1, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                applyToEnemy(randomMonster1, new WeakPower(randomMonster1, 1, true));
                dmg(randomMonster2, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                applyToEnemy(randomMonster2, new WeakPower(randomMonster2, 1, true));
                break;
            case "P2":
                damage = baseDamage * 5;
                target = CardTarget.ALL_ENEMY;
                rawDescription = cardStrings.EXTENDED_DESCRIPTION[0];
                cyclePreviewCards.clear();
                allDmg(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
                atb(new ReducePowerAction(p, p, PurpleAmmo.getID, 1));
                if (pwrAmt(p, PurpleAmmo.getID) == 0) {
                    removeFromSelf(PurpleAmmo.getID);
                }
                break;
            default:
                rawDescription = cardStrings.DESCRIPTION;
                firePreviews();
                break;
        }
        initializeDescription();
    }

}