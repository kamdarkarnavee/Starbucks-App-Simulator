package starbucks;

import java.util.ArrayList;

/** Settings Screen */
public class Settings extends Screen implements IDisplayComponent, IAppFrameObserver
{
    private ArrayList<IDisplayComponent> components;
    private AddCard ac;
    private PinScreen ps;
    private IFrame frame;
    private IScreen myCards;

    public Settings(IScreen myCards)
    {
        this.myCards = myCards;
        components = new ArrayList<>();
        ac = new AddCard(myCards);
        ps = new PinScreen();
        ps.addSubComponent(ac);
    }

    public String display(){
        String setting_options = "Add Card\n" + "Delete Card\n" + "Billing\n" + "Passcode\n\n" +
                                 "About | Terms\n" + "Help";
        return setting_options;
    }

    public void touch(int x, int y){
        if(y == 1 && (x == 1 || x == 2 || x == 3)){
            frame.setCurrentScreen(ac);
        }
    }

    @Override
    public void frameUpdate(IFrame frame) {
        this.frame = frame;
    }
}
