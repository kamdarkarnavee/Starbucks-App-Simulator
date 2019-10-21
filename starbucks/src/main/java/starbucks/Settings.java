

package starbucks;

/** Settings Screen */
public class Settings extends Screen
{
   
    public Settings()
    {
       
    }

    public String display(){
        String setting_options = "Add Card\n" + "Delete Card\n" + "Billing\n" + "Passcode\n\n" +
                                 "About | Terms\n" + "Help";
        return setting_options;
    }

   
}
