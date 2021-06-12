package aboutAbstract.practiceInterface.Animal.Type;

public class Reproductions {
    public String getReproduction(int option) {
        String reproduction = null;
        switch (option) {
            case 1: {
                reproduction = Reproduction.CUB.getValue();
                break;
            }
            case 2: {
                reproduction = Reproduction.OVIPOSIT.getValue();
                break;
            }
        }
        return reproduction;
    }
}
