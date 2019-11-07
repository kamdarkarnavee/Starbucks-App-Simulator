package starbucks;

/**
 * My Card Options Screen
 */
public class MyCardsOptions extends Screen implements ITouchEventHandler, IAppFrameObserver {
    ITouchEventHandler nextHandler;
    IFrame frame;
    IScreen cm;

    public MyCardsOptions() {
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        String cardOptions = "Reload\n" + "Refresh\n" + "More Options\n" + "Cancel";
        return cardOptions;
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (x == 2 && y == 4) {
            frame.setCurrentScreen(this);
        } else {
            if (nextHandler != null)
                nextHandler.touch(x, y);
        }
    }

    /**
     * Set Next Event Handler
     *
     * @param next Next Handler Object
     */
    @Override
    public void setNext(ITouchEventHandler next) {
        nextHandler = next;
    }

    /**
     * Updates frame
     */
    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
