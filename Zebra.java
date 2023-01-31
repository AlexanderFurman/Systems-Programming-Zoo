/*This is a class representing a concrete product*/
public class Zebra implements Animal{
    /*concrete method for performing*/
    @Override
    public void performAction(){
        System.out.println("The zebra is running...");
    }

    /*concrete method for eating*/
    @Override
    public void eat(){
        System.out.println("The zebra is eating grass...");
    }
}
