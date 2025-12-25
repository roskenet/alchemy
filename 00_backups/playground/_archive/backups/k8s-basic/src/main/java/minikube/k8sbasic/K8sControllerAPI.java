package minikube.k8sbasic;

import java.util.List;

public interface K8sControllerAPI {
    List<K8sResponse> getResponse();
    void doSomething();
}
