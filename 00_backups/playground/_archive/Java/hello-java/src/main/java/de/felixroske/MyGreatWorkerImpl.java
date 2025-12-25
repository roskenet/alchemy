package de.felixroske;

public class MyGreatWorkerImpl implements MyGreatWorker {

    @Override
    public String doSomething(String param) {
        return param.toUpperCase();
    }

    @Override
    public int returnSomething() {
        return 42;
    }
}
