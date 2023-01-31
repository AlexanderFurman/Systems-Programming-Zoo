/*generic interface to represent a message to be updated*/
public interface Updates {

    /*method to update message which will be sent to the observers*/
    void setDescription(DescriptionType type);
}
