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
        return "[" + cn.getCardNumber() + "]\n[" + cc.getCardCode() + "]\n\n" + kp.display();
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
        if (y == 2) {
            if (x == 1 || x == 2 || x == 3)
                this.state = cn;
            else
                this.state.touch(x, y);
        } else if (x == 2 && y == 3) {
            this.state = cc;
        } else {
            this.state.touch(x, y);
        }
    }

    /**
     * Resets Card Details to initial state
     */
    private void resetCardDetails() {
        this.cn = new CardNumber();
        this.cc = new CardCode();
        this.state = this.cn;
    }

    /**
     * Next Screen
     */
    public void next() {
        if (cn.getCardNumber().length() == 9 && cc.getCardCode().length() == 3) {
            cardNumber = cn.getCardNumber();
            cardCode = cc.getCardCode();
            ((MyCards) card).setBalance(20);
            frame.cmd("A");
            ((MyCards) card).setMyCardPay(cardNumber);
        }
        resetCardDetails();
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
