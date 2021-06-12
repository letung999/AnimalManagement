package aboutAbstract.practiceInterface.Animal.exception;

public class InvalidNameException extends Exception {
    private String animalName;

    public InvalidNameException(String animalName) {
        this.animalName = animalName;
    }

    public InvalidNameException(String message, String animalName) {
        super(message);
        this.animalName = animalName;
    }

    public String getAnimalName(){
        return animalName;
    }

}
