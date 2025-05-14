package de.roskenet.createreactappbackend;

public class HelloResponse {
    private String respText;
    private int respInteger;

    public HelloResponse(String respText, int respInteger) {
        this.respText = respText;
        this.respInteger = respInteger;
    }

    public String getRespText() {
        return respText;
    }

    public int getRespInteger() {
        return respInteger;
    }
}
