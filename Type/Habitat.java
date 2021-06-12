package aboutAbstract.practiceInterface.Animal.Type;

public enum Habitat {
    LAND("Trên Cạn"),
    UNDERWATER("Dưới nước"),
    ONTHETALLTREE("Trên Cây Cao");

    private String values;

    Habitat(String values){
        this.values = values;
    }

    public String getValues() {
        return values;
    }
}
