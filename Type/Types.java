package aboutAbstract.practiceInterface.Animal.Type;

public class Types {
    public String getTypes(int option){
        String animals = null;
        switch (option){
            case 1:{
                animals = Type.BIRD.getValue();
                break;
            }
            case 2:{
                animals = Type.MAMMAL.getValue();
                break;
            }
            case 3:{
                animals = Type.REPTILE.getValue();
                break;
            }
        }
        return animals;
    }
}
