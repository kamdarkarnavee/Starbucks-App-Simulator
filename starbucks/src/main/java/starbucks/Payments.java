

package starbucks ;

/** Payments Screen */
public class Payments extends Screen implements IAppFrameObserver
{
    IFrame frame;

    public Payments()
    {

    }

    public String display(){
        return "Find Store\nEnable Payments";
    }

    public void touch(int x, int y){

    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
