import java.util.ArrayList;
import java.util.Collections;

/*Here we create a class which uses the Singleton design pattern*/
public class Zoo implements Updates, Subject {
    private static Zoo instance = null;
    private int happiness;
    private int hunger;
    private static int totalNumberOfAnimals;
    private String description;

    /*create an arraylist to keep track of all te animals in the zoo*/
    private ArrayList<Animal> animals;

    /*Create arraylist to keep track of all the observers*/
    public ArrayList<Observer> observers;

    /*We create an arraylist which will hold the number of factories called*/
    /*This will allow us to keep track of the number of each individual type of animal*/
    /*make it public and static, so it can easily be accessed by the AnimalFactory Class*/
    public static ArrayList<AnimalFactory> factoryList;


    private Zoo(){
        this.happiness = 2;
        this.hunger = 3;
        this.totalNumberOfAnimals = 0;
        this.factoryList = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.description = "";

    }

    /*Singleton getInstance method which will create a new Zoo if it doesn't already exist*/
    public static Zoo getInstance(){
        if (instance==null){
            instance = new Zoo();
            System.out.println("Creating zoo...");

        }
        else{
            /*return a message saying that the zoo already has an instance*/
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    /*method to add an animal to the zoo: we add 1 to the total number of animals, and when an*/
    /*animal is created in the brackets of add*/
    public void addAnimal(Animal animal){
        this.animals.add(animal);
        this.totalNumberOfAnimals++;
        setDescription(DescriptionType.ANIMAL_ADDED);
        notifyObservers();
    }

    /*method to add observers to the subscriber list which will receive messages from the zoo subject*/
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /*method to remove observers from the subscriber list*/
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    /*method to notify observers when something new happens. We will use this method whenever*/
    /*animals are being fed, performing, or added to the zoo*/
    @Override
    public void notifyObservers(){
        System.out.println("Notifying observers:");
        for (Observer o : observers){
            o.update(description);
        }
    }

    /*Method to set the type of message that will be sent to the zooObservers*/
    @Override
    public void setDescription(DescriptionType type){
        /*We implement switch case to apply the correct message accordingly (using the enum DescriptionType)*/
        switch(type){
            case EATING:
                this.description = "The animals are being fed";
                break;

            case WATCHED:
                this.description = "The animals are being watched";
                break;

            /*the default case is when an animal is added to the zoo*/
            default:
                this.description = animals.get(animals.size() - 1).getClass().getSimpleName()
                        + " has been added to the zoo!";
        }
    }

    /*Method which iterates through all animals and makes them eat*/
    public void feedAnimals(){
        for(Animal a : animals){
            a.eat();
        }
        /*report that the animals are being fed to the observers*/
        setDescription(DescriptionType.EATING);
        notifyObservers();

        /*reduce the level of hunger by 1*/
        if(hunger > 1){
            hunger--;
        }
    }

    /*method which iterates though all the animals and makes them perform*/
    public void watchAnimals(){
        for(Animal a : animals){
            a.performAction();
        }

        /*notify the observers that the animals are being watched*/
        setDescription(DescriptionType.WATCHED);
        notifyObservers();

        /*adjust the hunger and happiness levels*/
        if(hunger < 5){
            hunger++;
        }
        if(happiness < 5){
            happiness++;
        }
    }

    /*Method which displays the info about the animals in the zoo*/
    public void showAnimalsInfo(){
        /*first display total number of animals*/
        System.out.println("The zoo contains total of " + totalNumberOfAnimals + " animals:");

        /*Organize the animal factories in alphabetical order*/
        Collections.sort(factoryList);

        /*now, iterate through all the different types of animal factories in factoryList*/
        /*and print the total number of each type of animal*/
        for(AnimalFactory f: factoryList){
            System.out.println(f.animalInfo());
        }

        /*now print out how happy the animals are, and add extra prints depending on how happy/hungry they are*/
        System.out.println("Happiness level: " + happiness);
        if(happiness < 3){
            System.out.println("The animals are not happy, you should watch them...");
        }
        else{
            System.out.println("The animals are very happy, keep working hard...");
        }

        System.out.println("Hunger level: " + hunger);
        if(hunger > 3){
            System.out.println("The animals are hungry, you should feed them...");
        }
    }
}
