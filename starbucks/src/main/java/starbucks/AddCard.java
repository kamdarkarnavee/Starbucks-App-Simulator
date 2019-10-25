
package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen implements ITouchEventHandler
{
    ITouchEventHandler nextHandler ;

    public AddCard()
    {
    }

    public String display(){
        return "Add Card\n";
    }

    @Override
    public void setNext(ITouchEventHandler next) {

    }
}
