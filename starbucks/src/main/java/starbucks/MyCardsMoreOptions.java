package starbucks;

/**
 * My Card More Options Screen
 */
public class MyCardsMoreOptions extends Screen implements ITouchEventHandler, IAppFrameObserver {
    ITouchEventHandler nextHandler;
    IFrame frame;
    KeyPad kp;

    public MyCardsMoreOptions() {
        this.kp = new KeyPad();
    }

    @Override
    public void setNext(ITouchEventHandler next) {
        nextHandler = next;
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (y == 7) {
            if (x == 1 || x == 2 || x == 3) {
                frame.setCurrentScreen(this);
            } else {
                kp.touch(x, y);
            }
        } else {
            kp.touch(x, y);
        }
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return "Reload\n" + "Refresh\n" + "Auto Reload\n" + "Transactions";
    }

    /**
     * Updates frame
     */
    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
