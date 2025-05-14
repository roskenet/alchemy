package minikube.k8sbasic;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class K8sController implements K8sControllerAPI {

    @Override
    public void doSomething() {
        System.out.println("Alles wird gut!");
    }

    @Override
    @GetMapping("/api/names")
    public List<K8sResponse> getResponse() {
        return Arrays.asList(new K8sResponse("Ameri Kanski", "Klaus"),
                new K8sResponse("Schaffa Sänff", "Holger"),
                new K8sResponse("Milda Sempf", "Milla"));
    }
}
