package aboutAbstract.practiceInterface.Animal.Type;

public class Habitats {
    public String getHabitats(int option){
        String habitats = null;
        switch (option){
            case 1:{
                habitats = Habitat.ONTHETALLTREE.getValues();
                break;
            }
            case 2:{
                habitats = Habitat.LAND.getValues();
                break;
            }
            case 3:{
                habitats = Habitat.UNDERWATER.getValues();
                break;
            }
        }
        return habitats;
    }
}
