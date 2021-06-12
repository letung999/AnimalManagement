package aboutAbstract.practiceInterface.Animal.Type;

public enum Type {
    MAMMAL("Động Vật Có Vú"),
    REPTILE("Các Loài Bò Sát"),
    BIRD("Các Loài Chim");

    private String value;

    Type(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
