/*This is a generic observer interface*/
/*Note: I do not add subscribe/unsubscribe features, since it appears that in this program*/
/*The observers are added by the zoo exclusively (They don't need to request it themselves)*/
public interface Observer {

    /*we wish to update the observer when there is a new message from a subject*/
    void update(String description);
}
