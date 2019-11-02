

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen implements ITouchEventHandler, IAppFrameObserver
{
    ITouchEventHandler nextHandler;
    IFrame frame;
    String cardNumber;
    MyCards card;
    private double balance;

    public MyCardsPay(MyCards card)
    {
        this.cardNumber = "000000000";
        this.card = card;
    }

    public String display(){
        return "\n["+ cardNumber +"]\n\n\nScan Now\n";
    }

    public void touch(int x, int y) {
        if (x == 2 && y == 4) {
            frame.setCurrentScreen((IScreen) nextHandler);
        }else if(y == 7){
//            Do Nothing
        }else if(x == 3 && y == 3){
            frame.cmd("A");
        }
        else if(y == 2 && (x == 2 || x == 3)){
            doPayment();
        }
        else{
            if ( nextHandler != null )
                nextHandler.touch(x, y);
        }
    }

    public void doPayment(){
        balance = card.getBalance();
        if(balance >= 1.5){
            card.setBalance(balance - 1.5);
        }
    }

    @Override
    public void setNext(ITouchEventHandler next) {
        nextHandler = next;
    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}

