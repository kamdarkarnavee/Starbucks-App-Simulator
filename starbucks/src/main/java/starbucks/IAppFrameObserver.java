package starbucks;

/**
 * App Frame Observer Interface
 */
public interface IAppFrameObserver {
    /**
     * Frame Update Event to Notify Observers
     *
     * @param frame frame object
     */
    void frameUpdate(IFrame frame);
}
