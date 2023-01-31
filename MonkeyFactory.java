/*this is a class representing a concrete creator*/
public class MonkeyFactory extends AnimalFactory{
    /*name of animal we are producing*/
    private String name = "Monkey";

    /*create a static integer which will let us keep track of the number of monkeys*/
    private static int numberOfMonkeys = 0;

    /*We create a method which returns a new Monkey object*/
    @Override
    public Monkey createAnimal(){
        /*checks if the current type of animal factory has been added to factoryList in Zoo*/
        super.addToFactoryList();

        /*increase the number of monkeys created*/
        numberOfMonkeys++;

        return new Monkey();
    }

    /*method to return String about the animal's current population in the zoo*/
    @Override
    public String animalInfo(){
        return "- " + this.name + ": " + numberOfMonkeys;
    }
}
