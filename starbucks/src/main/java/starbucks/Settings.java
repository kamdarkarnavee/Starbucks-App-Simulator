package starbucks;

/**
 * Settings Screen
 */
public class Settings extends Screen implements IAppFrameObserver {
    private AddCard ac;
    private PinScreen ps;
    private IFrame frame;
    private IScreen myCards;

    public Settings(IScreen myCards) {
        this.myCards = myCards;
        ac = new AddCard(myCards);
        ps = new PinScreen();
        ps.addSubComponent(ac);
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        String setting_options = "Add Card\n" + "Delete Card\n" + "Billing\n" + "Passcode\n\n" +
                "About | Terms\n" + "Help";
        return setting_options;
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (y == 1 && (x == 1 || x == 2 || x == 3)) {
            frame.setCurrentScreen(ac);
        }
    }

    /**
     * Updates frame and calls register observers exactly once
     *
     * @param frame
     */
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
