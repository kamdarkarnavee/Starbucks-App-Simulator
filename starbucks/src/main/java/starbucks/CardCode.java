package starbucks;

public class CardCode implements ICardState, IKeyPadObserver {
    private String cardCode = "";
    private final int length = 4;

    private KeyPad kp;
    private String key;
    private int pinCount = 0;

    public CardCode(){
        kp = new KeyPad();
        kp.attach(this);
    }

    public void touch(int x, int y){
        kp.touch(x, y);
    }

    public void setCardCode(String key) {
        if(pinCount < length){
            if(key.equals("X")){
                if(cardCode.length() > 0){
                    this.cardCode = this.cardCode.substring(0, this.cardCode.length()-1);
                    kp.setCountPinDigits(cardCode.length());
                }
            }
            else if(key.equals(" ")){
//              Do Nothing
            }
            else{
                this.cardCode += key;
            }
        }
        else{
            kp.setCountPinDigits(length);
        }
    }

    public String getCardValue(){
        return cardCode;
    }

    @Override
    public void keyEventUpdate(int numKeys, String key) {
        this.pinCount = numKeys;
        this.key = key;
        setCardCode(this.key);
    }
}
