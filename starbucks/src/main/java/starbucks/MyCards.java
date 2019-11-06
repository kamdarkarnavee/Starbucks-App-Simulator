package starbucks;

/**
 * My Cards Screen
 */
public class MyCards extends Screen implements IAppFrameObserver {
    private Frame frame;
    private double balance;
    ITouchEventHandler nextHandler;
    IScreen cp;
    IScreen co;
    IScreen cm;
    boolean alreadyExecuted = false;


    public MyCards() {
        balance = 0;
        cp = new MyCardsPay(this);
        co = new MyCardsOptions();
        cm = new MyCardsMoreOptions();

        nextHandler = (ITouchEventHandler) cp;
        ((ITouchEventHandler) cp).setNext((ITouchEventHandler) co);
        ((ITouchEventHandler) co).setNext((ITouchEventHandler) cm);

    }

    /**
     * Get current balance
     *
     * @return balance value
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets card balance
     *
     * @param balance balance value
     */
    void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Get screen contents
     *
     * @return contents
     */
    public String contents() {
        return String.format("$%.2f\n", getBalance());
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return contents();
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (x == 3 && y == 3) {
            frame.setCurrentScreen((IScreen) nextHandler);
        } else if (y == 7) {
//            Do Nothing
        } else {
            if (nextHandler != null)
                nextHandler.touch(x, y);
        }
    }

    /**
     * Sets Card Number for payment
     *
     * @param cardNumber Card Number value
     */
    public void setMyCardPay(String cardNumber) {
        ((MyCardsPay) cp).cardNumber = cardNumber;
    }

    /**
     * Registers cp, co and cm as observers
     */
    private void registerObservers() {
        this.frame.attach((IAppFrameObserver) cp);
        this.frame.attach((IAppFrameObserver) co);
        this.frame.attach((IAppFrameObserver) cm);
    }

    /**
     * Updates frame and calls register observers exactly once
     *
     * @param frame frame
     */
    public void frameUpdate(IFrame frame) {
        this.frame = (Frame) frame;
        if (!alreadyExecuted) {
            registerObservers();
            alreadyExecuted = true;
        }
    }
}

