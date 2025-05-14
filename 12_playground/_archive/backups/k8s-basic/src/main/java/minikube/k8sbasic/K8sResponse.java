package minikube.k8sbasic;

public class K8sResponse {
    private String name;
    private String nickName;

    public K8sResponse(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }
}
