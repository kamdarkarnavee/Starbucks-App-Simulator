

package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen implements IAppFrameObserver
{
    private Frame frame;
    private double balance;
    ITouchEventHandler nextHandler;
    IScreen cp;
    IScreen co;
    IScreen cm;



    public MyCards()
    {
        balance = 0;
        cp = new MyCardsPay(this);
        co = new MyCardsOptions();
        cm = new MyCardsMoreOptions();

        nextHandler = (ITouchEventHandler) cp;
        ((ITouchEventHandler) cp).setNext((ITouchEventHandler) co);
        ((ITouchEventHandler) co).setNext((ITouchEventHandler) cm);

    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance){
        this.balance = balance;
    }

    public String contents(){
        return String.format("$%.2f\n", getBalance());
    }

    public String display(){
        return contents();
    }

    public void touch(int x, int y){
        if(x == 3 && y == 3){
            frame.setCurrentScreen((IScreen) nextHandler);
        }else if(y == 7){
//            Do Nothing
        }
        else{
            if ( nextHandler != null )
                nextHandler.touch(x, y);
        }
    }

    public void setMyCardPay(String cardNumber){
        ((MyCardsPay)cp).cardNumber = cardNumber;
    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = (Frame) frame;
        this.frame.attach((IAppFrameObserver) cp);
        this.frame.attach((IAppFrameObserver) co);
        this.frame.attach((IAppFrameObserver) cm);
    }
}

