/*This is a class representing a concrete product*/
public class Unicorn implements Animal{
    /*concrete method for performing*/
    @Override
    public void performAction(){
        System.out.println("The unicorn is flying...");
    }

    /*concrete method for eating*/
    @Override
    public void eat(){
        System.out.println("The unicorn is eating rainbow cakes...");
    }
}
