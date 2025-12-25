package de.roskenet.demo;

public class StdApplicationBean implements EnvApplicationBean {

    private final AnotherBean anotherBean;

    public StdApplicationBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    @Override
    public String getTheEnvString() {
        return "The StdApplicationBean";
    }
}
