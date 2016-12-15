package word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by jdp on 2016/12/13.
 */

@RestController
public class RandomWordController {

    @Autowired
    DiscoveryClient client;

    @Value("${words}") String words;

    private final String RANK_SERVICE_NAME = "ux-eureka-rank-data";


    @RequestMapping("/word")
    public String getWord() {
        int rank = callRankService();
        if(rank == -1) {
            rank = selfRandom();
        }
        String[] wordArray = words.split(",");
        return wordArray[rank%wordArray.length];
    }

    public int callRankService() {
        List<ServiceInstance> serviceInstances = client.getInstances(RANK_SERVICE_NAME);
        if(serviceInstances != null && serviceInstances.size() > 0) {
            URI uri =  serviceInstances.get(0).getUri();
            if(uri != null) {
                return (new RestTemplate()).getForObject(uri, Integer.class);
            }
        }
        return -1;
    }

    public int selfRandom() {
        return (int) Math.round(Math.random() * 300);
    }
}
