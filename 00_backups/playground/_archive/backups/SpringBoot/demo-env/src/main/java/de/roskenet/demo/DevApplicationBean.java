package de.roskenet.demo;

public class DevApplicationBean implements EnvApplicationBean {

    private final AnotherBean anotherBean;

    public DevApplicationBean(AnotherBean anotherBean) {
       this.anotherBean = anotherBean;
    }

    @Override
    public String getTheEnvString() {
        return anotherBean.showAnotherText();
    }

}
