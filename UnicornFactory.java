/*this is a class representing a concrete creator*/
public class UnicornFactory extends AnimalFactory{
    /*name of animal we are producing*/
    private String name = "Unicorn";

    /*create a static integer which will let us keep track of the number of unicorns*/
    private static int numberOfUnicorns = 0;

    /*We create a method which returns a new Unicorn object*/
    @Override
    public Unicorn createAnimal(){
        /*checks if the current type of animal factory has been added to factoryList in Zoo*/
        super.addToFactoryList();

        /*increase the number of unicorns created*/
        numberOfUnicorns++;
        return new Unicorn();
    }

    /*method to return String about the animal's current population in the zoo*/
    public String animalInfo(){
        return "- " + this.name + ": " + numberOfUnicorns;
    }
}
