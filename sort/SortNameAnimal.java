package aboutAbstract.practiceInterface.Animal.sort;

import aboutAbstract.practiceInterface.Animal.model.Pet;

import java.util.Comparator;

public class SortNameAnimal implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        String name1 = pet1.getAnimalName();
        String name2 = pet2.getAnimalName();
        return name1.compareTo(name2);
    }
}
