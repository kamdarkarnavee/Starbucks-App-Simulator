package starbucks;

/**
 * Card Code State
 */
public class CardCode implements ICardState, IKeyPadObserver {
    private String cardCode = "";
    private final int length = 4;

    private KeyPad kp;
    private String key;
    private int pinCount = 0;

    public CardCode() {
        kp = new KeyPad();
        kp.attach(this);
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
     * Sets Card Code
     *
     * @param key Key value
     */
    public void setCardCode(String key) {
        if (pinCount < length) {
            if (key.equals("X")) {
                if (cardCode.length() > 0) {
                    this.cardCode = this.cardCode.substring(0, this.cardCode.length() - 1);
                    kp.setCountPinDigits(cardCode.length());
                }
            } else if (key.equals(" ")) {
//              Do Nothing
            } else {
                this.cardCode += key;
            }
        } else {
            kp.setCountPinDigits(length);
        }
    }

    /**
     * Gets Card Code
     *
     * @return cardCode value
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * Observer of Key Events
     *
     * @param numKeys Number of Keys So Far
     * @param key     Last Key Entered
     */
    @Override
    public void keyEventUpdate(int numKeys, String key) {
        this.pinCount = numKeys;
        this.key = key;
        setCardCode(this.key);
    }
}
