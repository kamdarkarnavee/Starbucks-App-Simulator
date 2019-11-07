package starbucks;

/**
 * My Card Pay Screen
 */
public class MyCardsPay extends Screen implements ITouchEventHandler, IAppFrameObserver {
    ITouchEventHandler nextHandler;
    IFrame frame;
    String cardNumber;
    MyCards card;
    private double balance;
    KeyPad kp;

    public MyCardsPay(MyCards card) {
        this.cardNumber = "000000000";
        this.card = card;
        this.kp = new KeyPad();
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return "\n[" + cardNumber + "]\n\n\nScan Now\n";
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (y != 7) {
            if (x == 3 && y == 3) {
                frame.cmd("A");
            } else if (y == 2 && (x == 2 || x == 3)) {
                doPayment();
            } else {
                kp.touch(x, y);
            }
        } else {
            kp.touch(x, y);
        }
    }

    /**
     * Payment Method
     * Deducts 1.5 on every transaction
     */
    public void doPayment() {
        balance = card.getBalance();
        if (balance >= 1.5) {
            card.setBalance(balance - 1.5);
        }
    }

    /**
     * Sets Next Event Handler
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

