/*This is a generic subject interface*/
public interface Subject {

    /*we need to be able to subscribe the observer to a subject*/
    void addObserver(Observer observer);

    /*we need to be able to unsubscribe the observer from a subject*/
    void removeObserver(Observer observer);

    /*we wish to update the observer when there is a new message from a subject*/
    void notifyObservers();
}
