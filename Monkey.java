/*This is a class representing a concrete product*/
public class Monkey implements Animal{
    /*concrete method for performing*/
    @Override
    public void performAction(){
        System.out.println("The monkey is hanging on trees...");
    }

    /*concrete method for eating*/
    @Override
    public void eat(){
        System.out.println("The monkey is eating a banana...");
    }
}
