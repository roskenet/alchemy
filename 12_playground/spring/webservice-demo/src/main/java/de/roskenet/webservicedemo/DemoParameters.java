package de.roskenet.webservicedemo;

import de.roskenet.webservicedemo.DemoController.Status;

public class DemoParameters {

    private String sure_name;
    private String first_name;
    private Status status;

    public String getSure_name() {
        return sure_name;
    }

    public void setSure_name(String sure_name) {
        this.sure_name = sure_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

