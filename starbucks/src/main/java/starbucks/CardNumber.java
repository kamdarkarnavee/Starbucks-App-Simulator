package starbucks;

public class CardNumber implements ICardState, IKeyPadObserver {
    private String cardNumber = "";
    private final int length = 10;
    private KeyPad kp;
    private String key;
    private int pinCount = 0;

    public CardNumber(){
        kp = new KeyPad();
        kp.attach(this);
    }

    public void touch(int x, int y){
        kp.touch(x, y);
    }

    public void setCardNumber(String key) {
        if(pinCount < length){
            if(key.equals("X")){
                if(this.cardNumber.length() > 0) {
                    this.cardNumber = this.cardNumber.substring(0, this.cardNumber.length() - 1);
                    kp.setCountPinDigits(cardNumber.length());
                }
            }
            else if(key.equals(" ")){
//              Do Nothing
            }
            else{
                this.cardNumber += key;
            }
        }else {
            kp.setCountPinDigits(length);
        }
    }

    public String getCardValue(){
        return cardNumber;
    }

    @Override
    public void keyEventUpdate(int numKeys, String key) {
        this.key = key;
        this.pinCount = numKeys;
        setCardNumber(this.key);
    }
}
