# Starbucks App Simulator

## Design and Flow of Starbucks App Simulator
The application starts with a 4 digit pin screen with a key pad to enter the passcode (accepts passcode - 1234).
Upon log in, "MyCards" screen will be displayed with the current card balance set to $0.00 by default. At the bottom of the screen, following menu options are available to navigate to each of the screens: 

Menu Options | A | B | C | D | E 
-------------|---|---|---|---|---
Screen | My Cards | Payments | Rewards | Store | Settings

To add a new card, user needs to navigate to "Settings" screen and select the "Add Card" option. Enter a 9 digit card number and a 3 digit card code before pressing "Next" to add the card. This will automatically navigate user to the "My Cards" screen, with an updated balance of $20.00 displayed on the screen. Now, user can pay for the coffee by navigating to the "My Cards Pay" screen from the "My Cards" screen and selecting the "Scan Now" option. An amount of $1.50 is deducted each time from the balance for the coffee unless the card balance is less than $1.50.

## Design Notes:
1) **Command Pattern:** 
+ For navigating through the menus screens i.e. "My Cards", "Payments", "Rewards", "Find Store" and "Settings".
When a screen's option is selected and given as input to the execute() function, it selects the corresponding command of that screen and executes the MenuOption's invoke() method. MenuCommand.execute() sets the current frame as that screen. 

2) **Chain of responsibility:** 
+ A chain is created of the objects that will handle a specific request one by one. In the login screen, when the user touches any digit, the chain that consists of Passcode, Keypad and Spacer is executed sequentially. Here, composite and chain of responsibility design patterns are used to handle the touch events.

+ Used chain of responsibility pattern to handle touch events to navigate from "My Cards" screen to "My Cards Options" and "My Cards More Options" Screen.

3) **Observer Pattern:** 
+ When the user enters the passcode for login, there are a couple of observers that needs to be notified for any changes during this process. The Keypad object notifies the class Passcode first and sets the count variable of the Passcode class as the new one and then updates the PinEntryMachine class to change the state of the object based on the number of digits entered till this time. Here the subject is the Keypad and observers are Passcode and PinEntryMachine. As two objects need to be updated on every keypad touch, observer design pattern is implemented to handle these objectives.

+ Implemented Observer Pattern to notify all the subscribed classes Of IAppFrameSubject whenever the current screen is updated through frameUpdate() method of IAppFrameObserver interface to make the frame object accessible. Likewise, registered Passcode class as an IPinAuthObserver as well for the login functionality. Once, the user is authenticated, Passcode and PinEntryMachine objects are removed from the IPinAuthObservers.

4) **Strategy Pattern:** 
+ Once the user is authenticated and redirected to the "My Cards" screen, he/she can navigate to any of the screens mentioned in the description. The orientation/layout of the display - potrait or landscape - is implemented using strategy pattern and default layout is set to potraitStrategy.

5) **Proxy Pattern:** 
+ It is used to create authenication proxy for the app. Unless the user is authenicated, he/she cannot access any of the app functionalities i.e. the AppController only comes in action if the user is logged in. 

6) **State Pattern:** 
+ PinEntryMachine is used to set and maintain the states of each pin for the login screen. First it checks the current state, and accordingly calls the method of that state, which executes a set of instructions that includes changing the state to next state and checking the authentication requirements for specific states.

* Used State Pattern for the Add Card functionality. Created two states: CardNumber and CardCode that implements ICardState interface. The default state of "Add Card" screen is CardNumber i.e. all the touch events are added/stored in CardNumber state to set the card number (9 digits). Likewise, a touch(2, 3) is used to change the state to CardCode following which all the touch event values are used to set card code (3 digits). 

+ On typing next, if the card requirements are met, card is added. On entering prev, the current screen is set to "Settings" screen. In both the cases, the state values are cleared and the state is set back to CardNumber state.

Here are the Class and Sequence diagrams of the **Add Card** functionality for better understanding of the flow

## Class Diagram for Add Card Screen
![Class Diagram](/starbucks/class_diagram.png)

## Sequence Diagram for Add Card Screen
![Main Sequence Overview](/starbucks/starbucks%20sequence.png)

## Add Card Number and Add Card Code Sequence Diagrams
![image](/starbucks/addCardNum.png)

## Next Screen Sequence Diagram
![Next Screen](/starbucks/next_screen.png)

## Previous Screen Sequence Diagram
![Previous Screen](/starbucks/previous_screen.png)
