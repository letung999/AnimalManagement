package aboutAbstract.practiceInterface.Animal.sort;

import aboutAbstract.practiceInterface.Animal.model.Pet;

import java.util.Comparator;

public class SortHeightAsc implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        float height1 = pet1.getHeight();
        float height2 = pet2.getHeight();
        float result = height1 - height2;
        if(result > 0) return 1;
        if(result < 0) return  -1;
        return 0;

    }
}
