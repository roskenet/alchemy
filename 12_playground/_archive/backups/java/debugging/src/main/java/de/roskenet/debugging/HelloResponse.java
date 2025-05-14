package de.roskenet.debugging;

public class HelloResponse {
    public HelloResponse(String myString, Integer myInt) {
        this.myString = myString;
        this.myInt = myInt;
    }

    private String myString;
    private Integer myInt;

    public String getMyString() {
        return myString;
    }

    public Integer getMyInt() {
        return myInt;
    }
}

