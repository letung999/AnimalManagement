package aboutAbstract.practiceInterface.Animal.sort;

import aboutAbstract.practiceInterface.Animal.model.Pet;

import java.util.Comparator;

public class SortWeightAsc implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        float weight1 = pet1.getWeight();
        float weight2 = pet2.getWeight();
        float result = weight1 - weight2;
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;

    }
}
