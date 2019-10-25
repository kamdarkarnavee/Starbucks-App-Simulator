package starbucks;

public interface IAppFrameSubject {


    public void attach( IAppFrameObserver obj ) ;

    public void remove(IAppFrameObserver obj);

    public void notifyObservers();
}
