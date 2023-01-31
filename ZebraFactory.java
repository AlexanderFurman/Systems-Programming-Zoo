/*this is a class representing a concrete creator*/
public class ZebraFactory extends AnimalFactory{
    /*name of animal we are producing*/
    private String name = "Zebra";

    /*create a static integer which will let us keep track of the number of zebras*/
    private static int numberOfZebras = 0;

    /*We create a method which returns a new Zebra object*/
    @Override
    public Zebra createAnimal(){
        /*checks if the current type of animal factory has been added to factoryList in Zoo*/
        super.addToFactoryList();

        /*increase the number of zebras created*/
        numberOfZebras++;
        return new Zebra();
    }

    /*method to return String about the animal's current population in the zoo*/
    public String animalInfo(){
        return "- " + this.name + ": " + numberOfZebras;
    }
}
