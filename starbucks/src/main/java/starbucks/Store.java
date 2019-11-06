package starbucks;

/**
 * Store Screen
 */
public class Store extends Screen implements IAppFrameObserver {
    IFrame frame;
    KeyPad kp;

    public Store() {
        this.kp = new KeyPad();
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        String store_location = "         X  \n" +
                "   X        \n" +
                "       X    \n" +
                "      X     \n" +
                "  X         \n" +
                "          X \n" +
                "  X         \n";
        return store_location;
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
