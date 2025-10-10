package entity;

public class Bird extends Animal{
    private double wingSpan;
    private boolean canSpeak;

    public Bird() {
    }

    public Bird(double wingSpan, boolean canSpeak) {
        this.wingSpan = wingSpan;
        this.canSpeak = canSpeak;
    }

    public Bird(String id, String name, int birthYear, String cage, double wingSpan, boolean canSpeak) {
        super(id, name, birthYear, cage);
        this.wingSpan = wingSpan;
        this.canSpeak = canSpeak;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    public boolean isCanSpeak() {
        return canSpeak;
    }

    public void setCanSpeak(boolean canSpeak) {
        this.canSpeak = canSpeak;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Bird{wingSpan=" + wingSpan + ", canSpeak=" + canSpeak + "}";
    }
}
