

package starbucks ;

/** Passcode Screen Component */
public class Passcode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver, IPinAuthObserver
{
    ITouchEventHandler nextHandler ;
    IPinStateMachine pm;
    private int count = 0;
    private boolean authenticated = false ;


    public Passcode(){
        pm = new PinEntryMachine();
        ((IPinAuthSubject)pm).registerObserver(this);
    }

    /**
     * Touch Event Ignored by Passcode
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y) 
    {
        if ( y==2 )
        {
            System.err.println( "Passcode Touched at (" + x + ", " + y + ")" ) ; 
        }
        else
        {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
    }
    
    /**
     * Set Next Touch Handler
     * @param next Touch Event Handler
     */
    public void setNext( ITouchEventHandler next) 
    { 
        nextHandler = next ;
    }
    
    
    /**
     * Display "Echo Feedback" on Pins entered so far
     * @return Passcode String for Display
     */
    public String display() 
    {
        String value = "" ;
        switch ( count )
        {
            case 0: value = "\n [_][_][_][_]" ; break ;
            case 1: value = "\n [*][_][_][_]" ; break ;
            case 2: value = "\n [*][*][_][_]" ; break ;
            case 3: value = "\n [*][*][*][_]" ; break ;
            case 4:
                    if(!authenticated){
                        value = "  Invalid Pin\n\n [_][_][_][_]" ; break ;
                    }

        }
         return value  ;
    }
    
    /**
     * Add Sub Component (Not used)
     * @param c Sub Component to Add
     */
    public void addSubComponent( IDisplayComponent c ) 
    {
        
    }   
    
    /**
     * Key Event Update
     * @param c   Count of Keys So Far
     * @param key Last key Pressed
     */
    public void keyEventUpdate( int c, String key ) 
    {
        System.err.println( "Key: " + key ) ;
        count = c ;
    }

    /**
     * Receive Authenticated Event from Authenticator
     */
    public void authEvent() {
        this.authenticated = true ;
    }
}

