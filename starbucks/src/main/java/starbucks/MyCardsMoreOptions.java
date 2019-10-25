

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen implements ITouchEventHandler, IAppFrameObserver
{
    ITouchEventHandler nextHandler;
    IFrame frame;
  
    public MyCardsMoreOptions()
    {
    }

    @Override
    public void setNext(ITouchEventHandler next) {
        nextHandler = next;
    }

    public void touch(int x, int y){

    }

    public String display(){
        return "Reload\n" + "Refresh\n" + "Auto Reload\n" + "Transactions";
    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
