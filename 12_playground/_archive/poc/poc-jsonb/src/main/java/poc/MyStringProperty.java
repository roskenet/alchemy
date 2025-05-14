package poc;

public class MyStringProperty {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyStringProperty{" +
                "value='" + value + '\'' +
                '}';
    }
}
