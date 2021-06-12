package aboutAbstract.practiceInterface.Animal.Type;

public enum Reproduction {
    OVIPOSIT("Đẻ Trứng"),
    CUB("Đẻ Con");
    private String value;

    Reproduction(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
