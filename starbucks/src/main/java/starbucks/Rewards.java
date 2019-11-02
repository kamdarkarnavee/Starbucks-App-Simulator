

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen implements IAppFrameObserver
{
    IFrame frame;

    public Rewards()
    {

    }

    public String display(){
        return "Make Every\nVisit Count";
    }

    public void touch(int x, int y){

    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
