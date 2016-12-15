package ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JDP on 2016/12/15.
 */

@Service
public class WordService {
    private final String WORD_SERVICE = "ux-eureka-random-word";

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "wordServiceFallback")
    public String getWord() {
        return restTemplate.getForEntity(String.format("http://%s/word", WORD_SERVICE), String.class).getBody() ;
    }

    public String wordServiceFallback() {
        return "service error";
    }
}
