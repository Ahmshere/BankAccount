package enums;

public enum Operations {
    ADD_CUSTOMER("btnClass1"), OPEN_ACCOUNT("btnClass2"), CUSTOMERS("btnClass3");
    private final String value;
    Operations(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
