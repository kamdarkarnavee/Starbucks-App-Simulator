package starbucks;

/**
 * Payments Screen
 */
public class Payments extends Screen implements IAppFrameObserver {
    IFrame frame;
    KeyPad kp;

    public Payments() {
        this.kp = new KeyPad();
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return "Find Store\nEnable Payments";
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
