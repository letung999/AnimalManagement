package aboutAbstract.practiceInterface.Animal.exception;

public class InvalidIdPetException extends Exception {
    private String idPet;

    public InvalidIdPetException(String idPet) {
        this.idPet = idPet;
    }

    public InvalidIdPetException(String message, String idPet) {
        super(message);
        this.idPet = idPet;
    }

    public String getIdPet() {
        return idPet;
    }
}
