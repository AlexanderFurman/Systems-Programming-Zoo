/*This class represents a concrete observer*/
public class ZooObserver implements Observer{
    /*define field variables*/
    private String desc;
    private String observerName;

    /*Constructor*/
    public ZooObserver(String name){
        //this.subject = Zoo.getInstance();
        this.observerName = name;
    }

    /*method to update the message description, and display the message*/
    @Override
    public void update(String description){
        this.desc = description;
        display();
    }

    /*method to print out a message sent to the observer correctly*/
    private void display(){
        System.out.println("[" + this.observerName + "] " + this.desc);
    }

}
