package starbucks;

/**
 * App Frame Subject Interface
 */
public interface IAppFrameSubject {

    /**
     * Add Observer to Subscribers List
     *
     * @param obj Observer Object
     */
    void attach(IAppFrameObserver obj);

    /**
     * Remove Observer from Subscription
     *
     * @param obj Observer Object
     */
    void remove(IAppFrameObserver obj);

    /**
     * Trigger Events to Observers
     */
    void notifyObservers();
}
