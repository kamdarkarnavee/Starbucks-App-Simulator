

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen implements ITouchEventHandler, IAppFrameObserver
{
    ITouchEventHandler nextHandler;
    IFrame frame;
    IScreen cm;
   
    public MyCardsOptions()
    {
    }

    public String display(){
        String cardOptions = "Reload\n" + "Refresh\n" + "More Options\n" + "Cancel";
        return cardOptions;
    }

    public void touch(int x, int y) {
        if (y == 7 && (x == 1 || x == 2 || x ==3)) {
            frame.setCurrentScreen((IScreen) nextHandler);
        }else{
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
