/*this is a creator class, for creating a general, abstract product*/
public abstract class AnimalFactory implements Comparable<AnimalFactory>{
    /*abstract method which creates some kind of animal*/
    public abstract Animal createAnimal();

    /*abstract method to add some type of AnimalFactory to factorylist (field variable in Zoo)*/
    /*but ONLY IF IT HAS NOT YET BEEN ADDED*/
    /*We will then use this list to make use of the factory's methods, while in the Zoo class*/
    public void addToFactoryList() {
        if (!Zoo.factoryList.contains(this)) {
            Zoo.factoryList.add(this);
        }
    }

    /*an abstract method to print some animal's current info as a string*/
    public abstract String animalInfo();

    /*We need to override the compareTo function, so we can compare the names of the animal factories*/
    @Override
    public int compareTo(AnimalFactory a) {
        /*This returns object whose class name is first alphabetically*/
        return this.getClass().getSimpleName().compareTo(a.getClass().getSimpleName());
    }
}
