

package starbucks ;

/** Store Screen */
public class Store extends Screen
{

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

}
