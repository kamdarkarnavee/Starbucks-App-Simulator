package starbucks;

/**
 * Rewards Screen
 */
public class Rewards extends Screen implements IAppFrameObserver {
    KeyPad kp;
    IFrame frame;

    public Rewards() {
        this.kp = new KeyPad();
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return "Make Every\nVisit Count";
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        kp.touch(x, y);
    }

    /**
     * Updates frame
     */
    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
