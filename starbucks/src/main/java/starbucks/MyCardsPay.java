

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen implements ITouchEventHandler, IAppFrameObserver
{
    ITouchEventHandler nextHandler;
    IFrame frame;
    String cardNumber;

    public MyCardsPay()
    {
        this.cardNumber = "000000000";
    }

    public String display(){
        return "["+ cardNumber +"]\n\n\nScan Now\n";
    }

    public void touch(int x, int y) {
        if (x == 2 && y == 4) {
            frame.setCurrentScreen((IScreen) nextHandler);
        }else if(y == 7){
//            Do Nothing
        }else if(x == 3 && y == 3){
            frame.cmd("A");
        }
        else{
            if ( nextHandler != null )
                nextHandler.touch(x, y);
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

