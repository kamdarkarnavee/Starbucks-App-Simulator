
package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen implements ITouchEventHandler, IAppFrameObserver
{
    private String cardNumber;
    private IFrame frame;
    private KeyPad kp;
    private String cardCode;
    private IScreen card;
    private CardNumber cn;
    private CardCode cc;
    private ICardState state;


    public AddCard(IScreen myCards)
    {
        this.cardNumber = "";
        this.cardCode = "";
        this.kp = new KeyPad();
        this.card = myCards;
        resetCardDetails();
    }

    public String display(){
        return "["+ cn.getCardValue() + "]\n["+ cc.getCardValue() +"]\n\n"+ kp.display() ;
    }

    @Override
    public void setNext(ITouchEventHandler next) {

    }

    public void touch(int x, int y){
        if(y == 2 && (x == 1 || x == 2 || x == 3)){
            this.state = cn;
        } else if(x == 2 && y == 3){
            this.state = cc;
        }else{
            if(state == null){
                this.state = cn;
            }
            this.state.touch(x, y);
        }
    }
    
    private void resetCardDetails(){
        this.cn = new CardNumber();
        this.cc = new CardCode();
        this.state = null;
    }

    public void next(){
        if( cn.getCardValue().length() == 9 && cc.getCardValue().length() == 3){
            cardNumber = cn.getCardValue();
            cardCode = cc.getCardValue();
            ((MyCards)card).setBalance(20);
            frame.cmd("A");
            ((MyCards) card).setMyCardPay(cardNumber);
            resetCardDetails();
        }
    }

    public void prev(){
        resetCardDetails();
        frame.cmd("E");
    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
        resetCardDetails();
    }
}
