package de.roskenet.poker;

public class PokerHand {

    private String hand;
    private int probability;
    private boolean accurate = true;
    private String handRating;

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public boolean isAccurate() {
        return accurate;
    }

    public void setAccurate(boolean accurate) {
        this.accurate = accurate;
    }
    public String getHandRating() {
        return handRating;
    }

    public void setHandRating(String hr) {
        this.handRating = hr;
    }
}
