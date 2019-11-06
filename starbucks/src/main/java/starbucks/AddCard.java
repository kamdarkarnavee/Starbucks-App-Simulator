package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen implements ITouchEventHandler, IAppFrameObserver {
    private String cardNumber;
    private IFrame frame;
    private KeyPad kp;
    private String cardCode;
    private IScreen card;
    private CardNumber cn;
    private CardCode cc;
    private ICardState state;

    /**
     * AddCard Constructor
     *
     * @param myCards
     */
    public AddCard(IScreen myCards) {
        this.cardNumber = "";
        this.cardCode = "";
        this.kp = new KeyPad();
        this.card = myCards;
        resetCardDetails();
    }

    /**
     * Get Display Contents
     *
     * @return Display Contents
     */
    public String display() {
        return "[" + cn.getCardValue() + "]\n[" + cc.getCardValue() + "]\n\n" + kp.display();
    }

    /**
     * Set Next Event Handler
     *
     * @param next Next Handler Object
     */
    @Override
    public void setNext(ITouchEventHandler next) {
//        Do Nothing
    }

    /**
     * Touch Event
     *
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        if (y == 2 && (x == 1 || x == 2 || x == 3)) {
            this.state = cn;
        } else if (x == 2 && y == 3) {
            this.state = cc;
        } else {
            if (state == null) {
                this.state = cn;
            }
            this.state.touch(x, y);
        }
    }

    /**
     * Resets Card Details to initial state
     */
    private void resetCardDetails() {
        this.cn = new CardNumber();
        this.cc = new CardCode();
        this.state = null;
    }

    /**
     * Next Screen
     */
    public void next() {
        if (cn.getCardValue().length() == 9 && cc.getCardValue().length() == 3) {
            cardNumber = cn.getCardValue();
            cardCode = cc.getCardValue();
            ((MyCards) card).setBalance(20);
            frame.cmd("A");
            ((MyCards) card).setMyCardPay(cardNumber);
            resetCardDetails();
        } else {
            resetCardDetails();
        }
    }

    /**
     * Previous Screen
     */
    public void prev() {
        resetCardDetails();
        frame.cmd("E");
    }

    /**
     * Updates frame and resets the card details to initial state
     *
     * @param frame frame
     */
    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
        resetCardDetails();
    }
}
