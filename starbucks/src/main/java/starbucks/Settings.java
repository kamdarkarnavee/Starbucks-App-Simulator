

package starbucks;

import java.util.ArrayList;

/** Settings Screen */
public class Settings extends Screen implements IDisplayComponent
{
//    ITouchEventHandler chain ;
    ArrayList<IDisplayComponent> components;
    AddCard ac;
    PinScreen ps;

    public Settings()
    {
       components = new ArrayList<>();
       ac = new AddCard();
       ps = new PinScreen();
       ps.addSubComponent(ac);
    }

    public String display(){
        String setting_options = ac.display() + "Delete Card\n" + "Billing\n" + "Passcode\n\n" +
                                 "About | Terms\n" + "Help";
        return setting_options;
    }

    public void touch(int x, int y){

    }
//    public void addSubComponent( IDisplayComponent c )
//    {
//        components.add( c ) ;
//        if (components.size() == 1 )
//        {
//            chain = (ITouchEventHandler) c ;
//        }
//    }

}
