package aboutAbstract.practiceInterface.Animal.model;

import aboutAbstract.practiceInterface.Animal.exception.InvalidIdPetException;
import aboutAbstract.practiceInterface.Animal.exception.InvalidNameException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pet implements Serializable {
    private String idPet;
    private String AnimalName;
    private String species;
    private float height;
    private float weight;
    private String habitat;
    private String reproduction;

    public Pet() {
    }

    public Pet(String idPet, String animalName, String species, float height, float weight, String habitat, String reproduction) {
        try {
            setIdPet(idPet);
        } catch (InvalidIdPetException e) {
            e.printStackTrace();
        }
        try {
            setAnimalName(animalName);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.habitat = habitat;
        this.reproduction = reproduction;
    }

    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) throws InvalidIdPetException {
        String regex = "^\\d+";
        String stringNumber = String.valueOf(idPet);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringNumber);
        if(matcher.find()){
            this.idPet = idPet;
        }
        else{
            this.idPet = null;
            var msg = "id Pet isn't Suitable";
            throw new InvalidIdPetException(msg,idPet);
        }

    }

    public String getAnimalName() {
        return AnimalName;
    }

    public void setAnimalName(String animalName) throws InvalidNameException {
        String regex = "^[A-Za-z\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(animalName);
        if (matcher.find()) {
            AnimalName = animalName;
        } else {
            this.AnimalName = null;
            var msg = "Animal Name is not suitable";
            throw new InvalidNameException(msg, animalName);
        }

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }
}
