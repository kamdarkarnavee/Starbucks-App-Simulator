

package starbucks ;

/** Store Screen */
public class Store extends Screen implements IAppFrameObserver
{
    IFrame frame;
    public Store()
    {

    }

    public String display(){
        String store_location = "         X  \n" +
                                "   X        \n" +
                                "       X    \n" +
                                "      X     \n" +
                                "  X         \n" +
                                "          X \n" +
                                "  X         \n";
        return store_location;
    }

    public void touch(int x, int y){

    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
